package job.test.forum.dto;

import job.test.forum.models.Topic;
import job.test.forum.models.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Topic info
 * Created by zuhai.jiang on 2016/10/26.
 */
public class TopicInfoDTO implements Serializable {
    private static final long serialVersionUID = -273029967138132315L;
    private int id;
    private String title;
    private String content;
    private int creatorId;
    private String creatorName;
    private Date createtime;
    private int lastPosterId;
    private String lastPosterName;
    private Date lastPostTime;
    private int postCnt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getLastPosterId() {
        return lastPosterId;
    }

    public void setLastPosterId(int lastPosterId) {
        this.lastPosterId = lastPosterId;
    }

    public String getLastPosterName() {
        return lastPosterName;
    }

    public void setLastPosterName(String lastPosterName) {
        this.lastPosterName = lastPosterName;
    }

    public Date getLastPostTime() {
        return lastPostTime;
    }

    public void setLastPostTime(Date lastPostTime) {
        this.lastPostTime = lastPostTime;
    }

    public int getPostCnt() {
        return postCnt;
    }

    public void setPostCnt(int postCnt) {
        this.postCnt = postCnt;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
