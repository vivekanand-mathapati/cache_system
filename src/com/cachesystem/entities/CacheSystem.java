package com.cachesystem.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CacheSystem {
    private int LEVELS;
    private static List<LRUCache> cacheLevels;

    public void addCache(LRUCache lruCache){
        this.cacheLevels.add(lruCache);
    }

    public void addCache(List<LRUCache> lruCache){
        if(cacheLevels.size() > LEVELS) {
            System.out.println("Maximum level allowed"+ LEVELS);
            return;
        }
        this.cacheLevels.addAll(lruCache);
    }

    public List<LRUCache> getCacheLevels() {
        return cacheLevels;
    }
}
