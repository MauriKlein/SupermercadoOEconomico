package com.company;

import com.company.model.Cliente;
import com.company.model.Fatura;
import com.company.model.Item;
import com.company.repository.ClienteRepository;
import com.company.repository.FaturaRepository;
import com.company.repository.ItemRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        ItemRepository itemRepository = new ItemRepository();
        FaturaRepository faturaRepository = new FaturaRepository();

        //criando 4 clientes
        Cliente cliente1 = new Cliente(123L, "Mauri", "Klein");
        Cliente cliente2 = new Cliente(124L, "Marlise", "Klein");
        Cliente cliente3 = new Cliente(125L, "Bruno", "Klein");
        Cliente cliente4 = new Cliente(126L, "Keila", "Klein");

        clienteRepository.salvar(cliente1); //salvar um cliente
        clienteRepository.salvar(cliente2); //salvar um cliente
        clienteRepository.salvar(cliente3); //salvar um cliente
        clienteRepository.salvar(cliente4); //salvar um cliente

        clienteRepository.exibirTodosNaTela(); //mostrando todos os clientes

        //buscar um cliente
        Scanner teclado = new Scanner(System.in);
        System.out.println("Para buscar por um Clinete, insira o ID:");
        Long idBuscar = teclado.nextLong();
        clienteRepository.buscarPorId(idBuscar);

        //excluir o cliente
        System.out.println("Para excluir um Cliente, insira o ID:");
        idBuscar = teclado.nextLong();
        clienteRepository.excluirPorId(idBuscar);


        //Criando Itens
        Item item1 = new Item(123L, "PS5", 2, 5000.0);
        Item item2 = new Item(124L, "MOBI", 1, 50000.0);
        Item item3 = new Item(125L, "UNO", 1, 40000.0);
        Item item4 = new Item(126L, "GALAXI", 3, 3000.0);

        //Salvando itens
        itemRepository.salvar(item1);
        itemRepository.salvar(item2);
        itemRepository.salvar(item3);
        itemRepository.salvar(item4);

        //Removendo o item 4
        itemRepository.excluirPorId(123L);

        //Criando uma Fatura
        Fatura fatura = new Fatura(999L, cliente1, itemRepository.buscarTodos());
        System.out.println(fatura.toString());




    }

}
