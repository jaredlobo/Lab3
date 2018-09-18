import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();

        return contents;
    }

    public int countWords(String webPage) {
        int wordCount = 0;

       // webPage = webPage.trim();

        for (int strIndex = 0; strIndex < webPage.length(); strIndex++) {
            if (webPage.charAt(strIndex) == ' ') {
                wordCount++;
            }
        }

        System.out.println("Number of Words: " + wordCount);

        return wordCount;
    }

    public static void main(String[] unused) {
       // System.out.println("Hello World");
        String webText = urlToString("http://erdani.com/tdpl/hamlet.txt");

        WebScraper obj = new WebScraper();
        obj.countWords(webText);
       // System.out.println(obj.urlToString("http://erdani.com/tdpl/hamlet.txt"));
    }
}
