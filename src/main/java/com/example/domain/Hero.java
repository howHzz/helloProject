package com.example.domain;

public class Hero {

    private int id;
    private String name;
    private String quote;

    public Hero(int id, String name, String quote) {
        this.id = id;
        this.name = name;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}
