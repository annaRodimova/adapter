package com.sber.adapter.service;

import com.sber.adapter.managerPropertyFiles.ServisProperyFiles;
import com.sber.adapter.servisForWorkWithFiles.CreateFiles;
import com.sber.adapter.sqlConnection.ConnectionBD;
import lombok.Data;
import org.springframework.stereotype.Service;

//@Service
//@Data
public class ServiceClass {
    //private  CreateFiles createFiles;
    private  ConnectionBD connectionBD;
    private  ServisProperyFiles servisProperyFiles;
}
