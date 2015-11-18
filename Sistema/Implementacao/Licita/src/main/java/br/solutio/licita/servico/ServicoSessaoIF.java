/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.EmpresaLicitante;
import br.solutio.licita.modelo.Proposta;
import br.solutio.licita.modelo.Sessao;
import java.util.List;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author ricardocaldeira
 */
public interface ServicoSessaoIF extends ServicoIF<Sessao> {
    
    public List<EmpresaLicitante> getEmpresasLicitantes();
    public List<Proposta> getPropostas(Sessao sessao);

    /**
     *
     * @param uploadArquivo
     * @return
     */
    public boolean filtraPlanilha(UploadedFile uploadArquivo);

    public boolean salvarPropostas(Sessao entidade, EmpresaLicitante empresaLicitante);
}
