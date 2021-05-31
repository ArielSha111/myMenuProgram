
public class Item
{
    private String _dish_name;
    private String _type;
    private String _price;
    /**
     * an empty constructor for Item
     */
    public Item()
    {
        _dish_name ="" ;
        _type = "";
        _price = "";
    }

    /**
     * a parameters constructor for Item
     * 
     * @param    dish_name, String type,String price
     */
    public Item(String dish_name, String type,String price)
    {
        _dish_name = dish_name;
        _type = type;
        _price = price;
    }

    /**
     * A get method for _dish_name
     *
     * @return    _dish_name
     */
    public String getDishName()
    {
        return _dish_name;
    }

    /**
     * A get method for _type
     *
     * @return    _type
     */
    public String getType()
    {
        return _type;
    }

    /**
     * A get method for _price
     *
     * @return    _price
     */
    public String getPrice()
    {
        return _price;
    } 
}
