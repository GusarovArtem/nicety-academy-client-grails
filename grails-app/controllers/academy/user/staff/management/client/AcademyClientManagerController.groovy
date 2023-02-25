package academy.user.staff.management.client

import academy.user.AcademyUserControllerTrait
import academy.user.staff.management.AcademyClientManager
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class AcademyClientManagerController implements AcademyUserControllerTrait {

    def userDomainClass() {
        return AcademyClientManager
    }

    def index(Integer max) {
        _index(max)
    }

    @Secured(['ROLE_ADMIN','ROLE_CLIENT_MANAGER'])
    def show(AcademyClientManager userInstance) {
        _show(userInstance)
    }

    def create() {
        _create()
    }

    @Transactional
    def save(AcademyClientManager userInstance) {
        _save(userInstance)
    }

    def edit(AcademyClientManager userInstance) {
        _edit(userInstance)
    }

    @Secured(['ROLE_CLIENT_MANAGER'])
    def selfEdit(AcademyClientManager userInstance) {
        _selfEdit(userInstance)
    }

    @Transactional
    def update(AcademyClientManager userInstance) {
        _update(userInstance)
    }

    @Transactional
    @Secured(['ROLE_CLIENT_MANAGER'])
    def selfUpdate(AcademyClientManager userInstance) {
        _selfUpdate(userInstance)
    }

}

