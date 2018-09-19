package com.zjc.wx_store.core.Utils;

public enum QueryType {

    EQ("eq"), LIKE("like");

    QueryType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return super.toString();
    }


}
