/*
(Web crawler) Rewrite Listing 12.18, WebCrawler.java, to improve the performance
by using appropriate new data structures for listOfPendingURLs and
listofTraversedURLs.

The World Wide web, abbreviated as WWW, W3, or Web, is a system of interlinked hypertext
documents on the Internet. With a web browser, you can view a document and follow the
hyperlinks to view other documents. In this case study, we will develop a program that automatically
traverses the documents on the Web by following the hyperlinks. This type of program
is commonly known as a web crawler. For simplicity, our program follows the hyperlink
that starts with http://. Figure 12.11 shows an example of traversing the Web. We start from
a Webpage that contains three URLs named URL1, URL2, and URL3. Following URL1 leads to
the page that contains three URLs named URL11, URL12, and URL13. Following URL2 leads
to the page that contains two URLs named URL21 and URL22. Following URL3 leads to the
page that contains four URLs named URL31, URL32, URL33, and URL34. Continue to traverse
the Web following the new hyperlinks. As you see, this process may continue forever, but we
will exit the program once we have traversed 100 pages.
*/
package c21_SetsMaps;

import java.net.URL;
import java.util.*;

public class E2114 {
    public static void main(String[]args) {
        // url (uniform resource locator) is input as a string
        String urlStr = "http://www.google.com/index.html";
        crawler(urlStr);
    }

    public static void crawler(String url0){
        //Use ArrayList to easily add and delete items on lists of strings
        Set<String> pendingURLs = new LinkedHashSet<>();
        Set<String> traversedURLs = new LinkedHashSet<>();

        // the input string is added to pending list
        pendingURLs.add(url0);
        while (!pendingURLs.isEmpty() && traversedURLs.size() <= 20) {
            Iterator<String> iterator = pendingURLs.iterator();
            String urlStr = iterator.next();
            iterator.remove();
            traversedURLs.add(urlStr);
            System.out.println("Crawl " + urlStr);
            pendingURLs.addAll(getSubURL(urlStr));
        }
    }

    public static Set<String> getSubURL(String urlStr) {
        Set<String> list = new HashSet<>();
        try {
            URL url = new URL (urlStr);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
                current = line.indexOf("http:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) {
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex); // if no such substring exists, then -1 is returned;
                    }
                    else current = -1;
                }
            }
        }
        //Error: Failed to select a proxy
        catch(Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }
    
}

