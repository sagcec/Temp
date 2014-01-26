package entity;

import java.util.ArrayList;
import java.util.List;

public class PartidaEntity {

	private String numeroPartida = "";

	private List<JogadorEntity> jogadorAssasinoLista = new ArrayList();

	private List<JogadorEntity> jogadorVitimaLista = new ArrayList();

	public PartidaEntity() {

	}

	public String getNumeroPartida() {
		return numeroPartida;
	}

	public void setNumeroPartida(String numeroPartida) {
		this.numeroPartida = numeroPartida;
	}

	public List<JogadorEntity> getJogadorAssasinoLista() {
		return jogadorAssasinoLista;
	}

	public void setJogadorAssasinoLista(List<JogadorEntity> jogadorAssasinoLista) {
		this.jogadorAssasinoLista = jogadorAssasinoLista;
	}

	public List<JogadorEntity> getJogadorVitimaLista() {
		return jogadorVitimaLista;
	}

	public void setJogadorVitimaLista(List<JogadorEntity> jogadorVitimaLista) {
		this.jogadorVitimaLista = jogadorVitimaLista;
	}

}