
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A2 {
	
	Scanner inp = new Scanner (System.in);
	
	SLL<Token> wordlist = new SLL<Token>();
	
	SLL<Token> decFreq = new SLL<Token>();
	
	SLL<Token> incFreq = new SLL<Token>();
	
	private String[] stopwords = { "a", "about", "all", "am", "an", 
		         "and", "any", "are", "as", "at", "be", "been", "but", "by", "can", 
		         "cannot", "could", "did", "do", "does", "else", "for", "from", 
		         "get", "got", "had", "has", "have", "he", "her", "hers", "him", 
		         "his", "how", "i", "if", "in", "into", "is", "it", "its", "like", 
		         "more", "me", "my", "no", "now", "not", "of", "on", "one", 
		         "or", "our", "out", "said", "say", "says", "she", "so", "some",
		         "than", "that", "the", "their", "them", "then", "there", "these", 
		         "they", "this", "to", "too", "us", "upon", "was", "we", "were", 
		         "what", "with", "when", "where", "which", "while", "who", 
		          "whom", "why", 
		         "will", "you", "your"};

    private int totalWordCount = 0;
		   
    private int stopWordCount = 0;
    
	public static void main (String []  args) throws FileNotFoundException {
		 A2 a2 = new A2();
	      a2.run();
	}
	
	public void run() throws FileNotFoundException {
	      readFile();
	      addFreqToLists();
	      printResults();      
	}
	/**
	 * Prints n# words in alphabetical order.
	 *
	 */
	private void printWords( int n) {
	      int i = 0;
	      while ( i < wordlist.size() && i < n) {
	         System.out.println( wordlist.get(i));
	         i++;
	      }
	}
	/**
	 * Prints n# Most Frequent words.
	 *
	 */
	private void printWordsIncFreq( int n) {
	      int i = 0;
	      while ( i < wordlist.size() && i < n) {
	         System.out.println( incFreq.get(i));
	         i++;
	      }
	}
	/**
	 * Print n# Least Frequent words.
	 * 
	 */
	private void printWordsDecFreq( int n) {
	      int i = 0;
	      while ( i < wordlist.size() && i < n) {
	         System.out.println( decFreq.get(i));
	         i++;
	      }
	}
	/**
	 * Prints the results. 
	 */
	private void printResults() {
		System.out.println( "Total Words: " + totalWordCount);
	    System.out.println( "Unique Words: " + wordlist.size()); 
	    System.out.println( "Stop Words: " + stopWordCount+"\n");
	    System.out.println("10 Most Frequent");
	    printWordsIncFreq(10);
	    System.out.println();
	    System.out.println("10 Least Frequent");
	    printWordsDecFreq(10);
	    System.out.println();
	    System.out.println("All");
	    printWords( wordlist.size()); 
	}
	/**
	 * Gets words from word linked list to add them in another 2 linkedlist.
	 */
	public void addFreqToLists() {
		int count = 0; 	
		while (wordlist.size() > count) { 
			Token word = wordlist.get(count);
			decFreq.addInOrderDec(word);
			incFreq.addInOrderInc(word);
			count++;
		}
	}
	/**
	 * Reads the input .txt file and adds words into the wordlist. 
	 * @throws FileNotFoundException 
	*/ 
	private void readFile() throws FileNotFoundException {
		
		while ( inp.hasNext()) {
			
			String word = inp.next().toLowerCase().trim().replaceAll( "[^a-z]","");
			
			if (word.length() > 0) {

				totalWordCount++;
				if ( stopWord( word)) {
					stopWordCount++;
				}
				else {
					Token w = wordlist.find(word);
					if (w == null) {
						w = new Token(word);
						wordlist.addInOrder( w);
					}
					w.incrCount();
				}

			}
		}
		inp.close();
		System.out.println();
		System.out.println("Read completed" );
		System.out.println();
	}
	/** 
	 * Sees if words is a stop word.
	 * 
	 */
	private boolean stopWord(String word) {
		 boolean isFound = false;
		 int i = 0;
		 while ( i< stopwords.length && !isFound) {
			 if ( word.equals( stopwords[i])) 
		            isFound = true;
		     i++;
		 }
		return isFound;
	}
	
}

