package com.cachesystem.entities;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

@Data
@Builder
public class LRUCache {
    private HashMap<Integer, Integer> hm;
    private Queue<Integer> dq;
    private final int CAPACITY;
    private final int READ_TIME;
    private final int WRITE_TIME;
    public LRUCache(int capacity, int readTime, int writeTime) {
        CAPACITY = capacity;
        dq = new ArrayDeque<>(CAPACITY);
        hm = new HashMap<>();
        READ_TIME = readTime;
        WRITE_TIME = writeTime;
    }

    public int get(int key) {
        if(hm.containsKey(key)){
            dq.remove(key);
            dq.offer(key);
            return hm.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(!hm.containsKey(key)){
            if(dq.size()==CAPACITY){
                int val = dq.poll();
                hm.remove(val);
            }
        }else
            dq.remove(key);

        dq.offer(key);
        hm.put(key,value);
    }
}
