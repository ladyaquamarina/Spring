package com.marina.spring.dto;

import com.marina.spring.model.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    private String username;
    private String password;
    private UserRole role;

    public boolean valid() {
        return this.username != null && this.password != null && this.role != null
                && !this.username.isBlank() && !this.password.isBlank();
    }
}
