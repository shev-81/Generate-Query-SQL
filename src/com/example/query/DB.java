package com.example.query;

import com.example.query.builders.SQLBuilder;
import com.example.query.dialects.DialectSQLite;
import com.example.query.interfaces.Dialect;
import com.example.query.interfaces.Query;

public class DB implements Query {

    public SQLBuilder builder;

    public DB() {
        this.builder = new SQLBuilder(new DialectSQLite());
    }

    public DB(Dialect dialect) {
        this.builder = new SQLBuilder(dialect);
    }

    @Override
    public SQLBuilder Query(String mainTable) {
        builder.setMainTable(mainTable);
        return builder;
    }

    public void setDialect(Dialect dialect) {
        builder.setDialect(dialect);
    }
}
