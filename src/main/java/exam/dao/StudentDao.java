package exam.dao;

import exam.bean.Student;
import exam.bean.StudentMajor;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public int insertStu(Student student);

    public List<Student> selectStudent(Map<String,Object> map);

    public List<StudentMajor> queryStudentMajor();

    public int updateStudent(Student student);

    public int deleteStudent(int id);

}
