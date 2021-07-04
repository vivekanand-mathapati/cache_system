package com.cachesystem.services;

import com.cachesystem.entities.CacheSystem;
import com.cachesystem.entities.LRUCache;
import lombok.Data;

import java.util.List;

@Data
public class CacheManager {
    private CacheSystem cacheSystem;
    private static int totalReadsOps = 0;
    private static int totalWriteOps = 0;

    public CacheManager() {
        this.cacheSystem = new CacheSystem();
    }

    public void createCacheSystem(int levels, List<LRUCache> lruCaches, List<Integer> capacities,
                                  List<Integer> readTime, List<Integer> writeTime){
        this.cacheSystem.setLEVELS(2);
        this.cacheSystem.addCache(lruCaches);
    }

    public int write(int key, int value){
        int writeTime  = 0;
        for (LRUCache lruCache : cacheSystem.getCacheLevels()){
            lruCache.put(key, value);
            writeTime += lruCache.getWRITE_TIME();
        }
        totalWriteOps += 1;
        return writeTime;
    }

    public int read(int key){
        int readTime = 0;
        for (LRUCache lruCache : cacheSystem.getCacheLevels()){
            readTime += lruCache.getREAD_TIME();
            if(lruCache.get(key) != -1)
                return readTime;
        }
        totalWriteOps += 1;
        return readTime;
    }

    public void status(){
        for (LRUCache lruCache : cacheSystem.getCacheLevels()){
            System.out.println("Capacity");
            System.out.print(String.format("%d / %d, ", lruCache.getDq().size(), lruCache.getCAPACITY()));
            System.out.println("Avg reads" + totalReadsOps/(totalReadsOps+totalWriteOps));
            System.out.println("Avg writes" + totalReadsOps/(totalReadsOps+totalWriteOps));
        }
    }
}
