package org.yeinp.hiimyein.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MeDto {
    private String id;
    private String name;
    private String phone;
    private String birth;
    private String mail;
    private String git;
    private String blog;
    private String portfolio;
}
