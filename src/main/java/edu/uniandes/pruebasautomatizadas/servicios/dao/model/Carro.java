package edu.uniandes.pruebasautomatizadas.servicios.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carro")
public class Carro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="linea")
	private String linea;
	
	@Column(name="cilindraje")
	private String cilindraje;
	
	@Column(name="modelo")
	private int modelo;
	
	@Column(name="anios_garantia")
	private int aniosGarantia;
	
	@Column(name="numero_serie")
	private String numeroSerie;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public int getAniosGarantia() {
		return aniosGarantia;
	}

	public void setAniosGarantia(int aniosGarantia) {
		this.aniosGarantia = aniosGarantia;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", " + (marca != null ? "marca=" + marca + ", " : "")
				+ (linea != null ? "linea=" + linea + ", " : "")
				+ (cilindraje != null ? "cilindraje=" + cilindraje + ", " : "") + "modelo=" + modelo
				+ ", aniosGarantia=" + aniosGarantia + ", " + (numeroSerie != null ? "numeroSerie=" + numeroSerie : "")
				+ "]";
	}
	
}
