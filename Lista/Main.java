import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String arquivo = "candidatos_vestibular.csv";

        ArrayList<Candidato> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

            String linha;

            br.readLine();

            while ((linha = br.readLine()) != null) {

                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] dados = linha.split(",");

                String nome = dados[0].trim();
                double nota = Double.parseDouble(dados[1].trim());

                lista.add(new Candidato(nome, nota));
            }

        } catch (IOException e) {

            System.out.println("Erro ao ler o arquivo CSV.");
            System.out.println(e.getMessage());
            return;

        } catch (NumberFormatException e) {

            System.out.println("Erro: alguma nota do CSV está inválida.");
            return;
        }

        Candidato[] candidatos = lista.toArray(new Candidato[0]);


        System.out.println("===== ANTES DA ORDENAÇÃO =====");

        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }


        Sorts<Candidato> sorts = new Sorts<>();

        sorts.bubbleSort(candidatos);


        System.out.println("\n===== CANDIDATOS CLASSIFICADOS =====");

        for (int i = 0; i < candidatos.length; i++) {

            System.out.println(
                (i + 1) + ". " + candidatos[i]
            );
        }
    }
}
