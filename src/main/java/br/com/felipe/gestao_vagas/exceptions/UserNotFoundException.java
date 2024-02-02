package br.com.felipe.gestao_vagas.exceptions;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(){
        super("Usuário não existe");
    }
}
    
