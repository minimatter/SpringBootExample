package exam.bean;

import java.util.Date;

public class Curriculum {
    private int id;
    private String curriculumName;
    private String curriculumPeriod;
    private String curriculumType;
    private String curriculumTypeStr;
    private String credits;
    private String textbook;
    private String teacher;
    private Date courseDate;
    private String curriculumClass;
    private String registrant;
    private Date registerDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public String getCurriculumPeriod() {
        return curriculumPeriod;
    }

    public void setCurriculumPeriod(String curriculumPeriod) {
        this.curriculumPeriod = curriculumPeriod;
    }

    public String getCurriculumType() {
        return curriculumType;
    }

    public void setCurriculumType(String curriculumType) {
        this.curriculumType = curriculumType;
    }

    public String getCurriculumTypeStr() {
        return curriculumTypeStr;
    }

    public void setCurriculumTypeStr(String curriculumTypeStr) {
        this.curriculumTypeStr = curriculumTypeStr;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getTextbook() {
        return textbook;
    }

    public void setTextbook(String textbook) {
        this.textbook = textbook;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }

    public String getCurriculumClass() {
        return curriculumClass;
    }

    public void setCurriculumClass(String curriculumClass) {
        this.curriculumClass = curriculumClass;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
