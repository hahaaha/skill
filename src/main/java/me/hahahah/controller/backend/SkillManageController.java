package me.hahahah.controller.backend;

import me.hahahah.common.ServerResponse;
import me.hahahah.pojo.Skill;
import me.hahahah.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/skill/manage/")
public class SkillManageController {
    @Autowired
    private ISkillService iSkillService;

    /**
     * 增加技能
     * @return
     */
    @RequestMapping("add.do")
    @ResponseBody
    public ServerResponse<String> add(Skill skill) {
        return iSkillService.add(skill);
    }

    /**
     * 删除某个技能
     * @param skill
     * @return
     */
    @RequestMapping("del.do")
    @ResponseBody
    public ServerResponse<String> del(Skill skill) {
        return iSkillService.del(skill);
    }

    /**
     * 更新技能信息
     * @param skill
     * @return
     */
    @RequestMapping("update.do")
    @ResponseBody
    public ServerResponse<String> update(Skill skill) {
        return iSkillService.update(skill);
    }

    /**
     *
     * @return
     */
    @RequestMapping("get_child_skill.do")
    @ResponseBody
    public ServerResponse<List<Skill>> childSkill(Integer preId) {
        return iSkillService.getChildrenParallelSkill(preId);
    }

    @RequestMapping("get_deep_child_skill.do")
    @ResponseBody
    public ServerResponse<Map> getDeepChildSkill(Integer preId) {
        return iSkillService.selectSkillAndChildrenById(preId);
    }

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<String> list() {
        return ServerResponse.createBySuccess();
    }
}
