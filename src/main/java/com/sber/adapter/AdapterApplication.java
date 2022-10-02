package com.sber.adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling

public class AdapterApplication {
//TODO СДЕЛАЙ шифрование, разберись с csv разделителями и заголовками, соннекшены бд закрой и в лист и отладь
	public static void main(String[] args) throws IOException {
		SpringApplication.run(AdapterApplication.class);

	}

}




//		SpringApplication springApplication = new SpringApplication(AdapterApplication.class);
//		springApplication.setWebApplicationType(WebApplicationType.NONE);
//		ConfigurableApplicationContext context = springApplication.run(args);
//		TaskScheduler taskScheduler = context.getBean(TaskScheduler.class);
//		CreateFiles createFiles = new CreateFileImplementation();
//		ConnectionBD connectionBD = new ConnectionBDImplement();
//		ServisPropertyFilesImplementation servisPropertyFilesImplementation = new ServisPropertyFilesImplementation();
//		ExecutServis executServis = new ExecuteServiceImplementation(servisPropertyFilesImplementation.readConfigFiles(), taskScheduler, createFiles,connectionBD);
//		executServis.execute();
