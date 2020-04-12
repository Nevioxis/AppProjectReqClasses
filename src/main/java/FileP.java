import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class FileP 
{
    private final File file;
    public FileP(String x) 
    {
        file = new File(x);
    }
    public ArrayList<String> readLines() throws FileNotFoundException
    {
        Scanner x = new Scanner(file);
        ArrayList<String> text = new ArrayList<>();
        while(x.hasNext())  text.add(x.nextLine());
        x.close();
        return text;
    }
    public ArrayList<String> readLines(int start, int end) throws FileNotFoundException
    {
        Scanner x = new Scanner(file);
        ArrayList<String> text = new ArrayList<>();
        int point = start;
        if(point <= 0) point = 1;
        String c;
        for(int i = 1;i<=start;i++) c = x.nextLine();
        while(x.hasNext() && point <= end)  
        {
            text.add(x.nextLine());
            point++;
        }
        x.close();
        return text;
    }
    public void writeLines(ArrayList<String> text) throws IOException
    {
        PrintWriter x = new PrintWriter(file);
        for(String t :text)
        {
            x.println(t);
        }
        x.close();
    }
    public ArrayList<String> toStringOfObject(ArrayList<Object> obj)
    {
        ArrayList<String> text = new ArrayList<>();
        for(Object x : obj) text.add(x.toString());
        return text;
    }
    public ArrayList<String> readLinesWithSkippedLines(String skip) throws FileNotFoundException
    {
        Scanner x = new Scanner(file);
        ArrayList<String> text = new ArrayList<>();
        String t;
        Boolean containSkipString;
        while(x.hasNext())  
        {
            t = x.nextLine();
            if(t.isBlank()) 
            {
                text.add(t);
                continue;
            }
            containSkipString = skip.equals(t.substring(0, skip.length()));
            if(!containSkipString) text.add(t);
        }
        x.close();
        return text;
    }
    public ArrayList<String> readLinesWithSkippedLinesWithoutBlank (String skip) throws FileNotFoundException
    {
        Scanner x = new Scanner(file);
        ArrayList<String> text = new ArrayList<>();
        String t;
        Boolean containSkipString;
        while(x.hasNext())  
        {
            t = x.nextLine();
            if(t.isBlank()) 
            {
                continue;
            }
            containSkipString = skip.equals(t.substring(0, skip.length()));
            if(!containSkipString) text.add(t);
        }
        x.close();
        return text;
    }
    public ArrayList<String> readLinesWithoutBlank() throws FileNotFoundException
    {
        Scanner x = new Scanner(file);
        ArrayList<String> text = new ArrayList<>();
        String t;
       while(x.hasNext())  
        {
            t = x.nextLine();
            if(!t.isBlank()) text.add(t);
        }
        x.close();
        return text;
    }
}







