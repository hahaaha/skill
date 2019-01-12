package me.hahahah.controller.portal;


import me.hahahah.common.ServerResponse;
import me.hahahah.pojo.Skill;
import me.hahahah.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/skill/")
public class SkillController {
    @Autowired
    private ISkillService iSkillService;
 }
