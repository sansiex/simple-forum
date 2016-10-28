package job.test.forum.utils;

import job.test.forum.models.Post;
import job.test.forum.models.Topic;
import job.test.forum.models.User;
import job.test.forum.services.PostService;
import job.test.forum.services.TopicService;
import job.test.forum.services.UserService;
import org.springframework.context.ApplicationContext;

import java.util.Random;

/**
 * Created by zuhai.jiang on 2016/10/28.
 */
public class TestUtil {

    private static ApplicationContext ctx;
    public static final String base = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static User createRandomUser(){
        UserService userService = ctx.getBean(UserService.class);
        String name = getRandomString(8);
        User user = userService.create(name);
        return user;
    }

    public static Topic createRandomTopic(int userId){
        TopicService topicService = ctx.getBean(TopicService.class);
        Random rand = new Random();
        String title = getRandomString(10+rand.nextInt(20));
        String content = getRandomString(30 + rand.nextInt(40));
        return topicService.create(userId, title, content);
    }

    public static Post createRandomPost(int userId, int topicId) {
        PostService postService = ctx.getBean(PostService.class);
        Random rand = new Random();
        String content = getRandomString(5+rand.nextInt(40));
        return postService.create(userId, topicId, content);
    }

    public static void init(ApplicationContext context){
        ctx = context;
    }

    private static String getRandomString(int len){;
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
