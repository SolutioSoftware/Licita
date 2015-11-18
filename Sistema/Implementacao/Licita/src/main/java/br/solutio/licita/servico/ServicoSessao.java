/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.controlador.ControladorSessao;
import br.solutio.licita.modelo.EmpresaLicitante;
import br.solutio.licita.modelo.ItemPregao;
import br.solutio.licita.modelo.Proposta;
import br.solutio.licita.modelo.Sessao;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.persistencia.FabricaDaoIF;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author ricardocaldeira
 */
public class ServicoSessao extends ServicoAbstrato<Sessao> implements ServicoSessaoIF {

    private DaoIF<Sessao> dao;
    private FabricaDaoIF fabricaDao;
    private DaoIF<EmpresaLicitante> daoLicitante;
    private DaoIF<Proposta> daoProposta;
    private DaoIF<ItemPregao> daoItemPregao;
    private ArrayList<Double> numTable;
    private Double[][] propostas;
    List<List> listas = null;

    public ServicoSessao(EntityManager entityManager) {
        super(entityManager);
        numTable = new ArrayList<>();
    }

    @Override
    public void setDao(DaoIF<Sessao> dao) {
        this.dao = dao;
    }

    @Override
    public void buscarPropostas(Sessao sessao, List<EmpresaLicitante> empresaLicitantes) {
        String[] parametros = {"idLicitante", "idSessao"};
        listas = new ArrayList<>();
        for (EmpresaLicitante licitante : empresaLicitantes) {
            Object[] valores = {licitante, sessao};
            listas.add(daoProposta.consultar("Proposta.findBySessaoWithLicitante", parametros, valores));
        }
        System.out.println(listas);
    }

    @Override
    public boolean filtraPlanilha(UploadedFile uploadArquivo) {
        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(uploadArquivo.getInputstream());
        } catch (IOException ex) {
            Logger.getLogger(ControladorSessao.class.getName()).log(Level.SEVERE, "Error InputStream ArquivoProposta", ex);
        }

        HSSFSheet planilha = wb.getSheetAt(0);
        Logger.getLogger(ControladorSessao.class.getName()).log(Level.INFO, " TAMANHO DA PLANILHA: {0}", planilha.getLastRowNum());

        //Indica o numero da coluna onde inicia os valores que serão retirado
        int indInicioValores = 6;
        // +1, devido a necessidade de contar mais uma coluna
        propostas = new Double[(planilha.getLastRowNum() + 1) - indInicioValores][2];

        for (int i = 6; i <= planilha.getLastRowNum(); i++) {
            HSSFRow linha = planilha.getRow(i);

            String conversao = linha.getCell(0).getStringCellValue();
            Double convertido = Double.parseDouble(conversao);
            propostas[i - indInicioValores][0] = convertido;
            propostas[i - indInicioValores][1] = linha.getCell(5).getNumericCellValue();
            numTable.add(linha.getCell(5).getNumericCellValue());
            Logger.getLogger(ControladorSessao.class.getName()).log(Level.INFO, numTable.toString());
        }
        return !numTable.isEmpty();
    }

    @Override
    public boolean salvarPropostas(Sessao sessao, EmpresaLicitante empresaLicitante) {
        if (empresaLicitante != null) {
            for (int i = 0; i < propostas.length; i++) {
                Proposta proposta = new Proposta();
                proposta.setIdLicitante(empresaLicitante);
                proposta.setIdSessao(sessao);
                proposta.setValorUnitario(new BigDecimal(propostas[i][1], MathContext.DECIMAL64));
                ItemPregao itemPregao = getDaoItemPregao().buscarPorId(propostas[i][0].longValue());
                proposta.setIdItemPregao(itemPregao);
                daoProposta.criar(proposta);
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Sessao> buscarTodos() {

        return getDao().consultar("Sessao.findAll");
    }

    @Override
    public DaoIF<Sessao> getDao() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityManager());
        }
        if (dao == null) {
            dao = fabricaDao.getDaoSessao();
        }
        return dao;
    }

    private DaoIF<EmpresaLicitante> getDaoLicitante() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityManager());
        }
        if (daoLicitante == null) {
            daoLicitante = fabricaDao.getDaoEmpresaLicitante();
        }
        return daoLicitante;
    }

    private DaoIF<Proposta> getDaoProposta() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityManager());
        }
        if (daoProposta == null) {
            daoProposta = fabricaDao.getDaoProposta();
        }
        return daoProposta;
    }

    private DaoIF<ItemPregao> getDaoItemPregao() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityManager());
        }
        if (daoItemPregao == null) {
            daoItemPregao = fabricaDao.getDaoItemPregao();
        }
        return daoItemPregao;
    }

    @Override
    public List<EmpresaLicitante> getEmpresasLicitantes() {
        return getDaoLicitante().consultar("EmpresaLicitante.findAll");
    }

    @Override
    public List<Proposta> getPropostas(Sessao sessao) {
        String[] parametros = {"idSessao"};
        Sessao[] valores = {sessao};
        return getDaoProposta().consultar("Proposta.findBySessao", parametros, valores);
    }

}
