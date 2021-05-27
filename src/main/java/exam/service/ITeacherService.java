package exam.service;

import exam.bean.Student;
import exam.bean.Teacher;

import java.util.List;
import java.util.Map;

public interface ITeacherService {
    public int insertTeacher(Teacher teacher);
    public List<Teacher> selectTeacher(int pageNum, int pageSize);

    public int updateTeacher(Teacher teacher);

    public int deleteTeacher(int id);

    public Teacher selectTeacherSingle(Map<String,Object> map);
}
