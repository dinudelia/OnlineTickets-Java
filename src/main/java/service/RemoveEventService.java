package service;

import model.Event;
import repositories.IEventRepository;

public class RemoveEventService {

    public void removeEvent(Event e){
        IEventRepository eventRepository1 = IEventRepository.build(IEventRepository.Type.DB);
        IEventRepository eventRepository2 = IEventRepository.build(IEventRepository.Type.FILE);
        IEventRepository eventRepository3 = IEventRepository.build(IEventRepository.Type.ARRAY);

        eventRepository1.deleteEvent(e);
        eventRepository2.deleteEvent(e);
        eventRepository3.deleteEvent(e);
    }

    public static RemoveEventService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static final class SingletonHolder {
        private static final RemoveEventService INSTANCE = new RemoveEventService();
    }
}
