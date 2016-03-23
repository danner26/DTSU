import TerminalIO.KeyboardReader;
public class Register
{
     public static void main(String args[])
    {
       KeyboardReader reader = new KeyboardReader();
       String category, name, Continue;
       int items = 0;
       double finalCost = 0.00, totalCost = 0.00;
       name = reader.readLine("What is your name?   ");
       System.out.println("Welcome " + name + "! I'm your handy little shopping calculator! We at Little Bit of Everything welcome you! Enjoy your time.");
       Continue = reader.readLine("To continue shopping, type continue; to stop shopping and finilize your order, please type stop.     ");
       if (Continue.equalsIgnoreCase("continue"))
       {
           totalCost = calculate();
           finalCost += totalCost;
           items++;
           System.out.println(items + finalCost);
           Continue = reader.readLine("To continue shopping, type continue; to stop shopping and finilize your order, please type stop.     ");
           if (Continue.equalsIgnoreCase("continue"))
       {
           totalCost = calculate();
           finalCost += totalCost;
           items++;
       }
       else if (Continue.equalsIgnoreCase("stop"))
       {
           
       }
       else
       {
            System.out.println("It seems you have incountered an error. Please restart the application");
       }   
       }
       else if (Continue.equalsIgnoreCase("stop"))
       {
           
       }
       else
       {
            System.out.println("It seems you have incountered an error. Please restart the application");
       }   
    }
    public static double calculate()
    {
        KeyboardReader reader = new KeyboardReader();
        String category, item, mOrF;
        int numOfItem;
        double doubleNumOfItem;
        double totalCost = 0.00;
        System.out.println("Please select a item category. \n 1. Household Items (HH) \n 2. Toiletries (T) \n 3. Food (F) \n 4. Plants (P) \n 5. Animals (A) \n 6. Clothing (C)");
        category = reader.readLine("Please enter the name or short name (letters in perentheses):    ");
        if (category.equalsIgnoreCase("household items") ||category.equalsIgnoreCase("household") || category.equalsIgnoreCase("hh"))
        {
            item = reader.readLine("1. Toilet Paper \n 2. Tissues \n Please type the name of the item:  ");
            if (item.equalsIgnoreCase("toilet paper"))
            {
                numOfItem = reader.readInt ("How many " + item + " rolls would you like?    ");
                totalCost = numOfItem * 10.99;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Tissues"))
            {
                numOfItem = reader.readInt ("How many " + item + " boxes would you like?    ");
                totalCost = numOfItem * 1.29;
                return totalCost;
            }
            else
            {
                System.out.println("There seems to be an error in the number you entered. Please restart");
                calculate();
            }
        }
        else if (category.equalsIgnoreCase("toiletries") || category.equalsIgnoreCase("t"))
        {
            item = reader.readLine("1. Hairspray \n 2. Tooth Paste \n 3. Shampoo \n 4. Contact Lens Solution \n Please type the name of the item:  ");
            if (item.equalsIgnoreCase("Hairspray"))
            {
                numOfItem = reader.readInt ("How many " + item + " bottles would you like?    ");
                totalCost = numOfItem * 9.99;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Tooth Paste"))
            {
                numOfItem = reader.readInt ("How many " + item + " tubes would you like?    ");
                totalCost = numOfItem * 2.49;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Shampoo"))
            {
                numOfItem = reader.readInt ("How many " + item + " bottles would you like?    ");
                totalCost = numOfItem * 2.99;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Contact Lens Solution"))
            {
                numOfItem = reader.readInt ("How many " + item + "s would you like?    ");
                totalCost = numOfItem * 7.99;
                return totalCost;
            }
            else
            {
                System.out.println("There seems to be an error in the number you entered. Please restart");
                calculate();
            }
        }
        else if (category.equalsIgnoreCase("food") || category.equalsIgnoreCase("f"))
        {
            item = reader.readLine("1. Chocolate \n 2. Milk \n 3. Bread \n 4. Ice Cream \n 5. Potatoe Chips \n 6. Tomatoes \n 7. Water \n 8. Steak \n 9. Lobster \n 10. Orange Juice \n 11. Soup \n Please type the name of the item:  ");
            if (item.equalsIgnoreCase("Chocolate"))
            {
                numOfItem = reader.readInt ("How many " + item + " bars would you like?    ");
                totalCost = numOfItem * 1.00;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Milk"))
            {
                numOfItem = reader.readInt ("How many " + item + " catrons would you like?    ");
                totalCost = numOfItem * 2.99;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Bread"))
            {
                numOfItem = reader.readInt ("How many " + item + " baskets would you like?    ");
                totalCost = numOfItem * 2.49;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Ice Cream"))
            {
                numOfItem = reader.readInt ("How many " + item + " tubs would you like?    ");
                totalCost = numOfItem * 1.99;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Potatoe Chips"))
            {
                numOfItem = reader.readInt ("How many " + item + " bags would you like?    ");
                totalCost = numOfItem * 1.99;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Tomatoes"))
            {
                doubleNumOfItem = reader.readInt ("How many pounds of " + item + " would you like?    ");
                totalCost = doubleNumOfItem * 2.00;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Water"))
            {
                numOfItem = reader.readInt ("How many " + item + " cases would you like?    ");
                totalCost = numOfItem * 1.00;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Steak"))
            {
                doubleNumOfItem = reader.readInt ("How many pounds of " + item + " would you like?    ");
                totalCost = doubleNumOfItem * 5.99;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Lobster"))
            {
                doubleNumOfItem = reader.readInt ("How many pounds of " + item + " would you like?    ");
                totalCost = doubleNumOfItem * 6.99;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Orange Juice"))
            {
                numOfItem = reader.readInt ("How many " + item + " cartons would you like?    ");
                totalCost = numOfItem * 2.99;
                return totalCost;
            }
            else if (item.equalsIgnoreCase("Soup"))
            {
                numOfItem = reader.readInt ("How many " + item + " cans would you like?    ");
                totalCost = numOfItem * 1.99;
                return totalCost;
            }
            else
            {
                System.out.println("There seems to be an error in the number you entered. Please restart");
                calculate();
            }
        }
        else if (category.equalsIgnoreCase("plants") || category.equalsIgnoreCase("plant") || category.equalsIgnoreCase("p"))
        {
            item = reader.readLine("1. Tulips \n Please type the name of the item:  ");
            if (item.equalsIgnoreCase("Tulips"))
            {
                numOfItem = reader.readInt ("How many " + item + " would you like?    ");
                totalCost = numOfItem * 1.00;
                return totalCost;
            }
            else
            {
                System.out.println("There seems to be an error in the number you entered. Please restart");
                calculate();
            }
        }
        else if (category.equalsIgnoreCase("animals") || category.equalsIgnoreCase("animal") || category.equalsIgnoreCase("a"))
        {
            item = reader.readLine("1. Dog Food \n Please type the name of the item:  ");
            if (item.equalsIgnoreCase("dog food"))
            {
                numOfItem = reader.readInt ("How many " + item + " bags would you like?    ");
                totalCost = numOfItem * 27.99;
                return totalCost;
            }
            else
            {
                System.out.println("There seems to be an error in the number you entered. Please restart");
                calculate();
            }
        }
        else if (category.equalsIgnoreCase("clothing") || category.equalsIgnoreCase("c"))
        {
            item = reader.readLine("1. Underwear \n Please type the name of the item:  ");
            if (item.equalsIgnoreCase("Underwear"))
            {
                mOrF = reader.readLine("Male underwear or female underwear?     ");
                if (mOrF.equalsIgnoreCase("male"))
                {
                    numOfItem = reader.readInt ("How many " + item + " would you like?    ");
                    totalCost = numOfItem * 8.99;
                    return totalCost; 
                }
                else if (mOrF.equalsIgnoreCase("female"))
                {
                    numOfItem = reader.readInt ("How many " + item + " would you like?    ");
                    totalCost = numOfItem * 7.99;
                    return totalCost;
                }
                else
                {
                    System.out.println("Error. Wrong input. Please retry");
                    calculate();
                }
                
            }
            else
            {
                System.out.println("There seems to be an error in the number you entered. Please restart");
                calculate();
            }
        }
        else
        {
            System.out.println("Sorry invalid entry please try again!");
            calculate();
        }
        return totalCost;
    }
 }
   