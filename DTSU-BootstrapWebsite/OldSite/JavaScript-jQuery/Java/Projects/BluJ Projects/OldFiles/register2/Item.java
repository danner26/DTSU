
/**
 * Item
 * Holds items for cart and shop.
 */
public class Item
{
    private String name;
    private double price;
    private int id;
    
    public Item()
    {
        name = "";
        price = 0.0;
        id = 0;
    }
    public Item(String n, double p, int i)
    {
        name = n;
        price = p;
        id = i;
    }
    
    public String getName()
    {
        return name;
    }
    public double getPrice()
    {
        return price;
    }
    public int getID()
    {
        return id;
    }
    
    public void changePrice(double p)
    {
        price = p;
    }
}
