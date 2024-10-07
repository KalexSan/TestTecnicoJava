package Quest03;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Faturamento {
    public static void main(String[] args){

        try {
           ObjectMapper objectMapper = new ObjectMapper();
           List<Map<String, Object>> faturamentoDiario = objectMapper.readValue(new File("faturamento.json"), new TypeReference<List<Map<String, Object>>>(){});
            
           double menorFaturamento = Double.MAX_VALUE;
           double maiorFaturamento = Double.MIN_VALUE;
           double somaFaturamento = 0;
           int diasComFaturamento = 0;

           for (Map<String, Object> dia : faturamentoDiario) {
                double faturamento = (double) dia.get("faturamento");

                if (faturamento > 0) {
                    diasComFaturamento++;
                    somaFaturamento += faturamento;

                    if (faturamento < menorFaturamento) {
                        menorFaturamento = faturamento;
                    }
                    if (faturamento > maiorFaturamento) {
                        maiorFaturamento = faturamento;
                    }
                    
                }
           }
           double mediaFaturamento = somaFaturamento / diasComFaturamento;

           int diasAcimaDaMadia = 0;
           for (Map<String, Object> dia : faturamentoDiario) {
                double faturamento = (double) dia.get("faturamento");
                if (faturamento > mediaFaturamento) {
                    diasAcimaDaMadia++;  
                }
           }

           System.out.println("Menor faturamento: " + menorFaturamento);
           System.out.println("Maior faturamento: " + maiorFaturamento);
           System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMadia);

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo JASON: " + e.getMessage());
        }

    }
}
