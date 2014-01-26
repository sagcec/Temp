package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.ArmaEntity;
import entity.JogadorEntity;
import entity.PartidaEntity;

public class Arquivo {

	private String nomeArquivo;

	public Arquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public void escreverNomeArquivo() {
		System.out.println(this.nomeArquivo);
	}

	public void ranking() {
		try {
			String dir = diretorio();

			File f = arquivo(dir);

			List lista = lerArquivo(f);
			escreverResultado(lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String diretorio() {
		File dir = new File("teste");

		String caminho = dir + File.separator;

		return caminho;
	}

	private File arquivo(String diretorio) {
		File f = new File(diretorio + "/" + "log.txt");

		return f;
	}

	private List lerArquivo(File f) throws IOException {
		List lista = new ArrayList();

		PartidaEntity part = new PartidaEntity();

		BufferedReader br = new BufferedReader(new FileReader(f));

		while (br.ready()) {
			String linha = br.readLine();

			// System.out.println(linha);

			if (linha.contains("New match")) {
				String[] s = linha.split(" - ");
				String partida = s[1].replace("New match ", "").replace(
						" has started", "");

				part.setNumeroPartida(partida);
			} else if (!linha.contains("New match")
					&& !linha.contains("has ended")) {
				if (!linha.contains("<WORLD>")) {
					String[] s = linha.split(" - ");
					s = s[1].split(" ");

					JogadorEntity jogador1 = new JogadorEntity();
					jogador1.setNome(s[0]);
					jogador1.setTipo("A");

					ArmaEntity arma = new ArmaEntity(s[4]);

					jogador1.setArma(arma);

					JogadorEntity jogador2 = new JogadorEntity();
					jogador2.setNome(s[2]);
					jogador2.setTipo("V");

					part.getJogadorAssasinoLista().add(jogador1);
					part.getJogadorVitimaLista().add(jogador2);
				}
			} else if (linha.endsWith("has ended")) {
				lista.add(part);

				part = new PartidaEntity();
			}
		}

		br.close();

		return lista;
	}

	private void escreverResultado(List lista) {
		for (Object obj : lista) {
			PartidaEntity ent = (PartidaEntity) obj;

			System.out.println("Partida " + ent.getNumeroPartida() + " teve "
					+ ent.getJogadorVitimaLista().size() + " morte (s).");

			for (Object obj1 : ent.getJogadorVitimaLista()) {
				JogadorEntity ent1 = (JogadorEntity) obj1;

				int qtd = 0;

				for (Object obj2 : ent.getJogadorVitimaLista()) {
					JogadorEntity ent2 = (JogadorEntity) obj2;

					if (ent2.getNome().equals(ent1.getNome())) {
						qtd++;
					}
				}

				ent1.setQtdMorte(qtd);

				System.out.println(" - " + ent1.getNome() + " morreu "
						+ ent1.getQtdMorte() + " vezes.");

				qtd = 0;
			}

			int t = 0;
			String arma = "";

			for (Object obj1 : ent.getJogadorAssasinoLista()) {
				JogadorEntity ent1 = (JogadorEntity) obj1;

				int qtd = 0;

				for (Object obj2 : ent.getJogadorAssasinoLista()) {
					JogadorEntity ent2 = (JogadorEntity) obj2;

					if (ent2.getArma().getNome()
							.equals(ent1.getArma().getNome())) {
						qtd++;
					}
				}

				if (t < qtd) {
					t = qtd;
					arma = ent1.getArma().getNome();
				}

				qtd = 0;
			}

			System.out.println("A arma " + arma
					+ " foi a mais utilizada. Foi utilizada " + t + " vezes.");

			System.out.println();
		}
	}

}