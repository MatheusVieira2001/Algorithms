/**
 *
 * @author Matheus Vieira
 */
public class SegmentTree {

  /**
     * Constrói a árvore de segmentos a partir do array original.
     *
     * @param arr   Array original
     * @param tree  Árvore de segmentos
     * @param node  Nó atual
     * @param start Início do intervalo
     * @param end   Fim do intervalo
     */
    public static void build(int[] arr, int[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        build(arr, tree, 2 * node, start, mid);
        build(arr, tree, 2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    /**
     * Realiza uma consulta no intervalo [left, right] dentro da árvore.
     *
     * @param tree  Árvore de segmentos
     * @param node  Nó atual
     * @param start Início do intervalo
     * @param end   Fim do intervalo
     * @param left  Início do intervalo de consulta
     * @param right Fim do intervalo de consulta
     * @return Resultado da operação desejada
     */
    public static int query(int[] tree, int node, int start, int end, int left, int right) {
        if (right < start || left > end)
            return 0;

        if (left <= start && right >= end)
            return tree[node];

        int mid = (start + end) / 2;
        int leftResult = query(tree, 2 * node, start, mid, left, right);
        int rightResult = query(tree, 2 * node + 1, mid + 1, end, left, right);
        return leftResult + rightResult;
    }

    /**
     * Atualiza o valor do elemento no índice index no array original, e reflete essa
     * alteração na Árvore de Segmentos.
     *
     * @param tree  Árvore de segmentos
     * @param node  Nó atual
     * @param start Início do intervalo
     * @param end   Fim do intervalo
     * @param index Índice do elemento a ser atualizado
     * @param value Novo valor do elemento
     */
    public static void update(int[] tree, int node, int start, int end, int index, int value) {
        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;
        if (index <= mid)
            update(tree, 2 * node, start, mid, index, value);
        else
            update(tree, 2 * node + 1, mid + 1, end, index, value);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11,13,15,17,19,21};
        // Tamanho da árvore deve ser 4 vezes o tamanho do array original
        int[] tree = new int[4 * arr.length]; 

        build(arr, tree, 1, 0, arr.length - 1);

        // Realiza uma consulta no intervalo [2, 4]
        int result = query(tree, 1, 0, arr.length - 1, 2, 4);
        System.out.println("Resultado da consulta: " + result);

        // Atualiza o valor do elemento no índice 3 para 6
        update(tree, 1, 0, arr.length - 1, 3, 6);

        // Realiza uma nova consulta no intervalo [2, 4]
        result = query(tree, 1, 0, arr.length - 1, 2, 4);
        System.out.println("Novo resultado da consulta: " + result);
    }
}
