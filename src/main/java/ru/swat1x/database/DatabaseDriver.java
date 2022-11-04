package ru.swat1x.database;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum DatabaseDriver {

    MYSQL("org.mysql.jdbc.Driver"), MARIADB("org.mariadb.jdbc.Driver");

    String driverPath;

}
