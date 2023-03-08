package academy.microservices.listener.course

import academy.course.AcademyCourse
import grails.gorm.transactions.Transactional
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.Topic

@Transactional
@KafkaListener
class AcademyCourseListener {

    @Topic('createCourse')
    void createCourse(AcademyCourse course) {
        course.save flush: true
    }

    @Topic('updateCourse')
    void updateCourse(AcademyCourse course) {
        course.save flush: true
    }

    @Topic('deleteCourse')
    void deleteCourse(Long id) {
        AcademyCourse.findById(id).delete()
    }
}