package mais;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {
    private Map<String, List<State>> transition = new HashMap<>();
    private Map<String, List<State>> behindTransition = new HashMap<>();
    private String name;
    private boolean isFinal;
    private boolean isInitial;

    private State() {

    }

    public State(String name, boolean isFinal, boolean isInitial) {
        this.name = name;
        this.isFinal = isFinal;
        this.isInitial = isInitial;
    }

    public void connect(State connectTo, String value) {
        connectTo.addBehind(value, this);
        this.transition.put(value, connectTo);
    }

    public void addBehind(String value ,State behind) {
        this.behindTransition.put(value,behind);
    }

}
