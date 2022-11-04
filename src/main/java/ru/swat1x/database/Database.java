package ru.swat1x.database;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.apache.commons.dbutils.QueryRunner;
import ru.swat1x.database.common.CompletableAsyncQueryRunner;
import ru.swat1x.database.common.ReThrowableQueryRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Database {

    @Getter
    HikariDataSource dataSource;
    ExecutorService executor;

    public Database(String host,
                    String database,
                    String user,
                    String password,
                    DatabaseDriver driver) {
        this(host.split(":")[0],
                Integer.parseInt(host.split(":")[1]),
                database,
                user,
                password,
                "database-pool",
                driver.getDriverPath(),
                driver.name().toLowerCase());
    }

    public Database(String host,
                    String database,
                    String user,
                    String password,
                    String poolName,
                    DatabaseDriver driver) {
        this(host.split(":")[0],
                Integer.parseInt(host.split(":")[1]),
                database,
                user,
                password,
                poolName,
                driver.getDriverPath(),
                driver.name().toLowerCase());
    }

    public Database(String host,
                    String database,
                    String user,
                    String password,
                    String poolName,
                    String driverPath,
                    String jdbc) {
        this(host.split(":")[0],
                Integer.parseInt(host.split(":")[1]),
                database,
                user,
                password,
                poolName,
                driverPath,
                jdbc);
    }

    public Database(String ip,
                    int port,
                    String database,
                    String user,
                    String password,
                    String poolName,
                    String driver,
                    String jdbcName) {
        ThreadFactory threadFactory = (new ThreadFactoryBuilder()).setNameFormat("database-worker-%d").build();
        this.executor = Executors.newFixedThreadPool(4, threadFactory);
        HikariConfig config = new HikariConfig();
        config.setPoolName(poolName);
        config.setDriverClassName(driver);
        config.setJdbcUrl("jdbc:" + jdbcName + "://" + ip + ":" + port + "/" + database + "?useUnicode=yes&useSSL=false&characterEncoding=UTF-8&allowMultiQueries=true&autoReconnect=true&jdbcCompliantTruncation=false");
        config.setUsername(user);
        config.setPassword(password);
        config.setConnectionTimeout(30000L);
        config.setIdleTimeout(600000L);
        config.setMaxLifetime(1800000L);
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        this.dataSource = new HikariDataSource(config);
    }

    public ReThrowableQueryRunner sync() {
        return new ReThrowableQueryRunner(this.dataSource);
    }

    public CompletableAsyncQueryRunner async() {
        return new CompletableAsyncQueryRunner(this.executor, new QueryRunner(this.dataSource));
    }

    public void shutdown() {
        dataSource.close();
        executor.shutdown();
    }

}
