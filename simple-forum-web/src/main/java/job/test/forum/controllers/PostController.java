package job.test.forum.controllers;

import job.test.forum.dto.Response;
import job.test.forum.dto.TopicInfoDTO;
import job.test.forum.exceptions.ServiceException;
import job.test.forum.models.Post;
import job.test.forum.models.Topic;
import job.test.forum.services.PostService;
import job.test.forum.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zuhai.jiang on 2016/10/25.
 */
@Controller
@RequestMapping("/post")
public class PostController extends BaseController {

    @Autowired
    private PostService postService;

    /**
     * create new post
     * @param content
     * @return the created topic
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Response<Post> create(int userId, int topicId, String content){
        try {
            Post post = postService.create(userId, topicId, content);
            if (post != null) {
                return suc(post);
            } else {
                throw new ServiceException("Failed to create post");
            }
        } catch (Exception e) {
            logger.error("Failed to create post by user:"+userId, e);
            return err(e.getMessage());
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> update(int id, String content){
        try {
            Post post = postService.update(id, content);
            return suc(true);
        } catch (Exception e) {
            logger.error(String.format("Failed to update post [id:%s,content:%s]", id, content), e);
            return err(e.getMessage());
        }
    }
}
