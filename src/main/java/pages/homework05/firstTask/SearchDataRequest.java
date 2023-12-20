package pages.homework05.firstTask;

public class SearchDataRequest {

    private String campaignName;
    private String dateFrom;
    private String dateTo;

    public SearchDataRequest(String campaignName, String dateFrom, String dateTo) {
        this.campaignName = campaignName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}
