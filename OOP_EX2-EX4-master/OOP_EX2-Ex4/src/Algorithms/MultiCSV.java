package Algorithms;

import java.io.File;
import java.io.IOException;

import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.regex.Pattern;

import File_format.Csv2kml;
import GIS.element;
import GIS.layer;
import GIS.project;
/**
 * https://stackoverflow.com/questions/3634853/how-to-create-a-directory-in-java
 * @author Gil && Amit
 *
 */

public final class MultiCSV extends Csv2kml  {
	  public static  ArrayList<String> csvFillArr =new ArrayList<String>(); 
	  
	  
	  public static void main(String[] args) throws IOException{
	    String ROOT ="C:\\Users\\Amit-PC\\Downloads\\OOP_EX2-EX4-master";
	    FileVisitor<Path> fileProcessor = new ProcessFile();
	    Files.walkFileTree(Paths.get(ROOT), fileProcessor);
	    ArrayList<String[]> list;
	    File theDir = new File("csv");

	 // if the directory does not exist, create it
	 if (!theDir.exists()) {
	     System.out.println("creating directory: " + theDir.getName());
	     boolean result = false;

	     try{
	         theDir.mkdir();
	         result = true;
	     } 
	     catch(SecurityException se){
	         //handle it
	     }        
	     if(result) {    
	         System.out.println("DIR created");  
	     }
	 }
	    for (int i = 0; i < csvFillArr.size(); i++) {
	    	String str=csvFillArr.get(i);
	    	list=csv2kmlAndReturnCsvElements(csvFillArr.get(i));
	    	layer elements =new layer(csvFillArr.get(i));
	    	for (int j = 0; j < list.size(); j++) {  		
	    		element elm =new element(list.get(j));
	    		elements.add(elm);
			}
	    	System.out.println(elements);
	    	project proj=new project(elements);
	    	proj.layer2csv();
		}
	  }
	  
private static final class ProcessFile extends SimpleFileVisitor<Path> { 
	   
	  	public FileVisitResult visitFile( Path file, BasicFileAttributes attrs) throws IOException {
	  		String temp = file.getFileName().toString();
	  		if (!temp.contains(".csv")) {
	    		return FileVisitResult.CONTINUE;
	    	}
	        System.out.println("Processing file:" + file);
	        csvFillArr.add(file.toString());
	        return FileVisitResult.CONTINUE;
	    }
	    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
	      System.out.println("Processing directory:" + dir);
	      return FileVisitResult.CONTINUE;
	    }
	  }
	} 