package com.example.query.interfaces;

import com.example.query.builders.SQLBuilder;

public interface Query {
    SQLBuilder Query(String table);
}