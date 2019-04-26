package com.shichen.ihuigo.entity;

public class Price {
    private String date;
    private int price;

    @Override
    public String toString() {
        return "Price{" +
                "date=" + date +
                ", price=" + price +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
