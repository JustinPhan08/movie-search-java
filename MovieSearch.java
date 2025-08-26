import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class MovieSearch {
    public static void main(String[] args) throws Exception {
        String apiKey = "YOUR_OMDB_API_KEY";
        String movie = "Inception";
        String urlStr = "http://www.omdbapi.com/?t=" + movie + "&apikey=" + apiKey;

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line, response = "";
        while ((line = in.readLine()) != null) response += line;
        in.close();

        JSONObject obj = new JSONObject(response);
        System.out.println("Title: " + obj.getString("Title"));
        System.out.println("Year: " + obj.getString("Year"));
        System.out.println("Actors: " + obj.getString("Actors"));
    }
}
