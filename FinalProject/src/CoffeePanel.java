import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class CoffeePanel extends JFrame {

	private JPanel contentPane;
	BufferedImage buttonIcon1 = ImageIO.read(new File("coffee1.jpg"));	
	BufferedImage buttonIcon2 = ImageIO.read(new File("coffee2.jpg"));
	CardLayout c1 = new CardLayout();

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
		pnlMenu.setBounds(370, 44, 378, 428);
		pnlContainer.add(pnlMenu,"Menu");
		c1.show(pnlContainer, "Menu");
		
		
		JButton btnIceCoffee = new JButton(new ImageIcon(buttonIcon1));
		btnIceCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});		
		btnIceCoffee.setBounds(27, 62, 117, 68);
		pnlMenu.add(btnIceCoffee);
		JButton btnLattee = new JButton(new ImageIcon(buttonIcon2));
		btnLattee.setBounds(210, 62, 117, 68);
		pnlMenu.add(btnLattee);
		
		JButton btnMocha = new JButton("Mocha");
		btnMocha.setBounds(27, 161, 117, 68);
		pnlMenu.add(btnMocha);
		
		JButton btnFrabuchinno = new JButton("Frabuchinno");
		btnFrabuchinno.setBounds(210, 161, 117, 68);
		pnlMenu.add(btnFrabuchinno);
		
		JButton btnBlackTea = new JButton("Black Tea");
		btnBlackTea.setBounds(27, 253, 117, 68);
		pnlMenu.add(btnBlackTea);
		
		JButton btnChai = new JButton("Chai");
		btnChai.setBounds(210, 253, 117, 68);
		pnlMenu.add(btnChai);
		
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
		btnSubmitOrder.setBounds(247, 423, 104, 49);
		contentPane.add(btnSubmitOrder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 47, 315, 252);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
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
		lblTotal.setBounds(225, 335, 70, 14);
		contentPane.add(lblTotal);
		
		JLabel label_6 = new JLabel("$ 0.00");
		label_6.setBounds(305, 335, 46, 14);
		contentPane.add(label_6);
		
		JLabel lblTax = new JLabel("Tax: ");
		lblTax.setBounds(225, 310, 70, 14);
		contentPane.add(lblTax);
		
		JLabel label_8 = new JLabel("$ 0.00");
		label_8.setBounds(305, 310, 46, 14);
		contentPane.add(label_8);
		
		JLabel lblBalanceDue = new JLabel("Balance Due: ");
		lblBalanceDue.setBounds(225, 360, 70, 14);
		contentPane.add(lblBalanceDue);
		
		JLabel label_10 = new JLabel("$ 0.00");
		label_10.setBounds(305, 360, 46, 14);
		contentPane.add(label_10);
		
		JLabel lblJohnDoe = new JLabel("John Doe");
		lblJohnDoe.setBounds(10, 22, 91, 14);
		contentPane.add(lblJohnDoe);
		

	}
}