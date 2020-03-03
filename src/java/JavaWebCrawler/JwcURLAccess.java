package JavaWebCrawler;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JwcURLAccess {

    CloseableHttpClient httpClient = HttpClients.createDefault();
    JwcCrawl jwcCrawl = new JwcCrawl();
    private List<String> pagesWillVisit = new LinkedList<String>();
    List <String> htmlOutput;


    public void getAccess(String url) throws IOException {

        try{
            HttpGet getReq = new HttpGet(url);
            getReq.addHeader("accept", "text/html");
            getReq.addHeader(HttpHeaders.USER_AGENT, "User-Agent");

            CloseableHttpResponse response = httpClient.execute(getReq);
            int status = response.getStatusLine().getStatusCode();
            if(status != 200) {
                throw new RuntimeException("Failed--Status: " + status);
            }

            Scanner scan = new Scanner(response.getEntity().getContent());
            while(scan.hasNext()) {
                String x = scan.nextLine();
                System.out.println(x);
//                htmlOutput.add(x);
//                System.out.println(htmlOutput);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            httpClient.close();
        }

//        return htmlOutput;
    }

}