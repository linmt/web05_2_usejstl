package entity;

/**
 * Created by ���޻� on 2018/9/19.
 */
public class Course {
    private Integer courseId;
    private String name;
    private Integer days;

    public Integer getId() {
        return courseId;
    }

    public void setId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}
