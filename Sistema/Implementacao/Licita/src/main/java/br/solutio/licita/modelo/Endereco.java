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
@Table(name = "tbl_endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findById", query = "SELECT e FROM Endereco e WHERE e.id = :id"),
    @NamedQuery(name = "Endereco.findByLogradouro", query = "SELECT e FROM Endereco e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "Endereco.findByCidade", query = "SELECT e FROM Endereco e WHERE e.cidade = :cidade"),
    @NamedQuery(name = "Endereco.findByEstado", query = "SELECT e FROM Endereco e WHERE e.estado = :estado"),
    @NamedQuery(name = "Endereco.findByCep", query = "SELECT e FROM Endereco e WHERE e.cep = :cep"),
    @NamedQuery(name = "Endereco.findByNumero", query = "SELECT e FROM Endereco e WHERE e.numero = :numero"),
    @NamedQuery(name = "Endereco.findByComplemento", query = "SELECT e FROM Endereco e WHERE e.complemento = :complemento")})
public class Endereco implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Size(max = 60)
    @Column(name = "logradouro")
    private String logradouro;
    
    @Size(max = 60)
    @Column(name = "cidade")
    private String cidade;
    
    @Size(max = 2)
    @Column(name = "estado")
    private String estado;
    
    @Size(max = 8)
    @Column(name = "cep")
    private String cep;
    
    @Column(name = "numero")
    private Integer numero;
    
    @Size(max = 50)
    @Column(name = "complemento")
    private String complemento;
    
    @JoinColumn(name = "id_pessoa_fisica", referencedColumnName = "id")
    @OneToOne
    private PessoaFisica pessoaFisica;
    
    @JoinColumn(referencedColumnName = "id", name = "id_pessoa_juridica")
    @OneToOne
    private PessoaJuridica pessoaJuridica;
    
    public Endereco() {
    }

    public Endereco(Long id) {
        this.id = id;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.solutio.licita.modelo.Endereco[ id=" + id + " ]";
    }
    
}
