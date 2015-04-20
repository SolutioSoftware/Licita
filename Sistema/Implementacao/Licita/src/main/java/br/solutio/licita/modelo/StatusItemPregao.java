/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.modelo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WitaloCarlos
 */
@Entity
@Table(name = "tbl_status_item_pregao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusItemPregao.findAll", query = "SELECT s FROM StatusItemPregao s"),
    @NamedQuery(name = "StatusItemPregao.findById", query = "SELECT s FROM StatusItemPregao s WHERE s.id = :id"),
    @NamedQuery(name = "StatusItemPregao.findByValor", query = "SELECT s FROM StatusItemPregao s WHERE s.valor = :valor")})
public class StatusItemPregao implements Identificavel {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 20)
    @Column(name = "valor")
    private String valor;
    @ManyToMany(mappedBy = "statusItemPregaoSet")
    private Set<ItemPregao> itemPregaoSet;

    public StatusItemPregao() {
    }

    public StatusItemPregao(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Set<ItemPregao> getItemPregaoSet() {
        return itemPregaoSet;
    }

    public void setItemPregaoSet(Set<ItemPregao> itemPregaoSet) {
        this.itemPregaoSet = itemPregaoSet;
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
        if (!(object instanceof StatusItemPregao)) {
            return false;
        }
        StatusItemPregao other = (StatusItemPregao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.solutio.licita.modelo.StatusItemPregao[ id=" + id + " ]";
    }
    
}
