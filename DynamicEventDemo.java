package assignment;

import java.lang.reflect.Method;
import java.util.*;

// Event Class
class Event {
    String name, data;
    Event(String name, String data) {
        this.name = name;
        this.data = data;
    }
}

// Event Listener Class
class EventListener {
    public void onClick(Event e) { 
        System.out.println("Clicked: " + e.data); 
    }
    public void onLogin(Event e) { 
        System.out.println("Login user: " + e.data); 
    }
}

// Event Dispatcher Class
class EventDispatcher {
    private Map<String, Method> handlers = new HashMap<>();
    private Object listener;

    EventDispatcher(Object listener) {
        this.listener = listener;
        for (Method m : listener.getClass().getDeclaredMethods()) {
            handlers.put(m.getName().toLowerCase(), m);
        }
    }

    void dispatch(Event e) {
        try {
            Method m = handlers.get(("on" + e.name).toLowerCase());
            if (m != null) {
                m.invoke(listener, e);
            } else {
                System.out.println("No handler for " + e.name);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

// Main Driver Class
public class DynamicEventDemo {
    public static void main(String[] args) {
        EventDispatcher d = new EventDispatcher(new EventListener());
        d.dispatch(new Event("Click", "Submit Button"));
        d.dispatch(new Event("Login", "Sonia"));
        d.dispatch(new Event("Exit", "Bye!"));
    }
}

