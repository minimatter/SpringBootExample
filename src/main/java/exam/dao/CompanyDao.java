package exam.dao;

import exam.bean.Company;
import exam.bean.Student;
import exam.bean.StudentMajor;
import exam.bean.Undertake;

import java.util.List;
import java.util.Map;

public interface CompanyDao {

    public int insertCompany(Company company);

    public List<Company> selectCompany(Map<String,Object> map);

    public List<Undertake> queryUndertake();

   // public int updateCompany(Company company);

    public int deleteCompany(int id);

}
