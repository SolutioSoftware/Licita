/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao;

import br.solutio.licita.modelo.EmpresaLicitante;
import br.solutio.licita.modelo.InstituicaoLicitadora;
import br.solutio.licita.modelo.ItemPregao;
import br.solutio.licita.modelo.Login;
import br.solutio.licita.modelo.Pregoeiro;

/**
 *
 * @author WitaloCarlos
 */
public interface FabricaDaoIF {
    
    public DaoIF<Pregoeiro> getDaoPregoeiro();
    public DaoIF<InstituicaoLicitadora> getDaoInstituicaoLicitadora();
    public DaoIF<Login> getDaoLogin();
    public DaoIF<EmpresaLicitante> getDaoEmpresaLicitante();
    public DaoIF<ItemPregao> getDaoItemPregao();
    
    
}
