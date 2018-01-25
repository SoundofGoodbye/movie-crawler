package moviecrawler;

public enum URLEnums {
    FANDANGO("https://www.fandango.com/moviesintheaters/");

    private final String url;
    URLEnums(String url) { this.url = url; }
    public String getValue() { return url; }
}
