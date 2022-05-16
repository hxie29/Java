/* 
(Search Web) Modify Listing 12.18 WebCrawler.java to search for the word
(e.g., Computer Programming) starting from a URL (e.g., http://cs.armstrong
.edu/liang). Your program prompts the user to enter the word and the starting
URL and terminates once the word is found. Display the URL for the page that
contains the word.
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.net.URL;
public class E12L18 {
    public static void main(String[]args) throws Exception{
        // url (uniform resource locator) is input as a string
        String urlStr = "http://cs.armstrong.edu/liang";
        String key = "Computer Programming";
        crawler(key, urlStr);
    }

    public static void crawler(String key, String url0) throws Exception{
        //Use ArrayList to easily add and delete items on lists of strings
        ArrayList<String> pendingURLs = new ArrayList<>();
        ArrayList<String> traversedURLs = new ArrayList<>();

        // the input string is added to pending list
        pendingURLs.add(url0);
        while (!pendingURLs.isEmpty() && traversedURLs.size() <= 20) {
            String urlStr = pendingURLs.remove(0);
            traversedURLs.add(urlStr);
            System.out.println("Crawl " + urlStr);
            if (match(key, urlStr)) {
                System.out.println("Key word - Computer Programming - found.");
                break;
            }
            for (String s: getSubURL(urlStr)) {
                if (!pendingURLs.contains(s) && !traversedURLs.contains(s)){
                    pendingURLs.add(s);
                }
            }
        }
    }

    public static ArrayList<String> getSubURL(String urlStr) throws Exception {
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
    
    public static boolean match(String key, String url) throws Exception{
        try (Scanner input = new Scanner((new URL(url)).openStream())) {
            while (input.hasNext()) {
                String line = input.nextLine();
                if (line.contains(key)) return true;
            }
        }
        return false;
    }
}

