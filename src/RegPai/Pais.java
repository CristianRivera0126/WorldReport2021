package RegPai;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class Pais {
	private String namePa;
	private String nameRe;
	private String SocialSup;
	private String HealLife;
	private String freeTM;
	private String Gene;
	private String Corrup;
	
	List<Pais> paises;
	List<Region> regiones;
	
	public Pais(String namePa,String nameRe,String socialSup, String healLife, String freeTM, String gene, String corrup) {
		super();
		this.namePa = namePa;
		this.nameRe = nameRe;
		this.SocialSup = socialSup;
		this.HealLife = healLife;
		this.freeTM = freeTM;
		this.Gene = gene;
		this.Corrup = corrup;
		List<Pais> paises = new ArrayList<Pais>();
		List<Region> regiones = new ArrayList<Region>();
	}

	public String getnamePa() {
		return namePa;
	}

	public void namePa(String namePa) {
		this.namePa = namePa;
	}
	
	public String getNameRe() {
		return nameRe;
	}

	public void setNameRe(String nameRe) {
		this.nameRe = nameRe;
	}

	public String getSocialSup() {
		return SocialSup;
	}

	public void setSocialSup(String socialSup) {
		SocialSup = socialSup;
	}

	public String getHealLife() {
		return HealLife;
	}

	public void setHealLife(String healLife) {
		HealLife = healLife;
	}

	public String getFreeTM() {
		return freeTM;
	}

	public void setFreeTM(String freeTM) {
		this.freeTM = freeTM;
	}

	public String getGene() {
		return Gene;
	}

	public void setGene(String gene) {
		Gene = gene;
	}

	public String getCorrup() {
		return Corrup;
	}

	public void setCorrup(String corrup) {
		Corrup = corrup;
	}
	
	public static void ImportarCSV() {
		try {
			List<Pais> paises = new ArrayList<Pais>(); //Lista donde guardaremos los datos del archivo
			
			CsvReader leerPaises = new CsvReader("world-happiness-report-2021.csv");
			leerPaises.readHeaders();
			
			//Mientras haya lineas obtenemos los datos del archivo
			while(leerPaises.readRecord()) {
				String CountryName = leerPaises.get(0);
				String RegionalIndicator = leerPaises.get(1);
				String SocialSupport = leerPaises.get(7);
				String HealthyLife = leerPaises.get(8);
				String FreedomChoices = leerPaises.get(9);
				String Generosity = leerPaises.get(10);
				String PercepCorrup = leerPaises.get(11);
				
				//Añadimos informacion a la lista
				paises.add(new Pais(CountryName,RegionalIndicator,SocialSupport,HealthyLife,FreedomChoices,Generosity,PercepCorrup));
			}
			
			leerPaises.close();//Cerramos el archivo
			
			//Recorremos la lista y la mostramos en la pantalla
			for(Pais count : paises) {
				System.out.println(count.getnamePa() + ", "
						+ count.getNameRe() + ", "
						+ count.getSocialSup() + ", "
						+ count.getHealLife() + ", "
						+ count.getFreeTM() + ", "
						+ count.getGene() + ", "
						+ count.getCorrup());
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void ExportarCSV(List<Pais> paises) {
		String SalidaArchivo = "world-happiness-report-2021.csv"; //Nombre Del Archivo
		boolean existe = new File(SalidaArchivo).exists();// Verifica si existe este archivo

		try {
			//Creamos el nuevo archivo
			CsvWriter SalidaCSV = new CsvWriter(new FileWriter(SalidaArchivo,true), ',');
			
			//Datos para identificar las columnas
			SalidaCSV.write("Country name");
			SalidaCSV.write("Regional indicator");
			SalidaCSV.write("Social support");
			SalidaCSV.write("Healthy life expectancy");
			SalidaCSV.write("Freedom to make life choices");
			SalidaCSV.write("Generosity");
			SalidaCSV.write("Perceptions of corruption");
			
			SalidaCSV.endRecord();//Deja de escribir en el archivo
		
		//Recorremos la lista e insertamos los archivos
		for(Pais count : paises) {
			SalidaCSV.write(count.getnamePa());
			SalidaCSV.write(count.getNameRe());
			SalidaCSV.write(count.getSocialSup());
			SalidaCSV.write(count.getHealLife());
			SalidaCSV.write(count.getFreeTM());
			SalidaCSV.write(count.getGene());
			SalidaCSV.write(count.getCorrup());
			
			SalidaCSV.endRecord();//Deja de escribir el archivo
		}
		
		SalidaCSV.close();//Cierra el archivo
		
	} catch(IOException e){
		e.printStackTrace();
	}
}
	
	
	
	

}
