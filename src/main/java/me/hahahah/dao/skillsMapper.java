package me.hahahah.dao;

import me.hahahah.pojo.skills;

public interface skillsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table allskill
     *
     * @mbggenerated Wed Jan 02 21:20:24 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table allskill
     *
     * @mbggenerated Wed Jan 02 21:20:24 CST 2019
     */
    int insert(skills record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table allskill
     *
     * @mbggenerated Wed Jan 02 21:20:24 CST 2019
     */
    int insertSelective(skills record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table allskill
     *
     * @mbggenerated Wed Jan 02 21:20:24 CST 2019
     */
    skills selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table allskill
     *
     * @mbggenerated Wed Jan 02 21:20:24 CST 2019
     */
    int updateByPrimaryKeySelective(skills record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table allskill
     *
     * @mbggenerated Wed Jan 02 21:20:24 CST 2019
     */
    int updateByPrimaryKey(skills record);
}