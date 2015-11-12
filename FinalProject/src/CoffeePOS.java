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
import java.awt.Font;

public class CoffeePOS extends JFrame {

	private JPanel contentPane;
	BufferedImage buttonIcon1 = ImageIO.read(new File("TeaButton.jpg"));	
	BufferedImage buttonIcon2 = ImageIO.read(new File("LatteButton.jpg"));
	BufferedImage buttonIcon3 = ImageIO.read(new File("DripCoffeeButton.jpg"));
	BufferedImage buttonIcon4 = ImageIO.read(new File("FrappuccinoButton.jpg"));
	BufferedImage btnIconBack = ImageIO.read(new File("BackIcon.png"));
	CardLayout c1 = new CardLayout();
	CardLayout cmenu = new CardLayout();
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
		pnlContainer.setBounds(361, 70, 387, 428);
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
		btnDripCoffee.setText("Drip Coffee");
		btnDripCoffee.setBounds(0, 105, 134, 110);
		pnlMenu.add(btnDripCoffee);
		
		JPanel categoryContainer = new JPanel();
		categoryContainer.setBounds(132, 0, 255, 428);
		categoryContainer.setBackground(new Color(51, 102, 153));
		categoryContainer.setLayout(cmenu);
		pnlMenu.add(categoryContainer);
		
		JPanel teaMenu = new JPanel();
		teaMenu.setBounds(132, 0, 255, 428);
		teaMenu.setBackground(new Color(51, 102, 153));
		teaMenu.setLayout(null);
		categoryContainer.add(teaMenu,"Tea");
		
		JButton btnBalckTea = new JButton("Black Tea");
		btnBalckTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b =(JButton) e.getSource();
				addOrderItem(b.getText());
				System.out.println(b.getText());
				System.out.println(items.get(b.getText()));
			}
		});
		btnBalckTea.setBounds(26, 33, 117, 83);
		teaMenu.add(btnBalckTea);
		
		JButton btnChaiTea = new JButton("Chai Tea");
		btnChaiTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b =(JButton) e.getSource();
				addOrderItem(b.getText());
				System.out.println(b.getText());
				System.out.println(items.get(b.getText()));
			}
		});
		btnChaiTea.setBounds(26, 138, 117, 83);
		teaMenu.add(btnChaiTea);
		
		JButton btnHerbalTea = new JButton("Herbal Tea");
		btnHerbalTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b =(JButton) e.getSource();
				addOrderItem(b.getText());
				System.out.println(b.getText());
				System.out.println(items.get(b.getText()));
			}
		});
		btnHerbalTea.setBounds(26, 245, 117, 83);
		teaMenu.add(btnHerbalTea);
		cmenu.show(categoryContainer, "Tea");
		
		
		JPanel dripcoffeeMenu = new JPanel();
		dripcoffeeMenu.setBounds(132, 0, 255, 428);
		dripcoffeeMenu.setBackground(new Color(51, 102, 153));
		dripcoffeeMenu.setLayout(null);
		categoryContainer.add(dripcoffeeMenu,"Drip Coffee");
		
		JButton btnCoffee = new JButton("Coffee1");
		btnCoffee.setBounds(21, 30, 117, 83);
		dripcoffeeMenu.add(btnCoffee);
		
		JButton btnCoffee_1 = new JButton("Coffee2");
		btnCoffee_1.setBounds(21, 135, 117, 83);
		dripcoffeeMenu.add(btnCoffee_1);
		
		JButton btnCoffee_2 = new JButton("Coffee3");
		btnCoffee_2.setBounds(21, 242, 117, 83);
		dripcoffeeMenu.add(btnCoffee_2);
		
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(36, 329, 84, 33);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit Amount");
		btnEdit.setBounds(258, 329, 91, 33);
		contentPane.add(btnEdit);
		
		JButton btnOverridePrice = new JButton("Override Price");
		btnOverridePrice.setBounds(125, 329, 125, 33);
		contentPane.add(btnOverridePrice);
		
		JButton btnSubmitOrder = new JButton("Submit Order");
		btnSubmitOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(pnlContainer, "Checkout");
			}
		});
		btnSubmitOrder.setBounds(218, 449, 126, 49);
		contentPane.add(btnSubmitOrder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 70, 315, 252);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(itemlist);
		
		JLabel lblNewLabel = new JLabel("Sub Total:");
		lblNewLabel.setBounds(46, 399, 63, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("$0.00");
		label.setBounds(143, 399, 46, 14);
		contentPane.add(label);
		
		JLabel lblDiscount = new JLabel("Discount:");
		lblDiscount.setBounds(46, 374, 74, 14);
		contentPane.add(lblDiscount);
		
		JLabel label_2 = new JLabel("$0.00");
		label_2.setBounds(143, 374, 46, 14);
		contentPane.add(label_2);
		
		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setBounds(46, 449, 85, 14);
		contentPane.add(lblTotal);
		
		JLabel label_6 = new JLabel("$0.00");
		label_6.setBounds(143, 449, 46, 14);
		contentPane.add(label_6);
		
		JLabel lblTax = new JLabel("Tax: ");
		lblTax.setBounds(46, 424, 85, 14);
		contentPane.add(lblTax);
		
		JLabel label_8 = new JLabel("$0.00");
		label_8.setBounds(143, 424, 46, 14);
		contentPane.add(label_8);
		
		JLabel lblBalanceDue = new JLabel("Balance Due: ");
		lblBalanceDue.setBounds(46, 474, 85, 14);
		contentPane.add(lblBalanceDue);
		
		JLabel label_10 = new JLabel("$0.00");
		label_10.setBounds(143, 474, 46, 14);
		contentPane.add(label_10);
		
		JLabel lblCustomer = new JLabel("Customer: ");
		lblCustomer.setForeground(new Color(0, 0, 0));
		lblCustomer.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblCustomer.setBounds(125, 52, 69, 14);
		contentPane.add(lblCustomer);
		
		JLabel lblNewLabel_2 = new JLabel("Menu");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(363, 52, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setForeground(new Color(0, 0, 0));
		lblOrder.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblOrder.setBounds(40, 50, 61, 16);
		contentPane.add(lblOrder);
		
		
		items.put("Black Tea",2.5d);
		items.put("Chai Tea",2.75d);
		items.put("Herbal Tea",2.1d);
		items.put("Hot Coffee",3.5d);
		items.put("Mocha",4.5d);
		items.put("Frappuccino",5.5d);
		items.put("Black Tea",2.2d);
		items.put("Chai",1.5d);
		
		
		btnTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cmenu.show(categoryContainer, "Tea");
			}
		});	
		
		btnDripCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmenu.show(categoryContainer, "Drip Coffee");
			}
		});

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
			
			return String.format("%-30s", name)+ String.format("%-15s", quantity) + 
					String.format("%-15s", unitprice)+String.format("%-15s", quantity*unitprice);
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