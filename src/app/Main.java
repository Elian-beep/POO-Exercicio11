package app;

import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import entities.Conta;
import excecoes.ExcecaoNegocio;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os dados da conta: ");

        System.out.printf("Número: ");
        int numero = sc.nextInt();
        sc.nextLine();

        System.out.printf("Titular: ");
        String titular = sc.nextLine();

        System.out.printf("Saldo inicial: ");
        double saldo = sc.nextDouble();

        System.out.printf("Limite de Crédito: ");
        double limiteCredito = sc.nextDouble();

        Conta conta = new Conta(numero, titular, saldo, limiteCredito);

        System.out.printf("\nValor para saque: ");
        double valorSaque = sc.nextDouble();

        try{
            conta.saque(valorSaque);
            System.out.println("Novo saldo: "+ String.format("%.2f", conta.getSaldo()));
        }catch(ExcecaoNegocio e){
            System.out.println(e.getMessage());
        }

        
    }
}
