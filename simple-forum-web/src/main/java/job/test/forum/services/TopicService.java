package job.test.forum.services;

import com.google.common.base.Strings;
import job.test.forum.dto.Page;
import job.test.forum.mappers.TopicMapper;
import job.test.forum.models.Topic;
import job.test.forum.models.TopicExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by zuhai.jiang on 2016/10/25.
 */
@Service
public class TopicService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TopicMapper topicMapper;

    public Topic create(int userId, String title, String content){
        checkArgument(!Strings.isNullOrEmpty(title), "Title must not be null or empty");
        checkArgument(!Strings.isNullOrEmpty(content), "Content must not be null or empty");
        logger.info("Create topic with creatorId:{}, title:{}, content:{}", new Object[]{userId, title, content});
        Topic topic = new Topic();
        topic.setCreatorid(userId);
        topic.setTitle(title);
        topic.setContent(content);
        topic.setCreatetime(new Date());
        topicMapper.insert(topic);
        return topic;
    }

    public Topic get(int id){
        logger.info("Get by id:{}", id);
        Topic topic = topicMapper.selectByPrimaryKey(id);
        return topic;
    }

    public Topic update(int id, String title, String content){
        checkArgument(!Strings.isNullOrEmpty(title), "Title must not be null or empty");
        checkArgument(!Strings.isNullOrEmpty(content), "Content must not be null or empty");
        logger.info("Update topic with id:{}, title:{}, contnet:{}", new Object[]{id, title, content});
        Topic topic = topicMapper.selectByPrimaryKey(id);
        if (!Strings.isNullOrEmpty(title)) {
            topic.setTitle(title);
        }
        if (!Strings.isNullOrEmpty(content)) {
            topic.setContent(content);
        }
        topicMapper.updateByPrimaryKey(topic);
        return topic;
    }

    public Page<Topic> list(int start, int pageSize){
        checkArgument(start>-1, "Start [] must > -1", start);
        checkArgument(pageSize>0, "Page size [] must > 0", pageSize);
        logger.info("List topics");
        TopicExample exp = new TopicExample();
        exp.setOrderByClause("order by updatetime desc limit "+start+","+pageSize);
        List<Topic> list = topicMapper.selectByExample(exp);
        Page<Topic> page = new Page<Topic>(list, start, pageSize);
        return page;
    }
}
