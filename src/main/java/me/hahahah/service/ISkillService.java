package me.hahahah.service;

import me.hahahah.common.ServerResponse;
import me.hahahah.pojo.Skill;

import java.util.List;

public interface ISkillService {
    ServerResponse<String> add(Skill skill);

    ServerResponse<String> del(Skill skill);

    ServerResponse<String> update(Skill skill);

    ServerResponse<List<Skill>> getChildrenParallelSkill(Integer id);

    ServerResponse selectSkillAndChildrenById(Integer preId);
}
