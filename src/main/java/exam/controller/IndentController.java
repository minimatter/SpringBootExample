package exam.controller;


import com.github.pagehelper.PageInfo;
import exam.bean.Department;
import exam.bean.Indent;
import exam.service.IIndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/indents")
public class IndentController {
    @Autowired
    IIndentService indentService;

    @GetMapping("/toIndent")
    public String toIndent(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                       int pageNum,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                                       int pageSize, @RequestParam Map<String,Object> queryMap, Model model){
        List<Indent> indentList=indentService.queryIndent(pageNum, pageSize);


        model.addAttribute("pageInfo",new PageInfo<>(indentList));
        model.addAttribute("indentList",indentList);
        return "indent/indentIndex";
    }


    @GetMapping("/toEdit")
    public String toEdit(int id,Model model){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        Indent indent=indentService.selectIndent(map);

        model.addAttribute("indent",indent);
        return "indent/indentEdit";
    }

    @RequestMapping("/toAddIndent")
    public String toAddIndent(){
        return "indent/indentAdd";
    }

    @GetMapping("/getDepartmentList")
    @ResponseBody
    public List<Department> departmentList(){
        return indentService.queryDepartment();
    }

    @PostMapping("updateIndent")
    @ResponseBody
    public boolean updateIndent(Indent indent){
        return indentService.updateIndent(indent)>0?true:false;
    }

    @PostMapping("/insertIndent")
    @ResponseBody
    public boolean insertIndent(Indent indent){
        return indentService.insertIndent(indent)>0?true:false;
    }

    @GetMapping("/deleteIndent")
    @ResponseBody
    public boolean deleteIndent(int id){
        return indentService.deleteIndent(id)>0?true:false;
    }

}
