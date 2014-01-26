package entity;

public class JogadorEntity {

	private String nome;

	private PartidaEntity partida;

	private String tipo;

	private Integer qtdMorte;

	private ArmaEntity arma;

	public JogadorEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PartidaEntity getPartida() {
		return partida;
	}

	public void setPartida(PartidaEntity partida) {
		this.partida = partida;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getQtdMorte() {
		return qtdMorte;
	}

	public void setQtdMorte(Integer qtdMorte) {
		this.qtdMorte = qtdMorte;
	}

	public ArmaEntity getArma() {
		return arma;
	}

	public void setArma(ArmaEntity arma) {
		this.arma = arma;
	}

}