package JavaWebCrawler;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class JwcCrawl {

    private static JwcURLAccess jwcURL = new JwcURLAccess();
    private List<String> pagesVisited = new LinkedList<>();
    private List<String> pagesWillVisit = new LinkedList<>();
    private static String links;

    public void readURL(List<String> list) throws IOException {

                try {
                    for(String link : list) {
                        URL url = new URL(link);
                        System.out.println(url);
                        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

                        System.out.println(in.readLine());

//                        String inputLine;
//                        while ((inputLine = in.readLine()) != null) {
//                            System.out.println(inputLine);
//                        }

                        in.close();
                    }
                } catch (MalformedURLException m) {
                    //System.out.println(m);
                }

    }

    public static List<String> crawl(String topic) throws IOException {
        List<String> linksFound = new ArrayList<>();
        for(String link : jwcURL.getAccess()) {
            if(link.contains(topic)) { linksFound.add(link); }
        }

        return linksFound;
    }

}

