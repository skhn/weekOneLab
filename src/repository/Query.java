package repository;

public class Query {

//    SELECT symbol, MAX(price), MIN(price), SUM(volume) FROM stocks
//    where date LIKE '2018-06-22%'
//    GROUP BY symbol

    public static final String GET_ALL = "SELECT * FROM STOCKS";
    //'2018-06-22%'
    public static final String INSERT_ROW = "INSERT INTO Stocks (symbol, price, volume, date) " +
            "VALUES (?, ?, ?, ?)";

    public static String resultByDate(String date) {
        return "Select symbol, max_price, min_price,price as closing_price,total_volume " +
                "from ( SELECT symbol as symbol_1, MAX(price) AS max_price, MIN(price) " +
                "AS min_price, SUM(volume) AS total_volume, date FROM stocks WHERE DATE LIKE '" + date + "%'" +
                " GROUP BY symbol ) AS t0 INNER JOIN ( SELECT * FROM stocks as t1 INNER JOIN( " +
                "Select max(date) as latestdate, symbol as symbol_2 from stocks where date like '" + date + "%' " +
                "Group by symbol ) AS t2 ON t1.date = t2.latestdate AND t1.symbol = t2.symbol_2 ) as " +
                "t3 on t0.symbol_1 = t3.symbol";
    }

    public static String resultByMonth(String date) {
        return "Select symbol, max_price, min_price,price as closing_price,total_volume " +
                "from ( SELECT symbol as symbol_1, MAX(price) AS max_price, MIN(price) " +
                "AS min_price, SUM(volume) AS total_volume, date FROM stocks WHERE MONTH(DATE) = '" + date + "'" +
                " GROUP BY symbol ) AS t0 INNER JOIN ( SELECT * FROM stocks as t1 INNER JOIN( " +
                "Select max(date) as latestdate, symbol as symbol_2 from stocks WHERE MONTH(DATE) = '" + date + "' " +
                "Group by symbol ) AS t2 ON t1.date = t2.latestdate AND t1.symbol = t2.symbol_2 ) as " +
                "t3 on t0.symbol_1 = t3.symbol";
    }

}
