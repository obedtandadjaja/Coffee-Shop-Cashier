
import java.awt.print.PrinterException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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
        
        subTotal_value.setText("0.00");
        Tax_value.setText("0.00");
        Receipt_Text.setText("");
        Pay_But.setText("   PAY        RM 0.00");
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
          Pay_But.setText("   PAY        RM "+displayTotal);
          Receipt_Text.setText("");
          display_print();
 }
   
    
 public void display_print(){
 
     Receipt_Text.setText("                         The Coffee Story \n");
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
     Receipt_Text.setText(Receipt_Text.getText() + "----------------------------------------------------------------\n");
     Receipt_Text.setText(Receipt_Text.getText() + "Discount :\tRM"+Discount_lbl.getText()+"\n");
     Receipt_Text.setText(Receipt_Text.getText() + "====================================\n");
     Receipt_Text.setText(Receipt_Text.getText() +"                     Thanks For Your Business...!"+"\n");
     Receipt_Text.setText(Receipt_Text.getText() + "----------------------------------------------------------------\n");
     Receipt_Text.setText(Receipt_Text.getText() +"                     Software by Techinbox"+"\n");
 
 }
 
 public void bill_print() throws PrinterException{
 
     Double amt =Double.valueOf(Amount_txt.getText());
     Double ttl = Double.valueOf(Total_txt.getText());
     Double Balance = amt - ttl;
     
     Receipt_Text.setText("                         The Coffee Story \n");
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
     Receipt_Text.setText(Receipt_Text.getText() + "Total:" + "\tRM"+String.format("%.2f",ttl)+"\n");
     Receipt_Text.setText(Receipt_Text.getText() + "----------------------------------------------------------------\n");
     Receipt_Text.setText(Receipt_Text.getText() + "Cash :\tRM"+ String.format("%.2f", amt)+"\n");
     Receipt_Text.setText(Receipt_Text.getText() + "Ballance :\tRM"+ String.format("%.2f",Balance) +"\n");
     Receipt_Text.setText(Receipt_Text.getText() + "====================================\n");
     Receipt_Text.setText(Receipt_Text.getText() +"                     Thanks For Your Business...!"+"\n");
     Receipt_Text.setText(Receipt_Text.getText() + "----------------------------------------------------------------\n");
     Receipt_Text.setText(Receipt_Text.getText() +"                     Software by Techinbox"+"\n");
 
     Receipt_Text.print();
 }
 
 public String set_AmountText( String set)
 {
        String data = Amount_txt.getText();
        if(data.equals("0.00")) data = set;
        else    data = data +set;
        return data;
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Payment = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        Key1_but = new javax.swing.JButton();
        Key2_but = new javax.swing.JButton();
        Key3_but = new javax.swing.JButton();
        Key4_but = new javax.swing.JButton();
        Key5_but = new javax.swing.JButton();
        Key6_but = new javax.swing.JButton();
        Key7_but = new javax.swing.JButton();
        Key8_but = new javax.swing.JButton();
        Key9_but = new javax.swing.JButton();
        KeyClear_but = new javax.swing.JButton();
        Key0_but = new javax.swing.JButton();
        KeyDot_but = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Total_lbl = new javax.swing.JLabel();
        Amount_lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Amount_txt = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Total_txt = new javax.swing.JTextPane();
        KeyEnter_but = new javax.swing.JButton();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        Table_Pane = new javax.swing.JScrollPane();
        Order_Table = new javax.swing.JTable();
        Function_Panel = new javax.swing.JPanel();
        Pay_But = new javax.swing.JButton();
        subTotal_value = new javax.swing.JLabel();
        lbl_Subtotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Tax_value = new javax.swing.JLabel();
        lbl_Tax = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Receipt_Pane = new javax.swing.JScrollPane();
        Receipt_Text = new javax.swing.JTextPane();
        lbl_Subtotal1 = new javax.swing.JLabel();
        Discount_lbl = new javax.swing.JLabel();
        Delete_but = new javax.swing.JButton();

        Payment.setTitle("Payment");
        Payment.setResizable(false);
        Payment.setSize(new java.awt.Dimension(277, 450));
        Payment.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                PaymentWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(430, 386));

        Key1_but.setText("1");
        Key1_but.setPreferredSize(new java.awt.Dimension(70, 70));
        Key1_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key1_butActionPerformed(evt);
            }
        });

        Key2_but.setText("2");
        Key2_but.setPreferredSize(new java.awt.Dimension(70, 70));
        Key2_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key2_butActionPerformed(evt);
            }
        });

        Key3_but.setText("3");
        Key3_but.setPreferredSize(new java.awt.Dimension(70, 70));
        Key3_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key3_butActionPerformed(evt);
            }
        });

        Key4_but.setText("4");
        Key4_but.setPreferredSize(new java.awt.Dimension(70, 70));
        Key4_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key4_butActionPerformed(evt);
            }
        });

        Key5_but.setText("5");
        Key5_but.setPreferredSize(new java.awt.Dimension(70, 70));
        Key5_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key5_butActionPerformed(evt);
            }
        });

        Key6_but.setText("6");
        Key6_but.setPreferredSize(new java.awt.Dimension(70, 70));
        Key6_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key6_butActionPerformed(evt);
            }
        });

        Key7_but.setText("7");
        Key7_but.setPreferredSize(new java.awt.Dimension(70, 70));
        Key7_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key7_butActionPerformed(evt);
            }
        });

        Key8_but.setText("8");
        Key8_but.setPreferredSize(new java.awt.Dimension(70, 70));
        Key8_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key8_butActionPerformed(evt);
            }
        });

        Key9_but.setText("9");
        Key9_but.setPreferredSize(new java.awt.Dimension(70, 70));
        Key9_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key9_butActionPerformed(evt);
            }
        });

        KeyClear_but.setText("CLEAR");
        KeyClear_but.setPreferredSize(new java.awt.Dimension(70, 70));
        KeyClear_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyClear_butActionPerformed(evt);
            }
        });

        Key0_but.setText("0");
        Key0_but.setPreferredSize(new java.awt.Dimension(70, 70));
        Key0_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key0_butActionPerformed(evt);
            }
        });

        KeyDot_but.setText(".");
        KeyDot_but.setPreferredSize(new java.awt.Dimension(70, 70));
        KeyDot_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyDot_butActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Key1_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Key2_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Key3_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Key4_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Key5_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Key6_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Key7_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Key8_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Key9_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(KeyClear_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Key0_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KeyDot_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Key1_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Key2_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Key3_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Key4_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Key5_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Key6_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Key7_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Key8_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Key9_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KeyClear_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Key0_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KeyDot_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Total_lbl.setText("Total     : RM");

        Amount_lbl.setText("Amount : RM");

        Amount_txt.setEditable(false);
        jScrollPane1.setViewportView(Amount_txt);

        Total_txt.setEditable(false);
        jScrollPane2.setViewportView(Total_txt);

        KeyEnter_but.setText("Pay");
        KeyEnter_but.setPreferredSize(new java.awt.Dimension(70, 70));
        KeyEnter_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyEnter_butActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Amount_lbl)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Total_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(KeyEnter_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KeyEnter_but, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Total_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Amount_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PaymentLayout = new javax.swing.GroupLayout(Payment.getContentPane());
        Payment.getContentPane().setLayout(PaymentLayout);
        PaymentLayout.setHorizontalGroup(
            PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaymentLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PaymentLayout.setVerticalGroup(
            PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaymentLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Coffee Shop Cashier System");
        setFont(new java.awt.Font("Book Antiqua", 0, 10)); // NOI18N
        setResizable(false);

        Home_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel1.setText("Menber Code:");

        jScrollPane3.setViewportView(jTextPane1);

        jButton1.setText("Enter");

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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Order_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(Order_PanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGap(50, 50, 50)
                .addGroup(Order_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        Home_Panel.add(Order_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 504));

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

        Home_Panel.add(Table_Pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 0, 351, 380));

        Function_Panel.setBackground(new java.awt.Color(255, 255, 255));
        Function_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));

        Pay_But.setBackground(new java.awt.Color(255, 153, 51));
        Pay_But.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Pay_But.setText("   PAY        RM 0.00");
        Pay_But.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Pay_But.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Pay_But.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pay_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pay_ButActionPerformed(evt);
            }
        });

        subTotal_value.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        subTotal_value.setText("0.00");

        lbl_Subtotal.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_Subtotal.setText("SubTotal :   RM");

        Tax_value.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Tax_value.setText("0.00");

        lbl_Tax.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_Tax.setForeground(new java.awt.Color(51, 0, 204));
        lbl_Tax.setText("Tax          :   RM ");

        Receipt_Pane.setViewportView(Receipt_Text);

        lbl_Subtotal1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_Subtotal1.setText("Discount :   RM");

        Discount_lbl.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Discount_lbl.setText("0.00");

        javax.swing.GroupLayout Function_PanelLayout = new javax.swing.GroupLayout(Function_Panel);
        Function_Panel.setLayout(Function_PanelLayout);
        Function_PanelLayout.setHorizontalGroup(
            Function_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(Function_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Function_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Function_PanelLayout.createSequentialGroup()
                        .addComponent(Receipt_Pane)
                        .addContainerGap())
                    .addGroup(Function_PanelLayout.createSequentialGroup()
                        .addComponent(Pay_But, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(Function_PanelLayout.createSequentialGroup()
                        .addComponent(lbl_Subtotal)
                        .addGap(111, 111, 111)
                        .addComponent(subTotal_value, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 92, Short.MAX_VALUE))
                    .addGroup(Function_PanelLayout.createSequentialGroup()
                        .addComponent(lbl_Subtotal1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Discount_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(Function_PanelLayout.createSequentialGroup()
                        .addComponent(lbl_Tax)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Tax_value, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
        );
        Function_PanelLayout.setVerticalGroup(
            Function_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Function_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Receipt_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Function_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Subtotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Discount_lbl))
                .addGap(4, 4, 4)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(Function_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subTotal_value))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(Function_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Tax)
                    .addComponent(Tax_value))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pay_But, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Home_Panel.add(Function_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, -1, -1));

        Delete_but.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Delete_but.setText("REMOVE");
        Delete_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_butActionPerformed(evt);
            }
        });
        Home_Panel.add(Delete_but, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 386, 137, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Home_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Home_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
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
         String amount = Pay_But.getText();
        amount = amount.substring(17);
        
        Payment.setVisible(true);
        Payment.setLocationRelativeTo(null);
        
        Total_txt.setText(amount);
        Amount_txt.setText("0.00");
        
         
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

    private void Key1_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key1_butActionPerformed
        // TODO add your handling code here:
        String result = set_AmountText("1");
        Amount_txt.setText(result);
    }//GEN-LAST:event_Key1_butActionPerformed

    private void Key2_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key2_butActionPerformed
        // TODO add your handling code here:
        String result = set_AmountText("2");
        Amount_txt.setText(result);
    }//GEN-LAST:event_Key2_butActionPerformed

    private void Key3_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key3_butActionPerformed
        // TODO add your handling code here:
        String result = set_AmountText("3");
        Amount_txt.setText(result);
    }//GEN-LAST:event_Key3_butActionPerformed

    private void Key4_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key4_butActionPerformed
        // TODO add your handling code here:
        String result = set_AmountText("4");
        Amount_txt.setText(result);
    }//GEN-LAST:event_Key4_butActionPerformed

    private void Key5_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key5_butActionPerformed
        // TODO add your handling code here:
        String result = set_AmountText("5");
        Amount_txt.setText(result);
    }//GEN-LAST:event_Key5_butActionPerformed

    private void Key6_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key6_butActionPerformed
        // TODO add your handling code here:
        String result = set_AmountText("6");
        Amount_txt.setText(result);
    }//GEN-LAST:event_Key6_butActionPerformed

    private void Key7_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key7_butActionPerformed
        // TODO add your handling code here:
        String result = set_AmountText("7");
        Amount_txt.setText(result);
    }//GEN-LAST:event_Key7_butActionPerformed

    private void Key8_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key8_butActionPerformed
        // TODO add your handling code here:
        String result = set_AmountText("8");
        Amount_txt.setText(result);
    }//GEN-LAST:event_Key8_butActionPerformed

    private void Key9_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key9_butActionPerformed
        // TODO add your handling code here:
        String result = set_AmountText("9");
        Amount_txt.setText(result);
    }//GEN-LAST:event_Key9_butActionPerformed

    private void KeyClear_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyClear_butActionPerformed
        // TODO add your handling code here:
        String result = Amount_txt.getText();
        String output =  result.substring(0, result.length() - 1);
        Amount_txt.setText(output);
    }//GEN-LAST:event_KeyClear_butActionPerformed

    private void Key0_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key0_butActionPerformed
        // TODO add your handling code here:
        String result = set_AmountText("0");
        Amount_txt.setText(result);
    }//GEN-LAST:event_Key0_butActionPerformed

    private void KeyDot_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyDot_butActionPerformed
        // TODO add your handling code here:
        String data = Amount_txt.getText();
        if(!data.contains("."))
        {
            String result_data= data + ".";
            Amount_txt.setText(result_data);
        }
    }//GEN-LAST:event_KeyDot_butActionPerformed

    private void KeyEnter_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyEnter_butActionPerformed
        // TODO add your handling code here:
        Double Amount = Double.valueOf(Amount_txt.getText());
        Double Total = Double.valueOf(Total_txt.getText());
        JFrame f = new JFrame();
        if(Amount-Total <0)
        {
            JOptionPane.showMessageDialog(f,"Invalid Input.");
            Amount_txt.setText("0.00");
        }
        else
        {
            JOptionPane.showMessageDialog(f,"Payment Success."); 
            try {
                bill_print();
            } catch (PrinterException ex) {
                Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            Payment.setVisible(false);
            reset_Val();
        }
        
    }//GEN-LAST:event_KeyEnter_butActionPerformed

    private void PaymentWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_PaymentWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_PaymentWindowActivated

    
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
            @Override
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Amount_lbl;
    private javax.swing.JTextPane Amount_txt;
    private javax.swing.JButton Bagel_But;
    private javax.swing.JButton Cof_But;
    private javax.swing.JButton Delete_but;
    private javax.swing.JLabel Discount_lbl;
    private javax.swing.JPanel Function_Panel;
    private javax.swing.JPanel Home_Panel;
    private javax.swing.JButton Key0_but;
    private javax.swing.JButton Key1_but;
    private javax.swing.JButton Key2_but;
    private javax.swing.JButton Key3_but;
    private javax.swing.JButton Key4_but;
    private javax.swing.JButton Key5_but;
    private javax.swing.JButton Key6_but;
    private javax.swing.JButton Key7_but;
    private javax.swing.JButton Key8_but;
    private javax.swing.JButton Key9_but;
    private javax.swing.JButton KeyClear_but;
    private javax.swing.JButton KeyDot_but;
    private javax.swing.JButton KeyEnter_but;
    private javax.swing.JPanel Order_Panel;
    private javax.swing.JTable Order_Table;
    private javax.swing.JButton Other_But;
    private javax.swing.JButton Pastry_But;
    private javax.swing.JButton Pay_But;
    private javax.swing.JFrame Payment;
    private javax.swing.JScrollPane Receipt_Pane;
    private javax.swing.JTextPane Receipt_Text;
    private javax.swing.JButton Smoothie_But;
    private javax.swing.JScrollPane Table_Pane;
    private javax.swing.JLabel Tax_value;
    private javax.swing.JButton Tea_But;
    private javax.swing.JLabel Total_lbl;
    private javax.swing.JTextPane Total_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lbl_Drink;
    private javax.swing.JLabel lbl_Subtotal;
    private javax.swing.JLabel lbl_Subtotal1;
    private javax.swing.JLabel lbl_Tax;
    private javax.swing.JLabel lbl_food;
    private javax.swing.JLabel subTotal_value;
    // End of variables declaration//GEN-END:variables
    
    private boolean menber;
 
}
