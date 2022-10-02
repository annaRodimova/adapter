package com.sber.adapter.sqlConnection;

import com.sber.adapter.managerPropertyFiles.ConfigurationPropertyFiles;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public interface ConnectionBD {
    public Connection connectionBD(String url, String user, String password, String driver) throws ClassNotFoundException;
    public void selectToDataBase(ConfigurationPropertyFiles configurationPropertyFiles);
}
