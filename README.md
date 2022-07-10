# Генерация SQL запросов
  
#### Тестовое задания для Java-разработчика

Сделайте класс, который будет генерировать SQL-запросы:

-----
Пример: 
 
        var query = db.Query("tableOne")
                  .Select("name", "surname")
                  .OrderBy("name")
                  .Join("tableTwo", "tableOne.id", "tableTwo.user_id")
                  .Limit(2)
                  .GroupBy("name")
                  .WhereNotNull("AuthorID")
                  .WhereIn("lang", "en", "fr");

Результат:

    SELECT name, surname FROM tableOne WHERE AuthorID IS NOT NULL AND lang IN ('en', 'fr') 
    GROUP BY name INNER JOIN tableTwo ON tableOne.id = tableTwo.user_id ORDER BY name LIMIT 2;
    
По возможности, в архитектуре класса предусмотрите возможность изменить диалект SQL. Вот пример различий:

- SQLite

      SELECT name, surname FROM tableOne ORDER BY name;

- SQLServer

      SELECT [name], [surname] FROM [tableOne] ORDER BY [name];
