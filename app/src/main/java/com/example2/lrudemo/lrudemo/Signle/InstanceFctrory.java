package com.example2.lrudemo.lrudemo.Signle;
import android.support.v4.util.LruCache;
import android.util.Log;

/**
 * Created by xuyimin on 2018/5/31.
 * E-mail codingyida@qq.com
 */

public class InstanceFctrory<T> {
    private InstanceFctrory(){};
    private String tag ="LruCacheSample";
    private int MAX_SIZE=8;
    volatile LruCache<Class<T>,Object> map=new LruCacheSample();

    class LruCacheSample extends LruCache<Class<T>, Object> {

        LruCacheSample() {
            super(MAX_SIZE);
        }

        @Override
        protected int sizeOf(Class<T> targetClass, Object value) {
            return 1;
        }

        @Override
        protected void entryRemoved(boolean evicted, Class<T> key, Object oldValue, Object newValue) {
            super.entryRemoved(evicted, key, oldValue, newValue);
            if(oldValue!=null){
                Log.i("LruCacheSample","old removed!"+oldValue.getClass());
            }
            if(newValue!=null){
                Log.i("LruCacheSample","new added!"+newValue.getClass());
            }
        }
    }


    private static class holder{
        private static final InstanceFctrory instance=new InstanceFctrory();
    }

    public static InstanceFctrory getInsFactory(){
        return holder.instance;
    }

    public T getInstance(Class<T> targetClass){
        if(!map.snapshot().containsKey(targetClass)){
            synchronized (this){
                if(!map.snapshot().containsKey(targetClass)){
                    try {
                        T t=  targetClass.newInstance();
                        map.put(targetClass,t);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("#start");
        for(Class<T> key:map.snapshot().keySet()) {
            //System.out.print("key:"+key+"###value:"+map.get(key).hashCode()+"*****");
            Log.i("LruCacheSample","key:"+key);
        }
        Log.i(tag,"########################");
        return (T) map.get(targetClass);

    }
}

