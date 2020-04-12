public class BusID
{
    private String busType;
    private String destination, departureTime; 
    private int busTravelTime, rows, columns, cost,costPremium,seatPremium;
    private final int busNo;
    private static int busCount = 0;
    public BusID()
    {
        busCount++;
        busNo = busCount;
    }
    public BusID(String bt,String d,String dt,int btt,int r,int c,String cost,String pcost,int pseat)
    {
        this.busType = bt;
        this.destination = d;
        this.departureTime= dt;
        this.busTravelTime= btt;
        rows = r;
        this.columns = c;
        this.cost = Integer.parseInt(cost.replace("B", ""));
        this.costPremium = Integer.parseInt(cost.replace("B", ""));;
        this.seatPremium = pseat;
        busCount++;
        busNo = busCount;
    }
    public BusID(String bt,String d,String dt,int btt,int r,int c,String cost)
    {
        this.busType = bt;
        this.destination = d;
        this.departureTime= dt;
        this.busTravelTime= btt;
        rows = r;
        this.columns = c;
        this.cost = Integer.parseInt(cost.replace("B", ""));;
        this.costPremium = 0;
        this.seatPremium = 0;
        busCount++;
        busNo = busCount;
    }
    public void setBusType(String bt)
    {
        this.busType = bt;
    }
    public void setDestination(String d)
    {
        this.destination = d;
    }
    public void setDepartureTime(String dt)
    {
        this.departureTime= dt;
    }
    public void setBusTravelTime(int btt)
    {
        this.busTravelTime= btt;
    }
    public void setRows(int r)
    {
        rows = r;
    }
    public void setColumns(int c)
    {
        this.columns = c;
    }
    public void setCost(int cost)
    {
        this.cost = cost;
    }
    public void setCostPremium(int pcost)
    {
        this.costPremium = pcost;
    }
    public void setSeatPremium(int pseat)
    {
        this.seatPremium = pseat;
    }
    public String getBusType()
    {
        return this.busType;
    }
    public String getDestination()
    {
        return this.destination;
    }
    public String getDepartureTime()
    {
        return this.departureTime;
    }
    public int getBusTravelTime()
    {
        return this.busTravelTime;
    }
    public int getRows()
    {
        return rows;
    }
    public int getColumns()
    {
        return this.columns;
    }
    public int getCost()
    {
        return this.cost ;
    }
    public int getCostPremium()
    {
        return this.costPremium;
    }
    public int getSeatPremium()
    {
        return this.seatPremium;
    }
    public int getBusNO()
    {
        return this.busNo;
    }
    @Override
    public String toString()
    {
       if(seatPremium == 0)
       {
           return "Bus " + Integer.toString(busNo) + ": " +  "Type " + busType + ",\t\t" + destination  + ",\t\t\t\t" + departureTime + ",\t\t" + Integer.toString(busTravelTime)+ ",\t\t\t" 
               + Integer.toString(rows) + ",\t\t" + Integer.toString(columns)+ ",\t\t" + "B" + Integer.toString(cost);
       }
       else
       {
           return "Bus " + Integer.toString(busNo) + ": " +  "Type " + busType + ",\t\t" + destination  + ",\t\t\t\t" + departureTime + ",\t\t" + Integer.toString(busTravelTime)+ ",\t\t\t" 
               + Integer.toString(rows) + ",\t\t" + Integer.toString(columns)+ ",\t\t" + "B" + Integer.toString(cost) + ",\t\t" + "B" + Integer.toString(costPremium)+ ",\t\t" + Integer.toString(seatPremium);
       }
    }
}


