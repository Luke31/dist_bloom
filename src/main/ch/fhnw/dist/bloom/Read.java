package ch.fhnw.dist.bloom;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * BloomFilter
 * Help for implementation: https://en.wikipedia.org/wiki/Bloom_filter
 * Used HashFunction generator: http://docs.guava-libraries.googlecode.com/git-history/v11.0/javadoc/com/google/common/hash/Hashing.html
 * @author Tobias Ernst, Andreas Gloor, Lukas Schmid 
 */
public class Read {
	ArrayList<String> list = new ArrayList<String>();
	public Read() {
		URL url = Thread.currentThread().getContextClassLoader().getResource("words.txt");
		File f = null;
		try {
			f = new File(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		Scanner s = null;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (s.hasNext()){
			list.add(s.next());
		}
		s.close();
	}
	
	public List<String> getContainedList(){
		return list;
	}
	
	public List<String> generateNotContainedList(int n){
		List<String> notContained = new ArrayList<>();
		for(int i = 0; i < n; i++){
			notContained.add(generateString(i));
		}
		return notContained;
	}
	
	private String generateString(int seed){
		StringBuilder strB = new StringBuilder();
		strB.append("AAA");
		int charsToAdd = 10;
		for(int i = 0; i < charsToAdd; i++){
			strB.append(Character.toString((char)('a'+i+(seed % (26 - i)))));
		}
		return strB.toString();
	}
}
