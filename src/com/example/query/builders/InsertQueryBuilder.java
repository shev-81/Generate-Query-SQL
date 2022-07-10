package com.example.query.builders;

import com.example.query.interfaces.InsertSQLQuery;

public class InsertQueryBuilder extends SQLBuilder implements InsertSQLQuery {

    private String[] insert;
    private String [] values;

    public InsertQueryBuilder(String[] insert) {
        this.insert = insert;
    }

    @Override
    public InsertSQLQuery values(String... insertValues) {
        this.values = insertValues;
        return this;
    }

    @Override
    public String build() {
        return "INSERT INTO "
                + dialect.inTo(mainTable)
                + " "
                + dialect.Insert(insert)
                + " VALUES "
                + dialect.Values(values)
                + ";"
                ;
    }

    @Override
    public String toString() {
        return build();
    }
}
