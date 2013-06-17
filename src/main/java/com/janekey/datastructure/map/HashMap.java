package com.janekey.datastructure.map;

/**
 * User: qi.zheng
 * Date: 13-6-17
 * Time: 上午11:34
 */
public class HashMap<K, V> {
    Entry[] table;
    int size;

    public HashMap() {
        table = new Entry[16];
    }

    public V put(K key, V value) {
        if (key == null)
            return putForNullKey(value);
        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length);
        for (Entry<K, V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addEntry(hash, key, value, i);
        return null;
    }

    public V get(Object key) {
        if (key == null)
            return getForNullKey();
        int hash = hash(key.hashCode());
        for (Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
                return e.value;
        }
        return null;
    }

    void addEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K, V> e = table[bucketIndex];
        table[bucketIndex] = new Entry<K, V>(key, value, e, hash);

        // 扩容
        if (size++ > table.length) {
            int newCapacity = table.length * 3 / 2 + 1;
            Entry[] newTable = new Entry[newCapacity];
            Entry[] src = table;
            for (int j = 0; j < src.length; j++) {
                Entry<K, V> tempE = src[j];
                if (tempE != null) {
                    src[j] = null;
                    do {
                        Entry<K, V> next = tempE.next;
                        int i = indexFor(tempE.hash, newCapacity);
                        tempE.next = newTable[i];
                        newTable[i] = tempE;
                        tempE = next;
                    } while (tempE != null);
                }
            }
            table = newTable;
        }
    }

    private V putForNullKey(V value) {
        for (Entry<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addEntry(0, null, value, 0);
        return null;
    }

    private V getForNullKey() {
        for (Entry<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null)
                return e.value;
        }
        return null;
    }

    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * Returns index for hash code h.
     */
    static int indexFor(int h, int length) {
        return h & (length-1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size > 0) {
            for (Entry e : table) {
                if (e != null) {
                    sb.append(e).append(",");
                    Entry tempE = e.next;
                    while (tempE != null) {
                        sb.append(tempE).append(",");
                        tempE = tempE.next;
                    }
                }
            }
        }
        if (sb.length() > 1)
            sb.delete(sb.length() - 1, sb.length());
        sb.append("]");
        return sb.toString();
    }

    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        final int hash;

        Entry(K key, V value, Entry<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        public final boolean equals(Object o) {
            if (!(o instanceof Entry))
                return false;
            Entry e = (Entry) o;
            Object k1 = key;
            Object k2 = e.key;
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = value;
                Object v2 = e.value;
                if (v1 == v2 || (v1 != null && v1.equals(v2)))
                    return true;
            }
            return false;
        }

        public final int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }

        public final String toString() {
            return key + "=" + value;
        }
    }

}
