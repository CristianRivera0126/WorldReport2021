package RegPai;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Region extends Thread{
	//Variables
	double SocialS;
	double HealLife;
	double FreeChoices;
	double Gene;
	double Corrup;
	double PSocialS;
	double PHealLife;
	double PFreeChoices;
	double PGene;
	double PCorrup;
	//Calcular Promedio
	private String nameR;
	private int NP;
	//Calcular la media
	public int Narchivos;
	private int detener;
	
	List<Region> regiones;
	
	public Region(String nameR, int NP) {
		super();
		this.nameR = nameR;
		this.NP = NP;
		List<Region> regiones = new ArrayList<Region>();
 	}
	
	public String getNameR() {
		return nameR;
	}

	public void setNameR(String nameR) {
		this.nameR = nameR;
	}

	public int getNP() {
		return NP;
	}

	public void setNP(int nP) {
		NP = nP;
	}

	public int getDetener() {
		return detener;
	}

	public void setDetener(int detener) {
		this.detener = detener;
	}

	public int getNarchivos() {
		return Narchivos;
	}

	public void setNarchivos(int narchivos) {
		Narchivos = narchivos;
	}

	public void Calcular_Promedio(String nameR) {
		String linea;
		double AltaCorrup=0;
		double AltaGene=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("world-happiness-report-2021.csv"));
			linea = br.readLine();
			while(linea != null) {
				String datos[] = linea.split(",");
				SocialS = Double.parseDouble(datos[7]);
				HealLife = Double.parseDouble(datos[8]);
				FreeChoices = Double.parseDouble(datos[9]);
				Gene = Double.parseDouble(datos[10]);
				Corrup = Double.parseDouble(datos[11]);
				PSocialS = (SocialS+SocialS)/this.NP;
				PHealLife = (HealLife+HealLife)/this.NP;
				PFreeChoices = (FreeChoices+FreeChoices)/this.NP;
				PGene = (Gene+Gene)/this.NP;
				PCorrup = (Corrup+Corrup)/this.NP;
				if(Corrup>AltaCorrup) {
					AltaCorrup=Corrup;
				}
				if(Gene>AltaGene) {
					AltaGene=Gene;
				}
				System.out.println("Promedio de Social Support: " + PSocialS +"\n");
				System.out.println("Promedio de Healty Life expectancy: " + PHealLife +"\n");
				System.out.println("Promedio de Freedom to make choices: " + PFreeChoices +"\n");
				System.out.println("Promedio de Generosity: " + PGene +"\n");
				System.out.println("Promedio de Perception Of Corruption: " + PCorrup +"\n");
				System.out.println("Pais Con la Mas alta Percepcion de corrupcion: " + AltaCorrup +"\n");
				System.out.println("Pais con la mas alta generosidad: " + AltaGene +"\n");
				linea = br.readLine();
			}
		} catch(FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
		
	}
	
	public void run(){
		double MSocialS=0;
		double MHealLife=0;
		double MFreeChoices=0;
		double MGene=0;
		double MCorrup=0;
		for(int i=0; i<Narchivos; i++) {
			MSocialS = SocialS-PSocialS;
			MHealLife = HealLife-PHealLife;
			MFreeChoices = FreeChoices-PFreeChoices;
			MGene = Gene-PGene;
			MCorrup = Corrup-PCorrup;
			System.out.println("La region: " + getNameR() + "\nTiene las siguientes medias: \n");
		    System.out.println("Social Support: " + MSocialS + "\n");
		    System.out.println("Healthy life expectancy: " + MHealLife + "\n");
		    System.out.println("Freedom to Make life choices: " + MFreeChoices + "\n");
		    System.out.println("Generosity: " + MGene + "\n");
		    System.out.println("Perception of corruption: " + MCorrup + "\n");
            try {
		    super.sleep(this.detener);
	      } catch(InterruptedException e) {
		        e.printStackTrace();
	}
   }
  }
}
