package horari;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Horari {

	private EspaiHorari[][] matriu;
	
	/**
	 * Constructora per defecte de la classe horari
	 */
	public Horari()
	{
		
		matriu = new EspaiHorari[6][5];
		
		for (int fila = 0; fila < 6; ++fila){
			for (int col = 0; col < 5; ++col){
				
				String dia = columnaDia(col);
				String hora = filaHora(fila);
				
				// omplir espais horaris
				
				matriu[fila][col] = null;
			}
		}
		
	}
	
	/**
	 * Funció que crearà l'horari
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public void creaHorari() throws BiffException, IOException
	{
		// llegir excels de cada Grau (de moment Q1)
		Workbook informatica = Workbook.getWorkbook(new File("/home/rafael/Projecte-PROP/BaseDades/Informatica.xls"));
		Workbook electronica = Workbook.getWorkbook(new File("/home/rafael/Projecte-PROP/BaseDades/Electronica.xls"));
		Workbook mecanica = Workbook.getWorkbook(new File("/home/rafael/Projecte-PROP/BaseDades/Mecanica.xls"));
		Workbook electrica = Workbook.getWorkbook(new File("/home/rafael/Projecte-PROP/BaseDades/Electrica.xls"));
		Workbook disseny = Workbook.getWorkbook(new File("/home/rafael/Projecte-PROP/BaseDades/Disseny.xls"));
		
		// obtenir les aules dels excel
		Workbook aules = Workbook.getWorkbook(new File("/home/rafael/Projecte-PROP/BaseDades/Aules.xls"));
		
		// obtenir les assignatures de cada grau
		
		int filaAssignatura = 1;
			
		for (int fila = 0; fila < 6; ++fila){
			for (int col = 0; col < 5; ++col){

				// obtenir l'espai horari

				// afegir assignatura a l'espai horari en la posicio "grau"

				for (int grau = 0; grau < 5; ++grau){
					Workbook aux;

					switch(grau){
					case 0:
						aux = informatica;
						break;
					case 1:
						aux = electronica;
						break;
					case 2:
						aux = mecanica;
						break;
					case 3:
						aux = electrica;
						break;
					case 4:
						aux = disseny;
						break;
					default:
						aux = informatica;
						break;
					}

					// obtenir fulla "Q1" de l'excel
					Sheet fullaQ1 = aux.getSheet("Q1");

					if (filaAssignatura < fullaQ1.getRows()){
						Cell casella = fullaQ1.getCell(0, filaAssignatura);
						
						System.out.println("Grau "+grau + "--"+casella.getContents());
					}
				}
				
				++filaAssignatura;

			}
		}
		
		
		// per cada espai de la matriu, afegir assignatura de cada grau a cada posicio de l'array
		// OJO: si el grup es massa gran, es divideix en dos dies diferents, no en diferents aules el mateix dia
		
		//Posicio de les assignatures a l'array
		//	0: informatica
		//	1: electronica
		//	2: mecanica
		//	3: electrica
		//	4: disseny
		
		
		
		
	}
	
	/**
	 * Funcio que retorna la franja horària a la que es refereix el número donat
	 * 
	 * @param n	Número que "convertirem" a hora
	 * @return	Franja horària a la que correspon el número
	 */
	private String filaHora(int n)
	{
		String out;
		
		switch(n){
		case 0:
			out = "8:30-10:30";
			break;
		case 1:
			out = "10:30-12:30";
			break;
		case 2:
			out = "12:30-14:30";
			break;
		case 3:
			out = "15:00-17:00";
			break;
		case 4:
			out = "17:00-19:00";
			break;
		case 5:
			out = "19:00-21:00";
			break;
		default:
			out = "";
			break;
		}
		
		return out;
	}
	
	/**
	 * Funció que retorna el dia corresponent al número donat
	 * 
	 * @param n	Número que "convertirem" a dia
	 * @return	Dia corresponent al número donat
	 */
	private String columnaDia(int n)
	{
		String out;
		
		switch(n){
		case 0:
			out = "Dilluns";
			break;
		case 1:
			out = "Dimarts";
			break;
		case 2:
			out = "Dimecres";
			break;
		case 3:
			out = "Dijous";
			break;
		case 4:
			out = "Divendres";
			break;
		default:
			out = "";
			break;
		}
		
		return out;
	}
	
	/**
	 * Funció que mostrarà l'horari creat
	 */
	public void mostraHorari()
	{
		for (int fila = 0; fila < 6; ++fila){
			for (int col = 0; col < 5; ++col){
				
				// mostra la info de l'espai horari que hi hagi
				
			}
		}
	}
}
