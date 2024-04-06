package org.yeinp.hiimyein.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeinp.hiimyein.dto.MeDto;
import org.yeinp.hiimyein.dto.UserDto;
import org.yeinp.hiimyein.entity.Me;
import org.yeinp.hiimyein.entity.User;
import org.yeinp.hiimyein.exception.WrongIdPasswordException;
import org.yeinp.hiimyein.repository.MeRepository;
import org.yeinp.hiimyein.repository.UserRepository;

import javax.swing.text.Document;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MeRepository meRepository;


    public UserDto loginUser(String userid, String password) {
        User user = userRepository.findByUserid(userid);
        if (user == null) {
            throw new WrongIdPasswordException();
        }
        if (!user.matchPassword(password)) {
            throw new WrongIdPasswordException();
        }
        return new UserDto(user.getId(), user.getUserid(), user.getUsername(), user.getPassword(), user.getStatus());
    }

    @Override
    public MeDto getAboutMe(String name) {
        Me me = meRepository.findByName(name);
        return meEntityToMeDto(me);
    }


}
