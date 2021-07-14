import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import java.net.URLEncoder;
import java.util.Scanner;

public class APIHandler {

    private String host;
    private String charset;
    private String x_rapidapi_host;
    private String x_rapidapi_key;

    public APIHandler(){
        this.host = "https://movie-database-imdb-alternative.p.rapidapi.com";
        this.charset = "UTF-8";
        this.x_rapidapi_host = "movie-database-imdb-alternative.p.rapidapi.com";
        this.x_rapidapi_key = "x-rapidapi-key";
    }

    //JSON response
    public HttpResponse response() throws Exception{
        String query = String.format("s=%s",
                URLEncoder.encode(queryMovie(), charset));

        HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
                .header("x-rapidapi-host", x_rapidapi_host)
                .header("x-rapidapi-key", x_rapidapi_key)
                .asJson();
        return response;
    }

    //Prettifying
    public void prettifyResponse(HttpResponse response){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);
    }
    //Search string title
    public String queryMovie(){
        System.out.println("Please enter a movie title: ");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        return title;
    }
}
