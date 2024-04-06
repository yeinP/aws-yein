package org.yeinp.hiimyein.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@Document(collection = "user")
public class User {
    @Id
    private String id;

    private String userid;
    private String username;
    private String password;
    private int status;

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }
}