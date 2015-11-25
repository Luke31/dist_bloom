package ch.fhnw.dist.bloom;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.fhnw.dist.bloom.BloomFilter;


public class TestBloomFilter {
	HashSet<String> wordsContained = new HashSet<>();
	HashSet<String> wordsToTest = new HashSet<>();
	HashSet<String> wordsToTestNotInList = new HashSet<>();
	BloomFilter filter;
	
	@Before
    public void setUp() {
		wordsContained.addAll(Arrays.asList(new String[]{"abc","abd","abe","abf","abg","abh","abi","abj","abk","abl"}));
		wordsToTest.addAll(Arrays.asList(new String[]{"abc","abg","abj"}));
		wordsToTestNotInList.addAll(Arrays.asList(new String[]{"not","blanot"}));
		filter = new BloomFilter(10, 0.01);
    }
	
	@After
    public void tearDown() {
		wordsContained.clear();
		wordsToTest.clear();
    }
	
	@Test
	public void testSingleWord(){
		for(String str : wordsContained){
			filter.add(str);
		}
		for(String str : wordsToTest){
			boolean contained = filter.contains(str);
			assertEquals(true, contained);
		}
		for(String str : wordsToTestNotInList){
			boolean contained = filter.contains(str);
			assertEquals(false, contained);
		}
	}
}
