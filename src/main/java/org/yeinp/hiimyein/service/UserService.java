package org.yeinp.hiimyein.service;

import org.yeinp.hiimyein.dto.MeDto;
import org.yeinp.hiimyein.dto.UserDto;
import org.yeinp.hiimyein.entity.Me;
import org.yeinp.hiimyein.entity.User;

import javax.swing.text.Document;

public interface UserService {
   default UserDto userEntityToUserDto(User user){
       return UserDto.builder().id(user.getId()).
               userid(user.getUserid()).username(user.getUsername()).
               password(user.getPassword()).status(user.getStatus()).
               build();
   }

    UserDto loginUser(String userid, String password);

   default MeDto meEntityToMeDto(Me me){
       return MeDto.builder().id(me.getId())
               .name(me.getName())
               .phone(me.getPhone())
               .birth(me.getBirth())
               .git(me.getGit())
               .mail(me.getMail())
               .blog(me.getBlog())
               .portfolio(me.getPortfolio()).build();
   }

    default Me MeDtoEntityToMe(MeDto meDto){
        return Me.builder().id(meDto.getId())
                .name(meDto.getName())
                .phone(meDto.getPhone())
                .birth(meDto.getBirth())
                .git(meDto.getGit())
                .mail(meDto.getMail())
                .blog(meDto.getBlog())
                .portfolio(meDto.getPortfolio()).build();
    }

   MeDto getAboutMe(String name);

}
