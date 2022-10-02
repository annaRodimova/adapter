package com.sber.adapter.servisForWorkWithFiles;

import lombok.Data;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Data
public class CreateFileImplementation{ // implements CreateFiles
//    @Override
//    public void createAndWriteIntoCsvFile(ResultSet resultSet, String pathFile) throws SQLException, IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFile));
//        CSVPrinter csvPrinter = new CSVPrinter(bufferedWriter, CSVFormat.DEFAULT.withHeader(resultSet));
//        csvPrinter.printRecords(resultSet);
//    }
//
//    @Override
//    public void createAndWriteIntoTXTFile() {
//
//    }
}
