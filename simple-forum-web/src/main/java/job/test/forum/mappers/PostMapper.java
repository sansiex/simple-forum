package job.test.forum.mappers;

import java.util.List;
import job.test.forum.models.Post;
import job.test.forum.models.PostExample;
import org.apache.ibatis.annotations.Param;

public interface PostMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbggenerated Tue Oct 25 20:45:21 CST 2016
     */
    int countByExample(PostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbggenerated Tue Oct 25 20:45:21 CST 2016
     */
    int deleteByExample(PostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbggenerated Tue Oct 25 20:45:21 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbggenerated Tue Oct 25 20:45:21 CST 2016
     */
    int insert(Post record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbggenerated Tue Oct 25 20:45:21 CST 2016
     */
    int insertSelective(Post record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbggenerated Tue Oct 25 20:45:21 CST 2016
     */
    List<Post> selectByExample(PostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbggenerated Tue Oct 25 20:45:21 CST 2016
     */
    Post selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbggenerated Tue Oct 25 20:45:21 CST 2016
     */
    int updateByExampleSelective(@Param("record") Post record, @Param("example") PostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbggenerated Tue Oct 25 20:45:21 CST 2016
     */
    int updateByExample(@Param("record") Post record, @Param("example") PostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbggenerated Tue Oct 25 20:45:21 CST 2016
     */
    int updateByPrimaryKeySelective(Post record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbggenerated Tue Oct 25 20:45:21 CST 2016
     */
    int updateByPrimaryKey(Post record);
}