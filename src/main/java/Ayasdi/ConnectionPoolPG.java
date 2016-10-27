package Ayasdi;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Connection pool for data base connections.
 */
class ConnectionPoolPG {

    private static final String DATA_DRIVER_CLASS_NAME = "postgres_driverClassName";
    private static final String DRIVER_CLASS_NAME = "driverClassName";
    private static final String DATA_JDBC_URL = "postgres_jdbcUrl";
    private static final String JDBC_URL = "jdbcUrl";
    private static final String DATA_USERNAME = "postgres_username";
    private static final String USERNAME = "username";
    private static final String DATA_PASSWORD = "postgres_password";
    private static final String PASSWORD = "password";
    private static final String DATA_MAXIMUM_POOLSIZE = "postgres_maximumPoolSize";
    private static final String MAXIMUM_POOLSIZE = "maximumPoolSize";
    private static final String DATA_AUTO_COMMIT = "postgres_autoCommit";
    private static final String AUTO_COMMIT = "autoCommit";
    private static final String DATA_SOURCE_KEY = "dataSource";
    private static final String DATA_SOURCE_VALUE = "costumerData";


    private static final Logger LOG = LoggerFactory.getLogger(ConnectionPoolPG.class);
    private static final ConnectionPoolPG INSTANCE = new ConnectionPoolPG();
    private HikariDataSource dataSource;

    /**
     * Private constructor to initialize the connection pool instance (singleton).
     */
    private ConnectionPoolPG() {
        try {
            final Properties connectionPoolProperties = new Properties();

            connectionPoolProperties.setProperty(DRIVER_CLASS_NAME, DATA_DRIVER_CLASS_NAME);
            connectionPoolProperties.setProperty(JDBC_URL, DATA_JDBC_URL);
            connectionPoolProperties.setProperty(USERNAME, DATA_USERNAME);
            connectionPoolProperties.setProperty(PASSWORD, DATA_PASSWORD);
            connectionPoolProperties.setProperty(MAXIMUM_POOLSIZE, DATA_MAXIMUM_POOLSIZE);
            connectionPoolProperties.setProperty(AUTO_COMMIT, DATA_AUTO_COMMIT);

            final HikariConfig config = new HikariConfig(connectionPoolProperties);
            config.addDataSourceProperty(DATA_SOURCE_KEY, DATA_SOURCE_VALUE);
            dataSource = new HikariDataSource(config);

        } catch (Exception e) {
            LOG.error("Error creating ConnectionPoolPG()", e);
            throw e;
        }
    }


    /**
     * Returns a handle to the connection pool (singleton).
     *
     * @return handle o the connection pool
     */
    public static ConnectionPoolPG getInstance() {
        return INSTANCE;
    }


    /**
     * Returns an open connection t the underlying data source from the connection pool.
     *
     * @return connection to the underlying data source
     */
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOG.error("Error getting database connection", e);
        }
        return null;
    }
}
