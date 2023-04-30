package org.example;

import com.google.gson.Gson;
import org.example.geocode.Transcript;
import org.example.nearbySearch.TranscriptNB;
import org.example.place.TranscriptPlace;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        Transcript transcript = new Transcript();
        TranscriptNB transcriptNB = new TranscriptNB();
        TranscriptPlace transcriptPlace = new TranscriptPlace();
        String APIkey = 

        Gson gson = new Gson();

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://maps.googleapis.com/maps/api/geocode/json?address=1615+bredell+ave&key="+APIkey))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        transcript = gson.fromJson(getResponse.body(), Transcript.class);

        String lat = transcript.getResults().get(0).getGeometry().getLocation().getLat();
        String lng = transcript.getResults().get(0).getGeometry().getLocation().getLng();

        HttpRequest getRequestNB = HttpRequest.newBuilder()
                .uri(new URI("https://maps.googleapis.com/maps/api/place/nearbysearch/json?type=restaurant&location=" + lat + "%2C" + lng + "&radius=1500&key="+APIkey))
                .build();

        HttpResponse<String> getResponseNB = httpClient.send(getRequestNB, HttpResponse.BodyHandlers.ofString());
        transcriptNB = gson.fromJson(getResponseNB.body(), TranscriptNB.class);

        List<String> place_ids = new ArrayList<>();

        for(int i=0; i < transcriptNB.getResults().size(); i++){
            String place_id = transcriptNB.getResults().get(i).getPlace_id();
            place_ids.add(place_id);
        }

        List<Restaurant> restaurants = new ArrayList<>();

        for(int place_num=0; place_num < place_ids.size(); place_num++){
            HttpRequest getRequestPlace = HttpRequest.newBuilder()
                    .uri(new URI("https://maps.googleapis.com/maps/api/place/details/json?place_id="+place_ids.get(place_num)+"&key="+APIkey))
                    .build();
            HttpResponse<String> getResponsePlace = httpClient.send(getRequestPlace, HttpResponse.BodyHandlers.ofString());
            transcriptPlace = gson.fromJson(getResponsePlace.body(), TranscriptPlace.class);

            String id = place_ids.get(place_num);
            String name = transcriptPlace.getResult().getName();
            String address = transcriptPlace.getResult().getFormatted_address();
            String phoneNumber = transcriptPlace.getResult().getFormatted_phone_number();
            Boolean open = transcriptPlace.getResult().getCurrent_opening_hours().getOpen_now();
            int priceLevel = transcriptPlace.getResult().getPrice_level();
            float rating = transcriptPlace.getResult().getRating();

            restaurants.add(new Restaurant(id, name, address, open, phoneNumber, priceLevel, rating));
        }

        System.out.println(restaurants.get(5).getName() + " is a fantastic restaurant located at "
        + restaurants.get(5).getAddress() + ". It is rated " + restaurants.get(5).getRating());

    }
}