package JavaWebCrawler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JwcURLAccess {

    CloseableHttpClient httpClient = HttpClients.createDefault();
    JwcCrawl jwcCrawl = new JwcCrawl();
    private List<String> pagesWillVisit = new LinkedList<String>();
    List <String> htmlOutput;


    public List<String> getAccess() throws IOException {

        try{
            HttpGet getReq = new HttpGet("https://www.cochranelibrary.com/home/topic-and-review-group-list.html?page=topic");
            getReq.addHeader("accept", "text/html");
            getReq.addHeader(HttpHeaders.USER_AGENT, "User-Agent");

            HttpResponse response = httpClient.execute(getReq);
            int status = response.getStatusLine().getStatusCode();
            if(status != 200) {
                throw new RuntimeException("Failed--Status: " + status);
            }

            Scanner scan = new Scanner(response.getEntity().getContent());
            while(scan.hasNext()) {
                System.out.println(scan.nextLine());
                htmlOutput.add(scan.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            httpClient.close();
        }

        return htmlOutput;
    }

}
