package com.flightreservationApp.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    //@NotEmpty(message = "Username is required")
    private String username;
    //@NotEmpty(message = "Create a password")
    private String password;
    // @NotEmpty(message = "Name is required")
    private String firstname;
    // @NotEmpty(message = "Lastname is required")
    private String lastname;
    //@NotEmpty(message = "email is required")
    private String email;
   // @NotEmpty(message = "Select role")
    private String role;

}
