package repositories;

import files.LoadFiles;
import files.SaveFiles;
import model.Event;

import java.util.List;

public class FileEventRepository implements IEventRepository {

    @Override
    public void addEvent(Event event) {
        SaveFiles saveFiles = new SaveFiles();
        saveFiles.saveEvent(event);
        saveFiles.saveLocation(event.getLocation());
    }

    @Override
    public void deleteEvent(Event event) {
        if (event!=null) {
            LoadFiles loadFiles = new LoadFiles();
            SaveFiles saveFiles = new SaveFiles();
            List<Event> fileEvents = loadFiles.loadEvents();
            for (int i=0;i<fileEvents.size();i++) {
                if (event.getNameEvent().equals(fileEvents.get(i).getNameEvent()))
                    fileEvents.remove(i);
            }
            saveFiles.rewriteEvents(fileEvents);
        }
    }

    @Override
    public List<Event> getEvents() {
        LoadFiles loadFiles = new LoadFiles();
        return loadFiles.loadEvents();
    }
}
