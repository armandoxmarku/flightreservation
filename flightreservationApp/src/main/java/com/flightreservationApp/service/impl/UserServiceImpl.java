package com.flightreservationApp.service.impl;
import com.flightreservationApp.dto.user.UserDTO;
import com.flightreservationApp.dto.user.UserUpdateDTO;
import com.flightreservationApp.entity.User;
import com.flightreservationApp.entity.UserRole;
import com.flightreservationApp.exceptions.ResourceNotFountException;
import com.flightreservationApp.mapper.UserMapper;
import com.flightreservationApp.repository.UserRepository;
import com.flightreservationApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDTO registerUser(UserDTO req, String userRole) {
        User u = UserMapper.toEntity(req);
        u.setRole(userRole!=null? UserRole.fromValue(userRole):UserRole.CUSTOMER);
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u = userRepository.save(u);
        return UserMapper.toDto(u);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email).get();
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    @Override
    public UserUpdateDTO updateUser(Integer id, UserUpdateDTO req) {
        User u = findById(id);
        u = UserMapper.buildUpdateUser(u,req);
        return UserMapper.toUpdateDto(userRepository.save(u));
    }


    @Override
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFountException(String
                        .format("User with id %s not found",id)));
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                format("User with username - %s, not found", email)));
    }
}
