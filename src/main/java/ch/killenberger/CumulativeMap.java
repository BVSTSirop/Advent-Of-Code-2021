package ch.killenberger;

import java.util.*;

public class CumulativeMap<K> {
    List<Map.Entry<K, Integer>> entries = new ArrayList<>();

    public void put(K key, Integer value) {
        Map.Entry<K, Integer> existingEntry = findEntryByKey(key);

        if(existingEntry == null) {
            Map.Entry<K, Integer> newEntry = new AbstractMap.SimpleEntry<>(key, value);

            entries.add(newEntry);
        } else {
            existingEntry.setValue(existingEntry.getValue() + value);
        }
    }

    public Integer get(K key) {
        Map.Entry<K, Integer> e = findEntryByKey(key);

        if(e == null) {
            return null;
        }

        return e.getValue();
    }

    public Map<K, Integer> toMap() {
        final Map<K, Integer> m = new HashMap<>();

        for(Map.Entry<K, Integer> e : entries) {
            m.put(e.getKey(), e.getValue());
        }

        return m;
    }

    private Map.Entry<K, Integer> findEntryByKey(K key) {
        return entries.stream().filter(e -> e.getKey().equals(key)).findFirst().orElse(null);
    }
}
