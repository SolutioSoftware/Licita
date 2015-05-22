/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia;


import br.solutio.licita.modelo.EmpresaLicitante;
import br.solutio.licita.modelo.InstituicaoLicitadora;
import br.solutio.licita.modelo.ItemPregao;
import br.solutio.licita.modelo.Login;
import br.solutio.licita.modelo.MembroApoio;
import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.modelo.Pregoeiro;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author WitaloCarlos
 */
public class FabricaDAO implements FabricaDaoIF{
    
    protected static final Logger logger = Logger.getGlobal();
    
    private EntityManager entityManager;
    
    public FabricaDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public EntityManager getEntityManager(){
        return this.entityManager;
    }
    
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public DaoIF<Pregoeiro> getDaoPregoeiro(){
        return new Dao<>(entityManager);
    }
    
    @Override
    public  DaoIF<InstituicaoLicitadora> getDaoInstituicaoLicitadora(){
        return new Dao<>(entityManager);
    }
    
    @Override
    public  DaoIF<Login> getDaoLogin(){
        return new Dao<>(entityManager);
    }
    
    @Override
    public  DaoIF<EmpresaLicitante> getDaoEmpresaLicitante(){
        return new Dao<>(entityManager);
    }
    
    @Override
    public  DaoIF<ItemPregao> getDaoItemPregao(){
        return new Dao<>(entityManager);
    }
    
    @Override 
    public  DaoIF<Pregao> getDaoPregao(){
        return new Dao<>(entityManager);
    }
    
    @Override
    public  DaoIF<PessoaFisica> getDaoPessoaFisica(){
        return new Dao<>(entityManager);
    }
    
    @Override
    public  DaoIF<MembroApoio> getDaoMembroApoio(){
        return new Dao<>(entityManager);
    }
    
}
