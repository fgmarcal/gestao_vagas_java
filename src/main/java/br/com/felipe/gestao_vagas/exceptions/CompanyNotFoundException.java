package br.com.felipe.gestao_vagas.exceptions;

public class CompanyNotFoundException extends RuntimeException {
    
    public CompanyNotFoundException(){
        super("Company não existe");
    }
}
