/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.persistencia.dao.DaoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import br.solutio.licita.persistencia.dao.TipoDAO;
import java.util.List;

/**
 *
 * @author WitaloCarlos
 */
public class ServicoPregao implements ServicoIF<Pregao>{

    private DaoIF<Pregao> dao;
    
    public ServicoPregao(){
       this.dao = FabricaDAO.getFabricaDAO(TipoDAO.Local).getDaoPregao();
    }

    public DaoIF<Pregao> getDao() {
        return dao;
    }
    
    
    
    @Override
    public int contagem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criar(Pregao entidade) {
        getDao().criar(entidade);
    }

    @Override
    public void editar(Pregao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Pregao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pregao buscarPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pregao> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
