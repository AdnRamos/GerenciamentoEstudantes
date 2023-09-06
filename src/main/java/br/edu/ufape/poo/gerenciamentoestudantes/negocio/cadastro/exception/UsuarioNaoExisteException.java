package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class UsuarioNaoExisteException extends Exception{
    private String email;
    private long id;

    public UsuarioNaoExisteException(String email){
        super("Não existe usuario com email cadastrado.");
        this.email = email;
    }
    public UsuarioNaoExisteException(long id){
        super("Não existe usuario com email cadastrado.");
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public long getId(){return id;}
}
