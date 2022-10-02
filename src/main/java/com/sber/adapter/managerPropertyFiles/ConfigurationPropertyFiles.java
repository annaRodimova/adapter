package com.sber.adapter.managerPropertyFiles;

import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ConfigurationPropertyFiles {
    private String number;
    private String url;
    private String user;
    private String password;
    private String driver;
    private String query;
    private String nameWithPath;
    private String areYouNeedArchive;
    private String cron;
}
