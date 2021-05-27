package exam.dao;

import exam.bean.TestA;

public interface TestAMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestA record);

    int insertSelective(TestA record);

    TestA selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestA record);

    int updateByPrimaryKey(TestA record);
}