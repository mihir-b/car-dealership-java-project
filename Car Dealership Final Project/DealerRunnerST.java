import java.util.Scanner;
import static java.lang.System.*;

public class DealerRunnerST 
{
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        int selection = 0;
        int spot = 50;
        
        Car[] lot = createCarList("01/05/2022",10);
        Car[] sold = new Car[20];
        SalesPerson[] salesTeam = createSalesTeam();
        
        while(selection != 5)
        { //start while
            printMenu();
            selection = keyboard.nextInt();
            System.out.println();
        
            if(selection == 1)
                printLot(lot);
            if(selection == 2)
                printSalesDetail(sold, salesTeam);
            if(selection == 3)
                printSalesPeople(salesTeam);
            if(selection == 4)
            {
                spot = soldCar(lot,sold,salesTeam,keyboard);
                lot[spot] = createCarList(lot[spot].getSoldDate(),1)[0];
                System.out.println("\nA " + lot[spot] + "\nwas just added to the lot in spot " + spot + "\n");
            }   
        } //end while
        
        System.out.println("\nGoodbye\n");
        

    }
    //Create methods here:
    public static Car[] createCarList(String date, int numCars)
    {
        Car[] lot = new Car[numCars];
        
        String brand = "Tesla";
        String[] models = {"Model S","Model 3","Model X","Model Y"};
        String[] colors = {"Red","White","Black","Blue"};
        boolean[] automatic = {true,false};
        int[] cylinders = {4,6,8};
        int[] listPrices = {15200,17980,19270,23500,29700,33450,39000};
        
        for(int i = 0; i < numCars; i++)
        {
            lot[i] = new Car(brand,models[(int)(Math.random()*models.length)],colors[(int)(Math.random()*colors.length)],automatic[(int)(Math.random()*automatic.length)],cylinders[(int)(Math.random()*cylinders.length)],date,listPrices[(int)(Math.random()*listPrices.length)]);
        }
        
        return lot;
    }
    public static SalesPerson[] createSalesTeam()
    {
        SalesPerson[] salesTeam = new SalesPerson[3];
        
        String[] names = {"David","Kate","Megan"};
        String[] addresses = {"101 Mockingbird Lane","201 South Crusher St.","301 Pigs Can Fly Ave"};
        int[] numCarsSold = {0,0,0};
        
        for(int i = 0; i < 3; i++)
        {
            salesTeam[i] = new SalesPerson(names[i],addresses[i],numCarsSold[i]);
        }
        
        return salesTeam;
    }
    public static void printMenu()
    {
        out.println("\nTesla Auto Dealer System v1.0");
        out.println();
        out.println("  1 Print list of cars on the lot\n  2 Print sold list by sales person\n  3 Print sales person list with sales data\n  4 Record the sale of a car\n  5 Exit the system\n\n");
        out.print("Select a menu option: ");
    }
    public static void printLot(Car[] lot)
    {
        out.print("\nCars on the lot:\n");
        for(int i = 0; i < lot.length; i++)
        {
            out.println(i + " " + lot[i]);
        }
    }
    public static void printSalesDetail(Car[] sold, SalesPerson[] salesTeam)
    {
        for(int i = 0; i < salesTeam.length; i++)
        {
            out.println(salesTeam[i].getName()+" has sold : ");
            if(sold[0] != null)
            {
                for(int j = 0; sold[j] != null; j++)
                {
                    if(sold[j].getSoldBy().equals(salesTeam[i].getName()))
                        out.println(sold[j].getBrand() + " " + sold[j].getModel() + " " + sold[j].getColor() + " sold on: " + sold[j].getSoldDate() + " for $" + sold[j].getSalePrice());
                }
            }
            out.println();
        }
    }
    public static void printSalesPeople(SalesPerson[] salesTeam)
    {
        for(int i = 0; i < salesTeam.length; i++)
        {
            out.println(i + " " + salesTeam[i]);
        }
    }
    public static int soldCar(Car[] lot, Car[] sold, SalesPerson[] salesTeam, Scanner keyboard)
    {
        printLot(lot);
        int spot = 0;
        int salesSpot = 0;
        out.print("\nEnter the number of the car that you have sold: ");
        spot = keyboard.nextInt();
        
        printSalesPeople(salesTeam);
        out.print("\nWhich salesperson sold the car? ");
        salesSpot = keyboard.nextInt();
        out.print("\nWhat was the sales date? ");
        keyboard.nextLine();
        lot[spot].setSoldDate(keyboard.nextLine());
        out.print("\nWhat was the sales price? ");
        lot[spot].setSalePrice(keyboard.nextInt());
        
        out.println();
        
        salesTeam[salesSpot].setCommission(lot[spot].getSalePrice()/10);
        salesTeam[salesSpot].setGrossSales(lot[spot].getSalePrice());
        salesTeam[salesSpot].setCarsSold(1);
        
        printSalesPeople(salesTeam);
        
        for(int i = 0; i < sold.length; i++)
        {
            if(sold[i] == null)
            {
                sold[i] = lot[spot];
                sold[i].setSoldBy(salesTeam[salesSpot].getName());
                return spot;
            }
        }
        return spot;
    }
}