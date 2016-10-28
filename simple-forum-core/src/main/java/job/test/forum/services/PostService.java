package job.test.forum.services;

import com.google.common.base.Strings;
import job.test.forum.dto.Page;
import job.test.forum.dto.PostDetailDTO;
import job.test.forum.dto.PostInfoDTO;
import job.test.forum.mappers.PostMapper;
import job.test.forum.models.Post;
import job.test.forum.models.PostExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by zuhai.jiang on 2016/10/25.
 */
@Service
public class PostService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PostMapper postMapper;

    public Post create(int userId, int topicId, String content){
        checkArgument(!Strings.isNullOrEmpty(content), "Content must not be null or empty");
        logger.info("Create post with creatorId:{}, topicId:{}, content:{}", new Object[]{userId, topicId, content});
        Post post = new Post();
        post.setCreatetime(new Date());
        post.setCreatorid(userId);
        post.setTopicid(topicId);
        post.setContent(content);
        postMapper.insert(post);
        return post;
    }

    public Post update(int id, String content){
        checkArgument(!Strings.isNullOrEmpty(content), "Content must not be null or empty");
        logger.info("Update post with id:{}, contnet:{}", new Object[]{id, content});
        Post post = postMapper.selectByPrimaryKey(id);
        if (!Strings.isNullOrEmpty(content)) {
            post.setContent(content);
        }
        postMapper.updateByPrimaryKey(post);
        return post;
    }

    /**
     * list the post details refered to the given topic
     * @param topicId
     * @return
     */
    public List<PostDetailDTO> listPostDetailsByTopicId (int topicId){
        logger.info("list post details By Topic Id:{}", topicId);
        List<PostDetailDTO> list = postMapper.listPostDetails(topicId);
        return list;
    }

    public Page<Post> listPostsByTopicId(int topicId, int start, int pageSize){
        checkArgument(start>-1, "Start [] must > -1", start);
        checkArgument(pageSize>0, "Page size [] must > 0", pageSize);
        logger.info("List posts on topic:{}", topicId);
        PostExample exp = new PostExample();
        exp.createCriteria().andTopicidEqualTo(topicId);
        exp.setOrderByClause("order by updatetime asc limit "+start+","+pageSize);
        List<Post> list = postMapper.selectByExample(exp);
        Page<Post> page = new Page<Post>(list, start, pageSize);
        return page;
    }
}
