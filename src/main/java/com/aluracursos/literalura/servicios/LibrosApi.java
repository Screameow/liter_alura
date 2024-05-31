package com.aluracursos.literalura.servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LibrosApi {

    public String consumoAPI(String URL) {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException  e) {
            throw new RuntimeException(e);
        }

        if (response.statusCode() != 200){
            throw new RuntimeException("API fallo al realizar la llamada " + response.statusCode());
        }

        return response.body();

    }


}
