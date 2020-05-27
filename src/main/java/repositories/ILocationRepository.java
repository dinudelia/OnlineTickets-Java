package repositories;

import model.Event;
import model.Location;

import java.util.List;
import java.util.Optional;

public interface ILocationRepository {

    void addLocation(Location location);
    void deleteLocation(Location location);
    List<Location> getLocations();

    static ILocationRepository build(Type type) {
        switch (type) {
            case DB: return new DBLocationRepository();
            case FILE: return new FileLocationRepository();
            case ARRAY:return new ArrayLocationRepository();
        }
        throw new RuntimeException("No such type");
    }
    enum Type {
        DB, FILE, ARRAY
    }
}
