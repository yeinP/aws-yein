package org.yeinp.hiimyein.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReadmeDto {

    private String id;
    private String projecttitle;
    private String summary;
    private List<String> mainfunction = new ArrayList<>();
    private List<String> tech = new ArrayList<>();
    private List<String> rolebe = new ArrayList<>();
    private List<String> rolefe = new ArrayList<>();
    private String review;
    private String code;

}
