package org.yeinp.hiimyein.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String id;
    private String userid;
    private String username;
    private String password;
    private int status;

}
