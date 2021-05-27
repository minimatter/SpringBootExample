package exam.dao;

import exam.bean.Department;
import exam.bean.Indent;

import java.util.List;
import java.util.Map;

public interface IndentDao {

    public List<Indent> queryIndent(Map<String,Object> map);
    public List<Department> queryDepartment();
    public int insertIndent(Indent indent);
    public int updateIndent(Indent indent);
    public int deleteIndent(int id);
}
