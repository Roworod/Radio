
public class Carro implements Radio {
	private double estacionActual;
	private double[] estacionesMemoria;
	private boolean on;
	private boolean fm;
	private int posicion;
	private boolean subirBajar;
	
	public Carro() {
		// TODO Auto-generated constructor stub
		on=false;
		fm=true;
		posicion=0;
		estacionActual=89.7;
		estacionesMemoria=new double[12];	
	}

	@Override
	public void ON_OFF() {
		// TODO Auto-generated method stub
		on=!on;
	}

	@Override
	public void AM_FM() {
		// TODO Auto-generated method stub
		fm=!fm;
	}

	@Override
	public void Cambio_de_Emisora(boolean subirBajar) {
		// TODO Auto-generated method stub
		if (subirBajar=true)
			estacionActual+=0.3;
		else if(subirBajar==false)
			estacionActual-=0.3;
	}

	@Override
	public void Guardar_Emisora(int posicion) {
		// TODO Auto-generated method stub
		estacionesMemoria[posicion]=estacionActual;
	}

	@Override
	public void Seleccionar_emisora_guardada(int posicion) {
		// TODO Auto-generated method stub
		estacionActual=estacionesMemoria[posicion];
	}

	public void Guardar_seleccion(){};

	public double getEmisora(){
		return estacionActual;
	}

	public boolean getEncendido(){
		return on;
	}

	public boolean getFm(){
		return fm;
	}

	
}
