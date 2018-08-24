package controller;

import repository.Credentials;
import repository.Query;
import repository.beans.AggregateView;
import services.DBService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private List<String> rows = JSONParser.getJSONParserInstance().getRowList();

    private List<List<AggregateView>> aggregateDataObject = new ArrayList<>();




    public static void main(String[] args) {


        App app = new App();


        try (
                Connection conn = DriverManager.getConnection   (
                        Credentials.getConnString(),
                        Credentials.getUSERNAME(),
                        Credentials.getPASSWORD()
                );
                Statement stmt = conn.createStatement()

        ) {


            System.out.println("Connection Established");

            double time, time_1, time_2;
            time_1 = System.currentTimeMillis();
            stmt.executeUpdate(Query.DROP_TABLE);
            System.out.println("Existing Table 'stocks' Dropped.");
            stmt.executeUpdate(Query.CREATE_TABLE);
            System.out.println("New Table 'stocks' Created.");


            for (String row : app.rows) {
                DBService.insertRow(conn, row);
            }

            System.out.println("Inserted List of Quotes from URL into DB.");
            time_2 = System.currentTimeMillis();
            time = (time_2 - time_1)/1000;
            System.out.println("Time Taken: " + time + " Seconds\n");
            app.aggregateDataObject = DBService.showAggregateData(conn, app.consoleIO());

            for(int i = 0; i < 2; i ++) {
                app.aggregateDataObject.get(i);
                System.out.println("\n\n");
                System.out.println(i == 0 ? "Aggregate Values By Date: ":"Aggregate Values By Month: ");
                for (AggregateView ag : app.aggregateDataObject.get(i)) {
                    System.out.println(ag);
                }
            }


        } catch (SQLException e) {
            System.err.println(e);
        }

    }


    private String consoleIO() {
        String input = null;
        try(Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter Date: ");
            input = scan.nextLine();
        } catch (Exception e) {
            System.err.println(e);
        }
        return input;
    }

}