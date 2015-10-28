/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.Item;
import br.solutio.licita.modelo.ItemPregao;
import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.servico.ProdutorEntityManager;
import br.solutio.licita.servico.ServicoIF;
import br.solutio.licita.servico.ServicoPregao;
import br.solutio.licita.servico.ServicoPregaoIF;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.PersistenceException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * @author ricardocaldeira
 */
@ManagedBean
@SessionScoped
public class ControladorPregao extends ControladorAbstrato<Pregao> {

    private Pregao entidade;
    private ItemPregao itemPregao;
    private Item item;
    private transient List<Pregao> pregoes;
    private transient Set<ItemPregao> itensPregao;
    private transient ServicoPregaoIF servico;

    public ControladorPregao() {
        entidade = new Pregao();
        servico = new ServicoPregao(ProdutorEntityManager.getInstancia().getEmLocal());
        item = new Item();
        itemPregao = new ItemPregao();
    }

    @Override
    public String criar(Pregao entidade) {
        try {
            entidade = getEntidade();
            getServico().criar(entidade);
            setEntidade(null);
            setEntidade(new Pregao());
            JsfUtil.addSuccessMessage("Salvo com Sucesso!");
            return "pregao";
        } catch (PersistenceException | IllegalStateException e) {
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage("Pregao ou Processo já existe");
            return "pregaoSalvar";
        }

    }

    @Override
    public String editar(Pregao entidade) {

        try {
            entidade = getEntidade();
            entidade.setItensPregoes(getItensPregao());
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.INFO, "" + getItensPregao().size());
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.INFO, "" + entidade.getItensPregoes().size());
            getServico().editar(entidade);
            setEntidade(new Pregao());
            JsfUtil.addSuccessMessage("Atualizado com Sucesso!!?");
            return "pregao?faces-redirect=true";
        } catch (PersistenceException | IllegalStateException e) {
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage("Pregao ou Processo já existe");
            return "pregaoEditar";
        }

    }

    @Override
    public String deletar(Pregao entidade) {
        entidade = getEntidade();
        getServico().deletar(entidade);
        setEntidade(new Pregao());
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        return "pregao";
    }

    public String limparDados() {
        setEntidade(null);
        setEntidade(new Pregao());
        return "pregaoSalvar";
    }

    public String preparaEditar() {
        logger.log(Level.INFO, "Editar funfando");
        return "pregaoEditar";
    }

    public String preparaAdicionaItens() {
        logger.log(Level.INFO, "Adicionar Itens funfando");
        setItensPregao(null);
        return "pregaoAdicionarItens?faces-redirect=true";
    }

    public void adicionarItem() {
        itemPregao.setPregao(entidade);
        itemPregao.setItem(item);
        itensPregao.add(itemPregao);
        itemPregao = new ItemPregao();
        item = new Item();
    }

    public void removerItem() {
        itensPregao.remove(itemPregao);
    }

    public void editandoXlsParaExportar(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet planilha = wb.getSheetAt(0);

        //Move as celulas selecionadas para baixo de acordo com o valor informado
        planilha.shiftRows(planilha.getFirstRowNum(), planilha.getLastRowNum(), 5);

        HSSFRow linha0 = planilha.createRow(0);
        linha0.createCell(0).setCellValue("Instituição Licitadora:");
        planilha.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
        linha0.createCell(2).setCellValue(" " + getEntidade().getInstituicaoLicitadora().getPessoaJuridica().getNomeFantasia());
        planilha.addMergedRegion(new CellRangeAddress(0, 0, 2, 6));

        HSSFRow linha1 = planilha.createRow(1);
        linha1.createCell(0).setCellValue("Numero do Pregao:");
        planilha.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));
        linha1.createCell(2).setCellValue(" " + getEntidade().getNumeroPregao());
        planilha.addMergedRegion(new CellRangeAddress(1, 1, 2, 6));

        HSSFRow linha2 = planilha.createRow(2);
        linha2.createCell(0).setCellValue("Numero do Processo:");
        planilha.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));
        linha2.createCell(2).setCellValue(" " + getEntidade().getNumeroProcesso());
        planilha.addMergedRegion(new CellRangeAddress(2, 2, 2, 6));

        HSSFRow linha3 = planilha.createRow(3);
        linha3.createCell(0).setCellValue("Empresa Licitante:");
        planilha.addMergedRegion(new CellRangeAddress(3, 3, 0, 1));
        linha3.createCell(2).setCellValue("Preencha com o nome de sua Empresa");
        planilha.addMergedRegion(new CellRangeAddress(3, 3, 2, 6));

        HSSFRow linha4 = planilha.createRow(4);

        //Nova coluna para a empresas adicionarem seus valores
        HSSFRow linha5 = planilha.getRow(5);
        HSSFCell celula5 = linha5.createCell(5);
        celula5.setCellValue("Valor do Licitante");

        //for para ajustar automaticamente o tamnho das colunas
        for (int i = 0; i < 6; i++) {
            planilha.autoSizeColumn(i);
        }

        //Cor da linha de titulos da tabela
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        for (int i = 0; i < linha5.getPhysicalNumberOfCells(); i++) {
            HSSFCell cell = linha5.getCell(i);

            cell.setCellStyle(cellStyle);
        }

        planilha.protectSheet("1234");
        CellStyle unlockedCellStyle = wb.createCellStyle();
        unlockedCellStyle.setLocked(false);
        
        HSSFCell celula2 = linha3.getCell(2);
        celula2.setCellStyle(unlockedCellStyle);
        
//        for (int i = 6; i < planilha.getLastRowNum(); i++) {
//            HSSFRow linhas = planilha.getRow(i);
//            
//            HSSFCell celula = linhas.getCell(5);
//            System.out.println(celula);
//            celula.setCellStyle(unlockedCellStyle);
//        }
        
    }

    @Override
    public ServicoIF getServico() {
        return this.servico;
    }

    @Override
    public Pregao getEntidade() {
        return entidade;
    }

    @Override
    public void setEntidade(Pregao entidade) {
        this.entidade = entidade;
    }

    public boolean getEditando() {
        return this.entidade.getId() != null;
    }

    public List<Pregao> getPregoes() {
        return pregoes = servico.buscarTodos();
    }

    public void setPregoes(List<Pregao> pregoes) {
        this.pregoes = pregoes;
    }

    public Set<ItemPregao> getItensPregao() {
        if (itensPregao == null) {
            itensPregao = servico.buscarItensPregoes(entidade);
        }
        return itensPregao;
    }

    public void setItensPregao(Set<ItemPregao> itensPregao) {
        this.itensPregao = itensPregao;
    }

    public ItemPregao getItemPregao() {
        return itemPregao;
    }

    public void setItemPregao(ItemPregao itemPregao) {
        this.itemPregao = itemPregao;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
