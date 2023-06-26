package com.cly.finalproj.service;

import com.cly.finalproj.entity.User;
import com.cly.finalproj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HashService hashService;

    public List<User> findAllUsers(){
        return userMapper.findAllUsers();
    };

    public int insertUser(User user){
        return userMapper.insert(user);
    }

    public boolean isUsernameAvailable(String username) {
        return userMapper.getUser(username) == null;
    }

    public int createUser(User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        return userMapper.insert(new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstName(), user.getLastName(), null));
    }

    public User findUserById(int id){
        return userMapper.findUserById(id);
    }

    public User getUser(String username){
        return userMapper.getUser(username);
    }
}
