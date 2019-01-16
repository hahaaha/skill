package me.hahahah.service.impl;

import me.hahahah.common.ServerResponse;
import me.hahahah.dao.UserMapper;
import me.hahahah.pojo.User;
import me.hahahah.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;
    public ServerResponse<User> login(String id) {
        int resultCount = userMapper.checkUsername(id);
        if(resultCount >0) {
            int updateResult = userMapper.updateTime(id);
            if(updateResult > 0){
                return ServerResponse.createBySuccess("登陆成功");
            }
        } else {
            User user = new User();
            user.setUsername(id);
            user.setStatus((long)0);
            int res = userMapper.insert(user);
            if(res > 0) {
                return ServerResponse.createBySuccess("登陆成功");
            }
        }

        return ServerResponse.createByErrorMessage("登录失败");
    }

}
