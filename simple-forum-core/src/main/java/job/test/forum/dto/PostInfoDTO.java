package job.test.forum.dto;

import job.test.forum.models.Post;
import job.test.forum.models.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zuhai.jiang on 2016/10/26.
 */
public class PostInfoDTO implements Serializable{
    private int id;
    private int creatorId;
    private String creatorName;
    private Date createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
