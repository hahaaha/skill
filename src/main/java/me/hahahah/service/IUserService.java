package me.hahahah.service;

import com.github.pagehelper.PageInfo;
import me.hahahah.common.ServerResponse;
import me.hahahah.pojo.User;

public interface IUserService {
    ServerResponse<User> login(String id);
    ServerResponse add(Integer userId,Integer skillId);
    ServerResponse<PageInfo> getUserList(int pageNum, int pageSize);
}
