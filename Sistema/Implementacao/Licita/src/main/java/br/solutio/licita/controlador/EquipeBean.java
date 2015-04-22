/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;


import br.solutio.licita.modelo.Identificavel;
import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.persistencia.dao.DaoAbstratoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import br.solutio.licita.persistencia.dao.TipoDAO;
import br.solutio.licita.persistencia.dao.local.FabricaDaoLocal;
import br.solutio.licita.persistencia.dao.local.FabricaDaoLocalIF;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author WitaloCarlos
 */
@ManagedBean
public class EquipeBean extends ControladorAbstrato<PessoaFisica>{

    FabricaDaoLocalIF fabricaLocal = (FabricaDaoLocal) FabricaDAO.getFabricaDAO(TipoDAO.Local);
    PessoaFisica entidade;
    
    
    
    @Override
    public DaoAbstratoIF getDao() {
        return fabricaLocal.getDaoPregoeiro();
    }

    @Override
    public PessoaFisica getEntidade() {
        return this.entidade;
    }

    @Override
    public void setEntidade(Identificavel entidade) {
        this.entidade = (PessoaFisica) entidade;
        
    }
    
}