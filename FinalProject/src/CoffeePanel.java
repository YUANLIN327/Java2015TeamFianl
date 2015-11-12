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

public class CoffeePanel extends JFrame {

	private JPanel contentPane;
	BufferedImage buttonIcon1 = ImageIO.read(new File("coffee1.jpg"));	
	BufferedImage buttonIcon2 = ImageIO.read(new File("coffee2.jpg"));
	BufferedImage btnIconBack = ImageIO.read(new File("back.png"));
	CardLayout c1 = new CardLayout();
	DefaultListModel<OrderItem> oidata = new DefaultListModel();
	JList itemlist = new JList(oidata);
	private JTextField textField;
	private JTextField textField_1;
	private static final double taxRate=0.0825;
	boolean isOrderEmpty = true;
	
	
	ArrayList<Order> orders = new ArrayList<Order>();
	
	HashMap<String, Double> items = new HashMap<String, Double>();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeePanel frame = new CoffeePanel();
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
	public CoffeePanel() throws IOException {
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
		pnlMenu.setBackground(UIManager.getColor("textHighlight"));		
		pnlContainer.add(pnlMenu,"Menu");		
		
		JPanel pnlCheckout = new JPanel();
		pnlCheckout.setLayout(null);
		pnlCheckout.setBackground(SystemColor.window);
		pnlContainer.add(pnlCheckout, "Checkout");
		
		textField = new JTextField();
		textField.setBounds(39, 82, 164, 31);
		pnlCheckout.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(244, 81, 119, 31);
		pnlCheckout.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Cash");
		btnNewButton_1.setBounds(89, 133, 105, 39);
		pnlCheckout.add(btnNewButton_1);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(204, 133, 105, 39);
		pnlCheckout.add(btnCheck);
		
		JButton btnCoupon = new JButton("Coupon");
		btnCoupon.setBounds(89, 183, 105, 39);
		pnlCheckout.add(btnCoupon);
		
		JButton btnGiftCard = new JButton("Gift Card");
		btnGiftCard.setBounds(204, 183, 105, 39);
		pnlCheckout.add(btnGiftCard);
		
		JButton btnCreditdebitCard = new JButton("Credit/Debit Card");
		btnCreditdebitCard.setBounds(114, 240, 172, 39);
		pnlCheckout.add(btnCreditdebitCard);
		
		JLabel lblNewLabel_1 = new JLabel("Amounts Due");
		lblNewLabel_1.setBounds(39, 57, 76, 14);
		pnlCheckout.add(lblNewLabel_1);
		
		JLabel lblChange = new JLabel("Change: ");
		lblChange.setBounds(249, 57, 46, 14);
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
		
		c1.show(pnlContainer, "Menu");
		
		
		
		
		JButton btnIceCoffee = new JButton(new ImageIcon(buttonIcon1));
		btnIceCoffee.setText("Ice Coffee");
		btnIceCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b =(JButton) e.getSource();
				addOrderItem(b.getText());
				System.out.println(b.getText());
				System.out.println(items.get(b.getText()));
			}
		});		
		btnIceCoffee.setBounds(27, 62, 117, 68);
		pnlMenu.add(btnIceCoffee);
		JButton btnLattee = new JButton(new ImageIcon(buttonIcon2));
		btnLattee.setText("Hot Coffee");
		btnLattee.setBounds(210, 62, 117, 68);
		pnlMenu.add(btnLattee);
		
		JButton btnMocha = new JButton("Mocha");
		btnMocha.setBounds(27, 161, 117, 68);
		pnlMenu.add(btnMocha);
		
		JButton btnFrabuchinno = new JButton("Frappuccino");
		btnFrabuchinno.setBounds(210, 161, 117, 68);
		pnlMenu.add(btnFrabuchinno);
		
		JButton btnBlackTea = new JButton("Black Tea");
		btnBlackTea.setBounds(27, 253, 117, 68);
		pnlMenu.add(btnBlackTea);
		
		JButton btnChai = new JButton("Chai");
		btnChai.setBounds(210, 253, 117, 68);
		pnlMenu.add(btnChai);
		
		JLabel lblNewLabel_2 = new JLabel("Menu");
		lblNewLabel_2.setBounds(10, 21, 46, 14);
		pnlMenu.add(lblNewLabel_2);
		
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(25, 395, 84, 33);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit Amount");
		btnEdit.setBounds(113, 395, 91, 33);
		contentPane.add(btnEdit);
		
		JButton btnOverridePrice = new JButton("Override Price");
		btnOverridePrice.setBounds(25, 439, 125, 33);
		contentPane.add(btnOverridePrice);
		
		JButton btnSubmitOrder = new JButton("Submit Order");
		btnSubmitOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(pnlContainer, "Checkout");
			}
		});
		btnSubmitOrder.setBounds(225, 423, 126, 49);
		contentPane.add(btnSubmitOrder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 47, 315, 252);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(itemlist);
		
		JLabel lblNewLabel = new JLabel("Sub Total:");
		lblNewLabel.setBounds(36, 335, 63, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("$0.00");
		label.setBounds(126, 335, 46, 14);
		contentPane.add(label);
		
		JLabel lblDiscount = new JLabel("Discount:");
		lblDiscount.setBounds(36, 310, 46, 14);
		contentPane.add(lblDiscount);
		
		JLabel label_2 = new JLabel("$0.00");
		label_2.setBounds(126, 310, 46, 14);
		contentPane.add(label_2);
		
		JLabel lblSurcharge = new JLabel("Surcharge: ");
		lblSurcharge.setBounds(36, 360, 63, 14);
		contentPane.add(lblSurcharge);
		
		JLabel label_4 = new JLabel("$0.00");
		label_4.setBounds(126, 360, 46, 14);
		contentPane.add(label_4);
		
		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setBounds(210, 335, 85, 14);
		contentPane.add(lblTotal);
		
		JLabel label_6 = new JLabel("$ 0.00");
		label_6.setBounds(305, 335, 46, 14);
		contentPane.add(label_6);
		
		JLabel lblTax = new JLabel("Tax: ");
		lblTax.setBounds(210, 310, 85, 14);
		contentPane.add(lblTax);
		
		JLabel label_8 = new JLabel("$ 0.00");
		label_8.setBounds(305, 310, 46, 14);
		contentPane.add(label_8);
		
		JLabel lblBalanceDue = new JLabel("Balance Due: ");
		lblBalanceDue.setBounds(210, 360, 85, 14);
		contentPane.add(lblBalanceDue);
		
		JLabel label_10 = new JLabel("$ 0.00");
		label_10.setBounds(305, 360, 46, 14);
		contentPane.add(label_10);
		
		JLabel lblJohnDoe = new JLabel("John Doe");
		lblJohnDoe.setBounds(10, 22, 91, 14);
		contentPane.add(lblJohnDoe);
		
		
		items.put("Ice Coffee",2.5d);
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
		
		String name;
		long pointcardnumber;
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