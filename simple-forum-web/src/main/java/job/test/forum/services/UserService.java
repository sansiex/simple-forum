package job.test.forum.services;

import job.test.forum.mappers.UserMapper;
import job.test.forum.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.google.common.base.Preconditions.*;

/**
 * Created by zuhai.jiang on 2016/10/25.
 */
@Service
public class UserService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    public User create(String name){
        checkArgument(null != name && name.length()>3, "用户名[]长度必须大于3", name);
        logger.info("Create user with name:{}", name);
        User user = new User();
        user.setCreatetime(new Date());
        user.setName(name);
        userMapper.insert(user);
        return user;
    }

    public User get(int id){
        logger.info("Get user by id:{}",id);
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

}
