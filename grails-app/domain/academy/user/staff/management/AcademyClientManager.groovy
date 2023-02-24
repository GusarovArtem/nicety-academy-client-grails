package academy.user.staff.management

import academy.user.AcademyUser
import academy.user.security.AcademyUserType

class AcademyClientManager extends AcademyUser {

    {
        this.userType = AcademyUserType.CLIENT_MANAGER
    }

}
