import java.io.FileNotFoundException;
import java.io.IOException;
public class Tester 
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        FileP file = new FileP("E:\\AppProject\\input.txt");
        GatheringInput x = new GatheringInput(file);
        for (String i:x.getInput())
         {
              System.out.println(i);
         }
        for (EventID i:x.getEvents())
         {
              System.out.println(i);
         }
        for (BusID i:x.getBuses())
         {
              System.out.println(i);
         }
        for (AccountID i:x.getAccounts())
         {
              System.out.println(i);
         }
        InfoWriter file2 = new InfoWriter("E:\\AppProject\\input2.txt");
        file2.update(x.getAccounts(),x.getBuses(),x.getEvents());
    }
}






