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
	private JButton btnOn, btnFm, btnGuardar, btnSubir, btnBajar, btnCargar;
	private JTextField txtFrecuenciaActual;
	private JComboBox cbxFrecuencias;
	private boolean a;
	private Double[] frecuencia;
	private JList miLista;

	DefaultListModel lstModelActividades=new DefaultListModel();


	private Carro miCarro= new Carro();
	Listener miListener= new Listener();
	public GUI(){
		a=miCarro.getEncendido();
		initialize();
		for (int i=0;i<13;i++){
			frecuencia[i]=0.0;
		}
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
		String frecuenciaRadio= Double.toString(miCarro.getEmisora());
		txtFrecuenciaActual.setText(frecuenciaRadio);
		txtFrecuenciaActual.setEditable(false);
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

		btnGuardar=new JButton("Guardar");
		btnGuardar.setBounds(10,200,125,30);
		btnGuardar.addActionListener(miListener);
		btnGuardar.setEnabled(false);
		pnlBienvenida.add(btnGuardar);

		btnCargar=new JButton("Cargar");
		btnGuardar.setBounds(10,200,125,30);
		btnCargar.addActionListener(miListener);
		btnCargar.setVisible(true);
		btnCargar.setEnabled(false);
		pnlBienvenida.add(btnCargar);

		miLista=new JList();
		for (int i=0;i<13;i++){
			String tempLlenar=String.valueOf(frecuencia[i]);
			lstModelActividades.addElement(tempLlenar);
		}
		miLista.setModel(lstModelActividades);
		miLista.setBounds(10,10,100,100);
		miLista.setVisible(true);
		pnlBienvenida.add(miLista);

	}

	public class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Object fuente=e.getSource();
			if (fuente==btnOn){
				miCarro.ON_OFF();
				a=miCarro.getEncendido();
				if (a==true){
					btnBajar.setEnabled(true);
					btnSubir.setEnabled(true);
					btnFm.setEnabled(true);
					btnGuardar.setEnabled(true);
					btnCargar.setEnabled(true);
				}
				else{
					btnBajar.setEnabled(false);
					btnSubir.setEnabled(false);
					btnFm.setEnabled(false);
					btnGuardar.setEnabled(false);
					btnCargar.setEnabled(false);
				}				
			}
			else if(fuente==btnGuardar){
				//String tempStringFrecuencia=txtFrecuenciaActual.getText();
				//String tempPosicion=cbxFrecuencias.getSelectedItem().toString();
				//double tempValor=Double.parseDouble(tempStringFrecuencia);
				//int tempIntPosicion=Integer.parseInt(tempPosicion);
				//frecuencia[tempIntPosicion]=tempValor;
				int tempInt=(Integer) cbxFrecuencias.getSelectedItem();
				miCarro.Guardar_Emisora(tempInt);
			}
			else if (fuente==btnSubir){
				miCarro.Cambio_de_Emisora(false);
				String tempString=Double.toString(miCarro.getEmisora());
				txtFrecuenciaActual.setText(tempString);
			}
			else if (fuente==btnBajar){
				miCarro.Cambio_de_Emisora(true);
				String tempString=Double.toString(miCarro.getEmisora());
				txtFrecuenciaActual.setText(tempString);
			}
			else if (fuente==btnFm){
				if(btnFm.getText()=="Fm")
					btnFm.setText("Am");
				else if(btnFm.getText()=="Am")
					btnFm.setText("Fm");
			}
			else if(fuente==btnCargar){
				int tempInt=(Integer) cbxFrecuencias.getSelectedItem();
				miCarro.Seleccionar_emisora_guardada(tempInt);
				String b=Double.toString(miCarro.getEmisora()); 
				txtFrecuenciaActual.setText(b);
			}
		}
	}

}