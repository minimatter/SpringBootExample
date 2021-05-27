package exam.dao;

import exam.bean.Student;
import exam.bean.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherDao {

    public int insertTeacher(Teacher teacher);

    public List<Teacher> selectTeacher(Map<String,Object> map);

    public int updateTeacher(Teacher teacher);

    public int deleteTeacher(int id);

}
