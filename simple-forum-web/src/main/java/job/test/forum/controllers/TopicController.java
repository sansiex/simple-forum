package job.test.forum.controllers;

import job.test.forum.dto.Response;
import job.test.forum.dto.TopicInfoDTO;
import job.test.forum.exceptions.ServiceException;
import job.test.forum.models.Topic;
import job.test.forum.models.User;
import job.test.forum.services.TopicService;
import job.test.forum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zuhai.jiang on 2016/10/25.
 */
@Controller
@RequestMapping("/topic")
public class TopicController extends BaseController {

    @Autowired
    private TopicService topicService;

    /**
     * create new topic
     * @param title
     * @param content
     * @return the created topic
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Response<Topic> create(int userId, String title, String content){
        try {
            Topic topic = topicService.create(userId, title, content);
            if (topic != null) {
                return suc(topic);
            } else {
                throw new ServiceException("Failed to create topic");
            }
        } catch (Exception e) {
            logger.error("Failed to create topic by user:"+userId, e);
            return err(e.getMessage());
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> update(int id, String title, String content){
        try {
            Topic topic = topicService.update(id, title, content);
            return suc(true);
        } catch (Exception e) {
            logger.error(String.format("Failed to update topic [id:%s,title:%s,content:%s]", id, title, content), e);
            return err(e.getMessage());
        }
    }

    /**
     * get topic info by id
     * @param id
     * @return the topic info
     */
    @RequestMapping(value = "/getTopicInfo", method = RequestMethod.GET)
    @ResponseBody
    public Response<TopicInfoDTO> get(int id){
        try {
            TopicInfoDTO info = topicService.getTopicInfo(id);
            if (info != null) {
                return suc(info);
            } else {
                throw new ServiceException("Failed to get topic info:"+id);
            }
        } catch (Exception e) {
            logger.error("Failed to get topic info with id:"+id, e);
            return err(e.getMessage());
        }
    }
}
