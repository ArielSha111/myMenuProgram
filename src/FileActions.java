import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList; // import the ArrayList class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import javax.swing.*;  
public class FileActions
{
    private Menu _menu;
    private final String FILE_TO_BE_OPEN = "menu.txt";
    /**
     * an empty constructor for FileActions
     */
    public FileActions()
    {
        _menu = new Menu();
    }

    /**
     * a method to read items from a file named menu.txt
     */
    public void readItems()
    {        
        String p_description;//the Product description
        String p_Type;//the Product type
        String p_price;//the Product price
        try
        {
            Scanner input = new Scanner(new File(FILE_TO_BE_OPEN)); //open the needed file and make it readable
            while (input.hasNext())//as long as there is what to read
            {
                p_description = input.nextLine();//we read it and save it as p_description
                if(!p_description.equals("")&&input.hasNext())//as long as the first line is not an empty line and there is a 2nd line
                {
                    p_Type = input.nextLine();//we read it and save it as p_Type
                    if(input.hasNext())//as long as there is another line to read
                    {
                        p_price = input.nextLine();//we read it and save it as p_price
                        if(p_Type.equals("appetizer"))//if the type is first
                        {
                            Item item = new Item(p_description,"appetizer",p_price);
                            _menu.addItem(item);
                        }
                        else if(p_Type.equals("main"))//same for main
                        {
                            Item item = new Item(p_description,"main",p_price);
                            _menu.addItem(item);
                        }
                        else if(p_Type.equals("desert"))//same for last
                        {
                            Item item = new Item(p_description,"desert",p_price);
                            _menu.addItem(item);
                        }
                        else if(p_Type.equals("drink"))//same for beverage
                        {
                            Item item = new Item(p_description,"drink",p_price);
                            _menu.addItem(item);
                        }
                        else
                        {
                            System.out.println("the program found a non defined dish type in your menu file make sure to fix it before trying to order. ");
                            System.out.println("the undefined dish type is: "+ p_Type);
                            System.exit(0);
                        }
                    }
                }
            } 
            input.close();
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("can not find the menu file (may not be exists or maybe not located in this project files).");
            System.exit(0);
        }
    }

    /**
     * a method to write items to a file
     *
     * @param   order_data, String name_and_id
     */
    public void writeItems(String order_data, String name_and_id)
    {
        try 
        {
            File file = new File(name_and_id+".txt");
            file.createNewFile();
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(null,"couldn't create the file.");
        }
        try 
        {
            FileWriter myWriter = new FileWriter(name_and_id+".txt");
            myWriter.write("order for-"+ name_and_id+"\n"+order_data);
            myWriter.close();
            JOptionPane.showMessageDialog(null, "your order been sent to the kitchen enjoy");
        } 
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "couldn't write in the file.");
        }
    }

    public Menu getMenu()
    {
        return _menu;
    }
}
