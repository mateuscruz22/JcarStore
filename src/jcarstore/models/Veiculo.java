/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.models;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mateus Araújo Cruz
 */
@Entity
@Table(name = "veiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v")
    , @NamedQuery(name = "Veiculo.findByIdVeiculo", query = "SELECT v FROM Veiculo v WHERE v.idVeiculo = :idVeiculo")
    , @NamedQuery(name = "Veiculo.findByModeloVeiculo", query = "SELECT v FROM Veiculo v WHERE v.modeloVeiculo = :modeloVeiculo")
    , @NamedQuery(name = "Veiculo.findByMarcaVeiculo", query = "SELECT v FROM Veiculo v WHERE v.marcaVeiculo = :marcaVeiculo")
    , @NamedQuery(name = "Veiculo.findByAnoVeiculo", query = "SELECT v FROM Veiculo v WHERE v.anoVeiculo = :anoVeiculo")
    , @NamedQuery(name = "Veiculo.findByFotoVeiculo", query = "SELECT v FROM Veiculo v WHERE v.fotoVeiculo = :fotoVeiculo")
    , @NamedQuery(name = "Veiculo.findByDescricaoVeiculo", query = "SELECT v FROM Veiculo v WHERE v.descricaoVeiculo = :descricaoVeiculo")
    , @NamedQuery(name = "Veiculo.findByPrecoCusto", query = "SELECT v FROM Veiculo v WHERE v.precoCusto = :precoCusto")
    , @NamedQuery(name = "Veiculo.findByPrecoVenda", query = "SELECT v FROM Veiculo v WHERE v.precoVenda = :precoVenda")})
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_veiculo")
    private Integer idVeiculo;
    @Basic(optional = false)
    @Column(name = "modelo_veiculo")
    private String modeloVeiculo;
    @Column(name = "marca_veiculo")
    private String marcaVeiculo;
    @Column(name = "ano_veiculo")
    private Integer anoVeiculo;
    @Column(name = "foto_veiculo")
    private String fotoVeiculo;
    @Column(name = "descricao_veiculo")
    private String descricaoVeiculo;
    @Basic(optional = false)
    @Column(name = "preco_custo")
    private double precoCusto;
    @Basic(optional = false)
    @Column(name = "preco_venda")
    private double precoVenda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVeiculo")
    private List<Venda> vendaList;

    public Veiculo() {
    }

    public Veiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Veiculo(Integer idVeiculo, String modeloVeiculo, double precoCusto, double precoVenda) {
        this.idVeiculo = idVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public Integer getAnoVeiculo() {
        return anoVeiculo;
    }

    public void setAnoVeiculo(Integer anoVeiculo) {
        this.anoVeiculo = anoVeiculo;
    }

    public String getFotoVeiculo() {
        return fotoVeiculo;
    }

    public void setFotoVeiculo(String fotoVeiculo) {
        this.fotoVeiculo = fotoVeiculo;
    }

    public String getDescricaoVeiculo() {
        return descricaoVeiculo;
    }

    public void setDescricaoVeiculo(String descricaoVeiculo) {
        this.descricaoVeiculo = descricaoVeiculo;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
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
        hash += (idVeiculo != null ? idVeiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.idVeiculo == null && other.idVeiculo != null) || (this.idVeiculo != null && !this.idVeiculo.equals(other.idVeiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jcarstore.models.Veiculo[ idVeiculo=" + idVeiculo + " ]";
    }
    
}
