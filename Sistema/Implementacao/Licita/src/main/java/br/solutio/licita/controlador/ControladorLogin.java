/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.Login;
import br.solutio.licita.servico.ProdutorEntityManager;
import br.solutio.licita.servico.ServicoIF;
import br.solutio.licita.servico.ServicoLogin;
import br.solutio.licita.servico.ServicoLoginIF;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Matheus Oliveira
 */
@ManagedBean(name = "Login")
@SessionScoped
public class ControladorLogin {

    private Login login;
    private transient ServicoLoginIF servico;

    public ControladorLogin() {
        login = new Login();
        servico = new ServicoLogin(ProdutorEntityManager.getInstancia().getEmLocal());
    }

    public Login getEntidade() {
        return this.login;
    }

    public void setEntidade(Login entidade) {
        this.login = entidade;
    }

    public ServicoIF getServico() {
        return this.servico;
    }

    public boolean efetuarLogin() {
        boolean permissao = false;
        if (getEntidade().getSenha() != null && getEntidade().getUsuario() != null) {
              Logger.getLogger(ControladorPregao.class.getName()).log(Level.INFO, "ControladorLogin {0}{1}", new Object[]{getEntidade().getUsuario(), getEntidade().getSenha()});
            permissao = this.servico.verificarDados(login.getUsuario(), login.getSenha());
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.INFO, "ControladorLogin {0}", permissao);
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

}
