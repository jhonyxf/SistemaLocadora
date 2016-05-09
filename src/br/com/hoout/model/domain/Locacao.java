package br.com.hoout.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_LOCACAO")
public class Locacao implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_LOCACAO")
	private Integer codigo;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date entrada;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date saida;
	
	@Digits(integer=5, fraction=2)
	@Column(name = "preco")
	private BigDecimal preco;
	
	@ManyToOne()
	@JoinColumn(name="CD_VEICULO", referencedColumnName="CD_VEICULO")
	private Veiculo veiculo;
	
	@ManyToOne()
	@JoinColumn(name="CD_CLIENTE", referencedColumnName="CD_CLIENTE")
	private Cliente cliente;
	
	@ManyToOne()
	@JoinColumn(name="CD_FUNCIONARIO", referencedColumnName="CD_FUNCIONARIO")
	private Funcionario funcionario;
	
	public Locacao(){}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
		Locacao other = (Locacao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
