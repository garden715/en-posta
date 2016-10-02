import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import kr.co.shineware.nlp.posta.en.core.EnPosta;

public class Enposta {
	public static void main(String[] args) {
		EnPosta posta = new EnPosta();
		posta.load("model");
		posta.buildFailLink();
		
		Analyzer wordAnlyzer = new Analyzer();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("scriptset/a.txt"));
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				List<String> resultList = posta.analyze(line);
				for (String result : resultList) {
					String posTag = result.split("/")[1];
					if (posTag.equals("VB") || posTag.equals("NN")) {
						System.out.println(result);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
