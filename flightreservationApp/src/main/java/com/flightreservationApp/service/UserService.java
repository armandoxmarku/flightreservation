package com.flightreservationApp.service;

import com.flightreservationApp.dto.user.UserDTO;
import com.flightreservationApp.dto.user.UserUpdateDTO;
import com.flightreservationApp.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public interface UserService {
    public UserDTO registerUser(UserDTO req, String userRole);
    UserUpdateDTO updateUser(Integer id, UserUpdateDTO req);
    public User loginUser(String email, String password);
    public User findById(Integer id);

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
