package moviecrawler.dtos;

public class SiteDTO {
    private String url;

    public SiteDTO(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
