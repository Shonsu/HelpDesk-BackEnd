package pl.shonsu.user.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.List;

public class Authorities {
    @Enumerated(EnumType.STRING)
    List<UserRole> userRoles;

    public List<UserRole> getUserRoles() {
        return userRoles;
    }
}