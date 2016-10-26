package job.test.forum.services;

import com.google.common.base.Strings;
import job.test.forum.dto.Page;
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

    @Transactional
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

    @Transactional
    public Page<Post> listPostsOnGivenTopic(int topicId, int start, int pageSize){
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
