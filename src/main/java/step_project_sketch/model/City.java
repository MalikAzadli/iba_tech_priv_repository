package step_project_sketch.model;

import java.io.Serializable;

public class City implements Serializable {

    private final int id;
    private final String name;

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("City{")
                .append("id=").append(id)
                .append(", name=").append(name)
                .append('}').toString();
    }
}
