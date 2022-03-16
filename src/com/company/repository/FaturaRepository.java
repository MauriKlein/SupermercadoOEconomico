package com.company.repository;

import com.company.model.Fatura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FaturaRepository implements Repository<Fatura> {

    List <Fatura> listaFaturas = new ArrayList<>();

    @Override
    public void salvar(Fatura objeto) {
        listaFaturas.add(objeto);
    }

    @Override
    public void exibirTodosNaTela() {
        for (Fatura fact : listaFaturas) {
            System.out.println(fact.toString());

        }
    }

    @Override
    public Optional<Fatura> buscarPorId(Long id) {
        boolean aux = false;
        for (Fatura f : listaFaturas) {
            if (f.getCodigo().equals(id)) {
                System.out.println("----Fatura encontrada, seus dados são: ----");
                System.out.println(f.toString());
                return Optional.of(f);
            }
        }

        if (aux == false) {
            System.out.println("Fatura não encontrada");
        }

        return Optional.empty();
    }

    @Override
    public void excluirPorId(Long id) {
        Optional<Fatura> fact = this.buscarPorId(id);

        if (fact.isEmpty()) {
            System.out.println("Fatura não encontrada");
        }
        else {
            System.out.println("Factura excluida corretamente");
            listaFaturas.remove(fact.get());
        }
    }

    @Override
    public List<Fatura> buscarTodos() {
        return listaFaturas;
    }
}
