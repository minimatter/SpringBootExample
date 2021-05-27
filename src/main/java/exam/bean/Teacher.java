package exam.bean;

import java.util.Date;

public class Teacher {
    private Integer id;
    //教师类型 1C语言 2java语言 3网页设计
    private Integer teacherType;
    //教师类型Str
    private String teacherTypeStr;
    //教师所在学院
    private String teacherCollege;
    //教师编号
    private String teacherNumber;
    //入职日期
    private Date entryDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(Integer teacherType) {
        this.teacherType = teacherType;
    }

    public String getTeacherCollege() {
        return teacherCollege;
    }

    public void setTeacherCollege(String teacherCollege) {
        this.teacherCollege = teacherCollege;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherTypeStr() {
        return teacherTypeStr;
    }

    public void setTeacherTypeStr(String teacherTypeStr) {
        this.teacherTypeStr = teacherTypeStr;
    }


    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}
