package com.kir.backend.services;


import java.util.List;
import java.util.Optional;

public interface IBaseService<T>  {
    void guardar(T entity);
    List<T> listar();
    void eliminar(T entity);
    Optional<T> buscarPorId(Long id);
    void actualizar(T type, T entity);
}
