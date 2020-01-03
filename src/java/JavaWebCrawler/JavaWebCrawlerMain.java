package JavaWebCrawler;

import java.io.IOException;
import java.net.MalformedURLException;

public class JavaWebCrawlerMain {

    public static void main(String[] args) throws IOException {
        JwcURLAccess jwcURLAccess = new JwcURLAccess();
//        JwcCrawl jwc = new JwcCrawl();
//        jwc.crawl("blood");
        jwcURLAccess.getAccess();
        }
}
