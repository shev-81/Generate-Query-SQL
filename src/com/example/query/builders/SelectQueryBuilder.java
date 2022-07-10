package com.example.query.builders;

import com.example.query.interfaces.SelectSQLQuery;

public class SelectQueryBuilder extends SQLBuilder implements SelectSQLQuery{

    private String[] select;
    private String orderBy;

    private String join;
    private String columnTableFrom;
    private String columnTableJoin;

    private int limit;
    private String groupBy;
    private String whereNotNull;
    private String whereIn;
    private String[] whereInAgrs;

    public SelectQueryBuilder(String [] select) {
        this.select = select;
        this.orderBy = "";
        this.join = "";
        this.columnTableFrom = "";
        this.columnTableJoin = "";
        this.limit = 0;
        this.groupBy = "";
        this.whereNotNull = "";
        this.whereIn = "";
        this.whereInAgrs = null;
    }

    @Override
    public SelectSQLQuery Select(String... select) {
        this.select = select;
        return this;
    }

    @Override
    public SelectSQLQuery OrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    @Override
    public SelectSQLQuery Join(String joinTable, String columnTableFrom, String columnTableJoin) {
        this.join = joinTable;
        this.columnTableFrom = columnTableFrom;
        this.columnTableJoin = columnTableJoin;
        return this;
    }

    @Override
    public SelectSQLQuery Limit(int limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public SelectSQLQuery GroupBy(String groupBy) {
        this.groupBy = groupBy;
        return this;
    }

    @Override
    public SelectSQLQuery WhereNotNull(String value) {
        this.whereNotNull = value;
        return this;
    }

    @Override
    public SelectSQLQuery WhereIn(String whereIn, String... whereInAgrs) {
        this.whereIn = whereIn;
        this.whereInAgrs = whereInAgrs;
        return this;
    }

    @Override
    public String build() {
        return "SELECT "
                + dialect.Select(select) +
                " FROM "
                + dialect.From(mainTable)
                + dialect.WhereNotNull(whereNotNull)
                + dialect.WhereIn(whereIn, whereInAgrs)
                + dialect.GroupBy(groupBy)
                + dialect.Join(join, columnTableFrom, columnTableJoin)
                + dialect.OrderBy(orderBy)
                + dialect.Limit(limit)
                + ";"
                ;
    }

    @Override
    public String toString() {
        return build();
    }
}
