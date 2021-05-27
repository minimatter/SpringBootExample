package exam.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import exam.bean.Company;
import exam.bean.Student;
import exam.bean.StudentMajor;
import exam.bean.Undertake;
import exam.service.ICompanyService;
import exam.service.IStudentService;
import exam.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/Company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @Value("${upload.uploadPath}")
    private String uploadPath;


    @RequestMapping("")
    String home() {
        return "Hello World!";
    }
    //@ResponseBody


    @RequestMapping(value = "/company", method = {RequestMethod.POST,RequestMethod.GET})
    public String queryStudents(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                            int pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                                            int pageSize,
                                @RequestParam Map<String,Object> queryMap,
                                Model model,
                                HttpServletRequest request) {
        //开始分页
        //PageHelper.startPage(pageNum,pageSize);
//
//        HttpSession session=request.getSession();//这就是session的创建
//        session.setAttribute("username","测试");


        List<Company> companyList = companyService.selectCompany(pageNum, pageSize,queryMap);


        model.addAttribute("pageInfo",new PageInfo<>(companyList));
        model.addAttribute("companyList", companyList);
        model.addAttribute("queryMap",queryMap);

        return "company/companyIndex";

    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
//        model.addAttribute("name","测试");
        return "hello";
    }



    @GetMapping("/getUndertake")
    @ResponseBody
    public List<Undertake> getUndertake(){
        return companyService.queryUndertake();
    }

    @ResponseBody
    @PostMapping("/add")
    public boolean add(Company company){
        //把字符串转换成日期格式
        ObjectMapper mapper=new ObjectMapper();
        mapper.getDateFormat();
        company.setStorageDate(new Date());
        company.setIdentity("zhaokaiyao");
       // String fileName= FileUtil.uploadFileSingle(file,uploadPath);


       // student.setFileNameSrc(student.getUploadFile().getOriginalFilename());
       return companyService.insertCompany(company,uploadPath)>0?true:false;


    }

    @GetMapping("/toAdd")
    public String toAdd(){

        return "company/add";
    }

//    @GetMapping("/toUpdate")
//    public String toUpdate(int id,Model model){
//
//        Map<String,Object> map=new HashMap<String,Object>();
//        map.put("id",id);
//
//        Student student = studentService.selectStudent(1,1,map).get(0);
//
//        model.addAttribute("student",student);
//
//        return "student/update";
//    }
//
//    @ResponseBody
//    @PostMapping("/update")
//    public boolean update(Student student){
//
//        return studentService.updateStudent(student,uploadPath)>0?true:false;
//
//    }

//    @ResponseBody
//    @GetMapping("/delete")
//    public boolean delete(int id){
//        return studentService.deleteStudent(id)>0?true:false;
//    }

//    @GetMapping("/toDetail")
//    public String toDetail(int id,Model model){
//
//        Map<String,Object> map=new HashMap<String,Object>();
//        map.put("id",id);
//
//        Student student = studentService.selectStudentSingle(map);
//
//        model.addAttribute("student",student);
//
//        return "student/detail";
//    }


    /**
     *
     * 下载文件
     *
     */
    @GetMapping("/downloadFile")
    public void downloadFile(HttpServletResponse response,String fileName,String fileNameSrc){

        FileUtil.downloadFile(response,uploadPath,fileName);


        //中文乱码使用UTF-8
        try {
            response.setHeader("Content-Disposition", "attachment;fileName="+ java.net.URLEncoder.encode(fileNameSrc, "UTF-8"));
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

}