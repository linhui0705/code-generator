package net.coderlin.generator.handler;

import net.coderlin.generator.bean.DbConfig;
import net.coderlin.generator.bean.db.Field;
import net.coderlin.generator.bean.db.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: DbHandler
 * Description:
 *
 * @author Lin Hui
 * Created on 2018-8-5 15:24
 */
public class DbHandler {
    private static final Logger logger = LoggerFactory.getLogger(DbHandler.class);

    private static DbHandler dbHandler;

    private DbConfig dataSource;

    /**
     * 数据库连接
     */
    private Connection connection;

    private static final String DEFAULT_DRIVER = "com.mysql.jdbc.Driver";

    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/test";

    private static final String DEFAULT_USERNAME = "root";

    private static final String DEFAULT_PASSWORD = "123456";

    private DbHandler() {
    }

    private DbHandler(DbConfig dataSource) throws SQLException, ClassNotFoundException {
        this.dataSource = dataSource;
        connection = getConnection(dataSource);
    }

    public static DbHandler getInstance(DbConfig dataSource) throws SQLException, ClassNotFoundException {
        if (null == dbHandler) {
            return new DbHandler(dataSource);
        }
        return dbHandler;
    }

    /**
     * 获取数据库连接
     *
     * @param dataSource
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection(DbConfig dataSource) throws ClassNotFoundException, SQLException {
        if (null != connection) {
            return connection;
        }
        if (null != dataSource) {
            Class.forName(dataSource.getDriverClassName());
            return DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
        }
        return DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
    }

    /**
     * 获取数据库连接
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (null != connection) {
            return connection;
        }
        return getConnection(dataSource);
    }

    /**
     * 扫描指定的数据库表
     *
     * @param selectedTables
     * @return
     * @throws SQLException
     */
    public List<Table> scanTables(List<String> selectedTables) throws SQLException {
        List<Table> tables = new LinkedList<>();
        for (String tableName : selectedTables) {
            if (existTable(tableName)) {
                Table table = new Table(tableName);
                List<Field> fields = scanFields(tableName);
                table.setFields(fields);

                tables.add(table);
            } else {
                logger.error("不存在名为 {} 的数据库表", tableName);
            }
        }
        return tables;
    }

    /**
     * 扫描数据库表
     *
     * @return
     * @throws SQLException
     */
    public List<Table> scanTables() throws SQLException {
        List<Table> tables = new LinkedList<>();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "%", new String[]{"TABLE"});
        while (resultSet.next()) {
            Table table = new Table(resultSet.getString("TABLE_NAME"), resultSet.getString("REMARKS"));
            List<Field> fields = scanFields(table.getTableName());
            table.setFields(fields);

            tables.add(table);
        }
        return tables;
    }

    /**
     * 扫描数据库表的字段
     *
     * @param tableName
     * @return
     * @throws SQLException
     */
    private List<Field> scanFields(String tableName) throws SQLException {
        List<Field> fields = new LinkedList<>();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getColumns(null, null, tableName, "%");
        while (resultSet.next()) {
            Field field = new Field();
            field.setColumnName(resultSet.getString("COLUMN_NAME"));
            field.setDbType(resultSet.getString("TYPE_NAME"));
            field.setColumnSize(resultSet.getInt("COLUMN_SIZE"));
            field.setDecimalDigits(resultSet.getInt("DECIMAL_DIGITS"));
            field.setNullable(resultSet.getBoolean("NULLABLE"));
            field.setRemark(resultSet.getString("REMARKS"));
            fields.add(field);
        }
        return fields;
    }

    /**
     * 查询数据库表是否存在
     *
     * @param tableName
     * @return
     */
    private boolean existTable(String tableName) {
        PreparedStatement ps = null;
        try {
            StringBuilder sql = new StringBuilder("SELECT 1 FROM ");
            sql.append(tableName);
            ps = connection.prepareStatement(sql.toString());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() throws SQLException {
        connection.close();
    }
}
