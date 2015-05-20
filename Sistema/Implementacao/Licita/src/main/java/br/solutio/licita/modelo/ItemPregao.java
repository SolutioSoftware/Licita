/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WitaloCarlos
 */
@Entity
@Table(name = "tbl_item_pregao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemPregao.findAll", query = "SELECT i FROM ItemPregao i"),
    @NamedQuery(name = "ItemPregao.findById", query = "SELECT i FROM ItemPregao i WHERE i.id = :id"),
    @NamedQuery(name = "ItemPregao.findByNumeroItem", query = "SELECT i FROM ItemPregao i WHERE i.numeroItem = :numeroItem"),
    @NamedQuery(name = "ItemPregao.findByQuantidade", query = "SELECT i FROM ItemPregao i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "ItemPregao.findByValorReferencia", query = "SELECT i FROM ItemPregao i WHERE i.valorReferencia = :valorReferencia"),
    @NamedQuery(name = "ItemPregao.findByNome", query = "SELECT i FROM ItemPregao i WHERE i.nome = :nome"),
    @NamedQuery(name = "ItemPregao.findByDescricao", query = "SELECT i FROM ItemPregao i WHERE i.descricao = :descricao"),
    @NamedQuery(name = "ItemPregao.findByUnidade", query = "SELECT i FROM ItemPregao i WHERE i.unidade = :unidade"),
    @NamedQuery(name = "ItemPregao.findByStatusItem", query = "SELECT i FROM ItemPregao i WHERE i.statusItem = :statusItem")})
public class ItemPregao implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "numero_item")
    private Integer numeroItem;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_referencia")
    private BigDecimal valorReferencia;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nome")
    private String nome;
    
    @Size(max = 50)
    @Column(name = "descricao")
    private String descricao;
    
    @Size(max = 15)
    @Column(name = "unidade")
    private String unidade;
    
    @Size(max = 15)
    @Column(name = "status_item")
    private String statusItem;
    
    @JoinTable(name = "tbl_historico_status_item_pregao", joinColumns = {
        @JoinColumn(name = "id_item_pregao", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_status", referencedColumnName = "id")})
    @ManyToMany
    private transient Set<StatusItemPregao> statusItemPregaoSet;
    
    @JoinColumn(name = "id_pregao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pregao idPregao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idItemPregao")
    private transient Set<Lance> lanceSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idItemPregao")
    private transient Set<Proposta> propostaSet;

    public ItemPregao() {
    }

    public ItemPregao(Long id) {
        this.id = id;
    }

    public ItemPregao(Long id, int quantidade, BigDecimal valorReferencia, String nome) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorReferencia = valorReferencia;
        this.nome = nome;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(Integer numeroItem) {
        this.numeroItem = numeroItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorReferencia() {
        return valorReferencia;
    }

    public void setValorReferencia(BigDecimal valorReferencia) {
        this.valorReferencia = valorReferencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getStatusItem() {
        return statusItem;
    }

    public void setStatusItem(String statusItem) {
        this.statusItem = statusItem;
    }

    @XmlTransient
    public Set<StatusItemPregao> getStatusItemPregaoSet() {
        return statusItemPregaoSet;
    }

    public void setStatusItemPregaoSet(Set<StatusItemPregao> statusItemPregaoSet) {
        this.statusItemPregaoSet = statusItemPregaoSet;
    }

    public Pregao getIdPregao() {
        return idPregao;
    }

    public void setIdPregao(Pregao idPregao) {
        this.idPregao = idPregao;
    }

    @XmlTransient
    public Set<Lance> getLanceSet() {
        return lanceSet;
    }

    public void setLanceSet(Set<Lance> lanceSet) {
        this.lanceSet = lanceSet;
    }

    @XmlTransient
    public Set<Proposta> getPropostaSet() {
        return propostaSet;
    }

    public void setPropostaSet(Set<Proposta> propostaSet) {
        this.propostaSet = propostaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ItemPregao)) {
            return false;
        }
        ItemPregao other = (ItemPregao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.solutio.licita.modelo.ItemPregao[ id=" + id + " ]";
    }
    
}
