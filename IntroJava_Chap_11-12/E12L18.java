/* 
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
import java.util.ArrayList;
import java.util.Scanner;
import java.net.URL;
public class E12L18 {
    public static void main(String[]args) {
        // url (uniform resource locator) is input as a string
        String urlStr = "http://www.google.com/index.html";
        crawler(urlStr);
    }

    public static void crawler(String url0){
        //Use ArrayList to easily add and delete items on lists of strings
        ArrayList<String> pendingURLs = new ArrayList<>();
        ArrayList<String> traversedURLs = new ArrayList<>();

        // the input string is added to pending list
        pendingURLs.add(url0);
        while (!pendingURLs.isEmpty() && traversedURLs.size() <= 20) {
            String urlStr = pendingURLs.remove(0);
            traversedURLs.add(urlStr);
            System.out.println("Crawl " + urlStr);
            for (String s: getSubURL(urlStr)) {
                if (!pendingURLs.contains(s) && !traversedURLs.contains(s)){
                    pendingURLs.add(s);
                }
            }
        }
    }

    public static ArrayList<String> getSubURL(String urlStr) {
        ArrayList<String> list = new ArrayList<>();
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

