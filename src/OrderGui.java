import javax.swing.*;  
import java.awt.event.*; 
import java.awt.*; 
import java.util.ArrayList; // import the ArrayList class

public class OrderGui extends JPanel
{ 
    //creating a file reader for the prog
    private FileActions files = new FileActions();
    //declaring a menu for the prog
    private Basics basics = new Basics();
    private Actions actions = new Actions();
    private Menu menu;
    //create the needed sizes
    private int a_size, m_size, de_size, dr_size;

    //creating a global panel for the menu
    private MenuPanel menu_panel = new MenuPanel();

    //declare the boxes(combo and check) arrays
    private JCheckBox[] firsts_check_box, mains_check_box,lasts_check_box, beverages_check_box;
    private JComboBox[] firsts_combo_box, mains_combo_box, lasts_combo_box, beverages_combo_box;
    //create the panel for the menu parts
    private JPanel middle_panel = new JPanel();
    //create the buttons
    private JButton cmdOrder = new JButton("Order"), cmdLeave = new JButton("Leave");
    //declare the current frame
    private JFrame _menu;
    //create the size for the frame
    private static final int FRAME_WIDTH=500;
    private static final int FRAME_LENGTH=650;
    //create some colors for the program
    private Color my_red = new Color(255, 51, 51), my_green = new Color(0, 204, 0), my_gray = new Color(204, 204, 204);
    private boolean ordered ;

    private JPanel buttons_panel;
    public OrderGui()
    {        
        files.readItems();//take the needed menu from the file reader
        menu= files.getMenu();//give the prog menu the needed menu
        //give the needed sizes there value
        a_size = menu.getAppetizers().size();
        m_size = menu.getMains().size();
        de_size = menu.getDeserts().size();
        dr_size = menu.getDrinks().size();
    }

    private JPanel menu_panel()
    {
        //restarting the ordered boolean to be false since its a new menu_panel
        ordered= false;

        //create a new boxes arrays to start from scratch
        firsts_check_box = new JCheckBox[a_size];
        mains_check_box = new JCheckBox[m_size];
        lasts_check_box = new JCheckBox[de_size];
        beverages_check_box = new JCheckBox[dr_size];
        //create a new boxes arrays to start from scratch
        firsts_combo_box = new JComboBox[a_size];
        mains_combo_box = new JComboBox[m_size];
        lasts_combo_box = new JComboBox[de_size];
        beverages_combo_box = new JComboBox[dr_size];

        //creates the firsts menu part
        JPanel firsts_menu = new JPanel();
        menu_panel.createDishPanel(firsts_menu,menu.getAppetizers(),a_size, "appetizers",firsts_check_box, firsts_combo_box);

        //creates the mains menu part
        JPanel mains_menu = new JPanel();        
        menu_panel.createDishPanel(mains_menu,menu.getMains(),m_size, "mains",mains_check_box, mains_combo_box);

        //creates the lasts menu part
        JPanel lasts_menu = new JPanel();
        menu_panel.createDishPanel(lasts_menu,menu.getDeserts(),de_size, "deserts",lasts_check_box, lasts_combo_box);

        //creates the beverages menu part
        JPanel beverages_menu = new JPanel();
        menu_panel.createDishPanel(beverages_menu,menu.getDrinks(),dr_size, "drinks",beverages_check_box, beverages_combo_box);
        //creates the middle panel for the menu

        JPanel middle_panel = new JPanel();
        middle_panel.setLayout(new GridLayout(2,2));//change the layout of the panel to be grid 
        middle_panel.add(firsts_menu);
        middle_panel.add(mains_menu);
        middle_panel.add(lasts_menu);
        middle_panel.add(beverages_menu); 
        return middle_panel;
    }

    private JFrame openMenu2(JPanel buttons_panel)
    { 
        //creates the middle panel for the menu
        middle_panel = menu_panel();

        //add both the middle part and the bottom part together
        JPanel all_panel;
        all_panel = new JPanel();//create a panel for the button for it to be in the middle of it
        all_panel.setLayout(new BorderLayout());//chang the layout of the panel to be grid
        all_panel.setBackground(Color.WHITE);//add white background
        all_panel.add(middle_panel, BorderLayout.CENTER);//add the middle panel to the middle
        all_panel.add(buttons_panel, BorderLayout.SOUTH);//add the buttons panel to the bottom

        JFrame frame = new JFrame("Ariel's restaurant menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH,FRAME_LENGTH); 
        frame.setLocation(700,200);

        frame.setLayout(new BorderLayout());//chang the layout of the panel to be grid
        frame.setBackground(Color.WHITE);//add white background
        frame.add(all_panel, BorderLayout.CENTER);//add the middle panel to the middle
        frame.add(new BackPanel(my_gray), BorderLayout.SOUTH);//add the bottom panel to the bottom
        frame.add(new BackPanel(my_gray), BorderLayout.NORTH);//add the bottom panel to the bottom
        frame.add(new BackPanel(my_gray), BorderLayout.EAST);//add the bottom panel to the bottom
        frame.add(new BackPanel(my_gray), BorderLayout.WEST);//add the bottom panel to the bottom
        return frame;
    }

    public void openMenu()
    {        
        //create a listener
        Listener lis = new Listener();
        //add the lis to order button
        cmdOrder.setBackground(my_green); 
        cmdOrder.addActionListener(lis);
        //smae with leave button
        cmdLeave.setBackground(my_red);
        cmdLeave.addActionListener(lis);

        //creates the buttom panel for the order button
        buttons_panel = new JPanel();//create a panel for the button for it to be in the middle of it
        buttons_panel.add(cmdOrder);//add the top panel to the bottom
        buttons_panel.add(cmdLeave);//add the top panel to the bottom
        buttons_panel.setBackground(Color.WHITE);
        _menu = openMenu2(buttons_panel);        
        _menu.setVisible(true); 
    }

    private class Listener extends MouseAdapter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {   
            if(e.getSource()==cmdLeave)//if user decided to leave
                System.exit(0); //exit program
            else if(e.getSource()==cmdOrder)//if he decided to order
            {
                String order_data="your order is:\n";
                double total_price = 0; 
                //we will checks all the firsts check and combo box and update the order and the total price
                order_data = actions.CertinDishActionPerformed(e,a_size,firsts_check_box ,firsts_combo_box,menu.getAppetizers(), order_data);
                total_price = actions.CertinDishActionPerformed(e,a_size,firsts_check_box ,firsts_combo_box,menu.getAppetizers(), total_price);
                //same withe mains
                order_data = actions.CertinDishActionPerformed(e,m_size,mains_check_box ,mains_combo_box,menu.getMains(), order_data);
                total_price = actions.CertinDishActionPerformed(e,m_size, mains_check_box ,mains_combo_box,menu.getMains(), total_price);
                //same withe lasts
                order_data = actions.CertinDishActionPerformed(e,de_size,lasts_check_box ,lasts_combo_box,menu.getDeserts(), order_data);
                total_price = actions.CertinDishActionPerformed(e,de_size,lasts_check_box ,lasts_combo_box,menu.getDeserts(), total_price);
                //same withe beverages
                order_data = actions.CertinDishActionPerformed(e,dr_size,beverages_check_box ,beverages_combo_box,menu.getDrinks(), order_data);
                total_price = actions.CertinDishActionPerformed(e,dr_size,beverages_check_box ,beverages_combo_box,menu.getDrinks(), total_price);

                ordered=basics.wasDishOrder(order_data);
                if(!ordered)//if the user didn't ordered anything
                {
                    JOptionPane.showMessageDialog(null, "you didn't ordered nothing try to order anything");
                }
                else
                {
                    order_data+="the total price is: "+total_price;
                    String[] options = {"order", "cancel", "update"};
                    int decision =-1;
                    decision = JOptionPane.showOptionDialog(null, order_data,"Click a button",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);  
                    if(decision==0)
                    {
                        String name_and_id;
                        boolean order_canceled = false;
                        while(true)
                        {
                            name_and_id=JOptionPane.showInputDialog(null,"Enter Name plus id number for example ariel318966074 make sure\n"+
                                "to have no gaps after it or before it and in between the id and name\n"+
                                "if the given file is exist it will be over written");
                            if(name_and_id==null)//if the user didn't gave any input he can keep order
                            {
                                JOptionPane.showMessageDialog(null,"this order is canceled.","error", JOptionPane.ERROR_MESSAGE);
                                order_canceled=true;
                                break;
                            }
                            else
                            if(!basics.validNameAndId(name_and_id))
                                JOptionPane.showMessageDialog(null,"this is non valid input try again.","error", JOptionPane.ERROR_MESSAGE);
                            else 
                                break;
                        } 
                        if(order_canceled ==false)
                            files.writeItems(order_data, basics.getCustomerName(name_and_id));
                        //restart
                        _menu.dispose();
                        _menu = openMenu2(buttons_panel);        
                        _menu.setVisible(true); 
                        // _menu.setVisible(true); 
                    }
                    else if(decision==1||decision==-1)
                    {
                        JOptionPane.showMessageDialog(null, "good bey"); 
                        //restart
                        _menu.dispose();
                        _menu = openMenu2(buttons_panel);        
                        _menu.setVisible(true); 
                        //_menu.setVisible(true); 
                    }
                    //if non been choosen its update and it will just stay the same continue
                }  
            }
        }
    }

}
