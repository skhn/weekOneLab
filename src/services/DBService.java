package services;

import repository.Query;
import repository.beans.AggregateView;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    public static void insertRow(Connection conn, String rowValue) {

        String[] rowItems  = rowValue.split(",");

        try (PreparedStatement stmt = conn.prepareStatement(Query.INSERT_ROW, Statement.RETURN_GENERATED_KEYS)) {

            for (int i = 1; i <= 3; i++) {
                stmt.setString(i, rowItems[i-1]);
            }

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            java.util.Date dateStr = formatter.parse(rowItems[3]);


            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

            Timestamp ts = new Timestamp(dateDB.getTime());
            stmt.setTimestamp(4,ts);

            stmt.executeUpdate();


        } catch (SQLException e) {
            System.err.println(e);
        } catch (ParseException e) {
           System.err.println(e);
        }
    }

    public static List<List<AggregateView>> showAggregateData (Connection conn, String clippedDate) {



        List<List<AggregateView>> aggregateList = new ArrayList<>();

        try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            ResultSet rs = stmt.executeQuery(Query.resultByDate(Query.aggregateResult(clippedDate,"DATE")));
            List<AggregateView> aggregateListItem = new ArrayList<>();
            aggregateViewHelper(rs, aggregateListItem);
            aggregateList.add(aggregateListItem);



            rs = stmt.executeQuery(Query.resultByDate(Query.aggregateResult(clippedDate,"MONTH")));
            aggregateListItem = new ArrayList<>();
            aggregateViewHelper(rs, aggregateListItem);
            aggregateList.add(aggregateListItem);

        } catch (SQLException e) {
            System.err.println(e);
        }

        return aggregateList;
    }

    private static void aggregateViewHelper(ResultSet rs, List<AggregateView> aggregateListItem) throws SQLException {
        while(rs.next()) {

            AggregateView agView = new AggregateView();

            agView.setSymbol(rs.getString(1));
            agView.setMaxPrice(rs.getString(2));
            agView.setMinPrice(rs.getString(3));
            agView.setClosingPrice(rs.getString(4));
            agView.setTotalVolume(rs.getString(5));

            aggregateListItem.add(agView);
        }
    }


}
