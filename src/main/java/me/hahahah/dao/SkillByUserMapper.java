package me.hahahah.dao;

import me.hahahah.pojo.SkillByUser;
import org.apache.ibatis.annotations.Param;

public interface SkillByUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_skill
     *
     * @mbggenerated Sat Jan 19 11:39:44 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_skill
     *
     * @mbggenerated Sat Jan 19 11:39:44 CST 2019
     */
    int insert(SkillByUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_skill
     *
     * @mbggenerated Sat Jan 19 11:39:44 CST 2019
     */
    int insertSelective(SkillByUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_skill
     *
     * @mbggenerated Sat Jan 19 11:39:44 CST 2019
     */
    SkillByUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_skill
     *
     * @mbggenerated Sat Jan 19 11:39:44 CST 2019
     */
    int updateByPrimaryKeySelective(SkillByUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_skill
     *
     * @mbggenerated Sat Jan 19 11:39:44 CST 2019
     */
    int updateByPrimaryKey(SkillByUser record);

    SkillByUser checkGrade(@Param("userId") Integer userId,@Param("skillId") Integer skillId);

}