package JavaWebCrawler;

import javax.print.DocFlavor;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class JwcCrawl {

    private List<String> pagesVisited = new LinkedList<>();
    private List<String> pagesWillVisit = new LinkedList<>();
    private static String links;

    public List<String> pagesToVisit(String htmlOutput) {

        String[] pagesToVisit = htmlOutput.split(">");
        List<String> pages = new ArrayList<>();
        for(int i=0;i<pagesToVisit.length;i++) {
            pages.add(pagesToVisit[i]);
            if(pages.get(i).contains("<a href")) {
                this.pagesWillVisit.add(pages.get(i));
                continue;
            }
        }
        return this.pagesWillVisit;
    }

    public String readURL(List<String> pages, String topic) throws IOException {

        for (int i=0;i<pages.size();i++) {
            try {
                URL url = new URL(pages.get(i));
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String inputLine = in.readLine();
                //System.out.println(inputLine);


                if (inputLine.equalsIgnoreCase("facetDisplayName="+topic)) {
                    links = inputLine;
                }
                in.close();

            }catch(MalformedURLException m) {
                System.out.println(m);
            }

        }
        return links;
    }

}
//                URL url = new URL(s);
//                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
