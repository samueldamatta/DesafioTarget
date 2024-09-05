import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Desafio3 {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            List<FaturamentoDiario> faturamento = objectMapper.readValue(
                    new File("faturamento.json"),
                    new TypeReference<List<FaturamentoDiario>>() {});

            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0;
            int diasComFaturamento = 0;

            for (FaturamentoDiario dia : faturamento) {
                if (dia.getValor() > 0) {
                    somaFaturamento += dia.getValor();
                    diasComFaturamento++;
                    if (dia.getValor() < menorFaturamento) {
                        menorFaturamento = dia.getValor();
                    }
                    if (dia.getValor() > maiorFaturamento) {
                        maiorFaturamento = dia.getValor();
                    }
                }
            }

            double mediaMensal = somaFaturamento / diasComFaturamento;

            int diasAcimaDaMedia = 0;
            for (FaturamentoDiario dia : faturamento) {
                if (dia.getValor() > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("Menor faturamento: " + menorFaturamento);
            System.out.println("Maior faturamento: " + maiorFaturamento);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FaturamentoDiario {
    private int dia;
    private double valor;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

