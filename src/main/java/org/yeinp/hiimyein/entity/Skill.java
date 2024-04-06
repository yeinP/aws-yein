package org.yeinp.hiimyein.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Setter
@Document(collection = "skill")
public class Skill {
    @Id
    private String id;
    private String div;
    private String skill;
}
