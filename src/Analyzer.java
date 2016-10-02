import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;

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
		initclassifyingWords();

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

	private void initclassifyingWords() {
		midWords = makeWordsHash(midPath);
		satWords = makeWordsHash(satPath);
		greWords = makeWordsHash(grePath);
	}

	private LinkedHashSet makeWordsHash(String path) {
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

}
