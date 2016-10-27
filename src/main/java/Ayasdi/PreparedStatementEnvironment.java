package Ayasdi;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementEnvironment<R> {
    R execute(PreparedStatement preparedStatement) throws SQLException;
}