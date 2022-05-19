package project.entity.common;

import java.util.List;

public interface Filterable<T, C>{
    List<C> filter(List<C> items, T value);
}
