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
@Table(name = "tbl_representante_legal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepresentanteLegal.findAll", query = "SELECT r FROM RepresentanteLegal r"),
    @NamedQuery(name = "RepresentanteLegal.findById", query = "SELECT r FROM RepresentanteLegal r WHERE r.representanteLegalPK.id = :id"),
    @NamedQuery(name = "RepresentanteLegal.findByIdPessoaFisica", query = "SELECT r FROM RepresentanteLegal r WHERE r.representanteLegalPK.idPessoaFisica = :idPessoaFisica"),
    @NamedQuery(name = "RepresentanteLegal.findByIdLicitante", query = "SELECT r FROM RepresentanteLegal r WHERE r.representanteLegalPK.idLicitante = :idLicitante")})
public class RepresentanteLegal implements Identificavel {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RepresentanteLegalPK representanteLegalPK;
    @JoinColumn(name = "id_licitante", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private EmpresaLicitante empresaLicitante;
    @JoinColumn(name = "id_pessoa_fisica", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PessoaFisica pessoaFisica;

    public RepresentanteLegal() {
    }

    public RepresentanteLegal(RepresentanteLegalPK representanteLegalPK) {
        this.representanteLegalPK = representanteLegalPK;
    }

    public RepresentanteLegal(long id, long idPessoaFisica, long idLicitante) {
        this.representanteLegalPK = new RepresentanteLegalPK(id, idPessoaFisica, idLicitante);
    }

    public RepresentanteLegalPK getRepresentanteLegalPK() {
        return representanteLegalPK;
    }

    public void setRepresentanteLegalPK(RepresentanteLegalPK representanteLegalPK) {
        this.representanteLegalPK = representanteLegalPK;
    }

    public EmpresaLicitante getEmpresaLicitante() {
        return empresaLicitante;
    }

    public void setEmpresaLicitante(EmpresaLicitante empresaLicitante) {
        this.empresaLicitante = empresaLicitante;
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
        hash += (representanteLegalPK != null ? representanteLegalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RepresentanteLegal)) {
            return false;
        }
        RepresentanteLegal other = (RepresentanteLegal) object;
        if ((this.representanteLegalPK == null && other.representanteLegalPK != null) || (this.representanteLegalPK != null && !this.representanteLegalPK.equals(other.representanteLegalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.solutio.licita.modelo.RepresentanteLegal[ representanteLegalPK=" + representanteLegalPK + " ]";
    }

    @Override
    public Long getId() {
        return getRepresentanteLegalPK().getId();
    }
    
}
