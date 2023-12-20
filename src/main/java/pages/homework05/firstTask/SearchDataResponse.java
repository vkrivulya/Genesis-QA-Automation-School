package pages.homework05.firstTask;

import java.util.List;

public class SearchDataResponse {

    private List<Result> result;
    private List<Errors> errors;
    private Meta meta;

    public static class Meta {

        private int totalRows;

        private int page;

        private int totalPages;

        private int pageSize;
    }
}
