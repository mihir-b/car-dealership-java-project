public class SalesPerson
{
    private String name;
    private String address;
    private int carsSold;
    private int grossSales;
    private int commission;
    
    public SalesPerson(String n, String a, int c)
    {
        name = n;
        address = a;
        carsSold = c;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setCarsSold(int x)
    {
        carsSold += x;
    }
    public void setGrossSales(int x)
    {
        grossSales += x;
    }
    public void setCommission(int x)
    {
        commission += x;
    }
    
    public String toString()
    {
        return name+" "+address+" \tcars sold: "+carsSold+"  gross sales: $"+grossSales+"  commission: $"+commission;
    }
}