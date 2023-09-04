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

@Service
public class CadastroVinculo implements InterfaceCadastroVinculo {
    @Autowired
    private InterfaceColecaoVinculo colecaoVinculo;
    @Autowired
    private InterfaceColecaoEstudante colecaoEstudante;

    @Override
    public Vinculo cadastrarVinculo(Vinculo vinculo) throws VinculoDuplicadoException {
        Estudante estudante = vinculo.getEstudante();

        if (estudante != null) {
            // Verifique se o estudante já está persistido no banco de dados
            if (estudante.getId() == 0) {
                // Se o estudante não tiver um ID, salve-o primeiro
                colecaoEstudante.save(estudante);
            }

            // Agora o estudante tem um ID válido
            Estudante estudanteExistente = colecaoEstudante.findById(estudante.getId())
                    .orElseThrow(EstudanteNaoEncontradoException::new);

            //estudanteExistente.addVinculo(vinculo);
            colecaoEstudante.save(estudanteExistente);
        }

        // Salve o estudante atualizado e o novo vínculo em uma única transação
        return colecaoVinculo.save(vinculo);
    }



    @Override
    public Vinculo atualizarVinculo(Vinculo vinculo) {
        // Verifique se o vínculo existe
        Vinculo vinculoExistente = consultarPorId(vinculo.getId());

        // Atualize os campos necessários
        if (vinculo.getTipoVinculo() != null) {
            vinculoExistente.setTipoVinculo(vinculo.getTipoVinculo());
        }
        if (vinculo.getDataFim() != null) {
            vinculoExistente.setDataFim(vinculo.getDataFim());
        }
        if (vinculo.getDataInicio() != null) {
            vinculoExistente.setDataInicio(vinculo.getDataInicio());
        }
        if (vinculo.getQtdHorasSemanais() != null) {
            vinculoExistente.setQtdHorasSemanais(vinculo.getQtdHorasSemanais());
        }
        if (vinculo.getEstudante() != null) {
            vinculoExistente.setEstudante(vinculo.getEstudante());
        }
        if(vinculo.isAtivo()){
            vinculoExistente.setAtivo(vinculo.isAtivo());
        }


        // Salve as alterações

        return colecaoVinculo.save(vinculoExistente);
    }




    @Override
    public List<Vinculo> listarVinculos() {
        return colecaoVinculo.findAll();
    }
    @Override
    public List<Vinculo> listarVinculosPorEstudante(Estudante estudante) {
        return colecaoVinculo.findByEstudante(estudante);
    }
    @Override
    public Vinculo consultarPorId(Long id) {
        return colecaoVinculo.findById(id).orElse(null);
    }
    @Override
    public void deletarPorId(Long aLong) {
        colecaoVinculo.deleteById(aLong);
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

