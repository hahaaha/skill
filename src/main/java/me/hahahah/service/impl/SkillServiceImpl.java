package me.hahahah.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import me.hahahah.common.ServerResponse;
import me.hahahah.dao.SkillMapper;
import me.hahahah.pojo.Skill;
import me.hahahah.service.ISkillService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("iSkillService")
public class SkillServiceImpl implements ISkillService {
    @Autowired
    private SkillMapper skillMapper;

    /**
     * 增加技能
     * @param skill
     * @return
     */
    public ServerResponse<String> add(Skill skill) {
        // 检验技能是否存在
        if(skillMapper.checkSkillName(skill.getSkillName()) > 0) {
            return ServerResponse.createByErrorMessage("此技能已存在");
        }
        // 检验pre_id参数是否存在，如果不存在默认给0
        if(skill.getPreId() == null) {
            skill.setPreId(0);
        }
        if(skill.getMaxGrade() == null) {
            skill.setMaxGrade(3);
        }
        if(skill.getStatus() == null) {
            skill.setStatus((long) 1);
        }
        int resultCount = skillMapper.insert(skill);
        if(resultCount == 0) {
            return ServerResponse.createByErrorMessage("添加失败");
        }
        return ServerResponse.createBySuccess("添加成功 ");
    }

    /**
     * 根据id删除技能
     * @param skill
     * @return
     */
    public ServerResponse<String> del(Skill skill) {
        skill.setStatus((long)0);
        int resultCount = skillMapper.updateByPrimaryKeySelective(skill);
        if(resultCount == 0) {
            return ServerResponse.createByErrorMessage("删除失败");
        }

        return ServerResponse.createBySuccess("删除成功");
    }

    /**
     * 更新技能信息
     * @param skill
     * @return
     */
    public ServerResponse<String> update(Skill skill) {
        int resultCount = skillMapper.updateByPrimaryKeySelective(skill);
        if(resultCount == 0) {
            return ServerResponse.createByErrorMessage("更新失败");
        }
        return ServerResponse.createBySuccess("更新成功");
    }


    /**
     * 获取一个技能及其子元素
     * @param preId
     * @return
     */
    public ServerResponse<List<Skill>> getChildrenParallelSkill(Integer preId) {
        List<Skill> skillList = skillMapper.selectSkillChildrenByPreId(preId);
        if(CollectionUtils.isEmpty(skillList)) {
            System.out.println("未找到当前分类的子技能");
        }
        return ServerResponse.createBySuccess(skillList);
    }

    /**
     * 获取一个技能及其所有的子节点的id
     * @param preId
     * @return
     */
    public ServerResponse<Set<Map>> selectSkillAndChildrenById(Integer preId) {
        Map skillMap = Maps.newHashMap();
        Set<Map> mapSet = findChildSkillInfo(skillMap,preId);
        return ServerResponse.createBySuccess(mapSet);
    }
//    public ServerResponse<Map<String,Skill>> selectSkillInfoAndChildrenById(Integer preId) {
//        Map<String,Skill> skillMap = Maps.newHashMap();
//
//    }

    /**
     * 获取以preId为父元素的节点，并将其放入skillSet中
     * @param skillSet
     * @param preId
     * @return
     */
    private Set<Skill> findChildSkill(Set<Skill> skillSet,Integer preId) {
        Skill skill = skillMapper.selectByPrimaryKey(preId);
        if(skill !=null) {
            skillSet.add(skill);
        }
        List<Skill> skillList = skillMapper.selectSkillChildrenByPreId(preId);
         for(Skill skillItem:skillList) {
            findChildSkill(skillSet,skillItem.getId());
        }
        return skillSet;
    }

    private Set<Map> findChildSkillInfo(Map skillMap,Integer preId) {
        Skill skill = skillMapper.selectByPrimaryKey(preId);
        Set<Map> mapSet = Sets.newHashSet();
        if(skill !=null) {
            skillMap.put("id",skill.getId());
            skillMap.put("pre_id",skill.getPreId());
            skillMap.put("skill_name",skill.getSkillName());
            skillMap.put("max_grade",skill.getMaxGrade());
            mapSet.add(skillMap);
        }
        List<Skill> skillList = skillMapper.selectSkillChildrenByPreId(preId);
        for(Skill skillItem: skillList) {
            findChildSkillInfo(skillMap,skillItem.getId());
        }
        return mapSet;
    }


}
