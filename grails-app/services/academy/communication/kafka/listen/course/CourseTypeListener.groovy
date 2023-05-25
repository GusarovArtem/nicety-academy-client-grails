package academy.communication.kafka.listen.course

import academy.course.CourseType
import grails.gorm.transactions.Transactional
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.Topic

@Transactional
@KafkaListener
class CourseTypeListener {

    @Topic('createCourseType')
    void createCourse(CourseType type) {
        type.save flush: true
    }

    @Topic('updateCourseType')
    void updateCourse(CourseType type) {
        type.save flush: true
    }

    @Topic('deleteCourseType')
    void deleteCourse(Long id) {
        CourseType.findById(id).delete()
    }
}