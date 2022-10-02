package com.sber.adapter.servisForWorkWithFiles;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
@Service
public interface CreateFiles {
    public void createAndWriteIntoCsvFile() throws SQLException, IOException;
    public void createAndWriteIntoTXTFile();

}
