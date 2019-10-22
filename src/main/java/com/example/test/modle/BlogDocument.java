package com.example.test.modle;

public class BlogDocument {
    private long id;
    private String name;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static final String Index_Name="index_blog";

    public static final String Type_Name="type_blog";

    public static String getType_Name() {
        return Type_Name;
    }

    public static String getIndex_Name() {
        return Index_Name;
    }
}
