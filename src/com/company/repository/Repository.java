package com.company.repository;

import java.util.List;
import java.util.Optional;

public interface Repository <T>{
    public void salvar (T objeto);
    public void exibirTodosNaTela();
    public Optional<T> buscarPorId (Long id);
    public void excluirPorId (Long id);
    public List<T> buscarTodos();
}
