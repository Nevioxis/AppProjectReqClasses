public class EventID 
{
    private String sport, discipline, category, venue, date, start, duration, bus;
    private final int eventNo;
    private static int eventCount = 0;

    public EventID()
    {
	eventCount++;
	eventNo = eventCount;	
    }

    public EventID (String Sport, String Discipline, String Category, String Venue,
                                String  Date, String Start_time, String Duration, String Bus_Travel_Time)
    {
        sport = Sport;
        discipline = Discipline;
        category = Category;
        venue = Venue;
        date = Date;
        start = Start_time;
        duration = Duration;
        bus = Bus_Travel_Time;
        eventCount++;
        eventNo = eventCount;
    }
    
    public int getEventNo()
    {
        return eventNo;
    }
    
    public void setSport(String sport)
    {
        this.sport = sport;
    }
    
    public String getSport()
    {
        return sport;
    }
    
    public void setDiscipline(String discipline)
    {
        this.discipline = discipline;
    }
    
    public String getDiscipline()
    {
        return discipline;
    }
    
    public void setCategory(String category)
    {
        this.category = category;
    }
    @Override
    public String toString()
    {
        return "Event " + Integer.toString(eventNo) + " : " + sport+ ", " + discipline+ ", " + category+ ", " + venue+ ", " + date+ ", " + start+ ", " + duration+ ", " + bus;
    }
}
