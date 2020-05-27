package model;

public class Location {

    private int idLocation;
    private String nameLocation;
    private String city;
    private static int nrLocations;

    static
    {
        nrLocations = 0;
    }

    public Location(int idLocation, String nameLocation, String city) {
        this.idLocation = idLocation;
        this.nameLocation = nameLocation;
        this.city = city;
        nrLocations++;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
