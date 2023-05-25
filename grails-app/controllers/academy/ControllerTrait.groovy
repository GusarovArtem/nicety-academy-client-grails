package academy

import grails.util.GrailsNameUtils
import grails.web.api.WebAttributes

trait ControllerTrait implements WebAttributes {

    def targetDomainClass() {}

    void showMessage(def target, String code) {
        flash.message =
                message(code: code,
                        args: [ message(code: GrailsNameUtils.getPropertyName(targetDomainClass()) + '.label'),
                                target ]
                )
    }

    def notFound() {
        showMessage(params.id, "default.not.found.message")

        redirect action: "index", method: "GET"
    }

}