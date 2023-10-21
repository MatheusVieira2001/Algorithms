/**
 *
 * @author Matheus Vieira
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Array original: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Array ordenado: " + Arrays.toString(arr));
    }

  /*O método quickSort é a peça central do algoritmo. Ele chama o método partition para encontrar o pivô e, em seguida, chama a si mesmo recursivamente para ordenar as sub-listas.*/
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

  /*O método partition encontra o pivô e rearranja os elementos de forma que os elementos menores que o pivô fiquem à esquerda e os maiores à direita.*/
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

  /*O método swap é uma função auxiliar que troca dois elementos em um array.*/
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
