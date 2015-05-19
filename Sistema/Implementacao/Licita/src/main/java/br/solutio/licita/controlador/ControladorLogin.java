/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.Login;
import br.solutio.licita.servico.ServicoIF;
import br.solutio.licita.servico.ServicoLogin;
import br.solutio.licita.servico.ServicoLoginIF;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Matheus Oliveira
 */
@ManagedBean(name = "Login")
public class ControladorLogin extends ControladorAbstrato<Login> {

    private static final Logger log = Logger.getGlobal();
    private Login login;
    private ServicoLoginIF servico;

    public ControladorLogin() {
        login = new Login();
        servico = new ServicoLogin();
    }

    @Override
    public Login getEntidade() {
        return this.login;
    }

    @Override
    public void setEntidade(Login entidade) {
        this.login = entidade;
    }

    @Override
    public ServicoIF getServico() {
        return this.servico;
    }

    public boolean efetuarLogin() {
        boolean permissao = false;
        if (getEntidade().getSenha() != null && getEntidade().getUsuario() != null) {
            permissao = this.servico.verificarDados(login.getUsuario(), login.getSenha());
            return permissao;
        } else {
            return permissao;
        }
    }

    public String concerderAcesso() {
        if (efetuarLogin()) {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getSessionMap()
                    .put("usuario", login); // Adiciona Login a sessão com JSF
            return "/restrito/index.xhtml?faces-redirect=true";
        } else {
            JsfUtil.addErrorMessage("Usuário ou Senha inválidos.");
            return "/restrito/login/login.xhtml";
        }
    }

    public String efetuarLogout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/restrito/login/login.xhtml?faces-redirect=true";
    }

    @Override
    public String criar(Login entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String editar(Login entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deletar(Login entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
