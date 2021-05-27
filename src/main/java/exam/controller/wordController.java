package exam.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import exam.bean.Department;
import exam.bean.Indent;
import exam.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class wordController {
    @Autowired
    IWordService wordService;

    @GetMapping("/toWord")
    public String toWord(Model model){
        List<Indent> indentList=wordService.queryIndent(null);

        model.addAttribute("indentList",indentList);
        return "world";
    }

    @GetMapping("/toEdit")
    public String toEidt(int id, Model model){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        Indent indent=wordService.queryIndent(map).get(0);
        model.addAttribute("indent",indent);
        return "indentEdit";
    }

    @GetMapping("/toAddIndent")
    public String toAddIndent(){
        return "indentAdd";
    }



    @RequestMapping("/indentList")
    @ResponseBody
    public List<Indent> indentList(){
        return wordService.queryIndent(null);
    }

    @GetMapping("/departmentList")
    @ResponseBody
    public List<Department> departmentsList()
    {
        return wordService.queryDP();
    }

    @PostMapping("/addIndent")
    @ResponseBody
    public boolean insertIndent(Indent indent){
        return wordService.insertIndent(indent)>0?true:false;
    }

    @PostMapping("/updateIndent")
    @ResponseBody
    public boolean updateIndent(Indent indent){
        return wordService.updateIndent(indent)>0?true:false;
    }

    @GetMapping("/deleteIndent")
    @ResponseBody
    public boolean deleteIndent(int id){
        return wordService.deleteIndent(id)>0?true:false;
    }

}
