/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.servico;

import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.persistencia.dao.DaoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import br.solutio.licita.persistencia.dao.TipoDAO;
import br.solutio.licita.servico.util.Criptografar;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoPregoeiro implements ServicoPregoeiroIF{
    
    private DaoIF<Pregoeiro> dao = FabricaDAO.getFabricaDAO(TipoDAO.Local).getDaoPregoeiro();
    private static Logger log = Logger.getGlobal();

    @Override
    public int contagem() {
        return dao.contagem();
    }

    @Override
    public void criar(Pregoeiro entidade) {
        criptografandoSenha(entidade);
        dao.criar(entidade);
    }

    @Override
    public void editar(Pregoeiro entidade) {
        dao.editar(entidade);
    }

    @Override
    public void deletar(Pregoeiro entidade) {
        dao.deletar(entidade);
    }

    @Override
    public Pregoeiro buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Pregoeiro> buscarTodos() {
        return dao.buscarTodos();
    }
    
    /**
     * Criptogrando senha, através da classe Criptografar, para que entao
     * possa ser persistido no banco com o MD-5
     * @param login
     * @param pregoeiro 
     */
    private void criptografandoSenha(Pregoeiro entidade) {
        String novaSenha = Criptografar.getInstance().criptografar(entidade.getLogin().getSenha());
        entidade.getLogin().setSenha(novaSenha);
    }
    
    public void setDao(DaoIF dao){
        this.dao = dao;
    }
}
