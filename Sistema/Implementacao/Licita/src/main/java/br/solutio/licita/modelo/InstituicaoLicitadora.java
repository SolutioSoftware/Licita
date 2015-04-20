/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WitaloCarlos
 */
@Entity
@Table(name = "tbl_instituicao_licitadora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstituicaoLicitadora.findAll", query = "SELECT i FROM InstituicaoLicitadora i"),
    @NamedQuery(name = "InstituicaoLicitadora.findById", query = "SELECT i FROM InstituicaoLicitadora i WHERE i.instituicaoLicitadoraPK.id = :id"),
    @NamedQuery(name = "InstituicaoLicitadora.findByIdPessoaJuridica", query = "SELECT i FROM InstituicaoLicitadora i WHERE i.instituicaoLicitadoraPK.idPessoaJuridica = :idPessoaJuridica")})
public class InstituicaoLicitadora implements Identificavel {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InstituicaoLicitadoraPK instituicaoLicitadoraPK;
    @JoinColumn(name = "id_pessoa_juridica", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PessoaJuridica pessoaJuridica;

    public InstituicaoLicitadora() {
    }

    public InstituicaoLicitadora(InstituicaoLicitadoraPK instituicaoLicitadoraPK) {
        this.instituicaoLicitadoraPK = instituicaoLicitadoraPK;
    }

    public InstituicaoLicitadora(long id, long idPessoaJuridica) {
        this.instituicaoLicitadoraPK = new InstituicaoLicitadoraPK(id, idPessoaJuridica);
    }

    public InstituicaoLicitadoraPK getInstituicaoLicitadoraPK() {
        return instituicaoLicitadoraPK;
    }

    public void setInstituicaoLicitadoraPK(InstituicaoLicitadoraPK instituicaoLicitadoraPK) {
        this.instituicaoLicitadoraPK = instituicaoLicitadoraPK;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instituicaoLicitadoraPK != null ? instituicaoLicitadoraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstituicaoLicitadora)) {
            return false;
        }
        InstituicaoLicitadora other = (InstituicaoLicitadora) object;
        if ((this.instituicaoLicitadoraPK == null && other.instituicaoLicitadoraPK != null) || (this.instituicaoLicitadoraPK != null && !this.instituicaoLicitadoraPK.equals(other.instituicaoLicitadoraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.solutio.licita.modelo.InstituicaoLicitadora[ instituicaoLicitadoraPK=" + instituicaoLicitadoraPK + " ]";
    }

    @Override
    public Long getId() {
        return getInstituicaoLicitadoraPK().getId();
    }
    
}
