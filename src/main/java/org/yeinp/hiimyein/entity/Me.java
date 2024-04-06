package org.yeinp.hiimyein.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document(collection = "aboutMe")
public class Me {

    @Id
    private String id;

    private String name;
    private String phone;
    private String birth;
    private String mail;
    private String git;
    private String blog;
    private String portfolio;
}
