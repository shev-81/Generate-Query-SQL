package com.example.query.interfaces;

public interface Dialect {
    String From(String from);

    String Select(String[] select);

    String OrderBy(String orderBy);

    String Join(String joinTable, String columnTableFrom, String columnTableJoin);

    String Limit(int limit);

    String GroupBy(String groupBy);

    String WhereNotNull(String value);

    String WhereIn(String value, String... agrs);

    String Insert(String... agrs);

    String Values(String... agrs);

    String inTo(String mainTable);

}
