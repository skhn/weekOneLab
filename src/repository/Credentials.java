package repository;

/**
 *
 * Database Access information and URL.
 */
public final class Credentials {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING =
            "jdbc:mysql://localhost:3306/lab";
    private static final String URL = "https://bootcamp-training-files.cfapps.io/week1/week1-stocks.json";

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getConnString() {
        return CONN_STRING;
    }

    public static String getURL() { return URL; }
}
