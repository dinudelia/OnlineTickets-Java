package service;

import model.*;

import repositories.IEventRepository;

import java.util.List;

public class AddEventService {

    public void addEvent(Event e){
        IEventRepository eventRepository1 = IEventRepository.build(IEventRepository.Type.DB);
        IEventRepository eventRepository2 = IEventRepository.build(IEventRepository.Type.FILE);
        IEventRepository eventRepository3 = IEventRepository.build(IEventRepository.Type.ARRAY);

        eventRepository1.addEvent(e);
        eventRepository2.addEvent(e);
        eventRepository3.addEvent(e);

    }

    public static AddEventService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static final class SingletonHolder {
        private static final AddEventService INSTANCE = new AddEventService();
    }
}
