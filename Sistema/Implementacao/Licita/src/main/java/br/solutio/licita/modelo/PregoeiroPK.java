/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author WitaloCarlos
 */
@Embeddable
public class PregoeiroPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pessoa_fisica")
    private long idPessoaFisica;

    public PregoeiroPK() {
    }

    public PregoeiroPK(long id, long idPessoaFisica) {
        this.id = id;
        this.idPessoaFisica = idPessoaFisica;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPessoaFisica() {
        return idPessoaFisica;
    }

    public void setIdPessoaFisica(long idPessoaFisica) {
        this.idPessoaFisica = idPessoaFisica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) idPessoaFisica;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregoeiroPK)) {
            return false;
        }
        PregoeiroPK other = (PregoeiroPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.idPessoaFisica != other.idPessoaFisica) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.solutio.licita.modelo.PregoeiroPK[ id=" + id + ", idPessoaFisica=" + idPessoaFisica + " ]";
    }
    
}
