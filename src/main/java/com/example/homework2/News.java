package com.example.homework2;

import java.util.SplittableRandom;

public class News {
    private String name;
    private String content;

    public News(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
