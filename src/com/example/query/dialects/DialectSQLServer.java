package com.example.query.dialects;

import com.example.query.interfaces.Dialect;

public class DialectSQLServer implements Dialect {
    private boolean whereSection;

    public DialectSQLServer() {
        this.whereSection = false;
    }

    @Override
    public String From(String from) {
        return "[" + from + "]";
    }

    @Override
    public String Select(String[] select) {
        if (select == null) {
            return "*";
        }
        String newSelect = "[";
        for (int i = 0; i < select.length; i++) {
            newSelect = newSelect + select[i] + "], [";
        }
        newSelect = newSelect.substring(0, newSelect.length() - 3);
        return newSelect;
    }

    @Override
    public String OrderBy(String orderBy) {
        if (orderBy.equals("")) {
            return "";
        }
        return " ORDER BY [" + orderBy + "]";
    }

    @Override
    public String Join(String joinTable, String columnTableFrom, String columnTableJoin) {
        if (joinTable.equals("")) {
            return "";
        }
        columnTableFrom = columnTableFrom.replace(".", "].[");
        columnTableJoin = columnTableJoin.replace(".", "].[");
        return " INNER JOIN [" + joinTable + "] ON [" + columnTableFrom + "] = [" + columnTableJoin + "]";
    }

    @Override
    public String Limit(int limit) {
        if (limit == 0) {
            return "";
        }
        return " LIMIT " + limit;
    }

    @Override
    public String GroupBy(String groupBy) {
        if (groupBy.equals("")) {
            return "";
        }
        return " GROUP BY [" + groupBy + "]";
    }

    @Override
    public String WhereNotNull(String value) {
        if (value.equals("")) {
            whereSection = false;
            return "";
        }
        whereSection = true;
        return " WHERE [" + value + "] IS NOT NULL";
    }

    @Override
    public String WhereIn(String whereIn, String... agrs) {
        if (whereIn.equals("")) {
            return "";
        }
        if (whereSection && !whereIn.equals("")) {
            String newWhere = "";
            for (int i = 0; i < agrs.length; i++) {
                newWhere = newWhere + agrs[i] + "', '";
            }
            newWhere = newWhere.substring(0, newWhere.length() - 3);
            return " AND [" + whereIn + "] IN ('" + newWhere + ")";
        }
        return "";
    }

    @Override
    public String Insert(String... agrs) {
        String newInsert = "(";
        for (int i = 0; i < agrs.length; i++) {
            newInsert = newInsert + agrs[i] + ", ";
        }
        newInsert = newInsert.substring(0, newInsert.length() - 2);
        return newInsert + ")";
    }

    @Override
    public String Values(String... agrs) {
        String newValues = "('";
        for (int i = 0; i < agrs.length; i++) {
            newValues = newValues + agrs[i] + "', '";
        }
        newValues = newValues.substring(0, newValues.length() - 3);
        return newValues + ")";
    }

    @Override
    public String inTo(String mainTable) {
        return "["+mainTable+"]";
    }
}
