package GUI;
import SIC.Register;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	JTextPane memoryText;
	JTextArea textRegA, textRegX, textRegL, textRegB;
	JTextArea textRegS, textRegT, textRegPC, textRegSW;
	
	public Panel() {
		setForeground(Color.WHITE);
		setBackground(new Color(169, 169, 169));
		setLayout(null);
		
		JLabel lblSicXeSimulator = new JLabel("SIC XE Simulator");
		lblSicXeSimulator.setBackground(new Color(0, 0, 0));
		lblSicXeSimulator.setBounds(145, 11, 152, 22);
		lblSicXeSimulator.setForeground(new Color(0, 0, 0));
		lblSicXeSimulator.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblSicXeSimulator);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(31, 43, 89, 23);
		add(btnNewButton);
		
		JButton btnStep = new JButton("STEP");
		btnStep.setSelectedIcon(new ImageIcon(Panel.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-medium.png")));
		btnStep.setForeground(new Color(0, 0, 0));
		btnStep.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnStep.setBounds(31, 110, 89, 23);
		add(btnStep);
		
		JLabel lblMemDump = new JLabel("Memory");
		lblMemDump.setForeground(new Color(0, 0, 0));
		lblMemDump.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMemDump.setBounds(21, 266, 89, 23);
		add(lblMemDump);
		
		memoryText = new JTextPane();
		memoryText.setEditable(false);
		memoryText.setForeground(Color.BLACK);
		memoryText.setBackground(Color.WHITE);
		memoryText.setBounds(21, 289, 408, 100);
		JScrollPane jsp = new JScrollPane(memoryText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setBounds(21, 297, 408, 98);
		//add(memoryText);
		add(jsp);
		
		textRegA = new JTextArea();
		textRegA.setEditable(false);
		textRegA.setBounds(37, 188, 66, 22);
		add(textRegA);
		
		textRegX = new JTextArea();
		textRegX.setEditable(false);
		textRegX.setBounds(140, 188, 66, 22);
		add(textRegX);
		
		textRegL = new JTextArea();
		textRegL.setEditable(false);
		textRegL.setBounds(243, 188, 66, 22);
		add(textRegL);
		
		textRegB = new JTextArea();
		textRegB.setEditable(false);
		textRegB.setBounds(346, 188, 66, 22);
		add(textRegB);
		
		textRegPC = new JTextArea();
		textRegPC.setEditable(false);
		textRegPC.setBounds(243, 233, 66, 22);
		add(textRegPC);
		
		textRegSW = new JTextArea();
		textRegSW.setEditable(false);
		textRegSW.setBounds(346, 233, 66, 22);
		add(textRegSW);
		
		textRegT = new JTextArea();
		textRegT.setEditable(false);
		textRegT.setBounds(140, 233, 66, 22);
		add(textRegT);
		
		textRegS = new JTextArea();
		textRegS.setEditable(false);
		textRegS.setBounds(37, 233, 66, 22);
		add(textRegS);
		
		JLabel lblRegisters = new JLabel("Registers");
		lblRegisters.setForeground(new Color(0, 0, 0));
		lblRegisters.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegisters.setBounds(176, 142, 72, 19);
		add(lblRegisters);
		
		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblA.setBounds(66, 172, 8, 14);
		add(lblA);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblX.setBounds(169, 172, 8, 14);
		add(lblX);
		
		JLabel lblL = new JLabel("L");
		lblL.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblL.setBounds(272, 172, 8, 14);
		add(lblL);
		
		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblB.setBounds(375, 172, 8, 14);
		add(lblB);
		
		JLabel lblS = new JLabel("S");
		lblS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblS.setBounds(66, 218, 8, 14);
		add(lblS);
		
		JLabel lblT = new JLabel("T");
		lblT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblT.setBounds(169, 218, 8, 14);
		add(lblT);
		
		JLabel lblPc = new JLabel("PC");
		lblPc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPc.setBounds(269, 218, 14, 14);
		add(lblPc);
		
		JLabel lblSw = new JLabel("SW");
		lblSw.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSw.setBounds(370, 218, 18, 14);
		add(lblSw);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setForeground(Color.BLACK);
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLoad.setBounds(31, 76, 89, 23);
		add(btnLoad);
		
		JTextArea textArea_1_2 = new JTextArea();
		textArea_1_2.setEditable(false);
		textArea_1_2.setBounds(272, 100, 111, 22);
		add(textArea_1_2);
		
		JLabel lblInstruction = new JLabel("Instruction");
		lblInstruction.setForeground(Color.BLACK);
		lblInstruction.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInstruction.setBounds(286, 76, 83, 19);
		add(lblInstruction);

	}
	
	protected void updateMemText(String mem) {
		memoryText.setText(mem);
	}
	
	protected void updateReg(Register r) {
		textRegA.setText(Integer.toString(r.get("A")));
		textRegX.setText(Integer.toString(r.get("X")));
		textRegL.setText(Integer.toString(r.get("L")));
		textRegB.setText(Integer.toString(r.get("B")));
		textRegS.setText(Integer.toString(r.get("S")));
		textRegT.setText(Integer.toString(r.get("T")));
		textRegPC.setText(Integer.toString(r.get("PC")));
		textRegSW.setText(Integer.toString(r.get("SW")));		
	}
}
