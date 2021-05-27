package exam.service;

import exam.bean.Student;
import exam.bean.StudentMajor;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    public List<Student> selectStudent(int pageNum, int pageSize,Map<String,Object> map);

    public List<StudentMajor> queryStudentMajor();

    public int insertStu(Student student,String uploadPath);

    public int updateStudent(Student student,String uploadPath);

    public int deleteStudent(int id);

    public Student selectStudentSingle(Map<String,Object> map);

}
