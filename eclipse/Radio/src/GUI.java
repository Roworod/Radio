import java.awt.EventQueue;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class GUI{
	private JPanel pnlBienvenida;
	private JFrame miFrame;
	private JButton btnOn, btnFm, btnGuardar, btnSubir, btnBajar;
	private JTextField txtFrecuenciaActual;
	private JComboBox cbxFrecuencias;

	Listener miListener= new Listener();
	
	public GUI(){
		initialize();
	}

	public void initialize(){
		miFrame= new JFrame("PIONEER");
		miFrame.setSize(700,500);
		miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miFrame.setVisible(true);

		//panel bienvienida
		pnlBienvenida=new JPanel();
		pnlBienvenida.setBounds(10,10,600,450);
		pnlBienvenida.setVisible(true);
		pnlBienvenida.setLayout(null);
		miFrame.add(pnlBienvenida);

		btnOn= new JButton("Encendido");
		btnOn.setBounds(500,400,100,50);
		btnOn.addActionListener(miListener);
		pnlBienvenida.add(btnOn);

		btnFm=new JButton("Fm");
		btnFm.setBounds(500,350,100,50);
		btnFm.addActionListener(miListener);
		btnFm.setEnabled(false);
		pnlBienvenida.add(btnFm);

		txtFrecuenciaActual= new JTextField();
		txtFrecuenciaActual.setText("unabled");
		txtFrecuenciaActual.setBounds(100,10,200,20);
		txtFrecuenciaActual.setVisible(true);
		pnlBienvenida.add(txtFrecuenciaActual);

		btnSubir=new JButton("Prev");
		btnSubir.setBounds(10,10,75,20);
		btnSubir.addActionListener(miListener);
		btnSubir.setEnabled(false);
		pnlBienvenida.add(btnSubir);

		btnBajar=new JButton("Next");
		btnBajar.setBounds(310,10,75,20);
		btnBajar.setEnabled(false);
		btnBajar.addActionListener(miListener);
		pnlBienvenida.add(btnBajar);


		cbxFrecuencias= new JComboBox();
		cbxFrecuencias.setBounds(10,50,100,30);
		for (int i=0;i<12;i++)
			cbxFrecuencias.addItem(i);
		pnlBienvenida.add(cbxFrecuencias);

	}

	public class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Object fuente=e.getSource();
			if (fuente==btnOn){
				Carro miCarro=new Carro();
				if (miCarro.getEncendido()==true){
					btnBajar.setEnabled(true);
					btnSubir.setEnabled(true);
					btnFm.setEnabled(true);
				}
				else{
					btnBajar.setEnabled(false);
					btnSubir.setEnabled(false);
					btnFm.setEnabled(false);
				}			

			}
		}
	}

}