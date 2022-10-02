package com.sber.adapter.sqlConnection;

import com.sber.adapter.managerPropertyFiles.ConfigurationPropertyFiles;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Data
@Slf4j
public class ConnectionBDImplement implements ConnectionBD {

    @Override
    public Connection connectionBD(String url, String user, String password, String driver) throws ClassNotFoundException {
        Connection connection = null;
        if (!driver.contains("ms") || !driver.contains("server")){
            Class.forName(driver);
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
        }catch (SQLException e) {
            e.printStackTrace();
            log.error(e + " don't connect data base ");
        }
        return connection;
    }

    @Override
    public void selectToDataBase(ConfigurationPropertyFiles configurationPropertyFiles) {
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(configurationPropertyFiles.getNameWithPath()));
                ResultSet resultSet = connectionBD(configurationPropertyFiles.getUrl(), configurationPropertyFiles.getUser(), configurationPropertyFiles.getPassword(),
                        configurationPropertyFiles.getDriver()).createStatement().executeQuery(configurationPropertyFiles.getQuery());
                CSVPrinter csvPrinter = new CSVPrinter(bufferedWriter, CSVFormat.DEFAULT.withHeader(resultSet));

            ) {
            csvPrinter.printRecords(resultSet);

        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
