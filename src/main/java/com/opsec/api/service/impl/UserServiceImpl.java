package com.opsec.api.service.impl;

import com.opsec.api.client.UserCoreClient;
import com.opsec.api.error.ErrorCode;
import com.opsec.api.error.UserNotFoundException;
import com.opsec.api.model.User;
import com.opsec.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserCoreClient coreClient;


    @Override
    public User insertUserData(User person) {
        return null;
    }

    @Override
    public Collection<User> getAllUserInformation() {
        List<User> userList = coreClient.getAllUserInformation();
        if (userList.isEmpty()) {
            throw new UserNotFoundException(ErrorCode.USER_NOT_FOUND);
        }
        return userList;
    }

    @Override
    public Optional<User> getUserInformationUsingId(String id) {
        Optional<User> optionalUser = coreClient.getUserInformationUsingId(id);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException(ErrorCode.USER_NOT_FOUND);
        }
        return optionalUser;
    }

    @Override
    public void updateUserUsingId(String id, User user) {

        coreClient.updateUserUsingId(id, user);
    }

    @Override
    public void deleteUserUsingId(String id) {
        coreClient.deleteUserUsingId(id);
    }
}
