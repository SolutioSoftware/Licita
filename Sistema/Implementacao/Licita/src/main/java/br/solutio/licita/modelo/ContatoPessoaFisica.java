/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WitaloCarlos
 */
@Entity
@Table(name = "tbl_contato_pessoa_fisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContatoPessoaFisica.findAll", query = "SELECT c FROM ContatoPessoaFisica c"),
    @NamedQuery(name = "ContatoPessoaFisica.findById", query = "SELECT c FROM ContatoPessoaFisica c WHERE c.id = :id"),
    @NamedQuery(name = "ContatoPessoaFisica.findByTipoContato", query = "SELECT c FROM ContatoPessoaFisica c WHERE c.tipoContato = :tipoContato"),
    @NamedQuery(name = "ContatoPessoaFisica.findByValor", query = "SELECT c FROM ContatoPessoaFisica c WHERE c.valor = :valor")})
public class ContatoPessoaFisica implements Identificavel {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 10)
    @Column(name = "tipo_contato")
    private String tipoContato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "valor")
    private String valor;
    @JoinColumn(name = "id_pessoa_fisica", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaFisica idPessoaFisica;

    public ContatoPessoaFisica() {
    }

    public ContatoPessoaFisica(Long id) {
        this.id = id;
    }

    public ContatoPessoaFisica(Long id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public PessoaFisica getIdPessoaFisica() {
        return idPessoaFisica;
    }

    public void setIdPessoaFisica(PessoaFisica idPessoaFisica) {
        this.idPessoaFisica = idPessoaFisica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContatoPessoaFisica)) {
            return false;
        }
        ContatoPessoaFisica other = (ContatoPessoaFisica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.solutio.licita.modelo.ContatoPessoaFisica[ id=" + id + " ]";
    }
    
}
