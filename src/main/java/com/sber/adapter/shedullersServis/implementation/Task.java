package com.sber.adapter.shedullersServis.implementation;

import com.sber.adapter.managerPropertyFiles.ConfigurationPropertyFiles;
import com.sber.adapter.sqlConnection.ConnectionBD;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task implements Runnable{
    private  ConnectionBD connectionBD;
    private  ConfigurationPropertyFiles configurationPropertyFiles;


    @SneakyThrows
    @Override
    public void run() {
       connectionBD.selectToDataBase(configurationPropertyFiles);

    }
}
