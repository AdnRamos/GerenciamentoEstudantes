package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Bolsa;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Inscricao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.InscricaoInvalidaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.InscricaoNaoEncontradaException;

import java.util.List;

public interface InterfaceCadastroInscricao {
    Inscricao cadastrarInscricao(Inscricao inscricao) throws InscricaoInvalidaException;

    List<Inscricao> listarInscricoesPorEstudante(Estudante estudante);

    Inscricao buscarInscricaoPorId(long id) throws InscricaoNaoEncontradaException;

    void removerInscricaoPorId(long id) throws InscricaoNaoEncontradaException;
    public List<Inscricao> listarInscricoes();

    }
