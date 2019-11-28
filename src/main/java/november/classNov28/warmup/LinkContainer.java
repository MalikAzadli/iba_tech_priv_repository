package november.classNov28.warmup;

public class LinkContainer {
    private final String href;
    private final String title;

    public LinkContainer(String href, String title) {
        this.href = href;
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public String getTitle() {
        return title;
    }
}
