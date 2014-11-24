package br.com.mv.comparar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//

		try {
			File f = new File("csv1.csv");

			BufferedReader in = new BufferedReader(new FileReader(f));
			String str = "";

			pri: while (in.ready()) {
				str = in.readLine();
				String[] s = str.split(";");

				s[1] = Normalizer.normalize(s[1], Normalizer.Form.NFD);
				s[1] = s[1].replaceAll("[^\\p{ASCII}]", "");

				//

				File f1 = new File("csv3.txt");

				BufferedReader in1 = new BufferedReader(new FileReader(f1));
				String str1 = "";

				seg: while (in1.ready()) {
					str1 = in1.readLine();
					String[] s1 = str1.split(";");

					// System.out.println(":: " + s1[1]);

					s1[1] = Normalizer.normalize(s1[1], Normalizer.Form.NFD);
					s1[1] = s1[1].replaceAll("[^\\p{ASCII}]", "");

					//s1[1] = s1[1].substring(0, s1[1].indexOf(" ("));

					if (s[1].equals(s1[1])) {
						System.out.println(s[1] + " == " + s1[1]);

						break seg;
					}
				}

				in1.close();

				System.out.println();
			}

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}