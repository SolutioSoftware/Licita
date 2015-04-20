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
public class EmpresaLicitantePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pessoa_juridica")
    private long idPessoaJuridica;

    public EmpresaLicitantePK() {
    }

    public EmpresaLicitantePK(long id, long idPessoaJuridica) {
        this.id = id;
        this.idPessoaJuridica = idPessoaJuridica;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPessoaJuridica() {
        return idPessoaJuridica;
    }

    public void setIdPessoaJuridica(long idPessoaJuridica) {
        this.idPessoaJuridica = idPessoaJuridica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) idPessoaJuridica;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaLicitantePK)) {
            return false;
        }
        EmpresaLicitantePK other = (EmpresaLicitantePK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.idPessoaJuridica != other.idPessoaJuridica) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.solutio.licita.modelo.EmpresaLicitantePK[ id=" + id + ", idPessoaJuridica=" + idPessoaJuridica + " ]";
    }
    
}
