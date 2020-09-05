package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Host {
    public StringProperty hostname = new SimpleStringProperty("");

    public Host(String hostname) {
        this.hostname.set(hostname);
    }

    public String getHostname() {
        return hostname.get();
    }
}
