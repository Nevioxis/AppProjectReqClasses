import java.io.IOException;
import java.util.ArrayList;
public class InfoWriter 
{
    FileP file;
    public InfoWriter(String f)
    {
        file = new FileP(f);
    }
    public void update(ArrayList<AccountID> accounts,ArrayList<BusID> buses,ArrayList<EventID> events) throws IOException
    {
         ArrayList<String> text = new ArrayList<>();
         text.add("//			Sport, 				Discipline, 						Category, 			Venue, 								Date, 		Start time, 	Duration, 	Bus travel time");
         for(EventID x : events) text.add(x.toString());
         text.add("\n//		Bus type,	Destination,					Depart,		Duration,	Rows,	Cols,	Cost");
         for(BusID x : buses) text.add(x.toString());
         text.add("\n//	    	UserID, password");
         for(AccountID x : accounts) text.add(x.toString());
         file.writeLines(text);
    }
}



