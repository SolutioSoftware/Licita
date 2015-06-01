/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia;

import br.solutio.licita.modelo.EmpresaLicitante;
import br.solutio.licita.modelo.InstituicaoLicitadora;
import br.solutio.licita.modelo.Item;
import br.solutio.licita.modelo.ItemPregao;
import br.solutio.licita.modelo.Login;
import br.solutio.licita.modelo.MembroApoio;
import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.modelo.Sessao;

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
    public DaoIF<Item> getDaoItem();
    public DaoIF<Pregao> getDaoPregao();
    public DaoIF<PessoaFisica> getDaoPessoaFisica();
    public DaoIF<MembroApoio> getDaoMembroApoio();
    public DaoIF<Sessao> getDaoSessao();
   

}
