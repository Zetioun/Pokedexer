package pokemon;

public class Coordinates {
	private double latitude;
	private double longtidue;
	
	public Coordinates(double lat, double lon){
		this.latitude = lat;
		this.longtidue = lon;
	}
	public String toString(){
		return latitude + "," + longtidue;
	}
	public Double getLatitude() {
		return latitude;
	}
	public Double getLongtidue() {
		return longtidue;
	}
}
