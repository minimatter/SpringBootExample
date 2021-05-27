package exam.dao;

import exam.bean.Curriculum;
import exam.bean.CurriculumType;

import java.util.List;
import java.util.Map;

public interface CurriculumDao {
    public List<Curriculum> queryCurriculum(Map<String,Object> map);
    public List<CurriculumType> queryCurriculumType();
    public int insertCurriculum(Curriculum curriculum);
    public int updateCurriculum(Curriculum curriculum);
    public int deleteCurriculum(int id);
}
