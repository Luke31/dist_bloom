package ch.fhnw.dist.bloom;

import java.io.IOException;
import java.util.List;

public class Terminal {
	private static final double DESIRED_P = 0.01; //Desired false positive probability (the lower the better)
	private static final int NOT_CONTAINED_SIZE = 10000;
	
	BloomFilter filter;
	Read read;
	
	public static void main(String[] args) throws IOException {
		new Terminal();
	}
	
	public Terminal(){
		read = new Read();
		addStrings();
		int falsePositive = testStrings();
		double falsePositiveProb = (double)falsePositive / NOT_CONTAINED_SIZE;
		System.out.println(falsePositive + " of " + NOT_CONTAINED_SIZE + " not contained Strings have been falsely identified as positive.");
		System.out.println("Desired false psoitive probability: " + DESIRED_P + " (Actual: " + falsePositiveProb +")");
	}
	
	private void addStrings(){
		int n = read.getContainedList().size();
	    filter = new BloomFilter(n, DESIRED_P);
	    for(String str : read.getContainedList()){
	    	filter.add(str);
	    }
	    //Must be true
	    for(String str : read.getContainedList()){
	    	assert ! filter.contains(str) : "" + str + " ist in Liste wurde aber nicht erkannt.";
	    }
	}
	
	private int testStrings(){
		List<String> notContained = read.generateNotContainedList(NOT_CONTAINED_SIZE);
	    int falsePositives = 0;
	    
		//Maybe false positive;
	    for(String str : notContained){
	    	if(filter.contains(str)){
	    		falsePositives++;
	    	}
	    }
		
		return falsePositives;
	}
}
