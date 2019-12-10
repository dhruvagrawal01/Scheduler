package com.example.scheduler;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public class EventsName {
    // static variable single_instance of type Singleton
    private static EventsName single_instance = null;

    // variable of type String
    public Map<LocalDate, String> map;

    // private constructor restricted to this class itself
    private EventsName()
    {
        map = new HashMap<>();
    }

    // static method to create instance of Singleton class
    public static EventsName getInstance()
    {
        if (single_instance == null)
            single_instance = new EventsName();
        return single_instance;
    }
}
