package assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FetchWikiURL {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://en.wikipedia.org");
            URLConnection urlConnection = url.openConnection();
            InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
            BufferedReader bufferedReader =  new BufferedReader(isr);
            String readLine, htmldata = null, headings=null;
            while((readLine = bufferedReader.readLine()) != null){
                htmldata+=readLine;
            }


//"<(h[1-6])[^>]*>(.*?)</\1>"
            Pattern pattern = Pattern.compile("<h1>(.*?)</h1>");
            Matcher matcher = pattern.matcher("<h1>ajdsfhjkasd</h1><p>fdfds</p><h1>mudit</h1>");
            System.out.println(matcher.matches());
            List<String> allHeadings = new ArrayList<>();
            while(matcher.find()) {
                System.out.println("Inside loop");

                allHeadings.add(matcher.group());
            }
            for(String s: allHeadings) System.out.println(s);
        }
        catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}