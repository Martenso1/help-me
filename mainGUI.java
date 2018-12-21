import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;


public class mainGUI extends JFrame implements  ActionListener
{
	private int productID = 0;
	private ProductList productList = new ProductList();
	
	private JButton stockBtn = new JButton ("RE-STOCK");
	private JButton sellItemBtn=new JButton("SELL");
	private JButton changePriceBtn=new JButton("Change Price");
	private JComboBox productListBox=new JComboBox();
	private JButton refreshComboBtn=new JButton("Refresh Item Information");
	private JTextArea inputTxTbox=new JTextArea("");
	
	private JLabel productInfolbl=new JLabel("Product Information:");
	private JTextArea productInfotxtbox=new JTextArea();
	private JTextField nameField = new JTextField();
	private JLabel nameFieldLbl=new JLabel("Enter Value:");

	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu fileMenu = new JMenu("File");
	
	private JMenuItem addItem = new JMenuItem("Add item");
	private JMenuItem exit = new JMenuItem("Exit");	


	//private JTable table;
				

	
	//gui
	public mainGUI(){
		setTitle("U1610329");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,290);
		setLocation(500,500);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		setJMenuBar(menuBar);
		
		menuBar.add(fileMenu);
		
		fileMenu.add(addItem);
		fileMenu.add(exit);
		
		addItem.addActionListener(this);
		exit.addActionListener(this);
		
		add(stockBtn);
		stockBtn.addActionListener(this);
		add(sellItemBtn);
		sellItemBtn.addActionListener(this);
		add(changePriceBtn);
		changePriceBtn.addActionListener(this);
		add(productListBox);
		add(refreshComboBtn);
		refreshComboBtn.addActionListener(this);
		refreshComboBtn.setBounds(25,180,400,40);
		stockBtn.setBounds(165,50,110,50);
		sellItemBtn.setBounds(25,50,110,50);
		changePriceBtn.setBounds(295,50,130,50);
		productListBox.setBounds(25,10,400,30);
		productListBox.addActionListener(this);
		
		
		add(nameFieldLbl);
		nameFieldLbl.setBounds(25,97,75,50);
		add(nameField);
		nameField.setBounds(105,110,200,25);
		
		add(productInfolbl);
		add(productInfotxtbox);
		productInfolbl.setBounds(25,135,125,50);
		productInfotxtbox.setBounds(150,150,275,20);
		
		for(int i = 0; i < productList.getSize(); i++)
		{
			productListBox.addItem(productList.getItem(i).getName());
		}
		
		updatePage();
		
		/*
		DefaultTableModel model = new DefaultTableModel();
		JTable table=new JTable(model);
		JScrollPane sp=new JScrollPane(table);
		
		model.addColumn("Product Name");
		model.addColumn("Product Quantity");
		model.addColumn("Product Price");
		
		for(Object[] i : productList)
		{
			model.addRow(i);
		}
		
		//sp.setPreferredSize(new Dimension(100,100));
		
		add(sp);
		sp.setBounds(25,100,400,150);
		*/
		
	 	// ArrayList < Product> testArray = new ArrayList <Product> ();
	 	// productListLi.setModel(new DefaultComboBoxModel(testArray.toArray()));
	 	
	 	
		setVisible(true);

	}
	
	public void updatePage()
	{
		productInfotxtbox.setText(productList.getItem(productID).getName() +",  Product Price: £"
			+productList.getItem(productID).getPrice() +",  In Stock: "
			+productList.getItem(productID).getStockLevel());
	}
				


	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if (e.getSource()==exit)
			{
				System.exit(0);
			}
			if(e.getSource() == addItem)
			{
				try
				{
					String name = JOptionPane.showInputDialog(null, "Enter name: ", "");
					int stock = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter stock: ", "0"));
					double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter price: ", "0"));
					
					productList.addItem(new Product(name, stock, price));
					productListBox.addItem(productList.getItem(productList.getSize()-1).getName());
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "Invalid value!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			if(e.getSource() == refreshComboBtn)
			{
				productID = productListBox.getSelectedIndex();
				updatePage();
			}
			
			else if(e.getSource()==stockBtn)
			{
				boolean valid = productList.getItem(productID).reStock(Integer.parseInt(nameField.getText()));
				if(!valid)
				{
					JOptionPane.showMessageDialog(null, "Invalid stock!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else updatePage();
			}
			
			else if(e.getSource()==sellItemBtn)
			{
				double amount = productList.getItem(productID).sell(Integer.parseInt(nameField.getText()));
				if(amount == -1)
				{
					JOptionPane.showMessageDialog(null, "Not enough in stock!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else updatePage();
			}
			else if(e.getSource()==changePriceBtn)
			{
				boolean valid = productList.getItem(productID).setPrice(Double.parseDouble(nameField.getText()));
				
				if(!valid)
				{
					JOptionPane.showMessageDialog(null, "Invalid price!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else updatePage();
			}
		}
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}		

}


		