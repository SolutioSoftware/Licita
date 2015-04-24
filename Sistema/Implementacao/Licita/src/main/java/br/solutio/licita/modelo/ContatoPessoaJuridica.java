/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.modelo;

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
@Table(name = "tbl_contato_pessoa_juridica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContatoPessoaJuridica.findAll", query = "SELECT c FROM ContatoPessoaJuridica c"),
    @NamedQuery(name = "ContatoPessoaJuridica.findById", query = "SELECT c FROM ContatoPessoaJuridica c WHERE c.id = :id"),
    @NamedQuery(name = "ContatoPessoaJuridica.findByTipoContato", query = "SELECT c FROM ContatoPessoaJuridica c WHERE c.tipoContato = :tipoContato"),
    @NamedQuery(name = "ContatoPessoaJuridica.findByValor", query = "SELECT c FROM ContatoPessoaJuridica c WHERE c.valor = :valor")})
public class ContatoPessoaJuridica implements Identificavel {
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
    @JoinColumn(name = "id_pessoa_juridica", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaJuridica idPessoaJuridica;

    public ContatoPessoaJuridica() {
    }

    public ContatoPessoaJuridica(Long id) {
        this.id = id;
    }

    public ContatoPessoaJuridica(Long id, String valor) {
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

    public PessoaJuridica getIdPessoaJuridica() {
        return idPessoaJuridica;
    }

    public void setIdPessoaJuridica(PessoaJuridica idPessoaJuridica) {
        this.idPessoaJuridica = idPessoaJuridica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ContatoPessoaJuridica)) {
            return false;
        }
        ContatoPessoaJuridica other = (ContatoPessoaJuridica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.solutio.licita.modelo.ContatoPessoaJuridica[ id=" + id + " ]";
    }
    
}
