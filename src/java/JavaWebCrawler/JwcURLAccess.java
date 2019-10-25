package JavaWebCrawler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JwcURLAccess {

    DefaultHttpClient httpClient = new DefaultHttpClient();
    JwcCrawl jwcCrawl = new JwcCrawl();
    private List<String> pagesWillVisit = new LinkedList<String>();


    public void getAccess() {
        String htmlOutput;
        try{
            HttpGet getReq = new HttpGet("https://www.cochranelibrary.com/home/topic-and-review-group-list.html?page=topic");
            getReq.addHeader("accept", "text/html");
            getReq.addHeader(HttpHeaders.USER_AGENT, "User-Agent");

            HttpResponse response = httpClient.execute(getReq);
            int status = response.getStatusLine().getStatusCode();
            if(status != 200) {
                throw new RuntimeException("Failed--Status: " + status);
            }

            HttpEntity httpEntity = response.getEntity();
            htmlOutput = EntityUtils.toString(httpEntity);

            System.out.println(jwcCrawl.pagesToVisit(htmlOutput));

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            httpClient.getConnectionManager().shutdown();
        }

    }



//    public void postAccess(String topic) {
//
//        this.getAccess();
//
//        try {
//            HttpPost postReq = new HttpPost("https://www.cochranelibrary.com/home/topic-and-review-group-list.html?page=topic");
//            postReq.addHeader("content-type", "text/html");
//
//            StringEntity userEntity = new StringEntity(topic);
//            postReq.setEntity(userEntity);
//
//            HttpResponse response = httpClient.execute(postReq);
//            System.out.println(postReq.toString());
//
//            int status = response.getStatusLine().getStatusCode();
//            if(status != 201)
//            {
//                throw new RuntimeException("Failed--Status: " + status);
//            }
//
//        } catch (IOException x) {
//            x.printStackTrace();
//        }
//        finally {
//            httpClient.getConnectionManager().shutdown();
//        }
//
//    }
}
