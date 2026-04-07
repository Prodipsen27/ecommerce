package com.ecommerce.project.security.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

public class SignupRequest {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank
    @Size(min= 3, max = 30)
    private String username;

    @NotBlank
    @Size(min=4, max = 50)
    private String email;
    private Set<String> role;

    @NotBlank
    @Size(min=6, max= 30)
    private String password;
}
