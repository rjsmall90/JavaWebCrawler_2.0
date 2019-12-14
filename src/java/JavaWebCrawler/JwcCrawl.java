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
        for(int i=0;i<pagesToVisit.length;i++) {
            if(pagesToVisit[i].contains("<a href")) {
                this.pagesWillVisit.add(pagesToVisit[i]);
            }
        }
        return this.pagesWillVisit;
    }

    public String readURL(List<String> pages, String topic) throws IOException {

        for (int i=0;i<pages.size();i++) {
            for (int x = 0; x < pages.get(i).length() -5; x++) {
                try {
//                    String testing = "";
//                    if (pages.get(i).substring(x, x+5) == "http"){
                        String testing = pages.get(i).replace(pages.get(i), pages.get(i).substring(9, pages.get(i).length()));

                    //}

                   //System.out.println(testing);
                    URL url = new URL(testing);
                    System.out.println(url);
                    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        //System.out.println(inputLine);
                    }


                    if (inputLine.equalsIgnoreCase("facetDisplayName=" + topic)) {
                        links = inputLine;
                    }
                    in.close();

                } catch (MalformedURLException m) {
                    //System.out.println(m);
                }

            }
        }
        return links;
    }

}

