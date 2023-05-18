package pl.shonsu.user.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;
import java.util.List;

public class Authorities implements Serializable{
    @Enumerated(EnumType.STRING)
    private List<UserRole> userRoles;

    public List<UserRole> getUserRoles() {
        return userRoles;
    }
}