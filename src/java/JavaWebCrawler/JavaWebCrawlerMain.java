package JavaWebCrawler;

import java.io.IOException;
import java.net.MalformedURLException;

public class JavaWebCrawlerMain {

    public static void main(String[] args) throws IOException {
        JwcURLAccess jwcURLAccess = new JwcURLAccess();
        //JwcCrawl jwc = new JwcCrawl();
        //jwc.crawl("blood", "https://www.cochranelibrary.com/home/topic-and-review-group-list.html?page=topic");

        jwcURLAccess.getAccess("https://hc.apache.org/httpcomponents-client-4.5.x/httpclient/apidocs/org/apache/http/impl/client/CloseableHttpClient.html");
        }
}
