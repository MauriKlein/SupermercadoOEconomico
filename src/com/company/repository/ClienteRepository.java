package com.company.repository;

import com.company.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository implements Repository<Cliente>{

    List<Cliente> listaClientes;

    public ClienteRepository() {
        this.listaClientes = new ArrayList<>();
    }

    @Override
    public void salvar(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void exibirTodosNaTela() {
        for (Cliente c : listaClientes) {
            System.out.println("ID: " + c.getId() +
                    "; Nome: " + c.getNome()+
                    " Sobrenome: " + c.getSobrenome());
        }
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        boolean aux = false;
        for (Cliente c : listaClientes) {
            if (c.getId().equals(id)) {
                System.out.println("----Cliente encontrado, seus dados são: ----");
                System.out.println("ID: " + c.getId() +
                        "; Nome: " + c.getNome()+
                        " Sobrenome: " + c.getSobrenome());
                aux=true;
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @Override
    public void excluirPorId(Long id) {
        Optional<Cliente> cliente = this.buscarPorId(id);
        if (cliente.isEmpty()){
            System.out.println("Cliente não encontrado");
        }else{
            listaClientes.remove(cliente.get());
            System.out.println("Cliente excluido corretamente");
        }

    }

    @Override
    public List<Cliente> buscarTodos() {
        return listaClientes;
    }
}
