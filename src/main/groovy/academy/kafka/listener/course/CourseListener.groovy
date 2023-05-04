package academy.kafka.listener.course


import academy.course.Course
import grails.gorm.transactions.Transactional
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.Topic

@Transactional
@KafkaListener
class CourseListener {

    @Topic('createCourse')
    void createCourse(Course course) {
        course.save flush: true
    }

    @Topic('updateCourse')
    void updateCourse(Course course) {
        course.save flush: true
    }

    @Topic('deleteCourse')
    void deleteCourse(Long id) {
        Course.findById(id).delete()
    }
}