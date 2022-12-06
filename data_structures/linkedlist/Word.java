public class Word implements Comparable<Word>
{
   private String word;
   private int count;
   
   public Word() 
   {
      this.word = "";
      this.count = 0;
   }
   public Word(String w, int cnt) 
   {
      super();
		this.word = w;
		this.count = cnt;
   }
   public void setWord(String w) 
   {
      this.word = w;
   }
   public String getWord() {
      return word;
   }
   public void setCount(int c) {
      this.count = c;
   }
   public int getCount() {
      return count;
   }
   @Override
   public boolean equals(Object o) {
      if (this == o)
      {
			return true;
      }
		if (o == null)
      {
			return false;
      }
		if (getClass() != o.getClass())
      {
			return false;
      }
      
		Word other = (Word) o;
      
		if (count != other.count)
      {
			return false;
      }
		if (word == null) 
      {
			if (other.word != null)
         {
				return false;
         }
      }
		else if (!word.equals(other.word))
      {
			return false;
      }
      
		return true;
   }
   public int compareTo(Word w) {
      return this.word.compareTo(w.getWord());
   }
   public String toString() {
      return word + " : " + count;
   }
}