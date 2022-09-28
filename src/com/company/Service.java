package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service
{

    static List<Cliente> listCliente = new ArrayList<>();

    public static void servico()
    {
        System.out.println("Bem vindo ao mercadinho");
        LOL:
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bem vindo a tela de De menu");
            System.out.println("Digite(1) para novo cliente: ");
            System.out.println("Digite(2) para remover um produto: ");
            System.out.println("Digite(3) para atualizar cliente: ");
            System.out.println("Digite(4) para remover cliente: ");
            System.out.println("Digite(5) para mostrar a lista: ");
            System.out.println("Digite(0) para sair do sistema: ");
            int opcaoEscolhida = scanner.nextInt();
            Cliente cliente = new Cliente();
            Produto produto = new Produto();
            if(opcaoEscolhida == 1)
            {
                System.out.println("Aba de cliente");
                Scanner addClinete = new Scanner(System.in);
                System.out.println("Digite o nome do cliente");
                cliente.nome = addClinete.nextLine();
                System.out.println("Digite o cpf do cliente");
                cliente.cpf = addClinete.nextLine();
                listCliente.add(cliente);
                produto.id = 1;
                produto.nome = "Cerveja";
                produto.precoIndividual = 2.00;
                produto.quantidade = 5;
                produto.precoTotal = (produto.precoIndividual * produto.quantidade);
                cliente.produtos.add(produto);
                if(produto.precoTotal < 100.00)
                {
                    produto.precoTotal = (produto.precoTotal/0.1 );
                }
                else
                {
                    produto.precoTotal = (produto.precoTotal*0.1 );
                }
            }

            if(opcaoEscolhida == 2)
            {

                for (int i = 0; i <= listCliente.size(); i++){
                    System.out.println("Digite o CPF do cliente que deseja remover os produtos");
                    Scanner removerProd = new Scanner(System.in);
                    String remProdut = removerProd.nextLine();
                    if (remProdut.equals(listCliente.get(i).cpf)){
                        cliente.produtos.remove(produto);
                        System.out.println("Produto removido");
                    }
                }
            }

            if(opcaoEscolhida == 3) {
                System.out.println("Para atualizar");
                System.out.println("Digite o CPF do cliente");
                Scanner novoProd = new Scanner(System.in);
                String novProduto = novoProd.nextLine();
                for (int g = 0; g < listCliente.size(); g++) {
                    if (novProduto.equals(listCliente.get(g).cpf)) {
                        produto.id = 1;
                        produto.nome = "Linguisa";
                        produto.precoIndividual = 1.00;
                        produto.quantidade = 15;
                        produto.precoTotal = (produto.quantidade * produto.precoIndividual);
                        cliente.produtos.add(produto);
                    }
                }
            }
            if(opcaoEscolhida == 4)
            {
                System.out.println("Remover o cliente");
                for (int i = 0; i <= listCliente.size(); i++) {
                    System.out.println("Informe o CPF do cliente que deseja remover");
                    Scanner removerCliente = new Scanner(System.in);
                    String exCliente = removerCliente.nextLine();
                    if (exCliente.equals(listCliente.get(i).cpf)) {

                        listCliente.remove(i);
                        System.out.println("Cliente removido!!!");
                        continue LOL;
                    }
                }
            }

            if(opcaoEscolhida == 5)
            {
                System.out.println("Mostrando lista");
                cliente.totalCompra = produto.precoTotal;
                for (Cliente a : listCliente)
                {
                    System.out.println(a.nome);
                    System.out.println(a.cpf);
                    for(Produto p : a.produtos)
                    {
                        System.out.println(p.id);
                        System.out.println(p.nome);
                        System.out.println(p.precoTotal);
                    }
                    System.out.println("##########");
                }
            }
            if(opcaoEscolhida == 0){
                System.out.println("Você está saindo");
                System.out.println("Saindo do sistema ...");
                break LOL;
            }
        }
    }
}
