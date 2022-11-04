package ru.swat1x.database.common;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.StatementConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReThrowableQueryRunner extends QueryRunner {

    public ReThrowableQueryRunner(boolean pmdKnownBroken) {
        super(pmdKnownBroken);
    }

    public ReThrowableQueryRunner(DataSource ds) {
        super(ds);
    }

    public ReThrowableQueryRunner(StatementConfiguration stmtConfig) {
        super(stmtConfig);
    }

    public ReThrowableQueryRunner(DataSource ds, boolean pmdKnownBroken) {
        super(ds, pmdKnownBroken);
    }

    public ReThrowableQueryRunner(DataSource ds, StatementConfiguration stmtConfig) {
        super(ds, stmtConfig);
    }

    public ReThrowableQueryRunner(DataSource ds, boolean pmdKnownBroken, StatementConfiguration stmtConfig) {
        super(ds, pmdKnownBroken, stmtConfig);
    }

    public int[] batch(String sql, Object[][] params) {
        try {
            return super.batch(sql, params);
        } catch (SQLException var4) {
            throw new RuntimeException(var4);
        }
    }

    /** @deprecated */
    @Deprecated
    public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) {
        try {
            return super.query(sql, param, rsh);
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }

    /** @deprecated */
    @Deprecated
    public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) {
        try {
            return super.query(sql, params, rsh);
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }

    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) {
        try {
            return super.query(sql, rsh, params);
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }

    public <T> T query(String sql, ResultSetHandler<T> rsh) {
        try {
            return super.query(sql, rsh);
        } catch (SQLException var4) {
            throw new RuntimeException(var4);
        }
    }

    public int update(String sql) {
        try {
            return super.update(sql);
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    public int update(String sql, Object param) {
        try {
            return super.update(sql, param);
        } catch (SQLException var4) {
            throw new RuntimeException(var4);
        }
    }

    public int update(String sql, Object... params) {
        try {
            return super.update(sql, params);
        } catch (SQLException var4) {
            throw new RuntimeException(var4);
        }
    }

    public <T> T insert(String sql, ResultSetHandler<T> rsh) {
        try {
            return super.insert(sql, rsh);
        } catch (SQLException var4) {
            throw new RuntimeException(var4);
        }
    }

    public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) {
        try {
            return super.insert(sql, rsh, params);
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }

    public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) {
        try {
            return super.insertBatch(sql, rsh, params);
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }

    public <T> T insertBatch(Connection conn, String sql, ResultSetHandler<T> rsh, Object[][] params) {
        try {
            return super.insertBatch(conn, sql, rsh, params);
        } catch (SQLException var6) {
            throw new RuntimeException(var6);
        }
    }

    public int execute(Connection conn, String sql, Object... params) {
        try {
            return super.execute(conn, sql, params);
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }

    public int execute(String sql, Object... params) {
        try {
            return super.execute(sql, params);
        } catch (SQLException var4) {
            throw new RuntimeException(var4);
        }
    }

    public <T> List<T> execute(String sql, ResultSetHandler<T> rsh, Object... params) {
        try {
            return super.execute(sql, rsh, params);
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }
}
