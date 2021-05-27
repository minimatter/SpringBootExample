package exam.service.impl;

import exam.bean.teacherType;
import exam.dao.TeacherTypeDao;
import exam.service.ITeacherTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherTypeServiceImpl implements ITeacherTypeService {
    @Autowired
    private TeacherTypeDao teacherTypeDao;

    @Override
    public List<teacherType> selectTeacherType() {
        return teacherTypeDao.selectTeacherType();
    }
}
