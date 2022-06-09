package pl.julka99.libraryservice.api.json;

import java.util.List;

public class StatusJson {

    private List<HistoryJson> history;

    private List<ActualyJson> actualy;

    public StatusJson() {
    }

    public StatusJson(List<HistoryJson> history, List<ActualyJson> actualy) {
        this.history = history;
        this.actualy = actualy;
    }

    public List<HistoryJson> getHistory() {
        return history;
    }

    public List<ActualyJson> getActualy() {
        return actualy;
    }

    public void setHistory(List<HistoryJson> history) {
        this.history = history;
    }

    public void setActualy(List<ActualyJson> actualy) {
        this.actualy = actualy;
    }
}

