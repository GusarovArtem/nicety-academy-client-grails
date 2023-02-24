package academy.user.security

enum AcademyUserType {

//  Client
    CLIENT(null, "ROLE_CLIENT"),

//  Management
    CLIENT_MANAGER("academyClientManager", "ROLE_CLIENT_MANAGER")

    String role

    String controller

    AcademyUserType(String controller, String role) {
        this.controller = controller
        this.role = role
    }
}