/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.main;

import br.solutio.licita.modelo.Login;
import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.modelo.PregoeiroPK;
import br.solutio.licita.persistencia.dao.DaoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import br.solutio.licita.persistencia.dao.TipoDAO;
import br.solutio.licita.servico.ServicoLogin;
import br.solutio.licita.servico.ServicoLoginIF;

/**
 *
 * @author WitaloCarlos
 */
public class Licita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        DaoIF<PessoaFisica> daoPF = FabricaDAO.getFabricaDAO(TipoDAO.Local).getDaoPessoaFisica();
        DaoIF<Pregoeiro> daoPR = FabricaDAO.getFabricaDAO(TipoDAO.Local).getDaoPregoeiro();
        DaoIF<Login> daoLO = FabricaDAO.getFabricaDAO(TipoDAO.Local).getDaoLogin();
        
        PessoaFisica pessoa = new PessoaFisica();
        Login login = new Login();
        Pregoeiro pregoeiro = new Pregoeiro();
        
        
        
        pessoa.setCpf("00011122266");
        pessoa.setNome("Matheus");
        pessoa.setRg("1232344");
        daoPF.criar(pessoa);
        
        PregoeiroPK pregoeiroPk = new PregoeiroPK();
        
        pregoeiroPk.setIdPessoaFisica(pessoa.getId());
        
        pregoeiro.setPregoeiroPK(pregoeiroPk);
        daoPR.criar(pregoeiro);
        
        login.setUsuario("matheuss");
        login.setSenha("1232");
        login.setIdPregoeiro(pregoeiro);
        
        
        
        daoLO.criar(login);
        
        
    }
    
}
