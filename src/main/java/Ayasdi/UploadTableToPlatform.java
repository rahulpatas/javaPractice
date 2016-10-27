package Ayasdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;
import java.sql.SQLException;
import java.util.stream.Stream;

public class UploadTableToPlatform {

    private static final Logger LOG = LoggerFactory.getLogger(UploadTableToPlatform.class);

    public UploadTableToPlatform(Path filePath) {

        try (Stream<String> stream = Files.lines(filePath)) {

            stream.forEach(tableName -> {
                String pathToCopy = filePath.toString() + "/" + tableName;

                try {
                    PreparedStatementExecutor.getInstance().writeToCSV(tableName, pathToCopy);
                    Path tmpFilePath = Paths.get(pathToCopy);

                    if (AyasdiSDK.uploadCSVFile(tmpFilePath)) {
                        LOG.info(tableName + " uploaded to Ayasdi platform");

                        Files.deleteIfExists(tmpFilePath);
                    }
                } catch (SQLException | IOException e) {
                    LOG.error(e.getMessage());
                }
            });
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }

    }
}


