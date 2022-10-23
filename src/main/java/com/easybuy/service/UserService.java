package com.easybuy.service;

import com.easybuy.model.User;
import com.easybuy.repository.UserRepository;
import com.easybuy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserVO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserVO> usersVO = new ArrayList<>();
        for (User user : users) {
            usersVO.add(convertUserToUserVO(user));
        }
        return usersVO;
    }

    private UserVO convertUserToUserVO(User user) {
        UserVO userVO = new UserVO();
        userVO.setUserId(user.getUserId());
        userVO.setUserPass(user.getUserPass());
        userVO.setUserName(user.getUserName());
        userVO.setFirstName(user.getFirstName());
        userVO.setLastName(user.getLastName());
        userVO.setAddress(user.getAddress());
        userVO.setMobile(user.getMobile());
        userVO.setEmail(user.getEmail());
        return userVO;
    }

    public UserVO getUserById(Integer userId) throws Exception {
        User user = checkUserbyIdExist(userId);
        UserVO userVO = convertUserToUserVO(user);
        return userVO;
    }

    private User checkUserbyIdExist(Integer userId) throws Exception {
        Optional<User> user1 = userRepository.findById(userId);
        User user = user1.orElseThrow(() -> new Exception("User not found"));
        return user;
    }

    public Integer saveUser(UserVO userVO) {
        User user = convertUserVOToUser(userVO);
        User savedUser = userRepository.save(user);
        return savedUser.getUserId();
    }

    private User convertUserVOToUser(UserVO userVO) {
        User user = new User();
        user.setUserName(userVO.getUserName());
        user.setUserPass(userVO.getUserPass());
        user.setFirstName(userVO.getFirstName());
        user.setLastName(userVO.getLastName());
        user.setAddress(userVO.getAddress());
        user.setMobile(userVO.getMobile());
        user.setEmail(userVO.getEmail());
        return user;
    }

    public Boolean deleteById(Integer userId) {
        try {
            User user = checkUserbyIdExist(userId);
            userRepository.delete(user);
        } catch (Exception e) {
            System.out.println("unable to delete");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean updateUser(Integer userId, UserVO userVO) {
        try {
            checkUserbyIdExist(userId);
            User user = convertUserVOToUser(userVO);
            user.setUserId(userId);
            userRepository.save(user);
        } catch (Exception e) {
            System.out.println("unable to update");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
