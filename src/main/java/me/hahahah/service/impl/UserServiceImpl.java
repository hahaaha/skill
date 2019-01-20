package me.hahahah.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.hahahah.common.ServerResponse;
import me.hahahah.dao.SkillByUserMapper;
import me.hahahah.dao.UserMapper;
import me.hahahah.pojo.SkillByUser;
import me.hahahah.pojo.User;
import me.hahahah.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    SkillByUserMapper skillByUserMapper;

    public ServerResponse<User> login(String id) {
        int resultCount = userMapper.checkUsername(id);
        if(resultCount >0) {
            int updateResult = userMapper.updateTime(id);
            if(updateResult > 0){
                User user = userMapper.selectByUsername(id);
                return ServerResponse.createBySuccess("登陆成功",user);
            }
        } else {
            User user = new User();
            user.setUsername(id);
            user.setStatus((long)0);
            int res = userMapper.insert(user);
            if(res > 0) {
                User newUser = userMapper.selectByUsername(id);
                return ServerResponse.createBySuccess("登陆成功",newUser);
            }
        }
        return ServerResponse.createByErrorMessage("登录失败");
    }

    public ServerResponse add(Integer userId,Integer skillId) {
        SkillByUser skillByUser = skillByUserMapper.checkGrade(userId,skillId);
        if(skillByUser == null){
            int resultCount = this.addSkillByUser(userId,skillId);
            if(resultCount > 0) {
                return ServerResponse.createBySuccess("升级成功",skillByUserMapper.checkGrade(userId,skillId));
            }
        } else {
            int grade = skillByUser.getGrade();
            skillByUser.setGrade(grade+1);
            int resultCount = skillByUserMapper.updateByPrimaryKeySelective(skillByUser);
            if(resultCount > 0) {
                return ServerResponse.createBySuccess("升级成功",skillByUserMapper.checkGrade(userId,skillId));
            }
            return ServerResponse.createByErrorMessage("升级失败");
        }

        return ServerResponse.createByErrorMessage("升级失败");
    }

    private int addSkillByUser(Integer userId,Integer skillId) {
        SkillByUser skillByUser = new SkillByUser();
        skillByUser.setUserId(userId);
        skillByUser.setSkillId(skillId);
        skillByUser.setGrade(1);
        return skillByUserMapper.insert(skillByUser);
    }

    public ServerResponse<PageInfo> getUserList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList =  userMapper.selectList();
        PageInfo pageResult = new PageInfo(userList);
        return ServerResponse.createBySuccess(pageResult);
    }

}
