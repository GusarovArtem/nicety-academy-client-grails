package academy.microservices.listener.course

import academy.course.AcademyCourseType
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaListener
class AcademyCourseTypeListener {

    @Topic('createCourseType')
    void createCourse(AcademyCourseType type) {
        type.save flush: true
    }

    @Topic('updateCourseType')
    void updateCourse(AcademyCourseType type) {
        type.save flush: true
    }

    @Topic('deleteCourseType')
    void deleteCourse(Long id) {
        AcademyCourseType.findById(id).delete()
    }
}