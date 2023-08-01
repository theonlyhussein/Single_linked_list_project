import java.util.Comparator;

public class Token  implements Comparable<Token> {
	 
	   private String word;
	   private int count; 
	   
	
	   public Token(String w) {
	      this.word = w;
	      this.count = 0;
	   }

	   /** This comparator sorts from high to low frequency count. 
	    */
	   public static Comparator<Token> CompFreqDesc = new Comparator<Token>() {
	      public int compare( Token w1, Token w2) {
	         int f1 = w1.getCount();
	         int f2 = w2.getCount();
	         if (f2-f1 == 0) 
	            return w1.compareTo(w2);
	         else
	            return f2 - f1; 
	      }
	   };

	   /** This comparator sorts from low to high frequency count. 
	    */
	   public static Comparator<Token> CompFreqAsc = new Comparator<Token>() {
	      public int compare( Token w1, Token w2) {

	         int f1 = w1.getCount();
	         int f2 = w2.getCount();
	         if (f1 - f2 == 0) 
	            return w1.compareTo( w2);
	         else
	            return f1 - f2; 
	      }
	   };

	   public String getWord() { 
	      return word;
	   }

	   public int getCount() { 
	      return count;
	   }

	   public void incrCount() { 
	      count++; 
	   }

	   public String toString() { 
	      return getWord() + " : " + getCount();
	   }

	   /** To check if one word is to another.
	    */
	   public boolean equals( Object other) {
	      if ( other == this) return true;
	      if ( other == null) return false;
	      if ( this.getClass() != other.getClass()) return false;
	      Token p = (Token)other;
	      return this.getWord().equals( p.getWord());
	   }
	  
	   /** Compare two words. 
	    * This method well order Words alphabetically. 
	    */
	   public int compareTo( Token o) {
	      if ( this.equals( o))
	         return 0;
	      else
	         return this.getWord().compareTo(o.getWord()); 
	   }

	  
	   
	 
}

