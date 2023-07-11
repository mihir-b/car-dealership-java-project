public class Car
{
    private String brand;
    private String model;
    private String color;
    private boolean automatic;
    private int cylinders;
    private String arrivalDate;
    private String soldDate;
    private int listPrice;
    private int salePrice;
    private String soldBy;
    
    public Car(String b, String m, String c, boolean a, int cyl, String aD, int lP)
    {
        brand = b;
        model = m;
        color = c;
        automatic = a;
        cylinders = cyl;
        arrivalDate = aD;
        listPrice = lP;
    }
    
    public String getBrand()
    {
        return brand;
    }
    public String getModel()
    {
        return model;
    }
    public String getColor()
    {
        return color;
    }
    public String getSoldDate()
    {
        return soldDate;
    }
    public int getSalePrice()
    {
        return salePrice;
    }
    public String getSoldBy()
    {
        return soldBy;
    }
    
    public void setSoldDate(String nSD)
    {
        soldDate = nSD;
    }
    public void setSalePrice(int nSP)
    {
        salePrice = nSP;
    }
    public void setSoldBy(String nSB)
    {
        soldBy = nSB;
    }
    
    public String toString()
    {
        return brand+" "+model+" "+color+" auto: "+automatic+" cyl: "+cylinders+" arrival: "+arrivalDate+" list price: $"+listPrice;
    }
}