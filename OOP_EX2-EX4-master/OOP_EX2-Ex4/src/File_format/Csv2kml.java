package File_format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class read CSV file and create KML file "MyKmlFile.kml" 
 * To create the KML file: run this class and enter the CSV file name.
 * make sure that the CSV file is on the project folder.   
 * @author Gil && Amilt
 *
 */
public class Csv2kml {
	
	 private static Scanner sc;
	 
	/**
	 * Get string and create KML file.
	 * we were helped by the following link:
	 * https://stackoverflow.com/questions/17853541/java-how-to-convert-a-xml-string-into-an-xml-file
	 * @param csv2kml
	 * @param fileName
	 * @throws IOException
	 */
	public static void stringToKml(String csv2kml, String fileName) throws IOException {
	    java.io.FileWriter fw = new java.io.FileWriter(fileName+".kml");
	    fw.write(csv2kml);
	    fw.close();
	}
	/**
	 * Read CSV file and create string from him.
	 * @param fileName
	 * @throws IOException
	 */
	 public static void csv2kml(String fileName) throws IOException {
		 	String csvFile;
		 	if(fileName.substring(fileName.length()-4).equals(".csv")){
		 		csvFile = fileName;
		 	}
		 	else {
		 		csvFile = fileName+".csv";
		 	}
	        String line = "";
	        ArrayList<kmlObject> csvArray= new  ArrayList<kmlObject>();
	        //Read the file.
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
	        {
	        	line = br.readLine();
	        	line = br.readLine();
	            while ((line = br.readLine()) != null) 
	            {	
	            	String[] csvLine= line.split(",");       //create kmlObject for evrey line and add him to ArrayList
	            	kmlObject csvLineSplit=new kmlObject(csvLine);
	            	csvArray.add(csvLineSplit);
	            }

	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
	        //create string that contain all the details for KML file
	        String kmlFile="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +  "<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\r\n";
	        for (int i = 0; i < csvArray.size(); i++) {
	        	kmlFile+="<Placemark>\n"+csvArray.get(i).getCoordinates()+"\n"+csvArray.get(i).getDescription()+"<styleUrl>#red</styleUrl>\n"+csvArray.get(i).getName()+"\n"+"</Placemark>";
			}
	        kmlFile+="\n"+"</Folder>\r\n" + "</Document></kml>";
			stringToKml(kmlFile, fileName.substring(0, fileName.length()-4));       //call the function that create the KML file
	  }
	 /**
		 * Read CSV file , create string from him and return ArrayList with evrey line.
		 * @param fileName
		 * @return ArrayList<String[]>
		 * @throws IOException
		 */
		 public static ArrayList<String[]> csv2kmlAndReturnCsvElements(String fileName) throws IOException {
			 	String csvFile;
			 	if(fileName.substring(fileName.length()-4).equals(".csv")){
			 		csvFile = fileName;
			 	}
			 	else {
			 		csvFile = fileName+".csv";
			 	}
		        String line = "";
		        ArrayList<kmlObject> csvArray= new  ArrayList<kmlObject>();
		        ArrayList<String[]> completeCsvFile= new  ArrayList<String[]>();
		        //Read the file.
		        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
		        {
		        	line = br.readLine();
		        	line = br.readLine();
		            while ((line = br.readLine()) != null) 
		            {	
		            	String[] csvLine= line.split(",");       //create kmlObject for evrey line and add him to ArrayList
		            	kmlObject csvLineSplit=new kmlObject(csvLine);
		            	csvArray.add(csvLineSplit);
		            	completeCsvFile.add(csvLine);
		            }

		        } catch (IOException e) 
		        {
		            e.printStackTrace();
		        }
		        //create string that contain all the details for KML file
		        String kmlFile="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +  "<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\r\n";
		        for (int i = 0; i < csvArray.size(); i++) {
		        	kmlFile+="<Placemark>\n"+csvArray.get(i).getCoordinates()+"\n"+csvArray.get(i).getDescription()+"<styleUrl>#red</styleUrl>\n"+csvArray.get(i).getName()+"\n"+"</Placemark>";
				}
		        kmlFile+="\n"+"</Folder>\r\n" + "</Document></kml>";
				stringToKml(kmlFile, fileName.substring(0, fileName.length()-4));       //call the function that create the KML file
				
				return completeCsvFile;
		  }
	 public static void main(String[] args) throws IOException {
		 sc = new Scanner(System.in); 
		 System.out.println("Please inseret CSV file name (without .csv)");
		 System.out.println("the CSV file must be on the project folder");
		 csv2kml(sc.nextLine());
	}
	
}
