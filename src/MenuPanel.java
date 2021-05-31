import javax.swing.*;  
import java.awt.*;  
import java.util.ArrayList; // import the ArrayList class
public class MenuPanel extends JPanel
{
    private final String options[]={"1","2","3","4","5","6","7","8","9","10"};//setting the amount of options for the combo box
    private Color my_yellow = new Color(255, 255, 204); // Color yellow
    /**
     * A method to create the panel for the labels of the dishes
     *
     * @param   type what label is needed
     * @return    JPanel the panel for the certain dish label
     */
    private JPanel createDishesTopPanel(String type)
    {
        //create a panel for the label(dish type amin or lasts and so on)
        JPanel dishes_label = new JPanel();
        dishes_label.setBackground(my_yellow);//give it a yellow background     
        dishes_label.add(new JLabel(type));//add the needed label for the panel

        //create a panel for the top of the menu while adding the label in the middle
        //and create gaps on the sides using drawing on east and west borders
        JPanel dishes_top_panel = new JPanel();
        dishes_top_panel.setLayout(new BorderLayout());//change the layout of the panel to be grid
        dishes_top_panel.add(dishes_label, BorderLayout.CENTER);//add the bottom panel to the bottom
        dishes_top_panel.add(new BackPanel(Color.WHITE), BorderLayout.WEST);//add the bottom panel to the bottom
        dishes_top_panel.add(new BackPanel(Color.WHITE), BorderLayout.EAST);//add the bottom panel to the bottom
        return dishes_top_panel;
    }

    /**
     * A method to create the panel for the dish it self
     *
     * @param   menu_type, ArrayList<Item> dishes, int list_size, JCheckBox [] check_box_arr, JComboBox[] combo_box_arr
     * @return    JPanel the panel for the certin dish
     */
    private JPanel createDishesMiddlePaanel(JPanel menu_type, ArrayList<Item> dishes, int list_size, JCheckBox [] check_box_arr, JComboBox[] combo_box_arr)
    {
        //create the middle panel
        JPanel dishes_middle_panel = new JPanel();//create a panel for the button for it to be in the middle of it
        dishes_middle_panel.setLayout(new GridLayout((list_size),1));//change the layout of the panel to be grid
        dishes_middle_panel.setBackground(Color.WHITE);
        int arr_index = 0;
        if(dishes==null)
            return dishes_middle_panel;
        for(int i=0;i<list_size;i++)//loop on all the dishes name since list is first dish and then price we can skip the prices
        {
            JPanel boxs_panel = new JPanel();//create a panel for the button for it to be in the middle of it
            boxs_panel.setLayout(new BorderLayout());//chang the layout of the panel to be grid
            boxs_panel.setBackground(Color.WHITE);//add white background

            JCheckBox new_check_box = new JCheckBox(dishes.get(i).getDishName()+", price: ("+ dishes.get(i).getPrice() + ")");
            new_check_box.setBackground(Color.WHITE);

            JComboBox new_combo_box=new JComboBox(options); 
            new_combo_box.setBackground(Color.WHITE);

            //add the check box and the combo box to the needed arrays
            check_box_arr[arr_index] = new_check_box;
            combo_box_arr[arr_index++] = new_combo_box;//add one to index at the end 

            boxs_panel.add(new_check_box, BorderLayout.CENTER);
            boxs_panel.add(new_combo_box, BorderLayout.EAST);
            //add the certain dish with the check and combo boxes
            dishes_middle_panel.add(boxs_panel); 
        }
        return dishes_middle_panel;
    }

    /**
     * this method receive various parameter and change one of them in order to create a menu for a certain dish
     * while updating what boxes(check or combo) are needed and where
     *
     * 
     */
    public void createDishPanel(JPanel menu_type, ArrayList<Item> dishes, int list_size, String type, JCheckBox [] check_box_arr, JComboBox[] combo_box_arr)
    {  
        menu_type.setLayout(new BorderLayout());
        menu_type.add(createDishesTopPanel(type), BorderLayout.NORTH);//add the bottom panel to the bottom
        menu_type.add(createDishesMiddlePaanel(menu_type, dishes, list_size, check_box_arr, combo_box_arr), BorderLayout.CENTER);//add the bottom panel to the bottom
    }
}