import java.util.Scanner;

public class Desafio2 {
    public static boolean isFibonacci(int num) {
        int a = 0, b = 1;
        while (b < num) {
            b = a + b;
            a = b - a;
        }
        return num == b || num == 0;
    }

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int num = leitura.nextInt();
        System.out.println(isFibonacci(num) ? "Pertence à sequência de Fibonacci." : "Não pertence à sequência de Fibonacci.");
    }
}
