package br.com.hoout.model.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_VEICULO")
public class Veiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_VEICULO")
	private Integer codigo;
	
	@Size(min=7,message="Nome da placa precisa ter pelo menos 7 caracteres")
	@NotNull(message="O campo placa � obrigat�rio")
	@Column(name="NM_PLACA",length=10,nullable=false)
	private String placa;
	
	
	@ManyToOne
	@JoinColumn(name="CD_CLIENTE",referencedColumnName="CD_CLIENTE")
	private Cliente cliente;

	
	
	public Veiculo(Integer codigo, String placa, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.placa = placa;
		this.cliente = cliente;
	}

	public Veiculo(){
		
	}

	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
