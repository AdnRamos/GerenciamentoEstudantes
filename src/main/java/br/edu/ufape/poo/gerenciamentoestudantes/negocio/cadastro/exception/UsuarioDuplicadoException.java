package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class UsuarioDuplicadoException  extends Exception{
    private String email;

    public UsuarioDuplicadoException(String email) {
        super("Não é possível cadastrar dois usuários com o mesmo email");
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

}
