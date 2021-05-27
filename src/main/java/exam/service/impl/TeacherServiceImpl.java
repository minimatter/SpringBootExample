package exam.service.impl;

import com.github.pagehelper.PageHelper;
import exam.bean.Student;
import exam.bean.Teacher;
import exam.dao.TeacherDao;
import exam.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> selectTeacher(int pageNum, int pageSize) {

        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Teacher> teacherList=teacherDao.selectTeacher(null);

        return teacherList;
    }

    @Override
    public int insertTeacher(Teacher teacher) {
        return teacherDao.insertTeacher(teacher);
    }


    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    @Override
    public int deleteTeacher(int id) {
        return teacherDao.deleteTeacher(id);
    }

    @Override
    public Teacher selectTeacherSingle(Map<String, Object> map) {
        Teacher teacher;
        teacher=teacherDao.selectTeacher(map).get(0);
        switch (teacher.getTeacherType())
        {
            case 1:{
                teacher.setTeacherTypeStr("C语言老师");
                break;
            }
            case 2:{
                teacher.setTeacherTypeStr("Java老师");
                break;
            }
            case 3:{
                teacher.setTeacherTypeStr("网页设计");
                break;
            }
        }
        return teacher;
    }


}
