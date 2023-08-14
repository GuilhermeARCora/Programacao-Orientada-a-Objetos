import java.util.Scanner;

public class VerificaNumeroPrimo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira um número inteiro para verificar se é primo: ");
        int numero = scanner.nextInt();

        int resultado = VerificaNumeroPrimo(numero);

        if (resultado == 1) {
            System.out.println(numero + " é primo.");
        } else {
            System.out.println(numero + " não é primo.");
        }

        scanner.close();
    }

    public static int VerificaNumeroPrimo(int n) {
        if (n <= 1) {
            return 0; // Números menores ou iguais a 1 não são primos
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0; // Encontrou um divisor, não é primo
            }
        }

        return 1; // Não encontrou nenhum divisor, é primo
    }
}
