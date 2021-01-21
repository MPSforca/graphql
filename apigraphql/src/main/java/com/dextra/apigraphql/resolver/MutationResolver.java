package com.dextra.apigraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.dextra.apigraphql.entity.Usuario;
import com.dextra.apigraphql.exceptions.NotFoundException;
import com.dextra.apigraphql.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(String nome, int idade) {
        return usuarioRepository.save(new Usuario(nome, idade));
    }

    public Usuario alterarNomeUsuario(Long id, String nome) throws NotFoundException {
        Optional<Usuario> oldUsuario = usuarioRepository.findById(id);
        if (oldUsuario.isPresent()) {
            Usuario usuario = oldUsuario.get();
            usuario.setNome(nome);
            usuarioRepository.save(usuario);
            return usuario;
        } else
            throw new NotFoundException("Usuário não encontrado!", "id");
    }

    public String deletarUsuario(Long id) throws NotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return "Usuário deletado!";
        } else
            throw new NotFoundException("Usuário não encontrado!", "id");
    }
}
