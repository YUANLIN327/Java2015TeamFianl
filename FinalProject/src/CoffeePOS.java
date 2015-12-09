import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CoffeePOS extends JFrame {


	private JPanel contentPane;
	BufferedImage buttonIcon1 = ImageIO.read(new File("Tea.png"));	
	BufferedImage buttonIcon2 = ImageIO.read(new File("Latte.png"));
	BufferedImage buttonIcon3 = ImageIO.read(new File("DripCoffee.png"));
	BufferedImage buttonIcon4 = ImageIO.read(new File("Frappuccino.png"));
	BufferedImage buttonIcon5 = ImageIO.read(new File("BlackTea.png"));
	BufferedImage buttonIcon6 = ImageIO.read(new File("ChaiTea.png"));
	BufferedImage buttonIcon7 = ImageIO.read(new File("HerbalTea.png"));
	BufferedImage buttonIcon8 = ImageIO.read(new File("RegularCoffee.png"));
	BufferedImage buttonIcon9 = ImageIO.read(new File("VanillaCoffee.png"));
	BufferedImage buttonIcon10 = ImageIO.read(new File("PumpkinCoffee.png"));
	//Button set 2./*
	BufferedImage buttonIcon11 = ImageIO.read(new File("ChocolateFrap.png"));
	BufferedImage buttonIcon12 = ImageIO.read(new File("VanillaFrap.png"));
	BufferedImage buttonIcon13 = ImageIO.read(new File("CaramelFrap.png"));
	BufferedImage buttonIcon14 = ImageIO.read(new File("HazelnutLatte.png"));
	BufferedImage buttonIcon15 = ImageIO.read(new File("MochaLatte.png"));
	BufferedImage buttonIcon16 = ImageIO.read(new File("VanillaLatte.png"));
	BufferedImage buttonIcon17 = ImageIO.read(new File("RooibosTea.png")); //rooibos tea
	BufferedImage buttonIcon18 = ImageIO.read(new File("HazelnutCoffee.png")); //hazelnut coffee
	BufferedImage buttonIcon19 = ImageIO.read(new File("MintFrap.png")); //mint frap
	BufferedImage buttonIcon20 = ImageIO.read(new File("CaramelLatte.png")); //caramel latte
	BufferedImage btnIconBack = ImageIO.read(new File("BackIcon.png")); 
	
	
	//initate card layout field instance
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
    JFrame Receipt = new JFrame();
    Desktop desktop = null;
	ArrayList<Order> orders = new ArrayList<Order>();	
	HashMap<String, Double> items = new HashMap<String, Double>();
	private JTextField textField_3;
    JTextArea ta = new JTextArea();
    String CashAmt;
    private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeePOS frame = new CoffeePOS();
					frame.setVisible(true);
					frame.setSize(1100,730);
					frame.setTitle("iCoffee Shop");
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
	
    void drawLine(){
        ta.append("------------------------------------\n");
}
	public CoffeePOS() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel pnlRibbon = new JPanel();
		pnlRibbon.setBounds(0, 11, 1090, 77);
		pnlRibbon.setLayout(null);
		pnlRibbon.setBackground(new Color(128, 0, 0));
		contentPane.add(pnlRibbon);
		
		
		
		JRadioButton rdbDinein = new JRadioButton("Dine In");
		rdbDinein.setForeground(Color.WHITE);
		rdbDinein.setBounds(573, 13, 97, 50);
		pnlRibbon.add(rdbDinein);
		rdbDinein.setFont(new Font("Dialog", Font.BOLD, 18));
		rdbDinein.setBackground(new Color(128, 0, 0));
		rdbDinein.setFocusPainted(false);
		
		JRadioButton rdbTakehome = new JRadioButton("Take Home");
		rdbTakehome.setForeground(Color.WHITE);
		rdbTakehome.setFont(new Font("Dialog", Font.BOLD, 18));
		rdbTakehome.setBackground(new Color(128, 0, 0));
		rdbTakehome.setBounds(666, 7, 144, 63);
		rdbTakehome.setFocusPainted(false);
		pnlRibbon.add(rdbTakehome);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbDinein);
		btnGroup.add(rdbTakehome);
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.setBounds(226, 41, 144, 29);
		pnlRibbon.add(btnNewButton);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(816, 24, 183, 33);
		pnlRibbon.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSearch.setBounds(1009, 30, 71, 16);
		pnlRibbon.add(lblSearch);
		
		JLabel lblWelcomeLin = new JLabel("Welcome Lin");
		lblWelcomeLin.setForeground(Color.WHITE);
		lblWelcomeLin.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeLin.setBounds(234, 14, 148, 16);
		pnlRibbon.add(lblWelcomeLin);
		
		
		
		//add container panel for menu and check out		
		JPanel pnlContainer = new JPanel();
		pnlContainer.setBackground(new Color(100, 149, 237));
		pnlContainer.setBounds(390, 90, 700, 589);
		//apply the card layout 
		pnlContainer.setLayout(c1);
		contentPane.add(pnlContainer);
		
		//add menu panel
		JPanel pnlMenu = new JPanel();
		pnlMenu.setLayout(null);
		pnlMenu.setBackground(new Color(210, 180, 140));	
		//add menu panel to container panel
		pnlContainer.add(pnlMenu,"Menu");		
		
		//add checkout panel
		JPanel pnlCheckout = new JPanel();
		pnlCheckout.setLayout(null);
		pnlCheckout.setBackground(new Color(210, 180, 140));
		
		//add checkout panel to container panel
		pnlContainer.add(pnlCheckout, "Checkout");
		
		txtAmountDue = new JTextField();
		txtAmountDue.setBounds(242, 27, 172, 31);
		pnlCheckout.add(txtAmountDue);
		txtAmountDue.setColumns(10);
		txtAmountDue.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(242, 95, 172, 31);
		pnlCheckout.add(textField_1);
		
		JButton btnCash = new JButton("Cash");
		btnCash.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnCash.setBounds(90, 271, 125, 51);
		btnCash.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		                //CashAmt = JOptionPane.showInputDialog("Please Enter Cash Amount: ");
		                System.out.println(CashAmt);
		                //Reciept nw = new Reciept();
		                //nw.NewScreen();
		                if (e.getSource()==btnCash){
		                            Receipt.setSize(250, 250);
		                            Receipt.setVisible(true);
		                            Receipt.getContentPane().add(ta, BorderLayout.NORTH);
		                            JButton emailBtn = new JButton("Email Reciept");
		                            Receipt.getContentPane().add(emailBtn, BorderLayout.SOUTH);
		                               emailBtn.addActionListener(new ActionListener(){
		                                    @Override
		                                    public void actionPerformed(ActionEvent e) {

		                                        String report$=ta.getText();
		                                        String mailto="Claudia_zamudio@baylor.edu?SUBJECT=Reciept [iCoffee Shoppe]&BODY=" + report$;

		                                        URI uri=null;

		                                        try{
		                                            uri=new URI("mailto", mailto, null);
		                                            try {
		                                                desktop.mail(uri);
		                                            } catch (IOException e1) {
		                                                // TODO Auto-generated catch block
		                                                e1.printStackTrace();
		                                            }
		                                        }catch (URISyntaxException e1){
		                                            e1.printStackTrace();

		                                        }
		                                    }

		                                });
		                            ta.setText("");
		                            drawLine();
		                            ta.append("\tiCoffeeShoppe\n");
		                            ta.append("\tRECIEPT\n");
		                            drawLine();
		                            ta.append("Total Amount Due: " + txtAmountDue.getText() + "\n"+ "Amount Tendered: " + textField_3.getText() + "\n"+
		                            "Change: " + textField_1.getText());

		                }
		    }

});
		
		pnlCheckout.add(btnCash);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnCheck.setBounds(334, 306, 105, 39);
		pnlCheckout.add(btnCheck);
		
		JButton btnCoupon = new JButton("Coupon");
		btnCoupon.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnCoupon.setBounds(114, 396, 105, 39);
		pnlCheckout.add(btnCoupon);
		
		
		JButton btnGiftCard = new JButton("Gift Card");
		btnGiftCard.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnGiftCard.setBounds(114, 335, 105, 39);
		pnlCheckout.add(btnGiftCard);
		
		JButton btnCreditdebitCard = new JButton("Credit/Debit Card");
		btnCreditdebitCard.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnCreditdebitCard.setBounds(242, 158, 172, 39);
		btnCreditdebitCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});		
		pnlCheckout.add(btnCreditdebitCard);
		
		JLabel lblNewLabel_1 = new JLabel("Amount Due: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(101, 44, 131, 14);
		pnlCheckout.add(lblNewLabel_1);
		
		JLabel lblChange = new JLabel("Change: ");
		lblChange.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChange.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblChange.setBounds(163, 112, 69, 14);
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
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_1.setBounds(72, 79, 164, 14);
		pnlCheckout.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(242, 61, 172, 31);
		pnlCheckout.add(textField_3);
		
		c1.show(pnlContainer, "Menu");		
		
		
		JButton btnTea = new JButton(new ImageIcon(buttonIcon1));
		btnTea.setBackground(new Color(0, 51, 51));
		btnTea.setText("Tea");	
		btnTea.setBounds(6, 24, 180, 120);
		pnlMenu.add(btnTea);
		
		JButton btnLatte = new JButton(new ImageIcon(buttonIcon2));
		btnLatte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLatte.setText("Latte");
		btnLatte.setBounds(6, 465, 180, 120);
		pnlMenu.add(btnLatte);
		
		JButton btnFrappuccino = new JButton(new ImageIcon(buttonIcon4));
		btnFrappuccino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFrappuccino.setText("Frappuccino");
		btnFrappuccino.setBounds(6, 322, 180, 120);
		pnlMenu.add(btnFrappuccino);
		//		pnlMenu.add(btnChai);
				
				JButton btnDripCoffee = new JButton(new ImageIcon(buttonIcon3));
				btnDripCoffee.setText("Drip Coffee");
				btnDripCoffee.setBounds(6, 172, 180, 120);
				pnlMenu.add(btnDripCoffee);
				
				JPanel categoryContainer = new JPanel();
				categoryContainer.setBounds(192, 0, 508, 599);
				categoryContainer.setBackground(new Color(30, 144, 255));
				categoryContainer.setLayout(cmenu);
				pnlMenu.add(categoryContainer);
				cmenu.show(categoryContainer, "Tea");
				
				JButton btnBlackTea = new JButton(new ImageIcon(buttonIcon5));
				btnBlackTea.setText("Black Tea");
				
				JPanel teaMenu = new JPanel();
				categoryContainer.add(teaMenu, "Tea");
				teaMenu.setBackground(new Color(128, 0, 0));
				teaMenu.setLayout(null);
				
				btnBlackTea.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());				
					}
				});
				btnBlackTea.setBounds(56, 79, 180, 120);
				teaMenu.add(btnBlackTea);
				
				JButton btnChaiTea = new JButton(new ImageIcon(buttonIcon6));
				btnChaiTea.setText("Chai Tea");
				btnChaiTea.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());				
					}
				});
				btnChaiTea.setBounds(270, 79, 180, 120);
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
				btnHerbalTea.setBounds(56, 270, 180, 120);
				teaMenu.add(btnHerbalTea);
				
				JButton btnRooibosTea = new JButton(new ImageIcon(buttonIcon17));
				btnRooibosTea.setText("Rooibos Tea");
				btnRooibosTea.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());
					}
				});
				btnRooibosTea.setBounds(270, 270, 180, 120);
				teaMenu.add(btnRooibosTea);
				
				JLabel lblBlackTea = new JLabel("Black Tea");
				lblBlackTea.setForeground(new Color(255, 255, 255));
				lblBlackTea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblBlackTea.setBounds(112, 199, 104, 16);
				teaMenu.add(lblBlackTea);
				
				JLabel lblChaiTea = new JLabel("Chai Tea");
				lblChaiTea.setForeground(Color.WHITE);
				lblChaiTea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblChaiTea.setBounds(325, 200, 104, 16);
				teaMenu.add(lblChaiTea);
				
				JLabel lblHerbalTea = new JLabel("Herbal Tea");
				lblHerbalTea.setForeground(Color.WHITE);
				lblHerbalTea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblHerbalTea.setBounds(103, 389, 84, 16);
				teaMenu.add(lblHerbalTea);
				
				JLabel lblRooibosTea = new JLabel("Rooibos Tea");
				lblRooibosTea.setForeground(Color.WHITE);
				lblRooibosTea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblRooibosTea.setBounds(317, 389, 104, 16);
				teaMenu.add(lblRooibosTea);
				
				JLabel lblTea = new JLabel("Tea");
				lblTea.setForeground(Color.WHITE);
				lblTea.setFont(new Font("Dialog", Font.BOLD, 18));
				lblTea.setBounds(21, 11, 104, 16);
				teaMenu.add(lblTea);
				
				
				JPanel dripcoffeeMenu = new JPanel();
				dripcoffeeMenu.setBounds(132, 0, 255, 428);
				dripcoffeeMenu.setBackground(new Color(128, 0, 0));
				dripcoffeeMenu.setLayout(null);
				categoryContainer.add(dripcoffeeMenu,"Drip Coffee");
				
				JButton btnRegularCoffee = new JButton(new ImageIcon(buttonIcon8));
				btnRegularCoffee.setText("Regular Coffee");
				btnRegularCoffee.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());
					}
				});
				btnRegularCoffee.setBounds(56, 79, 180, 120);
				dripcoffeeMenu.add(btnRegularCoffee);
				
				
				JButton btnVanillaCoffee = new JButton(new ImageIcon(buttonIcon9));
				btnVanillaCoffee.setText("Vanilla Coffee");
				btnVanillaCoffee.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());
					}
				});
				btnVanillaCoffee.setBounds(270, 79, 180, 120);
				dripcoffeeMenu.add(btnVanillaCoffee);
				
				JButton btnPumpkinCoffee = new JButton(new ImageIcon(buttonIcon10));
				btnPumpkinCoffee.setText("Pumpkin Coffee");
				btnPumpkinCoffee.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());
					}
				});
				btnPumpkinCoffee.setBounds(56, 270, 180, 120);
				dripcoffeeMenu.add(btnPumpkinCoffee);
				
				JButton btnHazelnutCoffee = new JButton(new ImageIcon(buttonIcon18));
				btnHazelnutCoffee.setText("Hazelnut Coffee");
				btnHazelnutCoffee.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());
					}
				});
				btnHazelnutCoffee.setBounds(270, 270, 180, 120);
				dripcoffeeMenu.add(btnHazelnutCoffee);
				
				JLabel lblPumpkinCoffee = new JLabel("Pumpkin Coffee");
				lblPumpkinCoffee.setForeground(Color.WHITE);
				lblPumpkinCoffee.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblPumpkinCoffee.setBounds(91, 388, 136, 19);
				dripcoffeeMenu.add(lblPumpkinCoffee);
				
				JLabel lblRegularCoffee = new JLabel("Regular Coffee");
				lblRegularCoffee.setForeground(Color.WHITE);
				lblRegularCoffee.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblRegularCoffee.setBounds(91, 199, 122, 19);
				dripcoffeeMenu.add(lblRegularCoffee);
				
				JLabel lblVanillaCoffee = new JLabel("Vanilla Coffee");
				lblVanillaCoffee.setForeground(Color.WHITE);
				lblVanillaCoffee.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblVanillaCoffee.setBounds(314, 200, 104, 16);
				dripcoffeeMenu.add(lblVanillaCoffee);
				
				JLabel lblHazelnutCoffee = new JLabel("Hazelnut Coffee");
				lblHazelnutCoffee.setForeground(Color.WHITE);
				lblHazelnutCoffee.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblHazelnutCoffee.setBounds(301, 388, 122, 16);
				dripcoffeeMenu.add(lblHazelnutCoffee);
				
				JLabel lblDripCoffee = new JLabel("Drip Coffee");
				lblDripCoffee.setForeground(Color.WHITE);
				lblDripCoffee.setFont(new Font("Dialog", Font.BOLD, 18));
				lblDripCoffee.setBounds(10, 11, 104, 16);
				dripcoffeeMenu.add(lblDripCoffee);
				
				JPanel frappuccinoMenu = new JPanel();
				frappuccinoMenu.setBackground(new Color(128, 0, 0));
				categoryContainer.add(frappuccinoMenu, "Frappuccino");
				frappuccinoMenu.setLayout(null);
				
				JButton btnChocolateFrap = new JButton(new ImageIcon(buttonIcon11));
				btnChocolateFrap.setText("Chocolate Frap");
				btnChocolateFrap.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());
					}
				});
				btnChocolateFrap.setBounds(56, 79, 180, 120);
				frappuccinoMenu.add(btnChocolateFrap);
				
				JButton btnVanillaFrap = new JButton(new ImageIcon(buttonIcon12));
				btnVanillaFrap.setText("Vanilla Frap");
				btnVanillaFrap.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());
					}
				});
				btnVanillaFrap.setBounds(270, 79, 180, 120);
				frappuccinoMenu.add(btnVanillaFrap);
				
				JButton btnCaramelFrap = new JButton(new ImageIcon(buttonIcon13));
				btnCaramelFrap.setText("Caramel Frap");
				btnCaramelFrap.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());
					}
				});
				btnCaramelFrap.setBounds(56, 270, 180, 120);
				frappuccinoMenu.add(btnCaramelFrap);
				
				JButton btnMintFrap = new JButton(new ImageIcon(buttonIcon19));
				btnMintFrap.setText("Mint Frap");
				btnMintFrap.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());
					}
				});
				btnMintFrap.setBounds(270, 270, 180, 120);
				frappuccinoMenu.add(btnMintFrap);
				
				JLabel lblCaramelFrappuccino = new JLabel("Caramel Frappuccino");
				lblCaramelFrappuccino.setForeground(Color.WHITE);
				lblCaramelFrappuccino.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblCaramelFrappuccino.setBounds(73, 388, 163, 16);
				frappuccinoMenu.add(lblCaramelFrappuccino);
				
				JLabel lblChocolateFrappuccino = new JLabel("Chocolate Frappuccino");
				lblChocolateFrappuccino.setForeground(Color.WHITE);
				lblChocolateFrappuccino.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblChocolateFrappuccino.setBounds(66, 198, 163, 16);
				frappuccinoMenu.add(lblChocolateFrappuccino);
				
				JLabel lblVanillaFrappuccino = new JLabel("Vanilla Frappuccino");
				lblVanillaFrappuccino.setForeground(Color.WHITE);
				lblVanillaFrappuccino.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblVanillaFrappuccino.setBounds(290, 199, 153, 16);
				frappuccinoMenu.add(lblVanillaFrappuccino);
				
				JLabel lblMintFrappuccino = new JLabel("Mint Frappuccino");
				lblMintFrappuccino.setForeground(Color.WHITE);
				lblMintFrappuccino.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblMintFrappuccino.setBounds(300, 388, 130, 16);
				frappuccinoMenu.add(lblMintFrappuccino);
				
				JLabel lblFrappuccino = new JLabel("Frappuccino");
				lblFrappuccino.setForeground(Color.WHITE);
				lblFrappuccino.setFont(new Font("Dialog", Font.BOLD, 18));
				lblFrappuccino.setBounds(10, 11, 130, 16);
				frappuccinoMenu.add(lblFrappuccino);
				
				JPanel latteMenu = new JPanel();
				latteMenu.setBackground(new Color(128, 0, 0));
				categoryContainer.add(latteMenu, "Latte");
				
				JButton btnHazelnutLatte = new JButton(new ImageIcon(buttonIcon14));
				btnHazelnutLatte.setText("Hazelnut Latte");
				btnHazelnutLatte.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());
					}
				});
				latteMenu.setLayout(null);
				btnHazelnutLatte.setBounds(56, 79, 180, 120);
				latteMenu.add(btnHazelnutLatte);
				
				JButton btnMochaLatte = new JButton(new ImageIcon(buttonIcon15));
				btnMochaLatte.setText("Mocha");
				btnMochaLatte.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());
					}
				});
				btnMochaLatte.setBounds(270, 79, 180, 120);
				latteMenu.add(btnMochaLatte);
				
				JButton btnVanillaLatte = new JButton(new ImageIcon(buttonIcon16));
				btnVanillaLatte.setText("Vanilla Latte");
				btnVanillaLatte.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());
					}
				});
				btnVanillaLatte.setBounds(56, 270, 180, 120);
				latteMenu.add(btnVanillaLatte);
				
				JButton btnCaramelLatte = new JButton(new ImageIcon(buttonIcon20));
				btnCaramelLatte.setText("Caramel Latte");
				btnCaramelLatte.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b =(JButton) e.getSource();
						addOrderItem(b.getText());
					}
				});
				btnCaramelLatte.setBounds(270, 270, 180, 120);
				latteMenu.add(btnCaramelLatte);
				
				JLabel lblVanillaLatte = new JLabel("Vanilla Latte");
				lblVanillaLatte.setForeground(Color.WHITE);
				lblVanillaLatte.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblVanillaLatte.setBounds(97, 388, 104, 16);
				latteMenu.add(lblVanillaLatte);
				
				JLabel lblHazelnutLatte = new JLabel("Hazelnut Latte");
				lblHazelnutLatte.setForeground(Color.WHITE);
				lblHazelnutLatte.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblHazelnutLatte.setBounds(89, 197, 126, 16);
				latteMenu.add(lblHazelnutLatte);
				
				JLabel lblMochaLatte = new JLabel("Mocha Latte");
				lblMochaLatte.setForeground(Color.WHITE);
				lblMochaLatte.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblMochaLatte.setBounds(316, 198, 112, 16);
				latteMenu.add(lblMochaLatte);
				
				JLabel lblCaramelLatte = new JLabel("Caramel Latte");
				lblCaramelLatte.setForeground(Color.WHITE);
				lblCaramelLatte.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblCaramelLatte.setBounds(304, 388, 112, 16);
				latteMenu.add(lblCaramelLatte);
				
				JLabel lblLattee = new JLabel("Lattee");
				lblLattee.setForeground(Color.WHITE);
				lblLattee.setFont(new Font("Dialog", Font.BOLD, 18));
				lblLattee.setBounds(10, 11, 104, 16);
				latteMenu.add(lblLattee);
				
				JLabel lblLatte = new JLabel("Lattes");
				lblLatte.setForeground(new Color(139, 0, 0));
				lblLatte.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				lblLatte.setBounds(71, 448, 47, 16);
				pnlMenu.add(lblLatte);
				
				JLabel lblFrappuccinos = new JLabel("Frappuccinos");
				lblFrappuccinos.setForeground(new Color(139, 0, 0));
				lblFrappuccinos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				lblFrappuccinos.setBounds(42, 304, 104, 16);
				pnlMenu.add(lblFrappuccinos);
				
				JLabel lblDripCoffees = new JLabel("Drip Coffees");
				lblDripCoffees.setForeground(new Color(139, 0, 0));
				lblDripCoffees.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				lblDripCoffees.setBounds(42, 154, 104, 16);
				pnlMenu.add(lblDripCoffees);
				
				JLabel lblTeas = new JLabel("Teas");
				lblTeas.setForeground(new Color(139, 0, 0));
				lblTeas.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				lblTeas.setBounds(71, 8, 36, 16);
				pnlMenu.add(lblTeas);
				
				
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
				btnFrappuccino.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cmenu.show(categoryContainer, "Frappuccino");
					}
				});
				btnLatte.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cmenu.show(categoryContainer, "Latte");
					}
				});
		if(Desktop.isDesktopSupported())desktop=Desktop.getDesktop();
//		btnBlackTea.setBounds(26, 30, 117, 105);
//		pnlMenu.add(btnBlackTea);
		
		JButton btnChai = new JButton("Chai");
		btnChai.setBounds(210, 184, 105, 68);
		
		
		JButton btnCancel = new JButton("Cancel Order");
		btnCancel.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				oidata.removeAllElements();
				isOrderEmpty = true;
			}
		});
		btnCancel.setBounds(95, 612, 123, 49);
		contentPane.add(btnCancel);
		
		
		//edit item quantity button
		JButton btnEdit = new JButton("Edit Amount");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = itemlist.getSelectedIndex();
				Order currorder = orders.get(orders.size()-1);
				OrderItem curroi = (OrderItem)itemlist.getSelectedValue();
				
				if (sel>-1){
					JFrame fAmount = new JFrame();
					JTextField tfamount = new JTextField("        "+curroi.quantity);
					tfamount.setHorizontalAlignment(SwingConstants.RIGHT);
					JPanel  pbuttons = new JPanel();
					JButton btnIncrease = new JButton("Increase");
					JButton btnDecrease = new JButton("Decrease");
					JButton btnUpdate = new JButton("Update");
					pbuttons.add(btnIncrease);
					pbuttons.add(tfamount);
					pbuttons.add(btnDecrease);
					JLabel avgLabel = new JLabel();		
					fAmount.setSize(240, 200);					
					fAmount.getContentPane().add(btnUpdate, BorderLayout.SOUTH);			
					fAmount.getContentPane().add(pbuttons,BorderLayout.CENTER);
					fAmount.setVisible(true);
					
					btnIncrease.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int curramount =Integer.parseInt(tfamount.getText().trim());						
						    tfamount.setText(""+(++curramount));
						}
					});
					
					btnDecrease.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int curramount =Integer.parseInt(tfamount.getText().trim());
							if (curramount>0){							
								tfamount.setText(""+(--curramount));
							}
						}
					});
					
					btnUpdate.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							curroi.quantity=Integer.parseInt(tfamount.getText().trim());
							oidata.remove(sel);
							oidata.insertElementAt(curroi, sel);
							updateitemlabel(currorder);
						}
					});
						
				}
			}
		});
		btnEdit.setBounds(266, 470, 112, 33);
		contentPane.add(btnEdit);
		
		JButton btnOverridePrice = new JButton("Override Price");
		btnOverridePrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = itemlist.getSelectedIndex();
				if (sel>-1){
					Order currorder = orders.get(orders.size()-1);
					OrderItem curroi = (OrderItem)itemlist.getSelectedValue();
					String newprice$ = JOptionPane.showInputDialog("Please enter the new price");
					curroi.unitprice = Double.parseDouble(newprice$);
					oidata.remove(sel);
					oidata.insertElementAt(curroi, sel);	
					updateitemlabel(currorder);
							
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select an item");
				}
			
			}
		});
		btnOverridePrice.setBounds(119, 470, 125, 33);
		contentPane.add(btnOverridePrice);
		
		JButton btnSubmitOrder = new JButton("Submit Order");
		btnSubmitOrder.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
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
		btnSubmitOrder.setBounds(254, 612, 126, 49);
		contentPane.add(btnSubmitOrder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 369, 339);
		contentPane.add(scrollPane);
		itemlist.setForeground(new Color(0, 0, 0));
		itemlist.setFont(new Font("Courier New", Font.PLAIN, 14));
		
		
		
		scrollPane.setViewportView(itemlist);
		
		JLabel labeldiscount = new JLabel("Discount:");
		labeldiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		labeldiscount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labeldiscount.setBounds(21, 513, 74, 14);
		contentPane.add(labeldiscount);
		
		JLabel lblDiscount = new JLabel("$0.00");
		lblDiscount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDiscount.setBounds(144, 513, 74, 14);
		contentPane.add(lblDiscount);
		
		JLabel label_Toal = new JLabel("Total: ");
		label_Toal.setHorizontalAlignment(SwingConstants.RIGHT);
		label_Toal.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_Toal.setBounds(174, 538, 85, 14);
		contentPane.add(label_Toal);
		
		lblTotal = new JLabel("$0.00");
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTotal.setBounds(308, 538, 74, 14);
		contentPane.add(lblTotal);
		
		JLabel label_Tax = new JLabel("Tax: ");
		label_Tax.setHorizontalAlignment(SwingConstants.RIGHT);
		label_Tax.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_Tax.setBounds(164, 513, 85, 14);
		contentPane.add(label_Tax);
		
		lblSubTotal = new JLabel("$0.00");
		lblSubTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblSubTotal.setBounds(144, 537, 74, 14);
		contentPane.add(lblSubTotal);
				
		lblTax = new JLabel("$0.00");
		lblTax.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTax.setBounds(308, 513, 74, 14);
		contentPane.add(lblTax);
		
		JLabel lblCustomer = new JLabel("Quantity");
		lblCustomer.setForeground(new Color(0, 0, 0));
		lblCustomer.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblCustomer.setBounds(95, 102, 69, 15);
		contentPane.add(lblCustomer);
		
		JLabel lblOrder = new JLabel("Name");
		lblOrder.setForeground(new Color(0, 0, 0));
		lblOrder.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblOrder.setBounds(10, 101, 61, 16);
		contentPane.add(lblOrder);
		
		JLabel lblUnitprice = new JLabel("Unit Price");
		lblUnitprice.setForeground(Color.BLACK);
		lblUnitprice.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblUnitprice.setBounds(212, 102, 83, 14);
		contentPane.add(lblUnitprice);
		
		JLabel lblTotal_1 = new JLabel("Total");
		lblTotal_1.setForeground(Color.BLACK);
		lblTotal_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblTotal_1.setBounds(332, 102, 46, 14);
		contentPane.add(lblTotal_1);
		
		JLabel label = new JLabel("Sub Total:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label.setBounds(20, 538, 74, 14);
		contentPane.add(label);
		
		
		
		JPanel panel = new JPanel();		
		panel.setBackground(new Color(210, 180, 140));
		panel.setBounds(0, 92, 386, 589);
		contentPane.add(panel);
		
		//Tea Prices
		items.put("Black Tea",1.5d);
		items.put("Chai Tea",1.75d);
		items.put("Herbal Tea",1.25d);
		items.put("Rooibos Tea", 1.75d);
		//Coffee Prices
		items.put("Regular Coffee",1.25d);
		items.put("Vanilla Coffee",1.5d);
		items.put("Pumpkin Coffee",1.6d);
		items.put("Hazelnut Coffee", 1.7d);
		//Frappuccino Prices
		items.put("Chocolate Frap",3.25d);
		items.put("Vanilla Frap",3.5d);
		items.put("Caramel Frap",3.6d);
		items.put("Mint Frap",3.7d);
		//Latte Price
		items.put("Hazelnut Latte",3.25d);
		items.put("Mocha",3.5d);
		items.put("Vanilla Latte",3.6d);
		items.put("Caramel Latte",3.6d);

	}
	
	public void addOrderItem(String itemname){
		
		OrderItem oi = new OrderItem(itemname,items.get(itemname));
		
		if (isOrderEmpty){
			Order newOrder = new Order();	
			isOrderEmpty=false;
			newOrder.orderitems.add(oi);
			oidata.addElement(oi);
			System.out.println(newOrder.getSubtotal());
			updateitemlabel(newOrder);
			
			
			
		}
		else {
			Order currOrder = orders.get(orders.size()-1);
			if(currOrder.orderitems.contains(oi)){
				
			}
			else {
				currOrder.orderitems.add(oi);
				oidata.addElement(oi);
				updateitemlabel(currOrder);
			}
		}	
		
	}

	private void updateitemlabel(Order currOrder) {
		System.out.println("updateitemlabel runned");
		lblSubTotal.setText("$"+currOrder.getSubtotal());
		lblTax.setText("$"+currOrder.getTax());
		lblTotal.setText("$"+currOrder.getTotal());
	

	}
	
	class Order{
		ArrayList<OrderItem> orderitems = new ArrayList<OrderItem>();
		boolean isDinein;
		
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
		OrderItem(){
			
		}
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