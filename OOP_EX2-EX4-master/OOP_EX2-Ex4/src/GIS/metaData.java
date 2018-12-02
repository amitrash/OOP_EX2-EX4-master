package GIS;

import Coords.MyCoords;
import Geom.Point3D;

public class metaData extends MyCoords implements Meta_data{
	public long UTC;
	public double yaw;
	public double pitch;
	public double roll;
	
	public metaData(String time, double lat, double lon, double alt ) {
		Point3D gps0 =new Point3D(0,0,0);
		Point3D gps1 =new Point3D(lat,lon,alt);
		double[] yawPitchRoll=azimuth_elevation_dist(gps0,gps1);
		this.yaw=yawPitchRoll[0];
		this.pitch=yawPitchRoll[1];
		this.roll=yawPitchRoll[2];
		int index=time.indexOf(" ");
		time=time.substring(0, index);
		String[] timesplit=time.split("/");
		String newtime="";
		for (int i = 0; i < timesplit.length; i++) {
			newtime+=timesplit[i];
		}
		this.UTC= 0;//Long.parseLong(newtime);
 	}
	
	

	/** returns the Universal Time Clock associated with this data; */
	public long getUTC() {
		return this.UTC;
	}
	/** return a String representing this data */
	public String toString() {
		return "yaw: "+this.yaw+"/n"+"pitch:"+this.pitch+"/n"+"roll:"+this.roll+"/n"+this.UTC;
	}
	/**
	 * @return the orientation: yaw, pitch and roll associated with this data;
	 */
	public Point3D get_Orientation() {
		return null;
	}

}
