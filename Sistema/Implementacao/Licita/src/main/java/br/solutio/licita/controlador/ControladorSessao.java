/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.excecoes.RunExcecoesLicita;
import br.solutio.licita.modelo.EmpresaLicitante;
import br.solutio.licita.modelo.Proposta;
import br.solutio.licita.modelo.Sessao;
import br.solutio.licita.servico.ProdutorEntityManager;
import br.solutio.licita.servico.ServicoIF;
import br.solutio.licita.servico.ServicoSessao;
import br.solutio.licita.servico.ServicoSessaoIF;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.PersistenceException;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author ricardocaldeira
 */
@ManagedBean
@SessionScoped
public class ControladorSessao extends ControladorAbstrato<Sessao> {

    private Sessao entidade;
    private UploadedFile arquivoProposta;
    private EmpresaLicitante empresaLicitante;
    private transient List<Sessao> sessoes;
    private transient List<EmpresaLicitante> empresasLicitantes;
    private transient List<Proposta> propostas;
    private final transient ServicoSessaoIF servico;

    public ControladorSessao() {
        entidade = new Sessao();
        servico = new ServicoSessao(ProdutorEntityManager.getInstancia().getEmLocal());
    }

    public void uploadArquivo() {
        try {
            if (arquivoProposta != null) {
                if (validarArquivo(arquivoProposta)) {
                    filtrarDadosPlanilha(arquivoProposta);
                    Logger.getLogger(ControladorSessao.class.getName()).log(Level.INFO, "Arquivo anexado com sucesso");
                    JsfUtil.addSuccessMessage("Arquivo Anexado Com Sucesso!");
                } else {
                    Logger.getLogger(ControladorSessao.class.getName()).log(Level.SEVERE, "O Arquivo Selecionado não é .XLS  ");
                    throw new RunExcecoesLicita("O Arquivo Selecionado não é .XLS  ");
                }
            } else {
                Logger.getLogger(ControladorSessao.class.getName()).log(Level.SEVERE, "Nenhum arquivo foi localizado");
                JsfUtil.addErrorMessage("Nenhum Arquivo Foi Localizado!");
            }
        } catch (RunExcecoesLicita re) {
            JsfUtil.addErrorMessage(re, re.getMessage());
            Logger.getLogger(ControladorSessao.class.getName()).log(Level.SEVERE, re.getMessage(), re);
        }
    }

    public void filtrarDadosPlanilha(UploadedFile arquivoUpload) {
        servico.filtraPlanilha(arquivoUpload);
    }

    @Override
    public String criar(Sessao entidade) {
        try {
            entidade = getEntidade();
            getServico().criar(entidade);
            setEntidade(null);
            setEntidade(new Sessao());
            JsfUtil.addSuccessMessage("Salvo com Sucesso!");
            return "sessao";
        } catch (PersistenceException | IllegalStateException e) {
            Logger.getLogger(ControladorSessao.class.getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage("Sessão já existe");
            return "sessaoSalvar";
        }

    }

    public String iniciar(Sessao entidade) {
        try {
            entidade = getEntidade();
            getServico().criar(entidade);
            JsfUtil.addSuccessMessage("Salvo com Sucesso!");
            return "sessaoIniciar?faces-redirect=true";
        } catch (PersistenceException | IllegalStateException e) {
            Logger.getLogger(ControladorSessao.class.getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage("Sessão já existe");
            return "sessaoSalvar?faces-redirect=true";
        }
    }

    @Override
    public String editar(Sessao entidade) {

        try {
            entidade = getEntidade();
            getServico().editar(entidade);
            setEntidade(new Sessao());
            JsfUtil.addSuccessMessage("Atualizado com Sucesso!");
            return "sessao";
        } catch (PersistenceException | IllegalStateException e) {
            Logger.getLogger(ControladorSessao.class.getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage("Sessão já existe");
            return "sessaoEditar";
        }

    }

    @Override
    public String deletar(Sessao entidade) {
        entidade = getEntidade();
        getServico().deletar(entidade);
        setEntidade(new Sessao());
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        return "sessao";
    }

    public String limparDados() {
        setEntidade(null);
        setEntidade(new Sessao());
        return "sessaoSalvar";
    }

    public String preparaEditar() {
        logger.log(Level.INFO, "Editar funfando");
        return "sessaoEditar";
    }

    public Date getDataAtual() {
        return new Date();
    }

    @Override
    public Sessao getEntidade() {
        return entidade;
    }

    @Override
    public void setEntidade(Sessao entidade) {
        this.entidade = entidade;
    }

    public EmpresaLicitante getEmpresaLicitante() {
        return this.empresaLicitante;
    }

    public void setEmpresaLicitante(EmpresaLicitante empresaLicitante) {
        this.empresaLicitante = empresaLicitante;
    }

    public List<Sessao> getSessoes() {
        return sessoes = servico.buscarTodos();
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    public List<EmpresaLicitante> getEmpresasLicitantes() {
        return servico.getEmpresasLicitantes();
    }

    @Override
    public ServicoIF<Sessao> getServico() {
        return servico;
    }

    public UploadedFile getArquivoProposta() {
        return this.arquivoProposta;
    }

    public void setArquivoProposta(UploadedFile arquivoProposta) {
        this.arquivoProposta = arquivoProposta;
    }

    private Boolean validarArquivo(UploadedFile arquivoProposta) {
        String tipoArquivo = ".xls";
        return arquivoProposta.getFileName().contains(tipoArquivo);
    }

    public List<Proposta> getPropostas() {
        return servico.getPropostas(entidade);
    }

}
