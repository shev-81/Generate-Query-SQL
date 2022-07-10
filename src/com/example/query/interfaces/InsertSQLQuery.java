package com.example.query.interfaces;

public interface InsertSQLQuery extends QuerySQL {

    InsertSQLQuery values(String... insertAgrs);
    String build();
}
