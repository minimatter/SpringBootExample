package exam.service.impl;

import com.github.pagehelper.PageHelper;
import exam.bean.Curriculum;
import exam.bean.CurriculumType;
import exam.dao.CurriculumDao;
import exam.service.ICurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CurriculumServiceImpl implements ICurriculumService {
    @Autowired
    private CurriculumDao curriculumDao;


    @Override
    public List<Curriculum> queryCurriculum(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return curriculumDao.queryCurriculum(null);
    }

    @Override
    public Curriculum selectCurriculum(Map<String, Object> map) {
        return curriculumDao.queryCurriculum(null).get(0);
    }

    @Override
    public List<CurriculumType> queryCurriculumType() {
        return curriculumDao.queryCurriculumType();
    }

    @Override
    public int insertCurriculum(Curriculum curriculum) {
        return curriculumDao.insertCurriculum(curriculum);
    }

    @Override
    public int updateCurriculum(Curriculum curriculum) {
        return curriculumDao.updateCurriculum(curriculum);
    }

    @Override
    public int deleteCurriculum(int id) {
        return curriculumDao.deleteCurriculum(id);
    }
}
