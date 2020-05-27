package repositories;

import model.Event;
import model.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayLocationRepository implements ILocationRepository {

    List<Location> locationsList = new ArrayList<Location>();

    @Override
    public void addLocation(Location location) {
        locationsList.add(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationsList.remove(location);
    }

    @Override
    public List<Location> getLocations() {
        return locationsList;
    }
}
