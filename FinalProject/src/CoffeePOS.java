import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.Icon;
import java.awt.Color;

public class CoffeePOS extends JFrame {

	private JPanel contentPane;
	BufferedImage buttonIcon1 = ImageIO.read(new File("TeaButton.jpg"));	
	BufferedImage buttonIcon2 = ImageIO.read(new File("LatteButton.jpg"));
	BufferedImage buttonIcon3 = ImageIO.read(new File("DripCoffeeButton.jpg"));
	BufferedImage buttonIcon4 = ImageIO.read(new File("FrappuccinoButton.jpg"));
	BufferedImage btnIconBack = ImageIO.read(new File("BackIcon.png"));
	CardLayout c1 = new CardLayout();
	DefaultListModel<OrderItem> oidata = new DefaultListModel();
	JList itemlist = new JList(oidata);
	private JTextField textField;
	private JTextField textField_1;
	private static final double taxRate=0.0825;
	boolean isOrderEmpty = true;
	
	
	ArrayList<Order> orders = new ArrayList<Order>();
	
	HashMap<String, Double> items = new HashMap<String, Double>();
	private JTextField textField_3;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeePOS frame = new CoffeePOS();
					frame.setVisible(true);
					frame.setSize(800,600);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public CoffeePOS() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 544);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel pnlContainer = new JPanel();
		pnlContainer.setBounds(361, 44, 387, 428);
		pnlContainer.setLayout(c1);
		contentPane.add(pnlContainer);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setLayout(null);
		pnlMenu.setBackground(new Color(51, 102, 153));		
		pnlContainer.add(pnlMenu,"Menu");		
		
		JPanel pnlCheckout = new JPanel();
		pnlCheckout.setLayout(null);
		pnlCheckout.setBackground(SystemColor.window);
		pnlContainer.add(pnlCheckout, "Checkout");
		
		textField = new JTextField();
		textField.setBounds(200, 19, 81, 31);
		pnlCheckout.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(200, 87, 81, 31);
		pnlCheckout.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Cash");
		btnNewButton_1.setBounds(93, 207, 105, 39);
		pnlCheckout.add(btnNewButton_1);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(208, 207, 105, 39);
		pnlCheckout.add(btnCheck);
		
		JButton btnCoupon = new JButton("Coupon");
		btnCoupon.setBounds(93, 257, 105, 39);
		pnlCheckout.add(btnCoupon);
		
		JButton btnGiftCard = new JButton("Gift Card");
		btnGiftCard.setBounds(208, 257, 105, 39);
		pnlCheckout.add(btnGiftCard);
		
		JButton btnCreditdebitCard = new JButton("Credit/Debit Card");
		btnCreditdebitCard.setBounds(112, 153, 172, 39);
		pnlCheckout.add(btnCreditdebitCard);
		
		JLabel lblNewLabel_1 = new JLabel("Amount Due: ");
		lblNewLabel_1.setBounds(108, 27, 87, 14);
		pnlCheckout.add(lblNewLabel_1);
		
		JLabel lblChange = new JLabel("Change: ");
		lblChange.setBounds(140, 95, 55, 14);
		pnlCheckout.add(lblChange);
		
		JButton btnBack = new JButton(new ImageIcon(btnIconBack));
		btnBack.setBackground(SystemColor.window);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(pnlContainer, "Menu");
			}
		});
		btnBack.setBounds(10, 11, 38, 39);
		btnBack.setBorderPainted(false);
		
		pnlCheckout.add(btnBack);
		
		JLabel label_1 = new JLabel("Amount Tendered: ");
		label_1.setBounds(75, 61, 120, 14);
		pnlCheckout.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(200, 53, 81, 31);
		pnlCheckout.add(textField_3);
		
		c1.show(pnlContainer, "Menu");
		
		
		
		
		JButton btnTea = new JButton(new ImageIcon(buttonIcon1));
		btnTea.setBackground(new Color(0, 51, 51));
		btnTea.setText("Tea");
		btnTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b =(JButton) e.getSource();
				addOrderItem(b.getText());
				System.out.println(b.getText());
				System.out.println(items.get(b.getText()));
			}
		});		
		btnTea.setBounds(0, 0, 134, 110);
		pnlMenu.add(btnTea);
		JButton btnLatte = new JButton(new ImageIcon(buttonIcon2));
		btnLatte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLatte.setText("Latte");
		btnLatte.setBounds(0, 317, 134, 110);
		pnlMenu.add(btnLatte);
		
		JButton btnFrappuccino = new JButton(new ImageIcon(buttonIcon4));
		btnFrappuccino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFrappuccino.setText("Frappuccino");
		btnFrappuccino.setBounds(0, 213, 135, 107);
		pnlMenu.add(btnFrappuccino);
		
		JButton btnBlackTea = new JButton("Black Tea");
		btnBlackTea.setBounds(27, 184, 105, 68);
//		pnlMenu.add(btnBlackTea);
		
		JButton btnChai = new JButton("Chai");
		btnChai.setBounds(210, 184, 105, 68);
//		pnlMenu.add(btnChai);
		
		JButton btnDripCoffee = new JButton(new ImageIcon(buttonIcon3));
		btnDripCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDripCoffee.setText("Drip Coffee");
		btnDripCoffee.setBounds(0, 105, 134, 110);
		pnlMenu.add(btnDripCoffee);
		
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(36, 302, 84, 33);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit Amount");
		btnEdit.setBounds(258, 302, 91, 33);
		contentPane.add(btnEdit);
		
		JButton btnOverridePrice = new JButton("Override Price");
		btnOverridePrice.setBounds(125, 302, 125, 33);
		contentPane.add(btnOverridePrice);
		
		JButton btnSubmitOrder = new JButton("Submit Order");
		btnSubmitOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(pnlContainer, "Checkout");
			}
		});
		btnSubmitOrder.setBounds(218, 422, 126, 49);
		contentPane.add(btnSubmitOrder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 47, 315, 252);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(itemlist);
		
		JLabel lblNewLabel = new JLabel("Sub Total:");
		lblNewLabel.setBounds(46, 372, 63, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("$0.00");
		label.setBounds(143, 372, 46, 14);
		contentPane.add(label);
		
		JLabel lblDiscount = new JLabel("Discount:");
		lblDiscount.setBounds(46, 347, 74, 14);
		contentPane.add(lblDiscount);
		
		JLabel label_2 = new JLabel("$0.00");
		label_2.setBounds(143, 347, 46, 14);
		contentPane.add(label_2);
		
		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setBounds(46, 422, 85, 14);
		contentPane.add(lblTotal);
		
		JLabel label_6 = new JLabel("$0.00");
		label_6.setBounds(143, 422, 46, 14);
		contentPane.add(label_6);
		
		JLabel lblTax = new JLabel("Tax: ");
		lblTax.setBounds(46, 397, 85, 14);
		contentPane.add(lblTax);
		
		JLabel label_8 = new JLabel("$0.00");
		label_8.setBounds(143, 397, 46, 14);
		contentPane.add(label_8);
		
		JLabel lblBalanceDue = new JLabel("Balance Due: ");
		lblBalanceDue.setBounds(46, 447, 85, 14);
		contentPane.add(lblBalanceDue);
		
		JLabel label_10 = new JLabel("$0.00");
		label_10.setBounds(143, 447, 46, 14);
		contentPane.add(label_10);
		
		JLabel lblCustomer = new JLabel("Customer: ");
		lblCustomer.setBounds(175, 22, 69, 14);
		contentPane.add(lblCustomer);
		
		JLabel lblNewLabel_2 = new JLabel("Menu");
		lblNewLabel_2.setBounds(361, 22, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setBounds(36, 20, 61, 16);
		contentPane.add(lblOrder);
		
		
		items.put("Tea",2.5d);
		items.put("Hot Coffee",3.5d);
		items.put("Mocha",4.5d);
		items.put("Frappuccino",5.5d);
		items.put("Black Tea",2.2d);
		items.put("Chai",1.5d);

	}
	
	public void addOrderItem(String itemname){
		
		OrderItem oi = new OrderItem(itemname,items.get(itemname));
		
		if (isOrderEmpty){
			Order newOrder = new Order();	
			isOrderEmpty=false;
			newOrder.orderitems.add(oi);
			oidata.addElement(oi);
			
		}
		else {
			Order currentOrder = orders.get(orders.size()-1);
			if(currentOrder.orderitems.contains(oi)){
				
			}
			else {
				currentOrder.orderitems.add(oi);
				oidata.addElement(oi);
			}
		}	
		
	}
	
	class Order{
		ArrayList<OrderItem> orderitems = new ArrayList<OrderItem>();
		
//		double amountsTendered=0.0;
//		double totalDue=total()-amountsTendered;
//		double couponamount;
//		double tax;		
//		double totaldue;
		
		Order() {
			orders.add(this);
		}
		
		public double getSubtotal(){
			double subtotal=0.0;
			for (OrderItem oi: orderitems){
				subtotal += oi.quantity*oi.unitprice;
			}
			return subtotal;
			
		}
		
		public double tax(){
			return taxRate*getSubtotal();
		}
		
		public double total(){
			return getSubtotal()+tax();
		}
		
		
		
	}
	
	class Customer {
		
	}
	
	class OrderItem {
		String name;
		double unitprice;
		int quantity;
		
		OrderItem (String name, Double price){
			this.name= name;
			this.unitprice = price;
			this.quantity = 1;
		}
		
		
		public String toString(){
			return name + "     \t" + quantity + "    \t" + unitprice+ "     \t" + unitprice*quantity;
		}
	}
	
	class Item {
		private String name;
		private Double price;
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}