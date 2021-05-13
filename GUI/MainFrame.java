package GUI;

import SIC.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	SIC sic;
	private JPanel contentPane;
	private Panel mainPanel =  new Panel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		getContentPane().add(mainPanel);
		
		Memory mem = new Memory();
		Register r = new Register();
		mainPanel.updateMemText(mem.memoryString());
		mainPanel.updateReg(r);
		//sic = new SIC();
		//SIC.memory.memoryString();
		
	}

}
