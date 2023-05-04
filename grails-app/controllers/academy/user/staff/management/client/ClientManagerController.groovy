package academy.user.staff.management.client

import academy.user.UserControllerTrait
import academy.user.staff.management.ClientManager
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class ClientManagerController implements UserControllerTrait {

    def userDomainClass() {
        return ClientManager
    }

    def index(Integer max) {
        _index(max)
    }

    @Secured(['ROLE_ADMIN','ROLE_CLIENT_MANAGER'])
    def show(ClientManager userInstance) {
        _show(userInstance)
    }

    def create() {
        _create()
    }

    @Transactional
    def save(ClientManager userInstance) {
        _save(userInstance)
    }

    def edit(ClientManager userInstance) {
        _edit(userInstance)
    }

    @Secured(['ROLE_CLIENT_MANAGER'])
    def selfEdit(ClientManager userInstance) {
        _selfEdit(userInstance)
    }

    @Transactional
    def update(ClientManager userInstance) {
        _update(userInstance)
    }

    @Transactional
    @Secured(['ROLE_CLIENT_MANAGER'])
    def selfUpdate(ClientManager userInstance) {
        _selfUpdate(userInstance)
    }

}

