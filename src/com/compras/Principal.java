package com.compras;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //pega o limite do cartão
        Scanner leitura = new Scanner(System.in);
        System.out.println("Qual o limite que deseja no seu cartão e credito?" );
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        //loop de compras
        int sair = 1;
        while (sair != 0){
            System.out.println("O que deseja comprar? ");
            String descricao = leitura.next();

            System.out.println("Qual o valor desse preoduto? ");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if(compraRealizada){
                System.out.println("Compra realaizada com sucesso");
                System.out.println("Digite 0 para sair ou 1 para continuar comprando: ");
                sair = leitura.nextInt();
            } else {
                System.out.println("Compra recusada");
                System.out.println("Digite 0 para sair ou 1 para continuar comprando: ");
                sair = leitura.nextInt();
            }

        }

        System.out.println("Até mais ;)");
        System.out.println("\n_____________________");
        System.out.println("\nCompras realizadas: ");
        //usa a interface e o método implementado na class Compra para ordenar as compras
        Collections.sort(cartao.getCompras());

        for (Compra c : cartao.getCompras()){
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }

        System.out.println("\n_____________________");
        System.out.println("\nSaldo do cartão: " + cartao.getSaldo());

    }


}
