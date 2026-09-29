public class Sorts<T extends Comparable<T>> {

    public void bubbleSort(T[] vetor) {

        int n = vetor.length;

        for (int i = 0; i < n - 1; i++) {

            boolean trocou = false;

            for (int j = 1; j < n - i; j++) {

                if (vetor[j].compareTo(vetor[j - 1]) < 0) {

                    T aux = vetor[j];
                    vetor[j] = vetor[j - 1];
                    vetor[j - 1] = aux;

                    trocou = true;
                }
            }

            if (!trocou) {
                break;
            }
        }
    }
}
