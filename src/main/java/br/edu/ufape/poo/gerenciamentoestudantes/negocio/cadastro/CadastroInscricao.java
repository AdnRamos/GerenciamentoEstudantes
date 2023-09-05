package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoEstudante;
import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoInscricao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Bolsa;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Inscricao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroInscricao implements InterfaceCadastroInscricao {
    @Autowired
    private InterfaceColecaoInscricao cadastroInscricao;
    @Autowired
    private InterfaceColecaoEstudante cadastroEstudante;
    @Autowired
    private InterfaceCadastroBolsa cadastroBolsa;

    @Override
    public Inscricao cadastrarInscricao(Inscricao inscricao) throws InscricaoInvalidaException, InscricaoDuplicadaException, BolsaNaoEncontradaException {
        if (inscricao.getEstudante() == null || inscricao.getBolsa() == null) {
            throw new InscricaoInvalidaException("Estudante e bolsa devem ser fornecidos", new IllegalArgumentException());
        }

        // Verifica se o estudante já existe no banco de dados com base no ID fornecido
        Optional<Estudante> estudanteExistente = cadastroEstudante.findById(inscricao.getEstudante().getId());

        if (estudanteExistente.isPresent()) {
            // O estudante já existe, atualiza o estudante existente com a nova inscrição
            Estudante estudante = estudanteExistente.get();
            estudante.addInscricao(inscricao); // Supondo que você tenha um método para adicionar inscrição no estudante
            inscricao.setEstudante(estudante); // Associa a inscrição ao estudante existente
        } else {
            // O estudante não existe, crie um novo estudante com a inscrição
            inscricao.setEstudante(cadastroEstudante.save(inscricao.getEstudante())); // Salva o novo estudante no banco de dados
        }

        // Verifica se a bolsa já existe no banco de dados com base no ID fornecido
        Bolsa bolsaExistente = cadastroBolsa.buscarBolsaPorId(inscricao.getBolsa().getId());

        if (bolsaExistente.getId() != 0) {
            // A bolsa já existe, associa a inscrição a essa bolsa
            Bolsa bolsa = bolsaExistente;
            bolsa.addInscricao(inscricao); // Supondo que você tenha um método para adicionar inscrição na bolsa
            inscricao.setBolsa(bolsa); // Associa a inscrição à bolsa existente
        } else {
            throw new BolsaNaoEncontradaException("Bolsa não encontrada ou inválida");
        }

        // Agora você pode salvar a inscrição
        return cadastroInscricao.save(inscricao);
    }


    @Override
    public List<Inscricao> listarInscricoesPorEstudante(Estudante estudante) {
        if (estudante == null) {
            throw new EstudanteNaoEncontradoException("Estudante não fornecido");
        }

        return cadastroInscricao.findByEstudante(estudante);
    }
    @Override
    public List<Inscricao> listarInscricoes() {
        return cadastroInscricao.findAll();
    }

    @Override
    public Inscricao buscarInscricaoPorId(long id) throws InscricaoNaoEncontradaException {
        return cadastroInscricao.findById(id)
                .orElseThrow(() -> new InscricaoNaoEncontradaException("Inscrição não encontrada com o ID: " + id));
    }

    @Override
    public void removerInscricaoPorId(long id) throws InscricaoNaoEncontradaException {
        if (!cadastroInscricao.existsById(id)) {
            throw new InscricaoNaoEncontradaException("Inscrição não encontrada com o ID: " + id);
        }

        cadastroInscricao.deleteById(id);
    }

}