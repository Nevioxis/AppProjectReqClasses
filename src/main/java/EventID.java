public class EventID 
{
    private String id, sport, discipline, category, venue, date, start, duration, bus;
    private final int eventNo;
    private static int eventCount = 0;

    public EventID()
    {
	eventCount++;
	eventNo = eventCount;	
    }

    public EventID (String EventID, String Sport, String Discipline, String Category, String Venue,
                                String  Date, String Start_time, String Duration, String Bus_Travel_Time)
    {
        id = EventID;
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
    
    public void setID(String id)
    {
        this.id = id;
    }
    
    public String getID()
    {
        return id;
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

}
