package academy.course

class Course {

    String tittle

    String description

    CourseType courseType

    static constraints = {
        tittle       blank: false
        description  blank: false
        courseType   nullable: false
    }


}
