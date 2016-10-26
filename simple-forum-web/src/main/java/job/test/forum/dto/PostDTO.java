package job.test.forum.dto;

import job.test.forum.models.Post;
import job.test.forum.models.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zuhai.jiang on 2016/10/26.
 */
public class PostDTO implements Serializable{
    private int id;
    private String content;
    private User creator;
    private Date createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
