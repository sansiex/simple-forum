package job.test.forum.controllers;

import job.test.forum.dto.Response;
import job.test.forum.exceptions.ServiceException;
import job.test.forum.models.User;
import job.test.forum.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zuhai.jiang on 2016/10/25.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * create new user
     * @param name
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Response<User> create(String name){
        try {
            User user = userService.create(name);
            if (user != null) {
                return suc(user);
            } else {
                throw new ServiceException("Failed to create user");
            }
        } catch (Exception e) {
            logger.error("Failed to create user with name:"+name, e);
            return err(e.getMessage());
        }
    }

    /**
     * get user info by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Response<User> get(int id){
        try {
            User user = userService.get(id);
            if (user != null) {
                return suc(user);
            } else {
                throw new ServiceException("Failed to get user:"+id);
            }
        } catch (Exception e) {
            logger.error("Failed to get user with id:"+id, e);
            return err(e.getMessage());
        }
    }
}
