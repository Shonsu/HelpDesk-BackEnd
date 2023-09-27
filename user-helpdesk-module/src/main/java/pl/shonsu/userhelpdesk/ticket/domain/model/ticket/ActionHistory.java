package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ActionHistory {
    private final List<Action> actions;

    public ActionHistory() {
        actions = new ArrayList<>();
    }

    public ActionHistory(List<Action> actions) {
        this.actions = actions;
    }

    public void addAction(Action action) {
        this.actions.add(action);
    }

    public List<Action> getActions() {
        return Collections.unmodifiableList(actions);
    }
}
