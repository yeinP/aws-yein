package org.yeinp.hiimyein.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SkillDto {
    private String id;
    private String div;
    private String skill;
}
