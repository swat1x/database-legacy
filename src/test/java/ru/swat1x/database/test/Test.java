package ru.swat1x.database.test;

import ru.swat1x.database.Database;
import ru.swat1x.database.DatabaseDriver;

public class Test {

    public static void main(String[] args) {
        Database database = new Database(
                "localhost:3306",
                "server",
                "root",
                "1234",
                DatabaseDriver.MYSQL);
    }

}
