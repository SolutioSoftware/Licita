/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.main;

import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.servico.GerenciadorTransacao;
import br.solutio.licita.servico.ProdutorEntityManager;
import br.solutio.licita.servico.util.Criptografar;

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
        
        DaoIF<Pregoeiro> dao;
        ProdutorEntityManager produtor = ProdutorEntityManager.getInstancia();
        FabricaDAO fabricaDAO = new FabricaDAO(produtor.getEmLocal());
        dao = fabricaDAO.getDaoPregoeiro();
        
        Pregoeiro pregoeiro = new Pregoeiro();
        String senha = Criptografar.getInstance().criptografar("admin");
        pregoeiro.getLogin().setSenha(senha);
        pregoeiro.getLogin().setUsuario("admin");
        pregoeiro.getPessoaFisica().setCpf("12143343543");
        pregoeiro.getPessoaFisica().setNome("Matheus");
        pregoeiro.getPessoaFisica().setRg("1233123");
        
        GerenciadorTransacao.abrirTransacao(dao.getEntityManager());
        dao.criar(pregoeiro);
        GerenciadorTransacao.encerrarTransacao(dao.getEntityManager());
        
        
    }
    
}
