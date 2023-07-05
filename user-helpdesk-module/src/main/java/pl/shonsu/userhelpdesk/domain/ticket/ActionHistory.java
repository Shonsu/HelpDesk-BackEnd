package pl.shonsu.userhelpdesk.domain.ticket;

import java.util.List;

class ActionHistory {
    private final List<Action> actions;

    public ActionHistory(List<Action> actions) {
        this.actions = actions;
    }

    public void addAction(Action action) {
        this.actions.add(action);
    }
}
