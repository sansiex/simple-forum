package job.test.forum.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by zuhai.jiang on 2016/10/26.
 */
public class TopicDetailDTO implements Serializable {

    private static final long serialVersionUID = 5963790968926549227L;
    private int id;
    private String title;
    private String content;
    private int creatorId;
    private String creatorName;
    private Date createtime;
    private List<PostDetailDTO> postList;

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public List<PostDetailDTO> getPostList() {
        return postList;
    }

    public void setPostList(List<PostDetailDTO> postList) {
        this.postList = postList;
    }
}
