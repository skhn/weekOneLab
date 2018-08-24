package repository;

/**
 *
 * Queries for database access stored in this class.
 */
public final class Query {

    public static final String GET_ALL = "SELECT * FROM STOCKS";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS stocks;";

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS stocks " +
            "(stockId INT(11) NOT NULL AUTO_INCREMENT," +
            "symbol VARCHAR(4) NOT NULL," +
            "price DECIMAL(11,2) NOT NULL," +
            "volume INT(11) NOT NULL," +
            "date DATETIME NOT NULL," +
            "PRIMARY KEY (stockId)) ENGINE=InnoDB  DEFAULT CHARSET=latin1;";

    public static final String INSERT_ROW = "INSERT INTO Stocks (symbol, price, volume, date) " +
            "VALUES (?, ?, ?, ?)";


    public static String aggregateResult (String date, String option) {
        switch (option) {
            case "MONTH":
                return  " WHERE MONTH(DATE) = '" + date.split("-")[1] + "' ";
            case "DATE":
                return  " WHERE DATE LIKE '" + date + "%' ";
        }
        return null;
    }

    public static String resultByDate(String date) {
        return "SELECT symbol, max_price, min_price,price as closing_price,total_volume " +
                "FROM ( SELECT symbol AS symbol_1, MAX(price) AS max_price, MIN(price) " +
                "AS min_price, SUM(volume) AS total_volume, date FROM stocks" + date +
                "GROUP BY symbol ) AS t0 INNER JOIN ( SELECT * FROM stocks AS t1 INNER JOIN( " +
                "SELECT MAX(date) as latestdate, symbol as symbol_2 FROM stocks" + date +
                "GROUP BY symbol ) AS t2 ON t1.date = t2.latestdate AND t1.symbol = t2.symbol_2 ) AS " +
                "t3 ON t0.symbol_1 = t3.symbol";
    }

}
