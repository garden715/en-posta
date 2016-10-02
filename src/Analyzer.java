import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;

public class Analyzer {
	private LinkedHashSet<String> posTags = new LinkedHashSet<>();
	private LinkedHashSet<String> midWords = new LinkedHashSet<>();
	private LinkedHashSet<String> satWords = new LinkedHashSet<>();
	private LinkedHashSet<String> greWords = new LinkedHashSet<>();
	
	
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
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("wordset/mid.txt"));
			
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				
				midWords.add(line);
			}
		} catch(IOException e)  {
			e.printStackTrace();
		}

	}
	

}
