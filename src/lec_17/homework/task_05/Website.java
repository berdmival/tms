package lec_17.homework.task_05;

public class Website {
    private String url;
    private WebsiteType type;

    public Website(String url) {
        this(url, WebsiteType.NEWS);
    }

    public Website(String url, WebsiteType type) {
        this.url = url;
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public WebsiteType getType() {
        return type;
    }
}

enum WebsiteType {
    NEWS,
    MUSIC,
    EDUCATION
}
