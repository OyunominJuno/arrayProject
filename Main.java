

import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        System.out.print('\u000C');
        Location loc1 = new Location("CO56Denver", 25);
        Customer cust1 = new Customer("Juno", "2066989680", 2800);
        Customer cust2 = new Customer("Ari", "2065989680", 200);
        loc1.addCustomer(cust1);
        loc1.addCustomer(cust2);
        
        loc1.getUnit(6,9).rentUnit(cust1);
        loc1.getUnit(9,7).rentUnit(cust1);
        loc1.getUnit(11,5).rentUnit(cust2);
        System.out.println(loc1.getUnit(6,9).getCustomer().getName());
        System.out.println(loc1.getUnit(9,7).getCustomer());
        System.out.println(loc1.getUnit(11,5));
        System.out.println(loc1.getCustomer(3));
        System.out.println(loc1);
    }
}
