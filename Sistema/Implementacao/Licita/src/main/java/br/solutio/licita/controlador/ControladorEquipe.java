/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.Login;
import br.solutio.licita.modelo.MembroApoio;
import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.servico.ServicoIF;
import br.solutio.licita.servico.ServicoMembroApoio;
import br.solutio.licita.servico.ServicoMembroApoioIF;
import br.solutio.licita.servico.ServicoPessoaFisica;
import br.solutio.licita.servico.ServicoPregoeiro;
import br.solutio.licita.servico.ServicoPregoeiroIF;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author WitaloCarlos
 */
@ManagedBean
@ViewScoped
public class ControladorEquipe extends ControladorAbstrato<PessoaFisica> implements ControladorAbstratoIF<PessoaFisica> {

    private PessoaFisica entidade;
    private Pregoeiro pregoeiro;
    private MembroApoio membroApoio;
    private Login login;
    private transient List<PessoaFisica> pessoasfisica;
    private boolean cargoPregoeiro = false;
    private boolean cargoMembrodeApoio = false;
    private String valor;
    private String confirmaSenha = "";
    private final transient ServicoIF<PessoaFisica> servico;
    private final transient ServicoMembroApoioIF servicoMembro;
    private final transient ServicoPregoeiroIF servicoPregoeiro;
    private transient static final Logger log = Logger.getGlobal();

    public ControladorEquipe() {
        entidade = new PessoaFisica();
        pregoeiro = new Pregoeiro();
        membroApoio = new MembroApoio();
        login = new Login();
        servicoMembro = new ServicoMembroApoio();
        servicoPregoeiro = new ServicoPregoeiro();
        servico = new ServicoPessoaFisica();
    }

    public void tipoPessoaFisica() {

        if ("Pregoeiro".equals(valor)) {
            setCargoPregoeiro(true);
            setCargoMembrodeApoio(false);
        } else {
            setCargoPregoeiro(false);
            setCargoMembrodeApoio(true);
        }

    }

    @Override
    public String criar(PessoaFisica entidade) {
        entidade = getEntidade();
        corrigirCPF(entidade);
        if ((isCargoPregoeiro()) && (pregoeiro != null) && (login != null)) {
            pregoeiro.setPessoaFisica(entidade);
            pregoeiro.setLogin(login);
            servicoPregoeiro.criar(pregoeiro);
            JsfUtil.addSuccessMessage("Salvo com Sucesso!");
        } else if (isCargoMembrodeApoio() && (membroApoio != null)) {
            membroApoio.setPessoaFisica(entidade);
            servicoMembro.criar(membroApoio);
            JsfUtil.addSuccessMessage("Salvo com Sucesso!");
        } else {
            log.warning("Nenhuma função selecionada");
            JsfUtil.addSuccessMessage("Nenhuma função selecionada");
        }
        limparDados();
        return "equipe";
    }

    @Override
    public String editar(PessoaFisica entidade) {
        entidade = getEntidade();
        getServico().editar(entidade);
        setEntidade(new PessoaFisica());
        JsfUtil.addSuccessMessage("Atualizado com Sucesso!");
        return "equipe";
    }

    @Override
    public String deletar(PessoaFisica entidade) {
        entidade = getEntidade();
        getServico().deletar(entidade);
        setEntidade(new PessoaFisica());
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        return "equipe";
    }
    
    public String preparaEditar() {
        logger.log(Level.INFO, "Editar funfando");
        return "equipeEditar";
    }

    /**
     * Realiza a remocao dos caracteres especiais, caso haja, presentes na
     * variavel do CPF
     *
     * @param entidade
     */
    private void corrigirCPF(PessoaFisica entidade) {
        entidade.setCpf(entidade.getCpf().replace(".", ""));
        entidade.setCpf(entidade.getCpf().replace("-", ""));
    }

    public String limparDados() {
        this.login = null;
        this.pessoasfisica = null;
        this.membroApoio = null;
        this.pregoeiro = null;
        this.cargoPregoeiro = false;
        this.cargoMembrodeApoio = false;
        this.confirmaSenha = "";
        return "equipeSalvar";
    }

    public boolean isCargoPregoeiro() {
        return cargoPregoeiro;
    }

    public void setCargoPregoeiro(boolean cargoPregoeiro) {
        this.cargoPregoeiro = cargoPregoeiro;
    }

    public boolean isCargoMembrodeApoio() {
        return cargoMembrodeApoio;
    }

    public void setCargoMembrodeApoio(boolean cargoMembrodeApoio) {
        this.cargoMembrodeApoio = cargoMembrodeApoio;
    }

    public List<PessoaFisica> getPessoasfisica() {
        return pessoasfisica = servico.buscarTodos();
    }

    public void setPessoasfisica(List<PessoaFisica> pessoasfisica) {
        this.pessoasfisica = pessoasfisica;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public PessoaFisica getEntidade() {
        return this.entidade;
    }

    @Override
    public void setEntidade(PessoaFisica entidade) {
        this.entidade = entidade;
    }

    public Pregoeiro getPregoeiro() {
        return this.pregoeiro;
    }

    public MembroApoio getMembroApoio() {
        return this.membroApoio;
    }

    public Login getLogin() {
        return this.login;
    }

    public String getConfirmaSenha() {
        return this.confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    @Override
    public ServicoIF<PessoaFisica> getServico() {
        return servico;
    }

    public ServicoMembroApoioIF getServicoMembro() {
        return servicoMembro;
    }

    public ServicoPregoeiroIF getServicoPregoeiro() {
        return servicoPregoeiro;
    }

    public static Logger getLog() {
        return log;
    }

    public void setPregoeiro(Pregoeiro pregoeiro) {
        this.pregoeiro = pregoeiro;
    }

    public void setMembroApoio(MembroApoio membroApoio) {
        this.membroApoio = membroApoio;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
}
