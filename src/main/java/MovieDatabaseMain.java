//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonElement;

import com.mashape.unirest.http.HttpResponse;

public class MovieDatabaseMain {


    public static void main( String[] args ) throws Exception{

        APIHandler apiHandler = new APIHandler();
        HttpResponse res = apiHandler.response();
        apiHandler.prettifyResponse(res);
    }

}
