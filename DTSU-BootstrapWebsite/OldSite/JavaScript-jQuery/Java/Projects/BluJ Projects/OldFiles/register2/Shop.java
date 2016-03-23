import java.util.ArrayList;
/**
 * Shop
 * Shop access
 */
public class Shop
{
    private ArrayList<Item> list;
    public Shop()
    {
        list = new ArrayList<Item>();
    }
    
    public void addItem(String n, double p, int i)
    {
        Item item = new Item(n, p, i);
        list.add(item);
    }
    public void changePrice(double p, int id, String n)
    {
        int index = 0;
        boolean changed = false;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getName().equals(n) || list.get(i).getID() == id)
            {
                index = i;
                changed = true;
                break;
            }
        }
        if (changed == true)
            list.get(index).changePrice(p);
        else
            System.out.println("Error");
    }
    public double priceCheck(int id, String n)
    {
        int index = 0;
        boolean changed = false;
        double price = 0.0;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getName().equals(n) || list.get(i).getID() == id)
            {
                index = i;
                changed = true;
                break;
            }
        }
        if (changed == true)
            price = list.get(index).getPrice();
        else
            System.out.println("Error");
        return price;
    }
    public void removeItem(int id, String n)
    {
        int index = 0;
        boolean changed = false;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getName().equals(n) || list.get(i).getID() == id)
            {
                index = i;
                changed = true;
                break;
            }
        }
        if (changed == true)
            list.remove(index);
    }
}
