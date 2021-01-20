package com.dextra.apigraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.dextra.apigraphql.entity.Usuario;
import com.dextra.apigraphql.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(String nome, int idade) {
        return null;
    }

    public Usuario alterarUsuario(long id, String nome, int idade) {
        return null;
    }

    public String deletarUsuario(long id) {
        return "";
    }
}
