import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Moedas {
    private String nome;
    private String sigla;
    @Expose private Double BRL;
    @Expose private Double USD;
    @Expose private Double ARS;
    @Expose private Double CUP;
    @Expose private Double GBP;
    @Expose private Double CHF;

    public Double getBRL() {
        return BRL;
    }

    public Double getUSD() {
        return USD;
    }

    public Double getARS() {
        return ARS;
    }

    public Double getCUP() {
        return CUP;
    }

    public Double getGBP() {
        return GBP;
    }

    public Double getCHF() {
        return CHF;
    }

    public String getNome() {
        return nome;
    }


    public String getSigla() {
        return sigla;
    }


    public Moedas atualizarConversoes() throws IOException, InterruptedException {
        String endereco = "https://v6.exchangerate-api.com/v6/SUAKEY/latest/" + this.sigla;

        HttpClient client = HttpClient.newHttpClient(); //o client que fazemos o pedido
        HttpRequest request = HttpRequest.newBuilder() //o request que é feito para o client
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        json = json.substring(json.indexOf("{") + 1);
        json = json.substring(json.indexOf("{"));
        json = json.substring(0, (json.indexOf("}") + 1));

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create();

        Moedas moedas = gson.fromJson(json, Moedas.class);

        moedas.nome = this.nome;
        moedas.sigla = this.sigla;

        return moedas;
    }

    @Override
    public String toString(){
        return this.nome + " (" + this.sigla + ")";
    }

    public Moedas(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }
}
