package entity;

public class ArmaEntity {

	private String nome;

	private int qtdUso;

	public ArmaEntity(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdUso() {
		return qtdUso;
	}

	public void setQtdUso(int qtdUso) {
		this.qtdUso = qtdUso;
	}

}