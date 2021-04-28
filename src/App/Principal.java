package App;

import java.util.ArrayList;
import java.util.List;

import RegPai.Pais;
import RegPai.Region;

public class Principal extends Thread {
	public static void main(String[] args) {
		//Importamos el CSV y los datos que queremos
		//Pais.ImportarCSV();
		//Creamos el pais en su region
		List<Pais> paises = new ArrayList<Pais>();
		
		paises.add(new Pais("Iran","Middle East and North Africa","0.710","66.300","0.608","0.218","0.714")); 
		paises.add(new Pais("Bulgaria","Central and Eastern Europe","0.931","67.000","0.788","-0.096","0.932"));
		
		//Pais.ExportarCSV(paises);
		
		//Leer el archivo y calcular su promedio
		Region r1 = new Region("Western Europe",21);

		//r1.Calcular_Promedio("Western Europe");
		
		r1.setNarchivos(1);
		r1.setDetener(500);
		
		r1.start();
		
		
	
	
	}

}
