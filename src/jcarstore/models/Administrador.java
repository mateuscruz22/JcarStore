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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    , @NamedQuery(name = "Administrador.findByIdAdministador", query = "SELECT a FROM Administrador a WHERE a.idAdministador = :idAdministador")
    , @NamedQuery(name = "Administrador.findByNomeAdministrador", query = "SELECT a FROM Administrador a WHERE a.nomeAdministrador = :nomeAdministrador")
    , @NamedQuery(name = "Administrador.findByEmailAdministrador", query = "SELECT a FROM Administrador a WHERE a.emailAdministrador = :emailAdministrador")
    , @NamedQuery(name = "Administrador.findBySenhaAdministrador", query = "SELECT a FROM Administrador a WHERE a.senhaAdministrador = :senhaAdministrador")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_administador")
    private Integer idAdministador;
    @Column(name = "nome_administrador")
    private String nomeAdministrador;
    @Basic(optional = false)
    @Column(name = "email_administrador")
    private String emailAdministrador;
    @Basic(optional = false)
    @Column(name = "senha_administrador")
    private String senhaAdministrador;

    public Administrador() {
    }

    public Administrador(Integer idAdministador) {
        this.idAdministador = idAdministador;
    }

    public Administrador(Integer idAdministador, String emailAdministrador, String senhaAdministrador) {
        this.idAdministador = idAdministador;
        this.emailAdministrador = emailAdministrador;
        this.senhaAdministrador = senhaAdministrador;
    }

    public Integer getIdAdministador() {
        return idAdministador;
    }

    public void setIdAdministador(Integer idAdministador) {
        this.idAdministador = idAdministador;
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
        hash += (idAdministador != null ? idAdministador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.idAdministador == null && other.idAdministador != null) || (this.idAdministador != null && !this.idAdministador.equals(other.idAdministador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jcarstore.models.Administrador[ idAdministador=" + idAdministador + " ]";
    }
    
}
