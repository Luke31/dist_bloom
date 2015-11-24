package ch.fhnw.dist.bloom;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 * BloomFilter
 * Help for implementation: https://en.wikipedia.org/wiki/Bloom_filter
 * Used HashFunction generator: http://docs.guava-libraries.googlecode.com/git-history/v11.0/javadoc/com/google/common/hash/Hashing.html
 * @author Tobias Ernst, Andreas Gloor, Lukas Schmid 
 */
public class BloomFilter {
	private int n; //Expected elements
	private double p; //Desired False positive Probabilty
	private double optM; //Optimal Array-size
	private int m; //"Rounded" int Array-size
	private double optK; //Optimal number of Hash-functions
	private int k; //"Rounded" int number of Hash-functions
	private boolean[] bitArr; //Bit-Array for Bloom-filter
	private HashFunction[] hashFunctions;
	
	/**
	 * @param n Expected number of elements in data structure
	 * @param p Desired False Positive Probability
	 */
	public BloomFilter(int n, double p) {
		super();
		this.n = n;
		this.p = p;
		
		//Calculate Array-size and create Array
		this.optM = -(n*Math.log(p))/(Math.log(2)*Math.log(2)); //Calc optimal array-size m
		this.m = (int) optM;
		bitArr = new boolean[m];
		
		//Calculate number of HashFunctions, create array and generate hash-functions
		this.optK = m/n * Math.log(2); //Calc optimal number of hash-functions k
		this.k = (int) optK;
		hashFunctions = new HashFunction[k];
		for(int i = 0; i < k; i++){
			int seed = i; //TODO: Try different seed?
			hashFunctions[i] = Hashing.murmur3_128(seed);
		}
	}
	
	public boolean contains(String str){
		//TODO
		return false;
	}
	
	public void add(String str){
		//TODO
	}
	
	private int[] getArrIndexes(String str){
		int[] idexes = new int[k];
		for(int i = 0; i < k; i++){
			idexes[i] = getArrIdx(hashFunctions[i].hashString(str, StandardCharsets.UTF_8));
		}
		return idexes;
	}
	
	private int getArrIdx(HashCode hashCode){
		return hashCode.asInt() % m;
	}
}
