package GIS;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import File_format.Csv2kml;

/**
 * 
 * @author Gil && Amit
 *
 */

public final class MultiCSV extends Csv2kml {
	  /*public static  ArrayList<String> csvFillArr =new ArrayList<String>(); 
	  
	  public static void main(String... args) throws IOException{
	    String ROOT ="C:\\Users\\Amit-PC\\Downloads\\OOP_EX2-EX4-master";
	    FileVisitor<Path> fileProcessor = new ProcessFile();
	    Files.walkFileTree(Paths.get(ROOT), fileProcessor);
	    for (int i = 0; i < csvFillArr.size(); i++) {
			
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
	  }*/
	} 