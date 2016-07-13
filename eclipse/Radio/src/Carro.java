
public class Carro implements Radio {
	private double EstacionActual;
	private double[] EstacionesMemoria;
	private boolean On;
	private boolean Fm;
	private int posicion;
	private boolean subirBajar;
	
	public Carro() {
		// TODO Auto-generated constructor stub
		On=false;
		Fm=true;
		posicion=0;
		EstacionActual=89.7;
		for (int i=0;i<13;i++){
			EstacionesMemoria[i]=0;
		}		
	}

	@Override
	public void ON_OFF() {
		// TODO Auto-generated method stub
		On=!On;
	}

	@Override
	public void AM_FM() {
		// TODO Auto-generated method stub
		Fm=!Fm;
	}

	@Override
	public void Cambio_de_Emisora(boolean subirBajar) {
		// TODO Auto-generated method stub
		if (subirBajar=true)
			EstacionActual+=0.3;
		else
			EstacionActual-=0.3;
	}

	@Override
	public void Guardar_Emisora(int posicion) {
		// TODO Auto-generated method stub
		EstacionesMemoria[posicion]=EstacionActual;
	}

	@Override
	public void Seleccionar_emisora_guardada(int posicion) {
		// TODO Auto-generated method stub
		EstacionActual=EstacionesMemoria[posicion];
	}

	public void Guardar_seleccion(){};

	public double getEmisora(){
		return EstacionActual;
	}

	public boolean getEncendido(){
		return On;
	}

	public boolean getFm(){
		return Fm;
	}

	
}
