package repository.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * Class to form a single List item
 */

public class Stocks implements Serializable {

    private int stockId;
    private String symbol;
    private BigDecimal price;
    private int volume;
    private String date;

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString(){
        return getSymbol() + "," + getPrice() + "," + getVolume() + "," + getDate();
    }
}
