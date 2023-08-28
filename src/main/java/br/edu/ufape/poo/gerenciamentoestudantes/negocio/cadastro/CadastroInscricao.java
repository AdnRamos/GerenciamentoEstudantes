package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoInscricao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Bolsa;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Inscricao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.EstudanteNaoEncontradoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.InscricaoDuplicadaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.InscricaoInvalidaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.InscricaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroInscricao implements InterfaceCadastroInscricao {
    @Autowired
    private InterfaceColecaoInscricao cadastroInscricao;

    @Override
    public Inscricao cadastrarInscricao(Inscricao inscricao) throws InscricaoInvalidaException, InscricaoDuplicadaException {
        if (inscricao.getEstudante() == null || inscricao.getBolsa() == null) {
            throw new InscricaoInvalidaException("Estudante e bolsa devem ser fornecidos", new IllegalArgumentException());
        }

        Optional<Inscricao> inscricaoExistente = cadastroInscricao.findByEstudanteAndBolsa(inscricao.getEstudante(), inscricao.getBolsa()   );
        if (inscricaoExistente.isPresent()) {
            throw new InscricaoDuplicadaException("Inscrição já cadastrada para este estudante e bolsa");
        }
        inscricao.setBolsa(inscricao.getBolsa());
        inscricao.setEstudante(inscricao.getEstudante());

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