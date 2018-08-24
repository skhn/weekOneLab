package repository.beans;

import java.io.Serializable;

public class AggregateView implements Serializable {

    private String symbol;
    private String maxPrice;
    private String minPrice;
    private String closingPrice;
    private String totalVolume;

    public String getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(String closingPrice) {
        this.closingPrice = closingPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(String totalVolume) {
        this.totalVolume = totalVolume;
    }

    @Override
    public String toString() {
        return
                        "     Symbol : " + getSymbol() +
                        "     Max Price : " + getMaxPrice() +
                        "     Min Price : " + getMinPrice() +
                        "     Closing Price : " + getClosingPrice() +
                        "     Total Volume : " + getTotalVolume();
    }
}
