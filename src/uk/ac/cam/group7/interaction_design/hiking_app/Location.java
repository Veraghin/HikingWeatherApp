package uk.ac.cam.group7.interaction_design.hiking_app;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Holds information about the location
 * 2 float for Lat and Long (final)
 * String for name
 * boolean for favourite
 * Warnings container for all warnings
 *
 * @author dobrik, Sam Gooch
 */
public class Location {
    private final float latitude, longitude;
    private String name;
    private boolean isFavourite;
    private final Path path;
    private WarningsContainer warnings;

    private final static String pSep = File.separator;

    /**
     * Constructor that takes no name parameter
     * and makes a new Location class with these coordinates
     *
     * @param latitude  Latitude of location
     * @param longitude Longitude of location
     */
    public Location(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = latitude + ", " + longitude;
        this.isFavourite = false;
        System.out.println("data" + pSep + generateFileName() + ".json");
        this.path = Paths.get("data" + pSep + generateFileName() + ".json");
        this.warnings = new WarningsContainer();
    }

    /**
     * Generates a filename for a location based on a hash of its latitude and longitude
     *
     * @return The file name to use
     */
    private int generateFileName() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Constructor that takes no name parameter
     * and makes a new Location class with these coordinates
     *
     * @param latitude    Latitude of location
     * @param longitude   Longitude of location
     * @param isFavourite If location is a favourite
     * @param path        The path to the JSON file storing the raw forecast data
     */
    public Location(float latitude, float longitude, boolean isFavourite, Path path, String name,
                    WarningsContainer warnings) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.isFavourite = isFavourite;
        this.path = path;
        this.warnings = warnings;
    }

    /**
     * Getter for latitude
     *
     * @return latitude (double)
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Getter for longitude
     *
     * @return longitude (double)
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Getter for name
     *
     * @return Name of location
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for favourite
     *
     * @return boolean for isFavourite or not
     */
    public boolean isFavourite() {
        return isFavourite;
    }

    /**
     * Setter for the name of the location
     *
     * @param name Name of the location
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set favourite location
     * boolean (false:notFav, true:Fav)
     */
    public void toggleFavourite() {
        isFavourite = !isFavourite;
    }

    /**
     * Gets the path of the file storing the weather data for the location
     *
     * @return The path to the file
     */
    public Path getPath() {
        return path;
    }

    /**
     * Gets the container to all weather warnings for the location
     *
     * @return WarningsContainer for the location
     */
    public WarningsContainer getAllWarnings() {
        return warnings;
    }

    /**
     * Adds a new warning to the location
     *
     * @param warning  The warning to add
     * @param severity The severity of the warning
     */
    public void addWarning(Warning warning, int severity) {
        warnings.addWarning(warning, severity);
    }

    /**
     * Gets the next warning to display
     *
     * @return Warning to display
     */
    public Warning getTopWarning() {
        return warnings.getNextWarning();
    }

    /**
     * Acknowledges that the top warning has been seen so delete it
     */
    public void acknowledgeWarning() {
        warnings.acknowledgeWarning();
    }

    /**
     * Autogenerated method for equals
     *
     * @param o Object to compare to
     * @return true or false depending on equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (latitude != location.latitude) return false;
        if (longitude != location.longitude) return false;
        return name != null ? name.equals(location.name) : location.name == null;
    }

    /**
     * Generates a hash code for the location
     *
     * @return The hashcode for th location
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isFavourite ? 1 : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }

    /**
     * Allows a String output for the location during debugging
     *
     * @return The String representation of a location
     */
    @Override
    public String toString() {
        return getName();
    }

}


