package repository;

public class Credentials {

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String CONN_STRING =
            "jdbc:mysql://localhost:8889/week_1_lab";

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getConnString() {
        return CONN_STRING;
    }
}
