package polsl.pl.bartlomiejgladys.learnit.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Bartłomiej Gładys
 * @Date 03/11/2018
 * @Version 1.0
 */

public class Base<A> {
    private List<A> elements = new ArrayList<>();

    public List<A> getAll() {
        return elements;
    }

    public void remove(A model) {
        elements.remove(model);
    }

    public void add(A model) {
        elements.add(model);
    }
}
