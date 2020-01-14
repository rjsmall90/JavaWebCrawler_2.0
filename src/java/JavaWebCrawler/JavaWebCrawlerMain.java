package JavaWebCrawler;

import java.io.IOException;
import java.net.MalformedURLException;

public class JavaWebCrawlerMain {

    public static void main(String[] args) throws IOException {
        JwcURLAccess jwcURLAccess = new JwcURLAccess();
        //JwcCrawl jwc = new JwcCrawl();
        //jwc.crawl("blood", "https://www.cochranelibrary.com/home/topic-and-review-group-list.html?page=topic");
        jwcURLAccess.getAccess("https://www.cochranelibrary.com/home/topic-and-review-group-list.html?page=topic").get(0).split(">");
        }
}
