import java.io.FileNotFoundException;
public class Tester 
{
    public static void main(String[] args) throws FileNotFoundException 
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
    }
}



