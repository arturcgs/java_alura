package desafioapi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiHandler {
    String cep;

    public ApiHandler(String cep) {
        this.cep = cep;
    }

    public String getCepJson() throws IOException, InterruptedException {

        // setup api stuff
        String apiAddress = "https://viacep.com.br/ws/" + this.cep + "/json/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiAddress)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
