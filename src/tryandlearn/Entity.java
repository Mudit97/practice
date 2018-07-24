package tryandlearn;

import java.util.Objects;

public class Entity {
    int id;
    String name;

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id == entity.id &&
                Objects.equals(name, entity.name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

   /* @Override

        public int hashCode() {

            return Objects.hash(id);
        }*/
}
