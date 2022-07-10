package com.example.query.interfaces;

public interface SelectSQLQuery extends QuerySQL{

    SelectSQLQuery OrderBy(String orderBy);

    SelectSQLQuery Join(String joinTable, String columnTableFrom, String columnTableJoin);

    SelectSQLQuery Limit(int limit);

    SelectSQLQuery GroupBy(String groupBy);

    SelectSQLQuery WhereNotNull(String value);

    SelectSQLQuery WhereIn(String whereIn, String... whereInAgrs);

    String build();
}
