package pages.homework05.secondTask;

public class Pagination {

    private int offset;
    private int limit;
    private int total_count;

    public Pagination(int offset, int limit, int total_count) {
        this.offset = offset;
        this.limit = limit;
        this.total_count = total_count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }
}
