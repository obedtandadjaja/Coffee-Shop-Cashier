
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Homepage extends javax.swing.JFrame {

    public Homepage() {
        initComponents();
        reset_Val();
    }

    public void addTable(String n, Double p ){
        String Qty = JOptionPane.showInputDialog(null, "Please Ente Your Qty","1");
        
        Double Total_qty = Double.valueOf(Qty);
        Double Total_prc = p * Total_qty;
        
        System.out.println(Total_prc);
        
        // Add product to cart
        DefaultTableModel dt = (DefaultTableModel)Order_Table.getModel();
        
                    Vector v = new Vector();
                    v.add(n);
                    v.add(Qty);
                    v.add(Total_prc);
                    dt.addRow(v);
                    
         cart_cal();
                    
    }
    
    public final void reset_Val()
    {
        DefaultTableModel dt = (DefaultTableModel)Order_Table.getModel();
        dt.setRowCount(0);
        
        Cash_value.setText("0.00");
        Balance_value.setText("0.00");
        subTotal_value.setText("0.00");
        Total_value.setText("0.00");
        Tax_value.setText("0.00");
        Receipt_Text.setText("");
    }
    
    public void cart_cal(){
 
          int Row_num = Order_Table.getRowCount();
          double subtotal = 0;
          
          for(int i = 0; i<Row_num; i++)
          {
              double value =  Double.parseDouble(Order_Table.getValueAt(i,2).toString());
              subtotal += value;
          }
          
          DecimalFormat df = new DecimalFormat("0.00");
          String displaySubtotal = df.format(subtotal);
          subTotal_value.setText(displaySubtotal);
          
          double tax = subtotal * 0.1;
          String displayTax = df.format(tax);
          Tax_value.setText(displayTax);
          
          double total = subtotal + tax;
          String displayTotal = df.format(total);
           Total_value.setText(displayTotal);
 }
   
    
 public void bill_print(){
 
        try {
             Receipt_Text.setText("                         The techinbox Pizza Hut \n");
             Receipt_Text.setText(Receipt_Text.getText() + "\t589/ King Road, \n");
             Receipt_Text.setText(Receipt_Text.getText() + "\tColombo, Srilanka, \n");
             Receipt_Text.setText(Receipt_Text.getText() + "\t+9411 123456789, \n");
             Receipt_Text.setText(Receipt_Text.getText() + "----------------------------------------------------------------\n");
             Receipt_Text.setText(Receipt_Text.getText() + " Iteam \tQty \tPrice \n");
             Receipt_Text.setText(Receipt_Text.getText() + "----------------------------------------------------------------\n");
            
            DefaultTableModel df = (DefaultTableModel) Order_Table.getModel();
            for (int i = 0; i < Order_Table.getRowCount(); i++) {
                
                String name = df.getValueAt(i, 0).toString();
                String qt = df.getValueAt(i, 1).toString();
                String prc = df.getValueAt(i, 2).toString();
                
                Receipt_Text.setText(Receipt_Text.getText() + name+"\t"+qt+"\t"+prc+" \n");
                
            }
             Receipt_Text.setText(Receipt_Text.getText() + "----------------------------------------------------------------\n");
             Receipt_Text.setText(Receipt_Text.getText() + "SubTotal (" +Order_Table.getRowCount() + "):\tRM"+subTotal_value.getText()+"\n");
             Receipt_Text.setText(Receipt_Text.getText() + "Tax 10%: " + "\tRM"+Tax_value.getText()+"\n");
             Receipt_Text.setText(Receipt_Text.getText() + "Total:" + "\tRM"+Total_value.getText()+"\n");
             Receipt_Text.setText(Receipt_Text.getText() + "----------------------------------------------------------------\n");
             Receipt_Text.setText(Receipt_Text.getText() + "Cash :\tRM"+Cash_value.getText()+"\n");
             Receipt_Text.setText(Receipt_Text.getText() + "Ballance :\tRM"+Balance_value.getText()+"\n");
             Receipt_Text.setText(Receipt_Text.getText() + "====================================\n");
             Receipt_Text.setText(Receipt_Text.getText() +"                     Thanks For Your Business...!"+"\n");
             Receipt_Text.setText(Receipt_Text.getText() + "----------------------------------------------------------------\n");
             Receipt_Text.setText(Receipt_Text.getText() +"                     Software by Techinbox"+"\n");
            
            
            Receipt_Text.print();
            
        } catch (PrinterException ex) {
            
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 }
 
 public String set_CashText(String data, String set)
 {
        if(data.equals("0.00")) data = set;
        else    data = data +set;
        return data;
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Home_Panel = new javax.swing.JPanel();
        Order_Panel = new javax.swing.JPanel();
        Cof_But = new javax.swing.JButton();
        Other_But = new javax.swing.JButton();
        Smoothie_But = new javax.swing.JButton();
        Tea_But = new javax.swing.JButton();
        lbl_Drink = new javax.swing.JLabel();
        lbl_food = new javax.swing.JLabel();
        Pastry_But = new javax.swing.JButton();
        Bagel_But = new javax.swing.JButton();
        Table_Pane = new javax.swing.JScrollPane();
        Order_Table = new javax.swing.JTable();
        Receipt_Pane = new javax.swing.JScrollPane();
        Receipt_Text = new javax.swing.JTextPane();
        Detail_Panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_Subtotal = new javax.swing.JLabel();
        lbl_Tax = new javax.swing.JLabel();
        lbl_Total = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        subTotal_value = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tax_value = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        Total_value = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        lbl_cash = new javax.swing.JLabel();
        Balance_lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Cash_value = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        Balance_value = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        Pay_But = new javax.swing.JButton();
        New_But = new javax.swing.JButton();
        Delete_but = new javax.swing.JButton();
        Keypad_Panel = new javax.swing.JPanel();
        But_0 = new javax.swing.JButton();
        But_DOT = new javax.swing.JButton();
        But_1 = new javax.swing.JButton();
        But_Backspace = new javax.swing.JButton();
        But_2 = new javax.swing.JButton();
        But_3 = new javax.swing.JButton();
        But_4 = new javax.swing.JButton();
        But_5 = new javax.swing.JButton();
        But_6 = new javax.swing.JButton();
        But_7 = new javax.swing.JButton();
        But_8 = new javax.swing.JButton();
        But_9 = new javax.swing.JButton();
        Print_But = new javax.swing.JButton();
        Member_but = new javax.swing.JButton();
        Registration_But = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Order_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 255, 204), null, null));

        Cof_But.setFont(new java.awt.Font("STFangsong", 0, 18)); // NOI18N
        Cof_But.setText("Coffee");
        Cof_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cof_ButActionPerformed(evt);
            }
        });

        Other_But.setFont(new java.awt.Font("STFangsong", 0, 18)); // NOI18N
        Other_But.setText("Others");
        Other_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Other_ButActionPerformed(evt);
            }
        });

        Smoothie_But.setFont(new java.awt.Font("STFangsong", 0, 18)); // NOI18N
        Smoothie_But.setText("Smoothie");
        Smoothie_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Smoothie_ButActionPerformed(evt);
            }
        });

        Tea_But.setFont(new java.awt.Font("STFangsong", 0, 18)); // NOI18N
        Tea_But.setText("Tea");
        Tea_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tea_ButActionPerformed(evt);
            }
        });

        lbl_Drink.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Drink.setText("Drink");

        lbl_food.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_food.setText("Food");

        Pastry_But.setFont(new java.awt.Font("STFangsong", 0, 18)); // NOI18N
        Pastry_But.setText("Pastry");
        Pastry_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pastry_ButActionPerformed(evt);
            }
        });

        Bagel_But.setFont(new java.awt.Font("STFangsong", 0, 18)); // NOI18N
        Bagel_But.setText("Bagel");
        Bagel_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bagel_ButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Order_PanelLayout = new javax.swing.GroupLayout(Order_Panel);
        Order_Panel.setLayout(Order_PanelLayout);
        Order_PanelLayout.setHorizontalGroup(
            Order_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Order_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Order_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Order_PanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(Order_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Smoothie_But, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cof_But, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bagel_But, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Order_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pastry_But, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Other_But, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tea_But, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(Order_PanelLayout.createSequentialGroup()
                        .addGroup(Order_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Drink, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_food, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        Order_PanelLayout.setVerticalGroup(
            Order_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Order_PanelLayout.createSequentialGroup()
                .addComponent(lbl_Drink)
                .addGap(14, 14, 14)
                .addGroup(Order_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cof_But, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tea_But, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(Order_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Other_But, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Smoothie_But, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_food)
                .addGap(18, 18, 18)
                .addGroup(Order_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pastry_But, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bagel_But, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Order_Table.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Order_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item", "Qty", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Table_Pane.setViewportView(Order_Table);

        Receipt_Pane.setViewportView(Receipt_Text);

        javax.swing.GroupLayout Home_PanelLayout = new javax.swing.GroupLayout(Home_Panel);
        Home_Panel.setLayout(Home_PanelLayout);
        Home_PanelLayout.setHorizontalGroup(
            Home_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Home_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Order_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(Table_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Receipt_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        Home_PanelLayout.setVerticalGroup(
            Home_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Home_PanelLayout.createSequentialGroup()
                .addGroup(Home_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Table_Pane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Receipt_Pane)
                    .addGroup(Home_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Order_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_Subtotal.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lbl_Subtotal.setText("SubTotal:   RM");

        lbl_Tax.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lbl_Tax.setText("Tax         :   RM ");

        lbl_Total.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lbl_Total.setText("Total      :   RM");

        subTotal_value.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jScrollPane3.setViewportView(subTotal_value);

        Tax_value.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jScrollPane4.setViewportView(Tax_value);

        Total_value.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jScrollPane5.setViewportView(Total_value);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Tax)
                    .addComponent(lbl_Subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbl_Subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Tax))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Total))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_cash.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lbl_cash.setText("Cash     :   RM");

        Balance_lbl.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        Balance_lbl.setText("Balance:   RM ");

        Cash_value.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jScrollPane1.setViewportView(Cash_value);

        Balance_value.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jScrollPane6.setViewportView(Balance_value);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Balance_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cash))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Balance_lbl))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Pay_But.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Pay_But.setText("PAY");
        Pay_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pay_ButActionPerformed(evt);
            }
        });

        New_But.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        New_But.setText("NEW");
        New_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                New_ButActionPerformed(evt);
            }
        });

        Delete_but.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Delete_but.setText("REMOVE");
        Delete_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_butActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(Pay_But, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(206, 206, 206))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(New_But, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Delete_but, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pay_But, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(New_But, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Delete_but)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Detail_PanelLayout = new javax.swing.GroupLayout(Detail_Panel);
        Detail_Panel.setLayout(Detail_PanelLayout);
        Detail_PanelLayout.setHorizontalGroup(
            Detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Detail_PanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Detail_PanelLayout.setVerticalGroup(
            Detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Detail_PanelLayout.createSequentialGroup()
                .addGroup(Detail_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        Keypad_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));

        But_0.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        But_0.setText("0");
        But_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_0ActionPerformed(evt);
            }
        });

        But_DOT.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        But_DOT.setText(".");
        But_DOT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_DOTActionPerformed(evt);
            }
        });

        But_1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        But_1.setText("1");
        But_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_1ActionPerformed(evt);
            }
        });

        But_Backspace.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        But_Backspace.setText("C");
        But_Backspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_BackspaceActionPerformed(evt);
            }
        });

        But_2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        But_2.setText("2");
        But_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_2ActionPerformed(evt);
            }
        });

        But_3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        But_3.setText("3");
        But_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_3ActionPerformed(evt);
            }
        });

        But_4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        But_4.setText("4");
        But_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_4ActionPerformed(evt);
            }
        });

        But_5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        But_5.setText("5");
        But_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_5ActionPerformed(evt);
            }
        });

        But_6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        But_6.setText("6");
        But_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_6ActionPerformed(evt);
            }
        });

        But_7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        But_7.setText("7");
        But_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_7ActionPerformed(evt);
            }
        });

        But_8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        But_8.setText("8");
        But_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_8ActionPerformed(evt);
            }
        });

        But_9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        But_9.setText("9");
        But_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_9ActionPerformed(evt);
            }
        });

        Print_But.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        Print_But.setText("PRINT");
        Print_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_ButActionPerformed(evt);
            }
        });

        Member_but.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Member_but.setText("MEMBER");
        Member_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Member_butActionPerformed(evt);
            }
        });

        Registration_But.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Registration_But.setText("REGISTRATION");
        Registration_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registration_ButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Keypad_PanelLayout = new javax.swing.GroupLayout(Keypad_Panel);
        Keypad_Panel.setLayout(Keypad_PanelLayout);
        Keypad_PanelLayout.setHorizontalGroup(
            Keypad_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Keypad_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Keypad_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Print_But, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Keypad_PanelLayout.createSequentialGroup()
                        .addComponent(But_1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(But_2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(But_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Keypad_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(Keypad_PanelLayout.createSequentialGroup()
                            .addGroup(Keypad_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(But_4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(But_7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(Keypad_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(But_8, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                .addComponent(But_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(Keypad_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(But_9, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                .addComponent(But_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Keypad_PanelLayout.createSequentialGroup()
                            .addComponent(But_0, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(But_Backspace, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(But_DOT, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Member_but, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Registration_But, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Keypad_PanelLayout.setVerticalGroup(
            Keypad_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Keypad_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Keypad_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Keypad_PanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(Keypad_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(But_7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(But_8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(But_9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Keypad_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(But_4, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(But_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(But_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Keypad_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(But_1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(But_2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(But_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Keypad_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(But_0, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(But_Backspace, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(But_DOT, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Print_But)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Member_but)
                .addGap(7, 7, 7)
                .addComponent(Registration_But, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Home_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Detail_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(Keypad_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Home_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Detail_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(Keypad_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cof_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cof_ButActionPerformed
        String Name ="Coffee";
        Double Price = 3.5;
        
        addTable(Name, Price);
    }//GEN-LAST:event_Cof_ButActionPerformed

    private void Bagel_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bagel_ButActionPerformed
         String Name ="Bagel";
         Double Price = 3.0;
          
         addTable(Name, Price);
    }//GEN-LAST:event_Bagel_ButActionPerformed

    private void Tea_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tea_ButActionPerformed
          String Name ="Tea";
          Double Price = 1.5;
         
         addTable(Name, Price);
    }//GEN-LAST:event_Tea_ButActionPerformed

    private void Other_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Other_ButActionPerformed
         String Name ="Others";
          Double Price = 4.0;
          
         addTable(Name, Price);
    }//GEN-LAST:event_Other_ButActionPerformed

    private void Registration_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registration_ButActionPerformed
        
    }//GEN-LAST:event_Registration_ButActionPerformed

    private void Smoothie_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Smoothie_ButActionPerformed
         String Name ="Smoothie";
         Double Price = 5.5;
          
         addTable(Name, Price);
    }//GEN-LAST:event_Smoothie_ButActionPerformed

    private void Pastry_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pastry_ButActionPerformed
        String Name ="Pastry";
         Double Price = 2.0;
          
         addTable(Name, Price);
    }//GEN-LAST:event_Pastry_ButActionPerformed

    private void Pay_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pay_ButActionPerformed
        Double tot = Double.valueOf(Total_value.getText());
        Double chs = Double.valueOf(Cash_value.getText());
        Double bal = chs - tot ;
        if(bal<0)
        {
            JOptionPane.showMessageDialog(null, "Amount not enought",
               "Cash Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            DecimalFormat df = new DecimalFormat("0.00");
            Balance_value.setText(String.valueOf(df.format(bal)));
        }
    }//GEN-LAST:event_Pay_ButActionPerformed

    private void Delete_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_butActionPerformed
        DefaultTableModel dt = (DefaultTableModel)Order_Table.getModel();
        
        int Remove_item = Order_Table.getSelectedRowCount();
        if(Remove_item >0)
        {
            dt.removeRow(Remove_item);
        }
        cart_cal();
    }//GEN-LAST:event_Delete_butActionPerformed

    private void Member_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Member_butActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Member_butActionPerformed

    private void New_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_New_ButActionPerformed
        reset_Val();
    }//GEN-LAST:event_New_ButActionPerformed

    private void Print_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print_ButActionPerformed
        Double tot = Double.valueOf(Total_value.getText());
        Double chs = Double.valueOf(Cash_value.getText());
        Double bal = chs - tot ;
        if(bal<0)
        {
            JOptionPane.showMessageDialog(null, "Amount not enought",
               "Cash Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            bill_print();
        }        
    }//GEN-LAST:event_Print_ButActionPerformed

    private void But_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_7ActionPerformed
        // TODO add your handling code here:
        String data = set_CashText(Cash_value.getText(),"7");
        Cash_value.setText(data);
    }//GEN-LAST:event_But_7ActionPerformed

    private void But_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_4ActionPerformed
        // TODO add your handling code here:
        String data = set_CashText(Cash_value.getText(),"4");
        Cash_value.setText(data);
    }//GEN-LAST:event_But_4ActionPerformed

    private void But_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_5ActionPerformed
        // TODO add your handling code here:
        String data = set_CashText(Cash_value.getText(),"5");
        Cash_value.setText(data);
    }//GEN-LAST:event_But_5ActionPerformed

    private void But_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_6ActionPerformed
        // TODO add your handling code here:
        String data = set_CashText(Cash_value.getText(),"6");
        Cash_value.setText(data);
    }//GEN-LAST:event_But_6ActionPerformed

    private void But_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_8ActionPerformed
        // TODO add your handling code here:
        String data = set_CashText(Cash_value.getText(),"8");
        Cash_value.setText(data);
    }//GEN-LAST:event_But_8ActionPerformed

    private void But_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_9ActionPerformed
        // TODO add your handling code here:
        String data = set_CashText(Cash_value.getText(),"9");
        Cash_value.setText(data);
    }//GEN-LAST:event_But_9ActionPerformed

    private void But_BackspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_BackspaceActionPerformed
        // TODO add your handling code here:
        String data = Cash_value.getText();
        int len = data.length();
        data = data.substring(0, len-1);
        Cash_value.setText(data);
    }//GEN-LAST:event_But_BackspaceActionPerformed

    private void But_DOTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_DOTActionPerformed
        // TODO add your handling code here:
        if(!Cash_value.getText().contains("."))
        {
            Cash_value.setText(Cash_value.getText() + ".");
        }
    }//GEN-LAST:event_But_DOTActionPerformed

    private void But_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_3ActionPerformed
        // TODO add your handling code here:
        String data = set_CashText(Cash_value.getText(),"3");
        Cash_value.setText(data);
    }//GEN-LAST:event_But_3ActionPerformed

    private void But_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_2ActionPerformed
        // TODO add your handling code here:
        String data = set_CashText(Cash_value.getText(),"2");
        Cash_value.setText(data);
    }//GEN-LAST:event_But_2ActionPerformed

    private void But_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_1ActionPerformed
        // TODO add your handling code here:
        String data = set_CashText(Cash_value.getText(),"1");
        Cash_value.setText(data);
    }//GEN-LAST:event_But_1ActionPerformed

    private void But_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_0ActionPerformed
        // TODO add your handling code here:
        String data = set_CashText(Cash_value.getText(),"0");
        Cash_value.setText(data);
    }//GEN-LAST:event_But_0ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bagel_But;
    private javax.swing.JLabel Balance_lbl;
    private javax.swing.JTextPane Balance_value;
    private javax.swing.JButton But_0;
    private javax.swing.JButton But_1;
    private javax.swing.JButton But_2;
    private javax.swing.JButton But_3;
    private javax.swing.JButton But_4;
    private javax.swing.JButton But_5;
    private javax.swing.JButton But_6;
    private javax.swing.JButton But_7;
    private javax.swing.JButton But_8;
    private javax.swing.JButton But_9;
    private javax.swing.JButton But_Backspace;
    private javax.swing.JButton But_DOT;
    private javax.swing.JTextPane Cash_value;
    private javax.swing.JButton Cof_But;
    private javax.swing.JButton Delete_but;
    private javax.swing.JPanel Detail_Panel;
    private javax.swing.JPanel Home_Panel;
    private javax.swing.JPanel Keypad_Panel;
    private javax.swing.JButton Member_but;
    private javax.swing.JButton New_But;
    private javax.swing.JPanel Order_Panel;
    private javax.swing.JTable Order_Table;
    private javax.swing.JButton Other_But;
    private javax.swing.JButton Pastry_But;
    private javax.swing.JButton Pay_But;
    private javax.swing.JButton Print_But;
    private javax.swing.JScrollPane Receipt_Pane;
    private javax.swing.JTextPane Receipt_Text;
    private javax.swing.JButton Registration_But;
    private javax.swing.JButton Smoothie_But;
    private javax.swing.JScrollPane Table_Pane;
    private javax.swing.JTextPane Tax_value;
    private javax.swing.JButton Tea_But;
    private javax.swing.JTextPane Total_value;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbl_Drink;
    private javax.swing.JLabel lbl_Subtotal;
    private javax.swing.JLabel lbl_Tax;
    private javax.swing.JLabel lbl_Total;
    private javax.swing.JLabel lbl_cash;
    private javax.swing.JLabel lbl_food;
    private javax.swing.JTextPane subTotal_value;
    // End of variables declaration//GEN-END:variables
}
