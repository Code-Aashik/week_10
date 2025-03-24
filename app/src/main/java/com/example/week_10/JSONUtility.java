package com.example.week_10;

import android.content.Context;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JSONUtility {
    public static List<Movie> loadMovies(Context context, String fileName) {
        List<Movie> movieList = new ArrayList<>();
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String title = obj.optString("title", "Unknown");
                int year = obj.optInt("year", 0);
                String genre = obj.optString("genre", "Unknown");
                String poster = obj.optString("poster", "default_poster");

                movieList.add(new Movie(title, year, genre, poster));
            }
        } catch (Exception e) {
            Log.e("JSONUtility", "Error parsing JSON", e);
        }
        return movieList;
    }
}