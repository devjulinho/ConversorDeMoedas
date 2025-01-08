import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    private static String enderecoInicial = "https://v6.exchangerate-api.com/v6/" + java.lang.System.getenv("EXCHANGE_RATE_API") + "/pair/";

    public static String obterDados(String moedaInicial, String moedaFinal, float valor) throws IOException, InterruptedException {
        String enderecoCompleto = enderecoInicial + moedaInicial + "/" + moedaFinal + "/" + valor;

        HttpClient client = HttpClient.newHttpClient(); //o client que fazemos o pedido
        HttpRequest request = HttpRequest.newBuilder() //o request que é feito para o client
                .uri(URI.create(enderecoCompleto))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}

//Gson gson = new GsonBuilder()
//        .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
//        .create();
//
//Moedas moedas = gson.fromJson(json, Moedas.class);
//
//moedas.nome = this.nome;
//moedas.sigla = this.sigla;
//
//        return moedas;