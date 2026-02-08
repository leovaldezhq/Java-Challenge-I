import java.util.Scanner;

public class Main {
    static void showMenu() {
        System.out.println("""
                Digite a opção desejada:
                1- Consultar saldo
                2- Realizar transferência
                3- Receber valor
                4- Sair
                """);
    }

    static void viewBalance(double balance) {
        System.out.println("O saldo da sua conta é: R$ " + balance);
    }

    static double transferAmount(double balance, Scanner scanner) {
        System.out.println("Digite o valor a ser transferido: ");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Saldo insuficiente");
        } else {
            balance -= amount;
            System.out.println("Transferência realizada");
            System.out.println("Novo saldo: R$ " + balance);
        }

        return balance;
    }

    static double receiveAmount(double balance, Scanner scanner) {
        System.out.println("Valor recebido: ");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Novo saldo: R$ " + balance);

        return balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "Gabriela Zanotti";
        String accountType = "Conta Corrente";
        double balance = 3000;
        int option = 0;

        System.out.println("--------------------");
        System.out.println("Dados iniciais da cliente:");
        System.out.println("\nNome: " + name);
        System.out.println("Tipo de conta: " + accountType);
        System.out.println("Saldo inicial: R$ " +  balance);
        System.out.println("\n--------------------");

        while  (option != 4) {
            showMenu();
            option = scanner.nextInt();

            if (option == 1) {
                viewBalance(balance);
            } else if (option == 2) {
                balance = transferAmount(balance, scanner);
                } else if (option == 3) {
                balance = receiveAmount(balance, scanner);
            } else if (option != 4) {
                System.out.println("Opção inválida!");
            }
        }
    }
}