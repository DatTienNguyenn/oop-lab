package Lab03;

import java.util.ArrayList;
import java.util.List;

public class cart {
    public static final int Max_number_order = 20;
    private List<DigitalVideosDics> itemOrdered = new ArrayList<>(); 
    
    public void addDigitalVideosDics (DigitalVideosDics disc)
    {   
        if ( itemOrdered.size() == Max_number_order)
            { 
             System.out.println("The cart is almost full");
             return;
            }
        else 
           {
            itemOrdered.add(disc);
            System.out.println("The disc has been added");
           }
    }

    public void removeDigitalVideosDics (DigitalVideosDics disc) {
        if (itemOrdered.size() == 0) {
            System.out.println("The cart is empty");
            return;
        }
        else {
            itemOrdered.remove(disc);
            System.out.println("The disc has been removed");
        }
    }

    public float totalCost ()
    {  
        float total =0;
        for (DigitalVideosDics disc : itemOrdered) {
            total += disc.getCost();
        }
        return total;
    }
}
