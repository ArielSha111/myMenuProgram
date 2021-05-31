import java.util.ArrayList; // import the ArrayList class
/**
 * Write a description of class b here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
    private ArrayList<Item> _appetizers;
    private ArrayList<Item> _mains;
    private ArrayList<Item> _deserts;
    private ArrayList<Item> _drinks;

    /**
     * an empty menu constructor
     */
    public Menu()
    {
        _appetizers = new ArrayList<Item>(); 
        _mains = new ArrayList<Item>();
        _deserts = new ArrayList<Item>();
        _drinks = new ArrayList<Item>();
    }

    /**
     * a parameters menu constructor
     */
    public Menu(ArrayList<Item> appetizers, ArrayList<Item>  mains, ArrayList<Item> deserts, ArrayList<Item> drinks)
    {
        _appetizers = appetizers;
        _mains = mains;
        _deserts = deserts;
        _drinks = drinks;
    }

    /**
     * A get method for _appetizers
     *
     * @return    ArrayList<Item> _appetizers
     */
    public ArrayList<Item> getAppetizers()
    {
        return _appetizers;
    }

    /**
     * A get method for _mains
     *
     * @return    ArrayList<Item> _mains
     */
    public ArrayList<Item> getMains()
    {
        return _mains;
    }

    /**
     * A get method for _deserts
     *
     * @return    ArrayList<Item> _deserts
     */
    public ArrayList<Item> getDeserts()
    {
        return _deserts;
    }

    /**
     * A get method for _drinks
     *
     * @return    ArrayList<Item> _drinks
     */
    public ArrayList<Item> getDrinks()
    {
        return _drinks;
    }

    /**
     * A add method for an item to the menu
     *
     * @param   dish
     */
    public void addItem(Item dish)
    {
        if(dish.getType() =="appetizer")
            _appetizers.add(dish);
        else if(dish.getType() =="main")
            _mains.add(dish);
        else if(dish.getType() =="desert")
            _deserts.add(dish);
        else if(dish.getType() =="drink")
            _drinks.add(dish);
    }
}
