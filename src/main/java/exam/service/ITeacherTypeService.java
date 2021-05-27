package exam.service;

import exam.bean.teacherType;
import org.springframework.stereotype.Service;

import java.util.List;



public interface ITeacherTypeService {
    public List<teacherType> selectTeacherType();

}
