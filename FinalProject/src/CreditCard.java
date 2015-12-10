import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CreditCard extends JFrame {

	private JPanel creditContentPane;
	private JTextField txtName;
	private JTextField txtCardNum;
	private JTextField txtSecurityCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditCard frame = new CreditCard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreditCard() {
		setTitle("Credit/Debit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 392);
		creditContentPane = new JPanel();
		creditContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		creditContentPane.setLayout(null);
		setContentPane(creditContentPane);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(35, 27, 104, 18);
		creditContentPane.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(35, 48, 263, 29);
		creditContentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCardNumber.setBounds(35, 88, 104, 18);
		creditContentPane.add(lblCardNumber);
		
		txtCardNum = new JTextField();
		txtCardNum.setColumns(10);
		txtCardNum.setBounds(35, 109, 263, 29);
		creditContentPane.add(txtCardNum);
		
		JLabel lblExpirationDate = new JLabel("Expiration Date:");
		lblExpirationDate.setFont(new Font("Dialog", Font.BOLD, 14));
		lblExpirationDate.setBounds(35, 159, 160, 18);
		creditContentPane.add(lblExpirationDate);
		
		JLabel lblSecurityCode = new JLabel("Security Code");
		lblSecurityCode.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSecurityCode.setBounds(35, 231, 104, 18);
		creditContentPane.add(lblSecurityCode);
		
		txtSecurityCode = new JTextField();
		txtSecurityCode.setColumns(10);
		txtSecurityCode.setBounds(35, 252, 72, 29);
		creditContentPane.add(txtSecurityCode);
		
		String[] monthStrings = { "Jan", "Feb", "Mar", "Apr", "May", 
				"June","July","Aug","Sep","Oct","Nov","Dec"};
		JComboBox cbxMonth = new JComboBox(monthStrings);
		cbxMonth.setSelectedIndex(11);
		cbxMonth.setMaximumRowCount(12);
		cbxMonth.setBounds(35, 188, 72, 32);
		creditContentPane.add(cbxMonth);
		
		String[] yearStrings = {"2015","2016","2017","2018","2019","2020","2021","2022","2023","2024"};
		JComboBox cbxYear = new JComboBox(yearStrings);
		cbxYear.setMaximumRowCount(20);
		cbxYear.setBounds(133, 188, 72, 32);
		creditContentPane.add(cbxYear);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(72, 306, 89, 36);
		creditContentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(194, 306, 89, 36);
		creditContentPane.add(btnCancel);
	}
}
