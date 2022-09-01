package entities;

import excecoes.ExcecaoNegocio;

public class Conta {
	
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteCredito;
	
	public Conta() {}

	public Conta(Integer numero, String titular, Double saldo, Double limiteCredito) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteCredito = limiteCredito;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getlimiteCredito() {
		return limiteCredito;
	}

	public void setlimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	public void deposito(double valor) {
		saldo += valor;
	}

	public void saque(double valor) {
		validarSaque(valor);
		saldo -= valor;
	}

	public void validarSaque(double valor){
		if(valor > getlimiteCredito()){
			throw new ExcecaoNegocio("Erro de saque: A quantia excede o limite de saque");
		}else if(valor > getSaldo()){
			throw new ExcecaoNegocio("Erro de saque: Saldo insuficiente");
		}
	}
	
	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", limiteCredito=" + limiteCredito
				+ "]";
	}	
}
