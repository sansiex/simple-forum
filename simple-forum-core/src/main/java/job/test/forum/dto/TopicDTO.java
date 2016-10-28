package job.test.forum.dto;

import java.io.Serializable;

/**
 * Created by zuhai.jiang on 2016/10/27.
 */
public class TopicDTO implements Serializable {

    private static final long serialVersionUID = 2349619735542222845L;
    private int id;
    private String title;
    private String content;
    private int creatorId;
    private String creatorName;

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
}
