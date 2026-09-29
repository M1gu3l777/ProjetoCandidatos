public class Candidato implements Comparable<Candidato> {

    private String nome;
    private double nota;

    public Candidato(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public int compareTo(Candidato outro) {

        if (this.nota > outro.nota) {
            return -1;
        }

        if (this.nota < outro.nota) {
            return 1;
        }

        return this.nome.compareToIgnoreCase(outro.nome);
    }

    @Override
    public String toString() {
        return nome + " - " + String.format("%.1f", nota);
    }
}
