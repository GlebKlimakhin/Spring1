package com.geekbrains.app;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Product {
    private long id;
    private String title;
    private int cost;

    public Product(long id, String title, int cost) {
        this.id = id;
        this.title = randString();
        this.cost = cost;
    }

    public String  randString() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.ISO_8859_1);
    }


    @Override
    public String toString() {
        return "id = " + this.id + " title = " + this.title + " cost = "
                + this.cost;
    }
}
