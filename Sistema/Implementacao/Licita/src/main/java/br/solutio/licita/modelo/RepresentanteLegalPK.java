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
public class RepresentanteLegalPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pessoa_fisica")
    private long idPessoaFisica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_licitante")
    private long idLicitante;

    public RepresentanteLegalPK() {
    }

    public RepresentanteLegalPK(long id, long idPessoaFisica, long idLicitante) {
        this.id = id;
        this.idPessoaFisica = idPessoaFisica;
        this.idLicitante = idLicitante;
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

    public long getIdLicitante() {
        return idLicitante;
    }

    public void setIdLicitante(long idLicitante) {
        this.idLicitante = idLicitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) idPessoaFisica;
        hash += (int) idLicitante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepresentanteLegalPK)) {
            return false;
        }
        RepresentanteLegalPK other = (RepresentanteLegalPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.idPessoaFisica != other.idPessoaFisica) {
            return false;
        }
        if (this.idLicitante != other.idLicitante) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.solutio.licita.modelo.RepresentanteLegalPK[ id=" + id + ", idPessoaFisica=" + idPessoaFisica + ", idLicitante=" + idLicitante + " ]";
    }
    
}
