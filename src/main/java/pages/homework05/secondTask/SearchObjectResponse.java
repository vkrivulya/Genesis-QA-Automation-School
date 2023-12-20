package pages.homework05.secondTask;

import java.util.List;

public class SearchObjectResponse {

    private List<Data> data;
    private Pagination pagination;

    public SearchObjectResponse(List<Data> data, Pagination pagination) {
        this.data = data;
        this.pagination = pagination;
    }

    public List<Data> getData() {
        return data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
