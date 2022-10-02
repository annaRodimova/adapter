package com.sber.adapter.managerPropertyFiles.implementation;

import com.sber.adapter.managerPropertyFiles.ConfigurationPropertyFiles;
import com.sber.adapter.managerPropertyFiles.ServisProperyFiles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
@Service
@Slf4j
public class ServisPropertyFilesImplementation implements ServisProperyFiles {
    private final String dbURLpropertyes = "url";
    private final String dbUserPropertyes = "user";
    private final String dbPasswordPropertyes = "password";
    private final String dbDriverPropertyes = "driver";
    private final String dbQueryPropertyes = "query";
    private final String cronProperty = "cron";
    private final String nameWithPathProperty = "nameWithPath";
    private final String areYouNeedArchive = "areYouNeedArchive";
    private final String numberFile = "number";

    @Override
    public List<Path> getAllPropertyFilesPaths() {
        final File jarFile = new File(ServisPropertyFilesImplementation.class.getProtectionDomain().getCodeSource().getLocation().getFile());
       // System.out.println(jarFile.getPath());
        String confLocation = jarFile.getParentFile().getParentFile().getPath();
        String location = confLocation.substring(5);
        System.out.println(confLocation + " location");
        List<Path> files = new ArrayList<>();
        try {
            files= Files.walk(Paths.get(confLocation+"/conf"))
                    .filter(Files::isRegularFile)
                    .filter((path) ->
                            path.getFileName().toString().endsWith(".yml") &&
                                    path.getFileName().toString().startsWith("config_"))
                    .collect(Collectors.toList());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (files.size()==0) {
            log.error("files aren't exist");
        }

        return files;
    }

    @Override
    public List<ConfigurationPropertyFiles> readConfigFiles() throws IOException {
        List<Path> paths = getAllPropertyFilesPaths();
        Properties properties = new Properties();
        List<ConfigurationPropertyFiles> configList = new ArrayList<>();
        for (Path path: paths) {
         //   System.out.println(path);
            properties.load(new FileInputStream(path.toString()));
            configList.add(translatePropertyesIntoObject(properties));
        }
        return configList;
    }
    public String readSelectFromQueryFile(String path) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            StringBuilder stringBuilder = new StringBuilder();
            String select;
            while ((select=bufferedReader.readLine()) !=null) {
                stringBuilder.append(select);
            }
            select = stringBuilder.toString();
            return select;
        }
    }
    public ConfigurationPropertyFiles translatePropertyesIntoObject(Properties properties) throws IOException {
//        ConfigurationBD configurationBD = new ConfigurationBD()
//                .builder()
//                .url(properties.getProperty(dbURLpropertyes))
//                .user(properties.getProperty(dbUserPropertyes))
//                .password(properties.getProperty(dbPasswordPropertyes))
//                .driver(properties.getProperty(dbDriverPropertyes))
//                .query(properties.getProperty(dbQueryPropertyes))
//                .build();
//        ConfigFiles configFiles = new ConfigFiles()
//                .builder()
//                .nameWithPath(properties.getProperty(nameWithPathProperty))
//                .areYouNeedArchive(properties.getProperty(areYouNeedArchive))
//                .build();
        ConfigurationPropertyFiles configurationPropertyFiles = new ConfigurationPropertyFiles()
                .builder()
                .number(properties.getProperty(numberFile))
                .url(properties.getProperty(dbURLpropertyes))
                .user(properties.getProperty(dbUserPropertyes))
                .password(properties.getProperty(dbPasswordPropertyes))
                .driver(properties.getProperty(dbDriverPropertyes))
                .query(readSelectFromQueryFile(properties.getProperty(dbQueryPropertyes)))
                .nameWithPath(properties.getProperty(nameWithPathProperty))
                .areYouNeedArchive(properties.getProperty(areYouNeedArchive))
                .cron(properties.getProperty(cronProperty))
                .build();
        return configurationPropertyFiles;
    }
}
