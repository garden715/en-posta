package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;

public class Analyzer {
	private String midPath = "wordset/mid.txt";
	private String satPath = "wordset/sat.txt";
	private String grePath = "wordset/gre.txt";
	
	private LinkedHashSet<String> posTags = new LinkedHashSet<>();
	private LinkedHashSet<String> midWords;
	private LinkedHashSet<String> satWords;
	private LinkedHashSet<String> greWords;

	public Analyzer() {
		// TODO Auto-generated constructor stub
		initPosTagsSet();
		initWordSet();
	}

	private void initPosTagsSet() {
		posTags.add("IN");
		posTags.add("JJ");
		posTags.add("JJR");
		posTags.add("JJS");
		posTags.add("MD");
		posTags.add("RB");
		posTags.add("VB");
	}

	private void initWordSet() {
		midWords = makeWordsHash(midPath);
		satWords = makeWordsHash(satPath);
		greWords = makeWordsHash(grePath);
	}

	private LinkedHashSet<String> makeWordsHash(String path) {
		LinkedHashSet<String> words = new LinkedHashSet<>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(path));

			while (true) {
				String line = br.readLine();
				if (line == null)
					break;

				words.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return words;
	}

	public SpeechInfo classifyingScript(List<String> resultList, SpeechInfo speech) {
		for (String result : resultList) {
			String posTag = result.split("/")[1];
			String word = result.split("/")[0];
			
			if (posTags.contains(posTag)) {
				if (greWords.contains(word)) {
					speech.greCount++;
				} else if(satWords.contains(word)) {
					speech.satCount++;
				} else if(midWords.contains(word)) {
					speech.midCount++;
				}
			}
		}
		speech.determieLevel();
		return speech;
	}
}
