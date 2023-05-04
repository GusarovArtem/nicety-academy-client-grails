package academy


import academy.user.UserType
import academy.user.role.Role
import academy.user.role.UserRole
import academy.user.staff.administration.Admin

class BootStrap {

    def grailsApplication

    def domainService

    def init = { servletContext ->

        log.info 'BOOTSTRAPPING start'

        createAcademyRolesIfNotExist()
        createSuperAdminIfNotExists()

        log.info 'BOOTSTRAPPING end'

    }

    def destroy = {
    }

    private void createAcademyRolesIfNotExist() {
        createAcademyRoleIfNotExists(UserType.CLIENT)
        createAcademyRoleIfNotExists(UserType.CLIENT_MANAGER)
        createAcademyRoleIfNotExists(UserType.ADMIN)
    }

    private void createAcademyRoleIfNotExists(UserType userType) {
        domainService.createIfNotExists(
                { Role.findByAuthority(userType.role) },
                { new Role(authority: userType.role) }
        )
    }

    private void createSuperAdminIfNotExists() {
        def SUPER_ADMIN = grailsApplication.config.academy.user.super_admin
        Admin admin

        domainService.createAllIfNotExist(
                { Admin.findByEmail(SUPER_ADMIN.email) },
                [
                        {
                            admin = new Admin(
                                    enabled: true,
                                    createdOn: new Date(),
                                    name     : SUPER_ADMIN.name,
                                    surname  : SUPER_ADMIN.surname,
                                    email    : SUPER_ADMIN.email,
                                    password : SUPER_ADMIN.password,
                                    passwordConfirm: SUPER_ADMIN.password
                            )
                        },
                        {
                            new UserRole(admin, Role.findByAuthority(UserType.ADMIN.role))
                        }
                ]
        )
    }

}
