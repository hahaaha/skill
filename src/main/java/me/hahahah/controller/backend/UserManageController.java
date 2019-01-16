package me.hahahah.controller.backend;

import me.hahahah.common.ServerResponse;
import me.hahahah.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")

public class UserManageController {
    @Autowired
    IUserService iUserService;

    @RequestMapping("login.do")
    @ResponseBody
    public ServerResponse login(HttpSession session) {
        return iUserService.login(session.getId());
    }
}
