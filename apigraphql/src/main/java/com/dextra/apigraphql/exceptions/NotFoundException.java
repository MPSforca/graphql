package com.dextra.apigraphql.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;
import java.util.Map;

public class NotFoundException extends RuntimeException implements GraphQLError {

    private String campoInvalido;

    public NotFoundException(String mensagem, String campoInvalido) {
        super(mensagem);
        this.campoInvalido = campoInvalido;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }

    @Override
    public List<Object> getPath() {
        return null;
    }

    @Override
    public Map<String, Object> toSpecification() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Map.of("campoInvalido", campoInvalido);
    }
}
