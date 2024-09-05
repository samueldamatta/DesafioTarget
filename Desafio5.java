import java.util.Scanner;

public class Desafio5 {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.print("Informe uma string: ");
        String input = leitura.nextLine();

        String invertida = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            invertida += input.charAt(i);
        }

        System.out.println("String invertida: " + invertida);
    }
}
