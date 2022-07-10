package com.example.query.interfaces;

public interface QuerySQL {

    SelectSQLQuery Select(String... select);
    InsertSQLQuery Insert(String... insert);


    /**
     * тут добавляем остальные CRUD операции с DB
     */
}
