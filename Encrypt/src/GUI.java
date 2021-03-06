import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import java.awt.Font;

public class GUI implements ActionListener {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	JLabel lblNewLabel;
	JButton btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3;
	JRadioButton rdbtnNewRadioButton, rdbtnNewRadioButton_1, rdbtnNewRadioButton_2, rdbtnNewRadioButton_3;
	JTextArea textArea, textArea_1, textArea_2;
	private static String username;
	private String methods;
	private String mode;
	String cryptedMessage;
	private boolean cancel = false;
	Socket s;
	DataOutputStream dos;
	DataInputStream dis;
	SecretKey AESKey;
	SecretKey DESKey;
	IvParameterSpec DESIV;
	IvParameterSpec AESIV;
	String clients;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
					// window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public GUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {

		InetAddress ip = InetAddress.getByName("localhost");
		s = new Socket(ip, 1904);
		dis = new DataInputStream(s.getInputStream());
		dos = new DataOutputStream(s.getOutputStream());

		frame = new JFrame();
		frame.setBounds(100, 100, 600, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblNewLabel = new JLabel("Not Connected");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnNewButton_1 = new JButton("Send");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnNewButton_1.addActionListener(this);

		btnNewButton_2 = new JButton("Connect");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnNewButton_2.addActionListener(this);

		btnNewButton_3 = new JButton("Disconnect");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnNewButton_3.addActionListener(this);

		rdbtnNewRadioButton = new JRadioButton("AES");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("DES");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("CBC");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup_1.add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_3 = new JRadioButton("OFB");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup_1.add(rdbtnNewRadioButton_3);

		btnNewButton = new JButton("Encrypt");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnNewButton.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("Method");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblNewLabel_2 = new JLabel("Mode");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));

		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(0, 0, 0, 0)));

		textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);

		textArea_1.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(0, 0, 0, 0)));

		textArea_2 = new JTextArea(10, 2);
		textArea_2.setWrapStyleWord(true);
		textArea_2.setLineWrap(true);
		textArea_2.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(0, 0, 0, 0)));

		JLabel lblNewLabel_3 = new JLabel("Text");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblNewLabel_4 = new JLabel("Crypted Text");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(10).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(btnNewButton_2).addGap(10)
										.addComponent(btnNewButton_3).addGap(6)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(rdbtnNewRadioButton).addGap(2)
														.addComponent(rdbtnNewRadioButton_1).addGap(2)
														.addComponent(rdbtnNewRadioButton_2).addGap(2)
														.addComponent(rdbtnNewRadioButton_3, GroupLayout.PREFERRED_SIZE,
																109, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup().addGap(8)
														.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 91,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblNewLabel_2))))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_4)
												.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
														.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 172,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 77,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 72,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED))))))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel,
								GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)))
				.addGap(62))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_3)
						.addContainerGap(528, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(textArea_2, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(4)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3).addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnNewRadioButton_1).addComponent(rdbtnNewRadioButton_2)
						.addComponent(rdbtnNewRadioButton_3))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(textArea_2, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4))
				.addGap(3)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(25)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
										.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
								.addGap(22))
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
										.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE).addGap(1)));
		frame.getContentPane().setLayout(groupLayout);
	}

	public String name() {
		return username;
	}

	public boolean disconnect() {
		System.out.println(cancel);
		return cancel;
	}

	public String method() {
		return methods;
	}

	public String modes() {
		return mode;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnNewButton_2)) {
			username = JOptionPane.showInputDialog(frame, "Enter user name:", null);
			lblNewLabel.setText("Connected: " + username);

			try {

				AESKey = EncryptDecrypt.SecretkeyDecode(dis.readUTF(), "AES");
				DESKey = EncryptDecrypt.SecretkeyDecode(dis.readUTF(), "DES");
				DESIV = EncryptDecrypt.ivDecode(dis.readUTF());
				AESIV = EncryptDecrypt.ivDecode(dis.readUTF());

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			btnNewButton_2.setEnabled(false);
			btnNewButton_3.setEnabled(true);

		} else if (e.getSource().equals(btnNewButton_3)) {

			System.out.println("CLOSE CLIENT SOCKET HERE");

			try {
				dos.writeUTF("Disconnect");
				dos.flush();
				s.close();
				dos.close();
				dis.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			btnNewButton_3.setEnabled(false);
			btnNewButton_2.setEnabled(true);
			lblNewLabel.setText("Not Connected");

		} else if (e.getSource().equals(btnNewButton)) {

			if (rdbtnNewRadioButton.isSelected()) {
				methods = "AES";
				System.out.println(methods);
			} else if (rdbtnNewRadioButton_1.isSelected()) {
				methods = "DES";
				System.out.println(methods);
			} else {
				System.out.println("No method is selected");
			}

			if (rdbtnNewRadioButton_2.isSelected()) {
				mode = "CBC";
				System.out.println(mode);
			} else if (rdbtnNewRadioButton_3.isSelected()) {
				mode = "OFB";
				System.out.println(mode);
			} else {
				System.out.println("No mode is selected");
			}

			if (methods.equals("AES")) {

				try {
					cryptedMessage = EncryptDecrypt.encrypt(textArea.getText(), AESIV, AESKey, methods, mode);
				} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
						| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e1) {
					// TODO Auto-generated catch block
					(e1).printStackTrace();
				}
				
				textArea_1.setText(cryptedMessage);

			}

			else {
				try {
					cryptedMessage = EncryptDecrypt.encrypt(textArea.getText(), DESIV, DESKey, methods, mode);
				} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
						| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textArea_1.setText(cryptedMessage);
			}

		} else if (e.getSource().equals(btnNewButton_1)) {

			try {
				System.out.println("logged in UserName "+ username);
				dos.writeUTF(username);
				dos.flush();
				dos.writeUTF(cryptedMessage);
				dos.flush();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
