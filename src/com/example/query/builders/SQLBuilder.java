package com.example.query.builders;

import com.example.query.interfaces.Dialect;
import com.example.query.interfaces.InsertSQLQuery;
import com.example.query.interfaces.QuerySQL;
import com.example.query.interfaces.SelectSQLQuery;

public class SQLBuilder implements QuerySQL {

    protected Dialect dialect;
    private SelectQueryBuilder selectQueryBuilder;
    private InsertQueryBuilder insertQueryBuilder;
    protected String mainTable;

    public SQLBuilder() {
    }

    public SQLBuilder(Dialect dialect) {
        this.dialect = dialect;
    }

    @Override
    public SelectSQLQuery Select(String... select) {
        selectQueryBuilder = new SelectQueryBuilder(select);
        selectQueryBuilder.setDialect(dialect);
        selectQueryBuilder.setMainTable(mainTable);
        return selectQueryBuilder;
    }

    @Override
    public InsertSQLQuery Insert(String... insert) {
        insertQueryBuilder = new InsertQueryBuilder(insert);
        insertQueryBuilder.setDialect(dialect);
        insertQueryBuilder.setMainTable(mainTable);
        return insertQueryBuilder;
    }

    /**
     * тут согласно контракта интерфейса " QuerySQL " можно добавлять дополнительные методы CRUD операций
     */

    public void setDialect(Dialect dialect){
        this.dialect = dialect;
    }

    public void setMainTable(String mainTable) {
        this.mainTable = mainTable;
    }
}
