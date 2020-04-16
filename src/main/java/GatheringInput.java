import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class GatheringInput
{
    private  ArrayList<String> input;
    private  ArrayList<AccountID> accounts;
    private  ArrayList<BusID> buses;
    private  ArrayList<EventID> events;
    public GatheringInput (FileP file) throws FileNotFoundException, IOException
    {
        input = file.readLinesWithSkippedLinesWithoutBlank("//");
        accounts = new ArrayList<>();
        buses= new ArrayList<>();
        events= new ArrayList<>();
        String content;
        String[] info;
        EventID event;
        AccountID account;
        BusID bus;
        LoginToken token;
        for(String i: input)
        {
            content = i.replace("\t", "");
            info = content.split(",");
            if(i.startsWith("Event"))
            {
                event = new EventID(info[0].split(":")[1].strip(),info[1],info[2],info[3],info[4],info[5],info[6],info[7]);
                events.add(event);
            }
            else if(i.startsWith("Bus"))
            {
                if (info.length == 9)
                {
                    bus = new BusID(info[0].split(":")[1].replace(" Type ",""),info[1],info[2],Integer.parseInt(info[3]),Integer.parseInt(info[4]),Integer.parseInt(info[5]),info[6],info[7],Integer.parseInt(info[8]));
                    buses.add(bus);
                }
                else
                {
                    bus = new BusID(info[0].split(":")[1].replace(" Type ",""),info[1],info[2],Integer.parseInt(info[3]),Integer.parseInt(info[4]),Integer.parseInt(info[5]),info[6]);
                    buses.add(bus);
                }
            }
            else if(i.startsWith("Account"))
            {
                if (info.length == 4)
                {
                    account = new AccountID(info[0].split(":")[1],info[1],info[2],info[3]);
                    token = new LoginToken(account);
                    token.createTokenfile();
                    accounts.add(account);
                }
                else
                {
                    account = new AccountID(info[0].split(":")[1],info[1]);
                    token = new LoginToken(account);
                    token.createTokenfile();
                    accounts.add(account);
                }
            }
        }
    }
    public ArrayList<String> getInput()
    {
        return input;
    }
    public ArrayList<AccountID> getAccounts()
    {
        return accounts;
    }
    public ArrayList<BusID> getBuses()
    {
        return buses;
    }
    public ArrayList<EventID> getEvents()
    {
        return events;
    }
}

























