/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao.remoto;

import br.solutio.licita.modelo.EmpresaLicitante;
import br.solutio.licita.modelo.InstituicaoLicitadora;
import br.solutio.licita.modelo.ItemPregao;
import br.solutio.licita.modelo.Login;
import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.persistencia.dao.DaoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;


/**
 *
 * @author WitaloCarlos
 */
public class FabricaDaoRemoto extends FabricaDAO {

    @Override
    public DaoIF<Pregoeiro> getDaoPregoeiro() {
        return new DaoRemoto<>();
    }

    @Override
    public DaoIF<InstituicaoLicitadora> getDaoInstituicaoLicitadora() {
        return new DaoRemoto<>();
    }

    @Override
    public DaoIF<Login> getDaoLogin() {
        return new DaoRemoto<>();
    }

    @Override
    public DaoIF<EmpresaLicitante> getDaoEmpresaLicitante() {
        return new DaoRemoto<>();
    }

    @Override
    public DaoIF<ItemPregao> getDaoItemPregao() {
        return new DaoRemoto<>();
    }

   
    
}
