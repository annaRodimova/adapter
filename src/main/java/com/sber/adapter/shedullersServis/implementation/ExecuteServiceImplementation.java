package com.sber.adapter.shedullersServis.implementation;

import com.sber.adapter.managerPropertyFiles.ConfigurationPropertyFiles;
import com.sber.adapter.managerPropertyFiles.ServisProperyFiles;
import com.sber.adapter.servisForWorkWithFiles.CreateFiles;
import com.sber.adapter.shedullersServis.ExecutServis;
import com.sber.adapter.sqlConnection.ConnectionBD;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Data

public class ExecuteServiceImplementation implements ExecutServis {
    private List<ConfigurationPropertyFiles> configurationPropertyFiles;
    @Autowired
    private TaskScheduler taskScheduler;
    private final ConnectionBD connectionBD;
    private final ServisProperyFiles servisProperyFiles;


    @PostConstruct
    @Override
    public void execute() throws IOException {
       configurationPropertyFiles = servisProperyFiles.readConfigFiles();

       System.out.println(configurationPropertyFiles.size() + " size");

        configurationPropertyFiles.forEach(countConfigFiles->{

            System.out.println(countConfigFiles.toString() + " toString");

            taskScheduler.schedule(new Task( connectionBD, countConfigFiles),
                    new CronTrigger(countConfigFiles.getCron()));
        });
    }
}
