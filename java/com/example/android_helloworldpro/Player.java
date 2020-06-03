package com.example.android_helloworldpro;

public class Player {
    private String name;
    private String price;
    private String nation;
    private int pic;

    public Player(String name, String price, String nation, int pic) {
        this.name = name;
        this.price = price;
        this.nation = nation;
        this.pic = pic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getNation() {
        return nation;
    }

    public int getPic() {
        return pic;
    }
}
