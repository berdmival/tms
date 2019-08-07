package lec_17.homework.task_05;

public class CodeRefactor {
    public static void main(String[] args) {
        Website website = new Website("http://www.onliner.by");

        String url = website.getUrl();
        WebsiteType type = website.getType();

        System.out.println(url);
        System.out.println(type);
    }
}
