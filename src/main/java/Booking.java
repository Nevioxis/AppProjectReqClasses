import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Booking 
{
    private final AccountID bookingUser;
    private final BusID bookingBus;
    private final EventID bookingEvent;
    private String[] seats;
    private final String bookingBusFile;
    public Booking(AccountID bu,BusID bb, EventID be) throws IOException
    {
        this.seats = new String[2];
        bookingUser = bu;
        bookingBus = bb;
        bookingEvent = be;
        this.seats = new String[2];
        bookingBusFile = this.bookingUser.getUesrID() + "_" + this.bookingEvent.getSport() + "_" + this.bookingEvent.getDiscipline() + "_" + this.bookingBus.getBusNO() + ".txt";
        File x = new File(bookingBusFile);
        x.createNewFile();
    }
    public void loadSeats() throws FileNotFoundException
    {
        File x = new File(bookingBusFile);
        String[] r = new String[2];
        r[0] = null;
        r[1] = null;
        int i = 0;
        Scanner read = new Scanner(x);
        while(read.hasNextLine())
        {
            r[i] = read.nextLine();
            i++;
        }
        System.arraycopy(r, 0, seats, 0, 2);
        read.close();
    }
    public boolean isThisseatAvailable(String s) throws FileNotFoundException
    {
        if(Arrays.asList(seats).contains(s)) return false;
        else
        {
            FileP v = new FileP("UserList.txt");
            ArrayList<String> user = v.readLines();
            for(String i : user)
            {
                File n = new File(this.bookingBusFile.replace(this.bookingUser.getUesrID(), i));
                FileP c = new FileP(this.bookingBusFile.replace(this.bookingUser.getUesrID(), i));
                if(n.exists())
                {
                    ArrayList<String> seat = c.readLines();
                    if(seat.contains(s)) return false;
                }
            }
            return true;
        }
    }
    public boolean addSeat(ArrayList<String> seat)
    {
        return !seat.isEmpty() && seat.size() <= 2 && Arrays.asList(seats).contains(null);
    }
    public String addingSeatError(ArrayList<String> seat)
    {
        if(!Arrays.asList(seats).contains(null)) return "You've already booked on the maximum numbers of seat.";
        if(seat.isEmpty()) return "Please select a seat!";
        else return "You select too many seats!";
    }
}


