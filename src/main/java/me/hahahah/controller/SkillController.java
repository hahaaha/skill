package me.hahahah.controller;

import me.hahahah.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/skill/")
public class SkillController {
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<String> list() {
        return ServerResponse.createBySuccess();
    }
}
