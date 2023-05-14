package pl.shonsu.user.model;

enum UserRole {
    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER"),
    ROLE_HELPDESK("HELPDESK");
    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
