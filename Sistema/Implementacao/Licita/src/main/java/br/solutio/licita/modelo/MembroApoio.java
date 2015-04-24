/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.modelo;

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
@Table(name = "tbl_membro_apoio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MembroApoio.findAll", query = "SELECT m FROM MembroApoio m"),
    @NamedQuery(name = "MembroApoio.findById", query = "SELECT m FROM MembroApoio m WHERE m.membroApoioPK.id = :id"),
    @NamedQuery(name = "MembroApoio.findByIdPessoaFisica", query = "SELECT m FROM MembroApoio m WHERE m.membroApoioPK.idPessoaFisica = :idPessoaFisica"),
    @NamedQuery(name = "MembroApoio.findByFuncao", query = "SELECT m FROM MembroApoio m WHERE m.funcao = :funcao")})
public class MembroApoio implements Identificavel {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MembroApoioPK membroApoioPK;
    @Size(max = 25)
    @Column(name = "funcao")
    private String funcao;
    @JoinColumn(name = "id_pessoa_fisica", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PessoaFisica pessoaFisica;

    public MembroApoio() {
    }

    public MembroApoio(MembroApoioPK membroApoioPK) {
        this.membroApoioPK = membroApoioPK;
    }

    public MembroApoio(long id, long idPessoaFisica) {
        this.membroApoioPK = new MembroApoioPK(id, idPessoaFisica);
    }

    public MembroApoioPK getMembroApoioPK() {
        return membroApoioPK;
    }

    public void setMembroApoioPK(MembroApoioPK membroApoioPK) {
        this.membroApoioPK = membroApoioPK;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (membroApoioPK != null ? membroApoioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MembroApoio)) {
            return false;
        }
        MembroApoio other = (MembroApoio) object;
        if ((this.membroApoioPK == null && other.membroApoioPK != null) || (this.membroApoioPK != null && !this.membroApoioPK.equals(other.membroApoioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.solutio.licita.modelo.MembroApoio[ membroApoioPK=" + membroApoioPK + " ]";
    }

    @Override
    public Long getId() {
        return getMembroApoioPK().getId();
    }
    
}
