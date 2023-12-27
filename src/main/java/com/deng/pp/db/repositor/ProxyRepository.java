package com.deng.pp.db.repositor;

import com.deng.pp.entity.ProxyEntity;
import com.deng.pp.schedule.ProxyVerifier;
import com.google.common.base.Strings;

import java.util.*;

/**
 * Created by hcdeng on 17-7-3.
 */
public  class ProxyRepository {

    private static  ProxyRepository REPOSITORY = new ProxyRepository();

    public static ProxyRepository getInstance(){return REPOSITORY;}

    private ProxyRepository(){
        this.deleteAll();
    }

//    private RedisTemplate<String, ProxyEntity> redisTemplate = RedisConfiguration.getRedisTemplate();

    public void save(ProxyEntity proxy) {
        proxy.setUsable(true);
        proxy.setLastValidateTime(new Date());
//        redisTemplate.opsForValue().set(getKey(proxy), proxy);
    }


    private ProxyEntity getByKey(String key) {
//        return redisTemplate.opsForValue().get(key);
        return null;
    }

    public ProxyEntity get(String ip, int port){
        return getByKey(ip + ":" +port);
    }

    public ProxyEntity getRandomly(){
//        String key = redisTemplate.randomKey();
//        return Strings.isNullOrEmpty(key) ? null : getByKey(key);
        return null;
    }

    public List<ProxyEntity> getList(int num){
        List<ProxyEntity> proxys = new ArrayList<>();

//        Set<String> keys = redisTemplate.keys("*");
//        Iterator<String> it = keys.iterator();
//
//        if(num < 0)num = keys.size();
//        while(it.hasNext() && num-- > 0){
//            proxys.add(getByKey(it.next()));
//        }

        return proxys;
    }

    public List<ProxyEntity> getAll() {
//        return  getList(-1);
        return ProxyVerifier.list;
    }

    public int getCount(){
//        return redisTemplate.keys("*").size();
        return ProxyVerifier.list.size();
    }

    public void delete(ProxyEntity b) {
        deleteByKey(getKey(b));
    }

    public void delete(String ip, int port) {
        deleteByKey(ip+":"+port);
    }

    public void deleteByKey(String key) {
        if(!Strings.isNullOrEmpty(key)) return;
//            redisTemplate.opsForValue().getOperations().delete(key);
    }

    public void deleteAll() {
//        Set<String> keys = redisTemplate.keys("*");
//        Iterator<String> it = keys.iterator();
//
//        while(it.hasNext()){
//            redisTemplate.opsForValue().getOperations().delete(it.next());
//        }
    }


    private static String getKey(ProxyEntity proxy){
        return proxy.getIp()+":"+proxy.getPort();
    }

}
