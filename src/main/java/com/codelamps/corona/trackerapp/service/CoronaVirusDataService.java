package com.codelamps.corona.trackerapp.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CoronaVirusDataService {

    private static String VIRUS_DATA_URI = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    @SneakyThrows
    @PostConstruct
    public void fetchVirusData(){
        // MEMBUAT CLIENT
        HttpClient client = HttpClient.newHttpClient();

        // MEMBUAT REQUEST
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URI))
                .build();

        // MEMBUAT RESPONSE DARI PERMINTAAN
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // MENAMPILKAN
        System.out.println(response.body());
    }
}
