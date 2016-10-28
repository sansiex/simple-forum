package job.test.forum.client;

import job.test.forum.dto.PostDetailDTO;
import job.test.forum.dto.PostInfoDTO;
import job.test.forum.dto.TopicDetailDTO;
import job.test.forum.dto.TopicInfoDTO;
import job.test.forum.models.Post;
import job.test.forum.models.Topic;
import job.test.forum.models.User;
import job.test.forum.services.PostService;
import job.test.forum.services.TopicService;
import job.test.forum.services.UserService;
import job.test.forum.utils.JsonUtil;
import job.test.forum.utils.OptionUtil;
import job.test.forum.utils.TestUtil;
import org.apache.commons.cli.CommandLine;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.SimpleFormatter;

/**
 * Created by zuhai.jiang on 2016/10/28.
 */
public class Client {
    private static ApplicationContext context;
    private static TopicService topicService;
    private static PostService postService;
    private static UserService userService;

    public static void main(String[] args) {
        CommandLine cl = OptionUtil.getCommandLine(args);
        init();
        if (cl.hasOption("t")) {
            if (cl.hasOption("c")) {
                createTopic(args);
            } else if (cl.hasOption("e")) {
                editTopic(args);
            }
        } else if (cl.hasOption("p")) {
            if (cl.hasOption("c")) {
                createPost(args);
            } else if (cl.hasOption("e")) {
                editPost(args);
            }
        } else if (cl.hasOption("s")) {
            createRandomData();
        } else if (cl.hasOption("l")) {
            listTopicInfo();
        } else if (cl.hasOption("d")) {
            getTopicDetail(args);
        } else {
            OptionUtil.printHelp();
        }
    }

    private static void createTopic(String[] args){
        if (!checkArguments(args, 5)) {
            return;
        }
        int userId = Integer.parseInt(args[2]);
        String title = args[3];
        String content = args[4];
        Topic t = getTopicService().create(userId, title, content);
        System.out.println("创建主题："+ JsonUtil.toJson(t));
    }

    private static void editTopic(String[] args){
        if (!checkArguments(args, 5)) {
            return;
        }
        int topicId = Integer.parseInt(args[2]);
        String title = args[3];
        String content = args[4];
        Topic t = getTopicService().update(topicId, title, content);
        System.out.println("编辑主题："+ JsonUtil.toJson(t));
    }

    private static void createPost(String[] args){
        if (!checkArguments(args, 5)) {
            return;
        }
        int userId = Integer.parseInt(args[2]);
        int topicId = Integer.parseInt(args[3]);
        String content = args[4];
        Post t = getPostService().create(userId, topicId, content);
        System.out.println("创建回复："+ JsonUtil.toJson(t));
    }

    private static void editPost(String[] args){
        if (!checkArguments(args, 4)) {
            return;
        }
        int postId = Integer.parseInt(args[2]);
        String content = args[3];
        Post t = getPostService().update(postId, content);
        System.out.println("编辑回复："+ JsonUtil.toJson(t));
    }

    private static void listTopicInfo(){
        List<TopicInfoDTO> list = getTopicService().listTopicInfo();
        for (TopicInfoDTO dto:list) {
            System.out.println(JsonUtil.toJson(dto));
        }
    }

    private static void getTopicDetail(String[] args){
        if (!checkArguments(args, 3)) {
            return;
        }
        int topicId = Integer.parseInt(args[2]);
        TopicDetailDTO dto = getTopicService().getTopicDetail(topicId);
        System.out.println("主题："+dto.getTitle());
        System.out.println("内容："+dto.getContent());
        System.out.println("发帖人："+dto.getCreatorName());
        System.out.println("发帖时间："+ dto.getCreatetime().toString());
        System.out.println("回复：");
        for (PostDetailDTO post:dto.getPostList()) {
            System.out.println(JsonUtil.toJson(post));
        }
    }

    private static void createRandomData(){
        TestUtil.init(context);
        List<User> userList = new ArrayList<User>(10);
        for (int i = 0; i < 10; i++) {
            userList.add(TestUtil.createRandomUser());
        }
        System.out.println("Created users:"+JsonUtil.toJson(userList));
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            User user = userList.get(rand.nextInt(10));
            Topic topic = TestUtil.createRandomTopic(user.getId());
            System.out.println("Created topic:"+JsonUtil.toJson(topic));
            int cnt = rand.nextInt(5)+5;
            for (int j = 0; j < cnt; j++) {
                Post post = TestUtil.createRandomPost(user.getId(), topic.getId());
                System.out.println("Created post:" + JsonUtil.toJson(post));
            }
        }
    }

    public static TopicService getTopicService() {
        return context.getBean(TopicService.class);
    }

    public static PostService getPostService() {
        return context.getBean(PostService.class);
    }

    public static UserService getUserService() {
        return context.getBean(UserService.class);
    }

    private static void init(){
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    private static boolean checkArguments(String[] args, int n){
        if (args.length != n) {
            System.out.println("参数个数不对，应该为"+n+"个！");
            return false;
        }
        return true;
    }
}
