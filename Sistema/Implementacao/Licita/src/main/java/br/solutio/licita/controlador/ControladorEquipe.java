/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.modelo.Login;
import br.solutio.licita.modelo.MembroApoio;
import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.servico.ServicoEquipe;
import br.solutio.licita.servico.ServicoEquipeIF;
import br.solutio.licita.servico.ServicoIF;
import java.util.List;
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

    private PessoaFisica entidade = new PessoaFisica();
    private Pregoeiro pregoeiro = new Pregoeiro();
    private MembroApoio membroApoio = new MembroApoio();
    private Login login = new Login();
    private transient List<PessoaFisica> pessoasfisica;
    private boolean cargoPregoeiro = false;
    private boolean cargoMembrodeApoio = false;
    private String valor;
    private String confirmaSenha = "";
    private ServicoEquipeIF servico = new ServicoEquipe();
    private Logger log = Logger.getGlobal();

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
        if( (isCargoPregoeiro()) && (pregoeiro != null) && (login != null) ){
            servico.criarPregoeiro(entidade, pregoeiro, login);
        }else if(isCargoMembrodeApoio() &&  (membroApoio != null) ){
            servico.criarMembroApoio(entidade, membroApoio);
        }else{
            log.warning("Nenhuma funcao selecionada");
        }
        limparDados();
        return "equipe";
    }

    /**
     * Realiza a remocao dos caracteres especiais, caso haja, presentes
     * na variavel do CPF
     * @param entidade 
     */
    private void corrigirCPF(PessoaFisica entidade) {
        entidade.setCpf(entidade.getCpf().replace(".", ""));
        entidade.setCpf(entidade.getCpf().replace("-", ""));
    }
    
      private void limparDados() {
          this.login = null;
          this.pessoasfisica = null;
          this.membroApoio = null;
          this.pregoeiro = null;
          this.cargoPregoeiro = false;
          this.cargoMembrodeApoio = false;
          this.confirmaSenha = "";
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
        return pessoasfisica;
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
    
    public MembroApoio getMembroApoio(){
        return this.membroApoio;
    }
    
    public Login getLogin() {
        return this.login;
    }

    @Override
    public ServicoIF getServico() {
        return this.servico;
    }
    
    public String getConfirmaSenha(){
        return this.confirmaSenha;
    }
    
    public void setConfirmaSenha(String confirmaSenha){
        this.confirmaSenha = confirmaSenha;
    }

}
