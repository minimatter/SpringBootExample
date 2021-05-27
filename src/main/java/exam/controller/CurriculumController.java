package exam.controller;

import com.github.pagehelper.PageInfo;
import exam.bean.Curriculum;
import exam.service.ICurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("curriculums")
public class CurriculumController {
    @Autowired
    ICurriculumService curriculumService;

    @GetMapping("/toCurriculum")
    public String toCurriculum(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                   int pageNum,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                                   int pageSize, @RequestParam Map<String,Object> queryMap, Model model){
        List<Curriculum> curriculumList=curriculumService.queryCurriculum(pageNum, pageSize);


        model.addAttribute("pageInfo",new PageInfo<>(curriculumList));
        model.addAttribute("curriculumList",curriculumList);
        return "curriculum/curriculumIndex";
    }

    @GetMapping("/toEdit")
    public String toEdit(int id,Model model){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        Curriculum curriculum=curriculumService.selectCurriculum(map);

        model.addAttribute("curriculum",curriculum);
        return "indent/curriculumEdit";
    }
}
