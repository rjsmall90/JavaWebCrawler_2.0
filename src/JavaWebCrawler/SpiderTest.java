package JavaWebCrawler;

public class SpiderTest {

    public static void main(String[] args) {
        Spider spider = new Spider();
        spider.search("https://www.meetup.com", "jobs");
    }
}
