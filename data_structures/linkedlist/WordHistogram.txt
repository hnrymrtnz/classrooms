import java.io.*;
import java.util.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;


//class to store the words
public class WordHistogram
{
    LinkedList<Word> words = new LinkedList<Word>();

    void add(Word word) {
        int index = searchWord(word);

        if (index != -1)
        {
            words.get(index).setCount(words.get(index).getCount()+1);  
        }   
        else
        {
            words.add(word);
        }
    }

    int searchWord(Word word)
    {
        for (int i = 0; i < words.size(); i++)
        {
            if (word.compareTo(words.get(i)) == 0)
            {
               return i;
            }
        }
        return -1;
    }

    void printList()
    { 
        Collections.sort((words), new Comparator<Word>() {
             @Override
             public int compare(Word w1, Word w2) {
                 return w1.compareTo(w2);
             }
        });
        
        for (int i = 0; i < words.size(); i++)
        {
            System.out.print(words.get(i));
            
            if (i == (words.size() - 1))
            {
               System.out.print("]");
            }
            else
            {
               System.out.print(", ");
            }
        }
    }
    
    public static void main(String [] args) throws Exception
    {   
        WordHistogram wordHistogram = new WordHistogram();

        File fl = new File("input.txt");

        Scanner sc = new Scanner(fl);
        
        while(sc.hasNext())
        {
            String str = sc.next().toLowerCase();
            str=str.replaceAll("[^a-zA-Z0-9]", "");  
            wordHistogram.add(new Word(str, 1));
        }
        
        System.out.print("[");
        wordHistogram.printList();
    }   
}