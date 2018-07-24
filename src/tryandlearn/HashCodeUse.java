package tryandlearn;

import java.util.HashSet;
import java.util.Set;

public class HashCodeUse {
    static Set<Entity> set= new HashSet<>();

    public boolean add(Entity entity){
        return set.add(entity);
    }

    public boolean remove(Entity entity){
        return set.remove(entity);
    }

    public static void main(String[] args){
        Entity e1 = new Entity(1, "Rohan");
        System.out.println(set.add(e1));
        Entity e2 = new Entity(2, "mudit");
        System.out.println(set.add(e2));
        Entity e3 = new Entity(1,"Rohan");
        System.out.println(set.add(e3));
        Entity e4 = new Entity(2, "mudit");
        System.out.println(set.add(e4));
     //   System.out.println(e1 == e3);
        System.out.println(e1.equals(e3));
        System.out.println(e1.hashCode());
        //System.out.println(e1.getId().hashCode());
    }

}
