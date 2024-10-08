package Quest03;

import java.io.File;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Faturamento {
    public static void main(String[] args){
        String caminhoArquivo = "dados.json";

        try {
           ObjectMapper objectMapper = new ObjectMapper();
           JsonNode faturamentos = objectMapper.readTree(new File(caminhoArquivo));
            
           double menorValor = Double.MAX_VALUE;
           double maiorValor = Double.MIN_VALUE;
           double somaFaturamento = 0;
           int diasComFaturamento = 0;

           for (JsonNode faturamento : faturamentos) {
                double valor = faturamento.get("valor").asDouble();

                if (valor > 0) {

                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }

                    somaFaturamento = valor + somaFaturamento;
                    diasComFaturamento++;
                    
                }
           }
           double mediaMensal = somaFaturamento / diasComFaturamento;

           

           System.out.printf("Menos faturamento: %.4f\n", menorValor);
           System.out.printf("Maior faturamento: %.4f\n", maiorValor);
           System.out.printf("Média de faturamento: %.4f\n", mediaMensal);
           System.out.printf("Dias com faturamento acima da média: %.4f\n", diasComFaturamento);

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo JASON: " + e.getMessage());
        }

    }
}
