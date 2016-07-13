import static org.junit.Assert.*;
import org.junit.Test;

public class Test {

	public void testEmisoraActual(){
		Carro tester=new Carro();

		//test de obtener emisora
		assertEquals("debe de tener 89.7",89.7, tester.getEmisora());

		//no puedo hacer test de los otros porque como son metodos
		//void no puedo analizar si regresan el valor que se quiere

		//pero puedo hacer pruebas de los sets y gets

		//test de getOn
		assertEquals("deberia de estar apagado (false)",false,tester.getEncendido());

		//test de geFm
		assertEquals("deberia de estar en true (en fm)",true,tester.getFm());

	} 
}
