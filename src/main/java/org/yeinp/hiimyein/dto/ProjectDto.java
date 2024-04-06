package org.yeinp.hiimyein.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class ProjectDto {
    private String id;
    private String title;
    private String sumup;
    private String content;
    private String function;
    private String giturl;
    private String backend;
    private String frontend;
    private String db;
    private String ide;
    private String deployment;
    private String role;
    private String server;
    private List<String> imageURLs;
    private Date regdate;
}
