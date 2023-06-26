package com.cly.finalproj.mapper;

import com.cly.finalproj.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> findAllUsers();

    int insert(User user);

    User findUserById(int userId);

    User getUser(String username);

}
