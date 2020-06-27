package work.ccpw.domain;

import java.util.List;

/**
 * @program: Entry
 * @description: 分页对象
 * @author: cone
 * @create: 2020-06-25 16:50
 **/
public class PageBean<T> {
    /**
     * 总记录数
     */
    private int totalCount;
    /**
     * 总页码
     */
    private int totalPage;
    /**
     * 每页的数据
     */
    private List<T> users;
    /**
     * 当前页码
     */
    private int currentPage;

    /**
     * 每页显示的条目
     */
    private int rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getUsers() {
        return users;
    }

    public void setUsers(List<T> users) {
        this.users = users;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", users=" + users +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}
