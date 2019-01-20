package me.hahahah.controller.portal;

import me.hahahah.common.Const;
import me.hahahah.common.ResponseCode;
import me.hahahah.common.ServerResponse;
import me.hahahah.pojo.User;
import me.hahahah.service.IUserService;
import net.sf.jsqlparser.schema.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/skill/")
public class UserController {
    @Autowired
    IUserService iUserService;
    /**
     * 提高用户的等级，每次只能提高一级
     * @param session
     * @param skill_id 技能id
     * @return
     */
    @RequestMapping("add.do")
    @ResponseBody
    public ServerResponse add(HttpSession session,Integer skill_id) {
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null ) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LONIN.getCode(),ResponseCode.NEED_LONIN.getDesc());
        }
        return iUserService.add(user.getId(),skill_id);
    }


}
