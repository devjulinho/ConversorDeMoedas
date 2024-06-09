import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        int menu = 0;
        double valor;
        double valorConvertido;
        Scanner leitura = new Scanner(System.in);

        Moedas BRL = new Moedas("Real Brasileiro", "BRL");
        Moedas USD = new Moedas("Dólar Americano", "USD");
        Moedas ARS = new Moedas("Peso Argentino", "ARS");
        Moedas CUP = new Moedas("Peso Cubano", "CUP");
        Moedas GBP = new Moedas("Libra Esterlina", "GBP");
        Moedas CHF = new Moedas("Franco Suíço", "CHF");

        BRL = BRL.atualizarConversoes();
        USD = USD.atualizarConversoes();
        ARS = ARS.atualizarConversoes();
        CUP = CUP.atualizarConversoes();
        GBP = GBP.atualizarConversoes();
        CHF = CHF.atualizarConversoes();

        System.out.println("Made by: Instagram: @dev.julinho  || github: @devjulinho");
        System.out.println("<=========================================================>");
        System.out.println("Olá, seja bem vindo ao Conversor de Moedas!\n");

        while (menu != 7){
            System.out.println("<========================= MENU ==========================>");
            System.out.println("       Escolha uma das opções definidas abaixo:            ");
            System.out.println("(1) Converter de " + BRL + " para " + USD);
            System.out.println("(2) Converter de " + USD + " para " + BRL);
            System.out.println("(3) Converter de " + ARS + " para " + USD);
            System.out.println("(4) Converter de " + CUP + " para " + BRL);
            System.out.println("(5) Converter de " + GBP + " para " + BRL);
            System.out.println("(6) Converter de " + CHF + " para " + GBP);
            System.out.println("(7) Fechar o programa");

            menu = leitura.nextInt();

            switch (menu){
                case 1:{
                    System.out.println("Poderia informar o valor, por gentileza?");
                    valor = leitura.nextDouble();

                    valorConvertido = valor * BRL.getUSD();
                    System.out.println("Valor em " + BRL.getSigla() + " " + valor);
                    System.out.println("Valor em " + USD.getSigla() + " " + valorConvertido);
                    break;
                }

                case 2:{
                    System.out.println("Poderia informar o valor, por gentileza?");
                    valor = leitura.nextDouble();

                    valorConvertido = valor * USD.getBRL();
                    System.out.println("Valor em " + USD.getSigla() + " " + valor);
                    System.out.println("Valor em " + BRL.getSigla() + " " + valorConvertido);
                    break;
                }

                case 3:{
                    System.out.println("Poderia informar o valor, por gentileza?");
                    valor = leitura.nextDouble();

                    valorConvertido = valor * ARS.getUSD();
                    System.out.println("Valor em " + ARS.getSigla() + " " + valor);
                    System.out.println("Valor em " + USD.getSigla() + " " + valorConvertido);
                    break;
                }

                case 4:{
                    System.out.println("Poderia informar o valor, por gentileza?");
                    valor = leitura.nextDouble();

                    valorConvertido = valor * CUP.getBRL();
                    System.out.println("Valor em " + CUP.getSigla() + " " + valor);
                    System.out.println("Valor em " + BRL.getSigla() + " " + valorConvertido);
                    break;
                }

                case 5:{
                    System.out.println("Poderia informar o valor, por gentileza?");
                    valor = leitura.nextDouble();

                    valorConvertido = valor * GBP.getBRL();
                    System.out.println("Valor em " + GBP.getSigla() + " " + valor);
                    System.out.println("Valor em " + BRL.getSigla() + " " + valorConvertido);
                    break;
                }

                case 6:{
                    System.out.println("Poderia informar o valor, por gentileza?");
                    valor = leitura.nextDouble();

                    valorConvertido = valor * CHF.getGBP();
                    System.out.println("Valor em " + CHF.getSigla() + " " + valor);
                    System.out.println("Valor em " + GBP.getSigla() + " " + valorConvertido);
                    break;
                }

                case 7:{
                    System.out.println("Fechando o programa. Muito obrigado!");
                    break;
                }

                default:{
                    System.out.println("Opa, essa opção não está dentro das possibilidades. Poderia digitar novamente?");
                }
            }
        }
    }
}