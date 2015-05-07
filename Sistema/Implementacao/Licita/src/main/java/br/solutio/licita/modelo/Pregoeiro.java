/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.modelo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WitaloCarlos
 */
@Entity
@Table(name = "tbl_pregoeiro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregoeiro.findAll", query = "SELECT p FROM Pregoeiro p"),
    @NamedQuery(name = "Pregoeiro.findById", query = "SELECT p FROM Pregoeiro p WHERE p.pregoeiroPK.id = :id"),
    @NamedQuery(name = "Pregoeiro.findByIdPessoaFisica", query = "SELECT p FROM Pregoeiro p WHERE p.pregoeiroPK.idPessoaFisica = :idPessoaFisica")})
public class Pregoeiro implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected PregoeiroPK pregoeiroPK;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPregoeiro")
    private Set<Sessao> sessaoSet;
    
    @OneToOne(cascade = CascadeType.ALL ,mappedBy = "idPregoeiro")
    private Login login;
    
    @JoinColumn(name = "id_pessoa_fisica", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PessoaFisica pessoaFisica;

    public Pregoeiro() {
    }

    public Pregoeiro(PregoeiroPK pregoeiroPK) {
        this.pregoeiroPK = pregoeiroPK;
    }

    public Pregoeiro(long id, long idPessoaFisica) {
        this.pregoeiroPK = new PregoeiroPK(id, idPessoaFisica);
    }

    public PregoeiroPK getPregoeiroPK() {
        return pregoeiroPK;
    }

    public void setPregoeiroPK(PregoeiroPK pregoeiroPK) {
        this.pregoeiroPK = pregoeiroPK;
    }

    @XmlTransient
    public Set<Sessao> getSessaoSet() {
        return sessaoSet;
    }

    public void setSessaoSet(Set<Sessao> sessaoSet) {
        this.sessaoSet = sessaoSet;
    }

    @XmlTransient
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
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
        hash += (pregoeiroPK != null ? pregoeiroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Pregoeiro)) {
            return false;
        }
        Pregoeiro other = (Pregoeiro) object;
        if ((this.pregoeiroPK == null && other.pregoeiroPK != null) || (this.pregoeiroPK != null && !this.pregoeiroPK.equals(other.pregoeiroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //TODO refazer método ToString de Login imprimindo todos os atributos do mesmo.
        return "br.solutio.licita.modelo.Pregoeiro[ pregoeiroPK=" + pregoeiroPK + " ]";
    }

    
    public Long getId() {
        return getPregoeiroPK().getId();
    }
    
}
