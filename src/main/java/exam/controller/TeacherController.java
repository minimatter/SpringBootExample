package exam.controller;

import com.github.pagehelper.PageInfo;
import exam.bean.Teacher;
import exam.bean.teacherType;
import exam.service.ITeacherService;
import exam.service.ITeacherTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private ITeacherTypeService teacherTypeService;

    @RequestMapping("")
    String home() {
        return "Hello World!";
    }
    //@ResponseBody

    @RequestMapping(value = "/teacher", method = {RequestMethod.POST,RequestMethod.GET})
    public String queryTeachers(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                        int pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                                        int pageSize,@RequestParam Map<String,Object> queryMap,Model model,HttpServletRequest request) {
        //开始分页
        //PageHelper.startPage(pageNum,pageSize);



        HttpSession session=request.getSession();//这就是session的创建
        session.setAttribute("username","测试");


        List<Teacher> teacherList = teacherService.selectTeacher(pageNum, pageSize);

        model.addAttribute("pageInfo",new PageInfo<>(teacherList));
        model.addAttribute("teacherList",teacherList);
        return "teacher/teacherIndex";

    }



    @ResponseBody
    @PostMapping("/add")
    public boolean add(Teacher teacher){

        return teacherService.insertTeacher(teacher)>0?true:false;


    }

    @GetMapping("/toAdd")
    public String toAdd(){

        return "teacher/teacherAdd";
    }

    @GetMapping("/toUpdate")
    public String toUpdate(int id,Model model){

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id",id);

        Teacher teacher = teacherService.selectTeacherSingle(map);

        model.addAttribute("teacher",teacher);

        return "teacher/teacherUpdate";
    }

    @ResponseBody
    @PostMapping("/update")
    public boolean update(Teacher teacher){

        return teacherService.updateTeacher(teacher)>0?true:false;

    }

    @ResponseBody
    @GetMapping("/delete")
    public boolean delete(int id){
        return teacherService.deleteTeacher(id)>0?true:false;
    }

    @GetMapping("/toDetail")
    public String toDetail(int id,Model model){

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id",id);

        Teacher teacher = teacherService.selectTeacherSingle(map);

        model.addAttribute("teacher",teacher);

        return "teacher/teacherDetail";
    }




    @ResponseBody
    @GetMapping("selectTeacherType")
    public List<teacherType> selectTeacherType(){
        return teacherTypeService.selectTeacherType();
    }

}