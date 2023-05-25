package academy.user

enum UserType {

//  Client
    CLIENT(null, "ROLE_CLIENT"),

//  Management
    CLIENT_MANAGER("academyClientManager", "ROLE_CLIENT_MANAGER"),
    
//  Administration
    ADMIN("academyAdmin", "ROLE_ADMIN");


    String role

    String controller

    UserType(String controller, String role) {
        this.controller = controller
        this.role = role
    }
}