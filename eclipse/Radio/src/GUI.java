import javax.swing.*;
import java.awt.*;

public class GUI{
	private JPanel pnlBienvenida;
	private JFrame miFrame;

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
		miFrame.add(pnlBienvenida);


	}

}