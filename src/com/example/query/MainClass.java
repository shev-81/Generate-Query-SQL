package com.example.query;


import com.example.query.dialects.DialectSQLServer;
import com.example.query.dialects.DialectSQLite;


/**
 * класс запуска приложения
 */

public class MainClass {
    public static void main(String[] args) {

        DB db = new DB(new DialectSQLite());
//        DB db = new DB(new DialectSQLServer());


        var query = db.Query("tableOne")
                .Select("name", "surname")
                .OrderBy("name")
                .Join("tableTwo", "tableOne.id", "tableTwo.user_id")
                .Limit(2)
                .GroupBy("name")
                .WhereNotNull("AuthorID")
                .WhereIn("lang", "en", "fr");

        System.out.println(query);

        var query2 = db.Query("newTable")
                .Insert("value1", "value2")
                .values("value1", "value2");

        System.out.println(query2);


    }
}
