package academy.user

import academy.ControllerTrait
import academy.user.role.UserRole

trait UserControllerTrait implements ControllerTrait {

    @Override
    def targetDomainClass() {
        userDomainClass()
    }

    @Override
    void showMessage(userInstance, String code) {
        super.showMessage(userInstance.fullname(), code)
    }

    def _index(Integer max) {
        def userInstanceList = targetDomainClass().findAll()

        render model: [userInstanceClass: targetDomainClass(),
                       userInstanceList : userInstanceList], view: '/user/index'
    }

    def _show(AcademyUser userInstance) {
        userInstance.clearErrors()
        render model: [userInstance: userInstance], view: '/user/show'
    }

    def _create() {
        render model: [userInstance: targetDomainClass()
                .newInstance(params)], view: '/user/create'
    }

    def _save(AcademyUser userInstance) {
        if (!userInstance) {
            notFound()
            return
        }

        userInstance.createdOn = new Date()
        userInstance.clearErrors()
        userInstance.validate()

        if (userInstance.hasErrors()) {
            render model: [userInstance: userInstance], view: '/user/create'
            return
        }

        userInstance.save flush: true
        UserRole.create(userInstance, true)

        showMessage(userInstance, "default.created.message")
        redirect userInstance
    }


    def _edit(AcademyUser userInstance) {
        render model: [userInstance: userInstance], view: '/user/edit'
    }

    def _selfEdit(AcademyUser userInstance) {
        render model: [userInstance: userInstance], view: '/user/self_edit'
    }

    def _update(AcademyUser userInstance) {
        update(userInstance, "/user/edit")
    }

    def _selfUpdate(AcademyUser userInstance) {
        update(userInstance, "/user/self_edit")
    }

    private update(AcademyUser userInstance, view) {
        if (userInstance == null) {
            notFound()
            return
        }

        userInstance.validate()

        if (userInstance.hasErrors()) {
            render model: [userInstance: userInstance], view: view
            return
        }

        userInstance.save flush: true

        showMessage(userInstance, 'account.updated')
        redirect userInstance
    }

}
