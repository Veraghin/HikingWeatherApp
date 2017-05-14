package uk.ac.cam.group7.interaction_design.hiking_app;

/**
 * Holds information about the location
 *  2 ints for Lat and Long (final)
 *  String for name (possibly NULL)
 *  boolean for favourite
 *  @author dobrik
 */
public class Location implements Comparable<Location> {
    private final double latitude, longtitude;
    private String name=null;
    private boolean isFavourite=false;



    /**
     * Constructor that takes 2 parameters (LAT and LONG)
     * and makes a new Location class with these coordinates
     * @param _latitude
     * Latitude of location
     * @param _longtitude
     * Longitude of location
     */
    public Location(double _latitude,double _longtitude){
        latitude=_latitude;
        longtitude=_longtitude;
    }

    /**
     * Constructor that takes 2 parameters (LAT and LONG)
     * and the name of the Location
     * and makes a new Location class with these coordinates and the name
     * @param _latitude
     * Latitude of location
     * @param _longtitude
     * Longitude of location
     * @param _name
     * Name of the location
     */
    public Location(double _latitude,double _longtitude,String _name){

        latitude=_latitude;
        longtitude=_longtitude;
        name=_name;
    }

    /**
     * Getter for latitude
     * @return
     * latitude ofc (integer)
     */
    public double getLatitude(){
        return latitude;
    }

    /**
     * Getter for longtitude
     * @return
     * longtitude (integer), you idiot, do you expect something else
     */
    public double getLongtitude(){
        return longtitude;
    }

    /**
     * Getter for name
     * @return
     * Name of location
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for favourite
     * @return
     * boolean for isFavourite or not
     */
    public boolean isFavourite() {
        return isFavourite;
    }

    /**
     * Setter for the name of the location
     * @param _name
     * Name of the location
     */
    public void setName(String _name){name=_name;}

    /**
     * Set favourite location
     * @param favourite
     * boolean (false:notFav, true:Fav)
     */
    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    /**
     * String for displaying the location in appropriate form
     *
     * @return name or coordinates (if name==null)
     */
    @Override
    public String toString() {
        if(name!=null)return name;
        return "("+latitude+","+longtitude+")";
    }

    /**
     * Equals function
     * 2 locations are considered equal if their COORDINATES are equal (even if NAME is different)
     * @param o
     * 2nd thing to compare to
     * @return
     * true/false depending on equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (Double.compare(location.latitude, latitude) != 0) return false;
        return Double.compare(location.longtitude, longtitude) == 0;
    }

    /**
     * Hash code fuction
     * @return
     * the hash code
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longtitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * CompareTo function
     * priority has Favourite
     * then alphabetical order
     * then coordinates
     * @param that
     * the other location
     * @return
     * -1/0/1 for </=/>
     */
    @Override
    public int compareTo(Location that) {
        if (!this.isFavourite&&that.isFavourite()){
            return -1;
        } else if (this.isFavourite && !that.isFavourite()) {
            return 1;
        }

        if(this.name==null)return -1;
        if(that.getName()==null)return 1;
        if (this.name.compareTo(that.getName()) < 0) {
            return -1;
        } else if (this.name.compareTo(that.getName()) > 0) {
            return 1;
        }

        if (this.latitude < that.getLatitude()) {
            return -1;
        } else if (this.latitude > that.getLatitude()) {
            return 1;
        }

        if (this.longtitude < that.getLongtitude()) {
            return -1;
        } else if (this.longtitude > that.getLongtitude()) {
            return 1;
        }
        return 0;
    }

    //public static void main(String args[]){
    //    Location test=new Location(11,22,"haway");
    //    System.out.println(test);
    //    test.setFavourite(true);
    //    System.out.println(test.isFavourite());
    //}

}

