package exam.dao;

import exam.bean.Department;
import exam.bean.Indent;

import java.util.List;
import java.util.Map;

public interface WordDao {
    public List<Indent> queryIndent(Map<String ,Object> map);

    public List<Department> queryDP();  //查询

    public int insertIndent(Indent indent);  //插入

    public int updateIndent(Indent indent);  //修改

    public int deleteIndent(int id);      //删除


}
