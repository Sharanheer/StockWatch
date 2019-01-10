package com.example.sharan.stockwatch;

public class Stock {

    private String companySymbol;
    private String companyName;
    private Double price;
    private Double priceChange;
    private Double changePercentage;

    public Stock(){

    }

    public Stock(String companySymbol, String companyName, Double price, Double priceChange, Double changePercentage) {
        this.companySymbol = companySymbol;
        this.companyName = companyName;
        this.price = price;
        this.priceChange = priceChange;
        this.changePercentage = changePercentage;
    }

    public String getCompanySymbol() {
        return companySymbol;
    }

    public void setCompanySymbol(String companySymbol) {
        this.companySymbol = companySymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(Double priceChange) {
        this.priceChange = priceChange;
    }

    public Double getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(Double changePercentage) {
        this.changePercentage = changePercentage;
    }

    @Override
    public boolean equals(Object obj) {

        boolean result = false;
        if (obj == null || obj.getClass() != getClass()) {
            result = false;
        } else {
            Stock stock = (Stock) obj;
            if (this.companySymbol.equals(stock.companySymbol)) {
                result = true;
            }
        }
        return result;
    }
}
