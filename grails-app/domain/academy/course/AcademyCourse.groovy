package academy.course

class AcademyCourse {

    String tittle

    String description

    AcademyCourseType courseType

    static constraints = {
        tittle       blank: false
        description  blank: false
        courseType   nullable: false
    }


}
