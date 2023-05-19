package dev.application.paymentInfo.Service;

import dev.application.paymentInfo.Dto.UserDto;
import dev.application.paymentInfo.Entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByUsername(String username);
    List<UserDto> findAllUsers();
}
