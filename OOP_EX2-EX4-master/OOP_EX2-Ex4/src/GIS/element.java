package GIS;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;

public class element extends MyCoords implements GIS_element  {
	public String MAC;
	public String name;
	public String AuthMode;
	public String time;
	public String Channel;
	public String RSSI;
	public double CurrentLatitude;
	public double CurrentLongitude;
	public double AltitudeMeters;
	public String AccuracyMeters;
	public String Type;
	public metaData data;
	
	@Override
	public Geom_element getGeom() {
		Point3D element=new Point3D(this.CurrentLatitude,this.CurrentLongitude,this.AltitudeMeters);
		return element;
	}

	@Override
	public Meta_data getData() {
		return this.data;
	}

	@Override
	public void translate(Point3D vec) {
		Point3D gps =new Point3D(this.CurrentLatitude,this.CurrentLongitude,this.AltitudeMeters);
		Point3D newgps=add(gps,vec);
		this.CurrentLatitude=newgps.x();
		this.CurrentLongitude=newgps.y();	
		this.AltitudeMeters=newgps.z();
		this.data =new metaData(this.time,this.CurrentLatitude,this.CurrentLongitude,this.AltitudeMeters);
	}

	
	public element(String[] csvFile) {
		this.MAC=csvFile[0];
		this.name=csvFile[1];
		this.AuthMode=csvFile[2];
		this.time=csvFile[3];
		this.Channel=csvFile[4];
		this.RSSI=csvFile[5];
		this.CurrentLatitude=Double.parseDouble(csvFile[6]);
		this.CurrentLongitude=Double.parseDouble(csvFile[7]);
		this.AltitudeMeters=Double.parseDouble(csvFile[8]);
		this.AccuracyMeters=csvFile[9];
		this.Type=csvFile[10];
		this.data=new metaData(this.time,this.CurrentLatitude,this.CurrentLongitude,this.AltitudeMeters);
	}
	
	@Override
	public String toString() {
		return "element [MAC=" + MAC + ", name=" + name + ", AuthMode=" + AuthMode + ", time=" + time + ", Channel="
				+ Channel + ", RSSI=" + RSSI + ", CurrentLatitude=" + CurrentLatitude + ", CurrentLongitude="
				+ CurrentLongitude + ", AltitudeMeters=" + AltitudeMeters + ", AccuracyMeters=" + AccuracyMeters
				+ ", Type=" + Type + ", data=" + data + "]";
	}

	public String getMAC() {
		return MAC;
	}

	public String getName() {
		return name;
	}

	public String getAuthMode() {
		return AuthMode;
	}

	public String getFirstSeen() {
		return time;
	}

	public String getChannel() {
		return Channel;
	}

	public String getRSSI() {
		return RSSI;
	}

	public double getCurrentLatitude() {
		return CurrentLatitude;
	}

	public double getCurrentLongitude() {
		return CurrentLongitude;
	}

	public double getAltitudeMeters() {
		return AltitudeMeters;
	}

	public String getAccuracyMeters() {
		return AccuracyMeters;
	}

	public String getType() {
		return Type;
	}
	
}
