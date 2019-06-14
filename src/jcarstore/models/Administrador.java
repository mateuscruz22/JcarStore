/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mateus Araújo Cruz
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.idAdministrador = :idAdministrador")
    , @NamedQuery(name = "Administrador.findByNomeAdministrador", query = "SELECT a FROM Administrador a WHERE a.nomeAdministrador = :nomeAdministrador")
    , @NamedQuery(name = "Administrador.findByEmailAdministrador", query = "SELECT a FROM Administrador a WHERE a.emailAdministrador = :emailAdministrador")
    , @NamedQuery(name = "Administrador.findBySenhaAdministrador", query = "SELECT a FROM Administrador a WHERE a.senhaAdministrador = :senhaAdministrador")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_administrador")
    private Integer idAdministrador;
    @Column(name = "nome_administrador")
    private String nomeAdministrador;
    @Column(name = "email_administrador")
    private String emailAdministrador;
    @Column(name = "senha_administrador")
    private String senhaAdministrador;

    public Administrador() {
    }

    public Administrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNomeAdministrador() {
        return nomeAdministrador;
    }

    public void setNomeAdministrador(String nomeAdministrador) {
        this.nomeAdministrador = nomeAdministrador;
    }

    public String getEmailAdministrador() {
        return emailAdministrador;
    }

    public void setEmailAdministrador(String emailAdministrador) {
        this.emailAdministrador = emailAdministrador;
    }

    public String getSenhaAdministrador() {
        return senhaAdministrador;
    }

    public void setSenhaAdministrador(String senhaAdministrador) {
        this.senhaAdministrador = senhaAdministrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdministrador != null ? idAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.idAdministrador == null && other.idAdministrador != null) || (this.idAdministrador != null && !this.idAdministrador.equals(other.idAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jcarstore.models.Administrador[ idAdministrador=" + idAdministrador + " ]";
    }
    
}
