package GIS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import File_format.kmlObject;


public class project extends  HashSet<layer>{
	/**
	 * Get string and create KML file.
	 * we were helped by the following link:
	 * https://stackoverflow.com/questions/17853541/java-how-to-convert-a-xml-string-into-an-xml-file
	 * @param csv2kml
	 * @param fileName
	 * @throws IOException
	 */
	public layer lay;
	public project(layer lay) {
		this.lay=lay;
	}
	
	/*public static void stringToCsv(String strcsv, String fileName) throws IOException {
	    java.io.FileWriter fw = new java.io.FileWriter(fileName+".csv");
	    fw.write(strcsv);
	    fw.close();
	}*/
	public void layer2csv() throws IOException {
		FileWriter writer = new FileWriter(this.lay.getName()+".csv");
		writer.append("MAC");
		writer.append(',');
		writer.append("SSID");
		writer.append(',');
		writer.append("AuthMode");
		writer.append(',');
		writer.append("FirstSeen");
		writer.append(',');
		writer.append("Channel");
		writer.append(',');
		writer.append("RSSI");
		writer.append(',');
		writer.append("CurrentLatitude");
		writer.append(',');
		writer.append("CurrentLongitude");
		writer.append(',');
		writer.append("AltitudeMeters");
		writer.append(',');
		writer.append("AccuracyMeters");
		writer.append(',');
		writer.append("Type");
		writer.append('\n');
		Iterator<element> iter=this.lay.iterator();
		while(iter.hasNext()) {
			element elm =iter.next();
			writer.append(elm.getMAC());
			writer.append(',');
			writer.append(elm.getName());
			writer.append(',');
			writer.append(elm.getAuthMode());
			writer.append(',');
			writer.append(elm.getChannel());
			writer.append(',');
			writer.append(elm.getRSSI());
			writer.append(',');
			String str=""+elm.getCurrentLatitude();
			writer.append(str);
			writer.append(',');
			str=""+elm.getCurrentLongitude();
			writer.append(str);
			writer.append(',');
			str=""+elm.getAltitudeMeters();
			writer.append(str);
			writer.append(',');
			writer.append("elm.getAccuracyMeters()");
			writer.append(',');
			writer.append("elm.getType()");
			writer.append('\n');
		}
		writer.flush();
		writer.close();
		/*String csv="WigleWifi-1.4,appRelease=2.26,model=SM-G950F,release=7.0,device=dreamlte,display=NRD90M.G950FXXU1AQJ5,board=universal8895,brand=samsung"+"/n";
		csv+="MAC,SSID,AuthMode,FirstSeen,Channel,RSSI,CurrentLatitude,CurrentLongitude,AltitudeMeters,AccuracyMeters,Type"+"/n";
		Iterator<element> iter=this.lay.iterator();
		while(iter.hasNext()) {
			element elm =iter.next();
			csv+=elm.getMAC() +"," +elm.getName()+","+elm.getAuthMode()+","+elm.getData()+","+elm.getChannel()+","+elm.getRSSI()+","+elm.getCurrentLatitude()+","+elm.getCurrentLongitude()+","+elm.getAltitudeMeters()+","+elm.getAccuracyMeters()+","+elm.getType();
			csv+="/n";
		}*/
		
		/*stringToCsv(csv,this.lay.getName());*/
		
	}
	       
	       
	        
	
}
