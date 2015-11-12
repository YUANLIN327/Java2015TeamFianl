import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.SwingConstants;

public class CoffeePOS extends JFrame {

	private JPanel contentPane;
	BufferedImage buttonIcon1 = ImageIO.read(new File("TeaButton.jpg"));	
	BufferedImage buttonIcon2 = ImageIO.read(new File("LatteButton.jpg"));
	BufferedImage buttonIcon3 = ImageIO.read(new File("DripCoffeeButton.jpg"));
	BufferedImage buttonIcon4 = ImageIO.read(new File("FrappuccinoButton.jpg"));
	BufferedImage buttonIcon5 = ImageIO.read(new File("BlackTeaButton.jpg"));
	BufferedImage buttonIcon6 = ImageIO.read(new File("ChaiTeaButton.jpg"));
	BufferedImage buttonIcon7 = ImageIO.read(new File("HerbalTeaButton.jpg"));
	BufferedImage buttonIcon8 = ImageIO.read(new File("RegularCoffeeButton.jpg"));
	BufferedImage buttonIcon9 = ImageIO.read(new File("VanillaCoffeeButton.jpg"));
	BufferedImage buttonIcon10 = ImageIO.read(new File("PumpkinCoffeeButton.jpg"));
	BufferedImage btnIconBack = ImageIO.read(new File("BackIcon.png"));
	CardLayout c1 = new CardLayout();
	CardLayout cmenu = new CardLayout();
	DefaultListModel<OrderItem> oidata = new DefaultListModel();
	JList itemlist = new JList(oidata);
	private JTextField txtAmountDue;
	private JTextField textField_1;
	private static final double taxRate=0.0825;
	boolean isOrderEmpty = true;
	
	JLabel lblSubTotal;
	JLabel lblTax;
	JLabel lblTotal;
	
	
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
		
		txtAmountDue = new JTextField();
		txtAmountDue.setBounds(200, 19, 81, 31);
		pnlCheckout.add(txtAmountDue);
		txtAmountDue.setColumns(10);
		txtAmountDue.setHorizontalAlignment(SwingConstants.RIGHT);
		
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
		btnTea.setBounds(0, 0, 133, 110);
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
		btnFrappuccino.setBounds(0, 213, 134, 107);
		pnlMenu.add(btnFrappuccino);
		
		JButton btnBlackTea = new JButton(new ImageIcon(buttonIcon5));
		btnBlackTea.setText("Black Tea");
		btnBlackTea.setBounds(26, 33, 117, 95);
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
		
//		JButton btnBlackTea1 = new JButton("Black Tea");
		btnBlackTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b =(JButton) e.getSource();
				addOrderItem(b.getText());
				System.out.println(b.getText());
				System.out.println(items.get(b.getText()));
			}
		});
		btnBlackTea.setBounds(26, 33, 117, 101);
		teaMenu.add(btnBlackTea);
		
		JButton btnChaiTea = new JButton(new ImageIcon(buttonIcon6));
		btnChaiTea.setText("Chai Tea");
		btnChaiTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b =(JButton) e.getSource();
				addOrderItem(b.getText());
				System.out.println(b.getText());
				System.out.println(items.get(b.getText()));
			}
		});
		btnChaiTea.setBounds(26, 138, 117, 101);
		teaMenu.add(btnChaiTea);
		
		JButton btnHerbalTea = new JButton(new ImageIcon(buttonIcon7));
		btnHerbalTea.setText("Herbal Tea");
		btnHerbalTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b =(JButton) e.getSource();
				addOrderItem(b.getText());
				System.out.println(b.getText());
				System.out.println(items.get(b.getText()));
			}
		});
		btnHerbalTea.setBounds(26, 245, 117, 101);
		teaMenu.add(btnHerbalTea);
		cmenu.show(categoryContainer, "Tea");
		
		
		JPanel dripcoffeeMenu = new JPanel();
		dripcoffeeMenu.setBounds(132, 0, 255, 428);
		dripcoffeeMenu.setBackground(new Color(51, 102, 153));
		dripcoffeeMenu.setLayout(null);
		categoryContainer.add(dripcoffeeMenu,"Drip Coffee");
		
		JButton btnRegularCoffee = new JButton(new ImageIcon(buttonIcon8));
		btnRegularCoffee.setText("Regular Coffee");
		btnRegularCoffee.setBounds(26, 30, 123, 101);
		dripcoffeeMenu.add(btnRegularCoffee);
		
		JButton btnVanillaCoffee = new JButton(new ImageIcon(buttonIcon9));
		btnVanillaCoffee.setText("Vanilla Coffee");
		btnVanillaCoffee.setBounds(26, 135, 123, 101);
		dripcoffeeMenu.add(btnVanillaCoffee);
		
		JButton btnPumpkinCoffee = new JButton(new ImageIcon(buttonIcon10));
		btnPumpkinCoffee.setText("Pumpkin Coffee");
		btnPumpkinCoffee.setBounds(26, 242, 123, 101);
		dripcoffeeMenu.add(btnPumpkinCoffee);
		
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(38, 361, 84, 33);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit Amount");
		btnEdit.setBounds(260, 361, 91, 33);
		contentPane.add(btnEdit);
		
		JButton btnOverridePrice = new JButton("Override Price");
		btnOverridePrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnOverridePrice.setBounds(127, 361, 125, 33);
		contentPane.add(btnOverridePrice);
		
		JButton btnSubmitOrder = new JButton("Submit Order");
		btnSubmitOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isOrderEmpty){
					c1.show(pnlContainer, "Checkout");
					Order currOrder = orders.get(orders.size()-1);
					txtAmountDue.setText(""+currOrder.getTotal());
				}
				else {
					
				}
			}
		});
		btnSubmitOrder.setBounds(218, 449, 126, 49);
		contentPane.add(btnSubmitOrder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 70, 315, 280);
		contentPane.add(scrollPane);
		itemlist.setFont(new Font("Courier New", Font.PLAIN, 12));
		
		
		scrollPane.setViewportView(itemlist);
		
		JLabel lblNewLabel = new JLabel("Sub Total:");
		lblNewLabel.setBounds(48, 430, 63, 14);
		contentPane.add(lblNewLabel);
		
		lblSubTotal = new JLabel("$0.00");
		lblSubTotal.setBounds(145, 430, 46, 14);
		contentPane.add(lblSubTotal);
		
		JLabel labeldiscount = new JLabel("Discount:");
		labeldiscount.setBounds(48, 405, 74, 14);
		contentPane.add(labeldiscount);
		
		JLabel lblDiscount = new JLabel("$0.00");
		lblDiscount.setBounds(145, 405, 46, 14);
		contentPane.add(lblDiscount);
		
		JLabel label_Toal = new JLabel("Total: ");
		label_Toal.setBounds(48, 480, 85, 14);
		contentPane.add(label_Toal);
		
		 lblTotal = new JLabel("$0.00");
		lblTotal.setBounds(145, 480, 46, 14);
		contentPane.add(lblTotal);
		
		JLabel label_Tax = new JLabel("Tax: ");
		label_Tax.setBounds(48, 455, 85, 14);
		contentPane.add(label_Tax);
		
		lblTax = new JLabel("$0.00");
		lblTax.setBounds(145, 455, 46, 14);
		contentPane.add(lblTax);
		
		JLabel lblCustomer = new JLabel("Quantity");
		lblCustomer.setForeground(new Color(0, 0, 0));
		lblCustomer.setFont(new Font("Georgia", Font.PLAIN, 12));
		lblCustomer.setBounds(111, 53, 69, 14);
		contentPane.add(lblCustomer);
		
		JLabel lblNewLabel_2 = new JLabel("Menu");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(363, 52, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblOrder = new JLabel("Name");
		lblOrder.setForeground(new Color(0, 0, 0));
		lblOrder.setFont(new Font("Georgia", Font.PLAIN, 12));
		lblOrder.setBounds(36, 52, 61, 16);
		contentPane.add(lblOrder);
		
		JLabel lblUnitprice = new JLabel("UnitPrice");
		lblUnitprice.setForeground(Color.BLACK);
		lblUnitprice.setFont(new Font("Georgia", Font.PLAIN, 12));
		lblUnitprice.setBounds(220, 54, 55, 14);
		contentPane.add(lblUnitprice);
		
		JLabel lblTotal_1 = new JLabel("Total");
		lblTotal_1.setForeground(Color.BLACK);
		lblTotal_1.setFont(new Font("Georgia", Font.PLAIN, 12));
		lblTotal_1.setBounds(319, 54, 46, 14);
		contentPane.add(lblTotal_1);
		
		
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
			lblSubTotal.setText("$"+newOrder.getSubtotal());
			lblTax.setText("$"+newOrder.getTax());
			lblTotal.setText("$"+newOrder.getTotal());
			
			
		}
		else {
			Order currOrder = orders.get(orders.size()-1);
			if(currOrder.orderitems.contains(oi)){
				
			}
			else {
				currOrder.orderitems.add(oi);
				oidata.addElement(oi);
				lblSubTotal.setText("$"+currOrder.getSubtotal());
				lblTax.setText("$"+currOrder.getTax());
				lblTotal.setText("$"+currOrder.getTotal());
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
		
		public double getTax(){
			return Math.round(taxRate*getSubtotal()*100.00)/100.0;
		}
		
		public double getTotal(){
			return  Math.round((getSubtotal()+getTax())*100.0)/100.00;
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
			
			return String.format("%-17s", name)+ String.format("%-10s", quantity) + 
					String.format("%7s", unitprice)+String.format("%10s", quantity*unitprice);
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