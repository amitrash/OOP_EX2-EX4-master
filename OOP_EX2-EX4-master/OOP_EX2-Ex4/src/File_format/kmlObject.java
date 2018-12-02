package File_format;
/**
 * this class represent object
 * @author Gil && Amilt
 *
 */
public class kmlObject {
	public String name;
	public String description;
	public String coordinates;
	
	/**
	 * Defult consructur
	 * @param arr
	 */
	public kmlObject(String[] arr) {
		this.description="<description><![CDATA[BSSID: <b>"+arr[0]+"</b><br/>Capabilities: "+arr[2]+"</b><br/>Frequency: <b></b><br/>Timestamp: <b></b><br/>Date: <b>"+arr[3]+"</b>]]></description>";
		this.name="<name>"+arr[1]+"</name>";
		this.coordinates="<Point>"+"/n"+"<coordinates>"+arr[7]+","+arr[6]+"</coordinates></Point>";

	}
	/**
	 * get name
	 * @return
	 */
	public String getName() {
		return name;
	}
	 /**
	  * get description
	  * @return
	  */
	public String getDescription() {
		return description;
	}
	/**
	 * get coordinates
	 * @return
	 */
	public String getCoordinates() {
		return coordinates;
	}
}
