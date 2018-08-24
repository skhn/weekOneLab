package controller;

import repository.Credentials;
import repository.beans.AggregateView;
import services.DBService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    // change
    List<String> rows = JSONParser.getJSONParserInstance().getRowList();
    List<AggregateView> aggregateListByDate = new ArrayList<>();
    List<AggregateView> aggregateListByMonth = new ArrayList<>();




    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Class.forName("com.mysql.jdbc.Driver");


        App app = new App();


        try (
                Connection conn = DriverManager.getConnection   (
                        Credentials.getConnString(),
                        Credentials.getUSERNAME(),
                        Credentials.getPASSWORD()
                );

        ) {

            System.out.println("connected");


////
//            for (String row : app.rows) {
//                DBService.insertRow(conn, row);
//            }

            app.aggregateListByDate =   DBService.showAggregateData(conn, "2018-06-22").get(0);
            app.aggregateListByMonth =  DBService.showAggregateData(conn, "2018-06-22").get(1);

            for (AggregateView agg : app.aggregateListByDate) {
                System.out.println(agg);
               }

            System.out.println("\n\n");

            for (AggregateView agg : app.aggregateListByMonth) {
                System.out.println(agg);
            }


        } catch (SQLException e) {
            System.err.println(e);
        }

    }

}