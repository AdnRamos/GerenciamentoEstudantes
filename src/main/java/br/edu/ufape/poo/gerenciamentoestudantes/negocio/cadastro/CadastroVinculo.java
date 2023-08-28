package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoEstudante;
import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoVinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoVinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Vinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroVinculo implements InterfaceCadastroVinculo {
    @Autowired
    private InterfaceColecaoVinculo colecaoVinculo;
    @Autowired
    private InterfaceColecaoEstudante colecaoEstudante;

    @Override
    public Vinculo cadastrarVinculo(Estudante estudante, Vinculo vinculo) throws VinculoDuplicadoException {
        if (verificarExistenciaVinculo(estudante,vinculo.getTipoVinculo(),vinculo.getDataInicio(), vinculo.getDataFim())) {
            throw new VinculoDuplicadoException("O estudante"+ estudante.getNome()+"já está com esse vinculo cadastrado");
        }
        System.out.println("Buscando estudante no banco de dados com ID: " + estudante.getId());
        Estudante estudanteExistente = colecaoEstudante.findById(estudante.getId())
                .orElseThrow(() -> new EstudanteNaoEncontradoException());
        System.out.println("Estudante encontrado: " + estudanteExistente.getNome());
        estudante.addVinculo(vinculo);
        colecaoEstudante.save(estudanteExistente);

        return colecaoVinculo.save(vinculo);
    }

    @Override
    public void atualizarVinculo(Vinculo vinculo) {
        Optional<Vinculo> vinculoExistente = colecaoVinculo.findById(vinculo.getId());

        if (!vinculoExistente.isPresent()) {
            throw new VinculoNaoEncontradoException(vinculo.getId());
        }

        Vinculo vinculoAtualizado = vinculoExistente.get();
        vinculoAtualizado.setAtivo(vinculo.isAtivo());
        vinculoAtualizado.setDataFim(vinculo.getDataFim());

        try {
            colecaoVinculo.save(vinculoAtualizado);
        } catch (Exception e) {
            throw new NaoSalvouException("Falha ao atualizar o vinculo", e);
        }
    }


    @Override
    public boolean verificarExistenciaVinculo(Estudante estudante, TipoVinculo tipoVinculo, String dataInicio, String dataFim) {
        List<Vinculo> vinculosEstudante = colecaoVinculo.findByEstudante(estudante);

        for (Vinculo vinculoExistente : vinculosEstudante) {
            if (vinculoExistente.getTipoVinculo() == tipoVinculo &&
                    vinculoExistente.getDataInicio().equals(dataInicio) &&
                    vinculoExistente.getDataFim().equals(dataFim)) {
                return true; // Vínculo duplicado encontrado
            }
        }

        return false; // Sem vínculo duplicado
    }

}

