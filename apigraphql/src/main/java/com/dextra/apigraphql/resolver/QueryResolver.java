package com.dextra.apigraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dextra.apigraphql.entity.Usuario;
import com.dextra.apigraphql.repository.UsuarioRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario getUsuario(Long id) throws NotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent())
            return usuario.get();
        else
            throw new NotFoundException("Usuário não encontrado!");
    }
}
