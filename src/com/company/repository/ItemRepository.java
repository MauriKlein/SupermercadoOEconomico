package com.company.repository;

import com.company.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemRepository implements Repository<Item> {

    List <Item> listaItems = new ArrayList<>();

    @Override
    public void salvar(Item objeto) {
        listaItems.add(objeto);
    }

    @Override
    public void exibirTodosNaTela() {
        for (Item it : listaItems) {
            System.out.println(it.toString());
        }
    }

    @Override
    public Optional<Item> buscarPorId(Long id) {
        boolean aux = false;
        for (Item i : listaItems) {
            if (i.getCodigo().equals(id)) {
                System.out.println("----Item encontrado, seus dados são: ----");
                System.out.println(i.toString());
                return Optional.of(i);
            }
        }

        if (aux == false) {
            System.out.println("Item não encontrado");
        }
        return Optional.empty();    }

    @Override
    public void excluirPorId(Long id) {
        Optional<Item> it = this.buscarPorId(id);

        if (it.isEmpty()) {
            System.out.println("Item não encontrado");
        }
        else {
            System.out.println("item excluido corretamente");
            listaItems.remove(it.get());
        }
    }

    @Override
    public List<Item> buscarTodos() {
        return listaItems;
    }
}
