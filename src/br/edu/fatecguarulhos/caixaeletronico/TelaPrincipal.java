package br.edu.fatecguarulhos.caixaeletronico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Caixa Eletronico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 723);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 245, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "M\u00F3dulo do Cliente:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "M\u00F3dulo do Administrador:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "M\u00F3dulo do Cliente:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/resource/imagembanco.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 324, Short.MAX_VALUE)
						.addComponent(label, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(41)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
		);
		
		JButton btnSair = new JButton("Sair");
		panel_2.add(btnSair);
		btnSair.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnSair.setBackground(new Color(255, 128, 128));
		panel_1.setLayout(new GridLayout(0, 1, 0, 7));
		
		JButton btnRelaCedu = new JButton("Relatório de Cedulas");
		panel_1.add(btnRelaCedu);
		btnRelaCedu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnRelaCedu.setBackground(new Color(255, 255, 255));
		
		JButton btnValor = new JButton("Valor total disponível");
		panel_1.add(btnValor);
		btnValor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnValor.setBackground(new Color(255, 255, 255));
		
		JButton btnRepo = new JButton("Reposição de Cédulas");
		panel_1.add(btnRepo);
		btnRepo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnRepo.setBackground(new Color(255, 255, 255));
		
		JButton btnCota = new JButton("Cóta Mínima");
		panel_1.add(btnCota);
		btnCota.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnCota.setBackground(new Color(255, 255, 255));
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnEfeSaque = new JButton("Efetuar Saque");
		btnEfeSaque.setForeground(new Color(255, 255, 255));
		panel.add(btnEfeSaque);
		btnEfeSaque.setBackground(new Color(21, 102, 84));
		btnEfeSaque.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		contentPane.setLayout(gl_contentPane);

	}
}
