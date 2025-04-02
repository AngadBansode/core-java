package jvm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class MemHoggerLeakSolWithEvict {

    private static final int MAX_CACHE_SIZE = 1000;
    private static Map<Integer, String> cache = new LinkedHashMap<>(MAX_CACHE_SIZE, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
            // Remove the eldest entry when the cache exceeds the maximum size
            return size() > MAX_CACHE_SIZE;
        }
    };

    public static void main(String[] args) {
        System.out.println("Stating Threads to Simulate OOM Error ...");

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                int count=0;
                while(true){
                    try{
                        cache.put(count,"Value "+count);

                        if(count%1000==0){
                            System.out.println("Count "+count+", cache.size():"+cache.size());
                        }
                        count++;
                    }catch (OutOfMemoryError error){
                        System.out.println("OutOfMemoryError triggered by Thread: "+Thread.currentThread().getName());
                        throw error;
                    }
                }
            }
        });
        thread.start();
    }

}
