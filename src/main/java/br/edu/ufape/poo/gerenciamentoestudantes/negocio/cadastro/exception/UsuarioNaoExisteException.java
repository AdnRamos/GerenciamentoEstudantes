package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class UsuarioNaoExisteException extends Exception{
    private String email;

    public UsuarioNaoExisteException(String email){
        super("Não existe usuario com email cadastrado.");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
