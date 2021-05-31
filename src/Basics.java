
/**
 * Write a description of class temp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Basics
{
    /**
     * this method chacks if a name and id string is valid
     *
     * @param   name_and_id
     * @return    boolean true if the name and id are valid 
     */
    public boolean validNameAndId(String name_and_id)
    {
        if(name_and_id==null||name_and_id.equals(""))
            return false;
        if(!Character.isLetter(name_and_id.charAt(0)))//i assume a name have at least one char and if the first is no letter then it return false
            return false;
        boolean id_begin = false;
        for(int i=1;i<name_and_id.length();i++)
        {
            char c = name_and_id.charAt(i);
            if(id_begin==false&&!Character.isLetter(name_and_id.charAt(i)))//if the digits didn't started yet and the current char is not letter
            {
                if(Character.isDigit(name_and_id.charAt(i))) //if we after a digit the id is begin
                {
                    id_begin = true;
                }
                else//if its not a digits its invalid
                    return false;
            }
            else if(id_begin&&!Character.isDigit(name_and_id.charAt(i)))//if we after the digit and we don't have a digit anymore
                return false;
        }
        if(id_begin==false)//if there were no digits its invalid 
            return false;
        return true;
    }

    /**
     * this method return just the name from a name and id string
     *
     * @param   name_and_id
     * @return    String name  
     */
    public String getCustomerName(String name_and_id)
    {
        String name="";
        for(int i=0;i<name_and_id.length();i++)
        {
            if(Character.isDigit(name_and_id.charAt(i)))//if it is a digit it means we can return thge name
                return name;
            name+=name_and_id.charAt(i);//if its not a digit the its still part of the name 
        }
        return name;
    }

    /**
     * this method chacks if a dish was order
     *
     * @param   order_data
     * @return    boolean true if the order_data contain mor then just: "your order is:\n"
     */
    public boolean wasDishOrder(String order_data)
    {
        if(order_data.equals("your order is:\n"))
            return false;
        return true;
    }
}
