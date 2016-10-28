package job.test.forum.controllers;

import job.test.forum.dto.PostInfoDTO;
import job.test.forum.dto.Response;
import job.test.forum.dto.TopicDetailDTO;
import job.test.forum.dto.TopicInfoDTO;
import job.test.forum.exceptions.ServiceException;
import job.test.forum.models.Topic;
import job.test.forum.models.User;
import job.test.forum.services.PostService;
import job.test.forum.services.TopicService;
import job.test.forum.services.UserService;
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
     * list topic info
     * @return the topic info
     */
    @RequestMapping(value = "/listTopicInfo", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<TopicInfoDTO>> listTopicInfo(){
        try {
            List<TopicInfoDTO> list = topicService.listTopicInfo();
            if (list != null) {
                return suc(list);
            } else {
                throw new ServiceException("Failed to list topic info");
            }
        } catch (Exception e) {
            logger.error("Failed to list topic info", e);
            return err(e.getMessage());
        }
    }

    /**
     * get topic detail
     * @return the topic info
     */
    @RequestMapping(value = "/getTopicDetail", method = RequestMethod.GET)
    @ResponseBody
    public Response<TopicDetailDTO> getTopicDetail(int id){
        try {
            TopicDetailDTO dto = topicService.getTopicDetail(id);
            if (dto != null) {
                return suc(dto);
            } else {
                throw new ServiceException("Failed to get topic detail");
            }
        } catch (Exception e) {
            logger.error("Failed to get topic detail", e);
            return err(e.getMessage());
        }
    }
}
