package me.hahahah.controller.backend;

import com.github.pagehelper.PageHelper;
import me.hahahah.common.Const;
import me.hahahah.common.ResponseCode;
import me.hahahah.common.ServerResponse;
import me.hahahah.pojo.User;
import me.hahahah.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        ServerResponse response = iUserService.login(session.getId());

        if(response.getMsg().equals("登陆成功")) {
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse userList(HttpSession session, @RequestParam(value="pageNum",defaultValue = "1") int pageNum,@RequestParam(value="pageSize",defaultValue = "10") int pageSize) {
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null ) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LONIN.getCode(),ResponseCode.NEED_LONIN.getDesc());
        }
        return iUserService.getUserList(pageNum,pageSize);
    }

}
