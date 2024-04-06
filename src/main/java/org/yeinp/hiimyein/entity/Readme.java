package org.yeinp.hiimyein.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Document(collection = "readme")
@AllArgsConstructor
@NoArgsConstructor
public class Readme {

    @Id
    private String id;
    private String projecttitle;
    private String summary;
    private List<String> mainfunction;
    private List<String> tech;
    private List<String> rolebe = new ArrayList<>();
    private List<String> rolefe = new ArrayList<>();
    private String review;
    private String code;


}
