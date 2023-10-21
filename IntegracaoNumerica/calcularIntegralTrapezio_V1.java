/**
 *
 * @author Matheus Vieira
 */
public class IntegracaoNumerica {

    public static void main(String[] args) {
        double a = 0.0; // Limite inferior
        double b = 1.0; // Limite superior
        int n = 4; // Número de subintervalos

        double resultado = calcularIntegralTrapezio(a, b, n);
        System.out.println("A aproximação da integral definida é: " + resultado);
    }

    public static double calcularIntegralTrapezio(double a, double b, int n) {
        double h = (b - a) / n;
        double soma = (f(a) + f(b)) / 2;

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            soma += f(x);
        }

        return h * soma;
    }

    public static double f(double x) {
        return x * x;
    }
}
