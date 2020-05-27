package repositories;

import managers.DBOperations;
import model.Location;

import java.util.List;


public class DBLocationRepository implements ILocationRepository  {

    @Override
    public void addLocation(Location location) {
        DBOperations.addLocation(location);

    }

    @Override
    public void deleteLocation(Location location) {
        DBOperations.deleteLocation(location);
    }

    @Override
    public List<Location> getLocations() {
        return DBOperations.allLocations();
    }
}
