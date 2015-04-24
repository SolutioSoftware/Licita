/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WitaloCarlos
 */
@Entity
@Table(name = "tbl_conta_bancaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContaBancaria.findAll", query = "SELECT c FROM ContaBancaria c"),
    @NamedQuery(name = "ContaBancaria.findById", query = "SELECT c FROM ContaBancaria c WHERE c.contaBancariaPK.id = :id"),
    @NamedQuery(name = "ContaBancaria.findByIdLicitante", query = "SELECT c FROM ContaBancaria c WHERE c.contaBancariaPK.idLicitante = :idLicitante"),
    @NamedQuery(name = "ContaBancaria.findByBanco", query = "SELECT c FROM ContaBancaria c WHERE c.banco = :banco"),
    @NamedQuery(name = "ContaBancaria.findByNome", query = "SELECT c FROM ContaBancaria c WHERE c.nome = :nome"),
    @NamedQuery(name = "ContaBancaria.findByAgencia", query = "SELECT c FROM ContaBancaria c WHERE c.agencia = :agencia"),
    @NamedQuery(name = "ContaBancaria.findByNumeroConta", query = "SELECT c FROM ContaBancaria c WHERE c.numeroConta = :numeroConta"),
    @NamedQuery(name = "ContaBancaria.findByOperacao", query = "SELECT c FROM ContaBancaria c WHERE c.operacao = :operacao")})
public class ContaBancaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContaBancariaPK contaBancariaPK;
    @Column(name = "banco")
    private Integer banco;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 10)
    @Column(name = "agencia")
    private String agencia;
    @Size(max = 15)
    @Column(name = "numero_conta")
    private String numeroConta;
    @Size(max = 6)
    @Column(name = "operacao")
    private String operacao;
    @JoinColumn(name = "id_licitante", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private EmpresaLicitante empresaLicitante;

    public ContaBancaria() {
    }

    public ContaBancaria(ContaBancariaPK contaBancariaPK) {
        this.contaBancariaPK = contaBancariaPK;
    }

    public ContaBancaria(long id, long idLicitante) {
        this.contaBancariaPK = new ContaBancariaPK(id, idLicitante);
    }

    public ContaBancariaPK getContaBancariaPK() {
        return contaBancariaPK;
    }

    public void setContaBancariaPK(ContaBancariaPK contaBancariaPK) {
        this.contaBancariaPK = contaBancariaPK;
    }

    public Integer getBanco() {
        return banco;
    }

    public void setBanco(Integer banco) {
        this.banco = banco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public EmpresaLicitante getEmpresaLicitante() {
        return empresaLicitante;
    }

    public void setEmpresaLicitante(EmpresaLicitante empresaLicitante) {
        this.empresaLicitante = empresaLicitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contaBancariaPK != null ? contaBancariaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ContaBancaria)) {
            return false;
        }
        ContaBancaria other = (ContaBancaria) object;
        if ((this.contaBancariaPK == null && other.contaBancariaPK != null) || (this.contaBancariaPK != null && !this.contaBancariaPK.equals(other.contaBancariaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.solutio.licita.modelo.ContaBancaria[ contaBancariaPK=" + contaBancariaPK + " ]";
    }
    
}
