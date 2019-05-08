/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mateus Araújo Cruz
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByCpfCliente", query = "SELECT c FROM Cliente c WHERE c.cpfCliente = :cpfCliente")
    , @NamedQuery(name = "Cliente.findByNomeCliente", query = "SELECT c FROM Cliente c WHERE c.nomeCliente = :nomeCliente")
    , @NamedQuery(name = "Cliente.findByNascimentoCliente", query = "SELECT c FROM Cliente c WHERE c.nascimentoCliente = :nascimentoCliente")
    , @NamedQuery(name = "Cliente.findByFotoCliente", query = "SELECT c FROM Cliente c WHERE c.fotoCliente = :fotoCliente")
    , @NamedQuery(name = "Cliente.findByEnderecoCliente", query = "SELECT c FROM Cliente c WHERE c.enderecoCliente = :enderecoCliente")
    , @NamedQuery(name = "Cliente.findByEmailCliente", query = "SELECT c FROM Cliente c WHERE c.emailCliente = :emailCliente")
    , @NamedQuery(name = "Cliente.findBySenhaCliente", query = "SELECT c FROM Cliente c WHERE c.senhaCliente = :senhaCliente")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Basic(optional = false)
    @Column(name = "cpf_cliente")
    private int cpfCliente;
    @Basic(optional = false)
    @Column(name = "nome_cliente")
    private String nomeCliente;
    @Column(name = "nascimento_cliente")
    @Temporal(TemporalType.DATE)
    private Date nascimentoCliente;
    @Column(name = "foto_cliente")
    private String fotoCliente;
    @Column(name = "endereco_cliente")
    private String enderecoCliente;
    @Basic(optional = false)
    @Column(name = "email_cliente")
    private String emailCliente;
    @Basic(optional = false)
    @Column(name = "senha_cliente")
    private String senhaCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<Venda> vendaList;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, int cpfCliente, String nomeCliente, String emailCliente, String senhaCliente) {
        this.idCliente = idCliente;
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public int getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(int cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getNascimentoCliente() {
        return nascimentoCliente;
    }

    public void setNascimentoCliente(Date nascimentoCliente) {
        this.nascimentoCliente = nascimentoCliente;
    }

    public String getFotoCliente() {
        return fotoCliente;
    }

    public void setFotoCliente(String fotoCliente) {
        this.fotoCliente = fotoCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jcarstore.models.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
