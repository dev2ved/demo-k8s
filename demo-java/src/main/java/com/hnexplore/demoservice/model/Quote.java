package com.hnexplore.demoservice.model;

import java.util.Objects;

public class Quote {

    private int id;
    private String author;
    private String message;

    public Quote(int id, String author, String message) {
        this.id = id;
        this.author = author;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quote)) return false;
        Quote quote = (Quote) o;
        return Objects.equals(author, quote.author) &&
                Objects.equals(message, quote.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, message);
    }
}
