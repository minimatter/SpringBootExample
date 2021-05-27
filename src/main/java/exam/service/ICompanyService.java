package exam.service;

import exam.bean.Company;
import exam.bean.Student;
import exam.bean.StudentMajor;
import exam.bean.Undertake;

import java.util.List;
import java.util.Map;

public interface ICompanyService {
    public List<Company> selectCompany(int pageNum, int pageSize, Map<String,Object> map);


    public List<Undertake> queryUndertake();

    public int insertCompany(Company company,String uploadPath);

  //  public int updateCompany(Student student,String uploadPath);

  //  public int deleteStudent(int id);

   // public Student selectCompany(Map<String,Object> map);

}
