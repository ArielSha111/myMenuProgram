import javax.swing.*;  
import java.awt.event.*; 
import java.util.ArrayList; 

public class Actions
{

    /**
     * this method return a price of the dish that orderd
     *
     * @param   e,int dish_size, JCheckBox[] dish_check_box , JComboBox[] dish_combo_box, ArrayList<Item> dishes_list, double total_price
     * @return    double the total price for the dishes and the previous price
     */
    public double CertinDishActionPerformed(ActionEvent e,int dish_size, JCheckBox[] dish_check_box , JComboBox[] dish_combo_box, ArrayList<Item> dishes_list, double total_price)
    { 
        String currnt_amount = "";
        for(int i=0;i<dish_size;i++)
        {
            if(dish_check_box[i].isSelected())
            {                  
                currnt_amount = ""+ dish_combo_box[i].getItemAt(dish_combo_box[i].getSelectedIndex());
                total_price+=(Integer.parseInt(currnt_amount) * Double.parseDouble(dishes_list.get(i).getPrice()));//add to total price the price of current dish times its ammount in the order
            }  
        }
        return total_price;
    }

    /**
     * this method return the order details as sting
     *
     * @param   e,int dish_size, JCheckBox[] dish_check_box , JComboBox[] dish_combo_box, ArrayList<Item> dishes_list,String order_data
     * @return    String the order data
     */
    public String CertinDishActionPerformed(ActionEvent e,int dish_size, JCheckBox[] dish_check_box , JComboBox[] dish_combo_box, ArrayList<Item> dishes_list,String order_data)
    { 
        String currnt_amount;
        boolean current_type_orderd = false;
        for(int i=0;i<dish_size;i++)
        {
            if(dish_check_box[i].isSelected())
            {    
                current_type_orderd = true;
                currnt_amount = ""+ dish_combo_box[i].getItemAt(dish_combo_box[i].getSelectedIndex());
                order_data +=currnt_amount+"*"+dishes_list.get(i).getDishName()+", ";                    
            }  
        }
        if(current_type_orderd)//if this type of dishes is been orderd at least once
        {
            order_data = order_data.substring(0,order_data.length()-2);//delete the last ',' by cutting the last char of order_data
            order_data+="\n";//add enter to the order
        }
        return order_data;
    }
}
