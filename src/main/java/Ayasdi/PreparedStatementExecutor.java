package Ayasdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PreparedStatementExecutor {

    private static final Logger LOG = LoggerFactory.getLogger(PreparedStatementExecutor.class);

    private static PreparedStatementExecutor preparedStatementFactory = new PreparedStatementExecutor();


    public static PreparedStatementExecutor getInstance() {
        return preparedStatementFactory;
    }

    private <R> R executeOnDatabase(String query, PreparedStatementEnvironment<R> function, boolean commit)
            throws SQLException {

        PreparedStatement preparedStatement = null;
        try (Connection connection = ConnectionPoolPG.getInstance().getConnection()) {
            preparedStatement = connection.prepareStatement(query);
            R result = function.execute(preparedStatement);
            if (commit) {
                connection.commit();
            }
            return result;
        } catch (SQLException sqlEx) {
            LOG.error(String.format("Exception during executing query/dml %s on database", preparedStatement), sqlEx);
            throw new SQLException(sqlEx);
        }
    }


    public void writeToCSV(String tableName, String pathToCopy) throws SQLException {

        executeOnDatabase("Copy (Select * From ?) To ? With CSV DELIMITER ',' ;",
                preparedStatement -> {
                    preparedStatement.setString(1, tableName);
                    preparedStatement.setString(2, pathToCopy);
                    preparedStatement.execute();
                    return true;
                }, true);
    }
}
