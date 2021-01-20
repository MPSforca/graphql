package com.dextra.apigraphql.repository;

import com.dextra.apigraphql.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    List<Usuario> findByNome(String nome);

    List<Usuario> findByIdade(Integer idade);

    List<String> findNomeByIdade(Integer idade);

}
