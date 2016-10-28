package job.test.forum.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zuhai.jiang on 2016/10/25.
 */
public class Page<T> implements Serializable {
    private static final long serialVersionUID = -4934407589001703149L;

    private List<T> list;
    private int start;
    private int pageSize;

    public Page(List<T> list, int start, int pageSize) {
        this.list = list;
        this.start = start;
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
