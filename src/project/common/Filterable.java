package project.common;
import project.event.Event;

import java.util.List;

public interface Filterable<T, C>{
    List<C> filter(List<C> items, T value);
}
