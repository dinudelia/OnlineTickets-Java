package repositories;
import files.LoadFiles;
import files.SaveFiles;
import model.Location;

import java.util.List;


public class FileLocationRepository implements ILocationRepository {

    private final String file = "LOCATIONS";

    @Override
    public void addLocation(Location location) {
        SaveFiles saveFiles = new SaveFiles();
        saveFiles.saveLocation(location);
    }

    @Override
    public void deleteLocation(Location location) {
            LoadFiles loadFiles = new LoadFiles();
            SaveFiles saveFiles = new SaveFiles();
            List<Location> fileLocations = loadFiles.loadLocations();
            fileLocations.remove(location);
            for (Location l:fileLocations) {
                saveFiles.saveLocation(l);
            }
    }

    @Override
    public List<Location> getLocations() {
        LoadFiles loadFiles = new LoadFiles();
        return loadFiles.loadLocations();
    }
}
