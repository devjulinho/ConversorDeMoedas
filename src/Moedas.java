import com.google.gson.annotations.Expose;

public class Moedas {
    private String nome;
    private String sigla;
    @Expose private Double BRL;
    @Expose private Double USD;
    @Expose private Double ARS;
    @Expose private Double CUP;
    @Expose private Double GBP;
    @Expose private Double CHF;

    @Override
    public String toString(){
        return this.nome + " (" + this.sigla + ")";
    }

    public Moedas(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }
}
