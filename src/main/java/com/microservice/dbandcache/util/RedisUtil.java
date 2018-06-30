package com.microservice.dbandcache.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
@Component
public class RedisUtil {
	@Autowired
	private ShardedJedisPool pool;
	
	public void set(String key,String value){
		ShardedJedis shardedJedis=null;
		try{
			shardedJedis=pool.getResource();
			if(shardedJedis!=null){
				shardedJedis.set(key, value);
			}
		}catch(Exception e){
			
		}finally{
			if(shardedJedis!=null){
				shardedJedis.close();
			}
		}
	}
	
	public String get(String key){
		ShardedJedis shardedJedis=null;
		try{
			shardedJedis=pool.getResource();
			if(shardedJedis!=null){
			 return	shardedJedis.get(key);
			}
		}catch(Exception e){
			
		}finally{
			if(shardedJedis!=null){
				shardedJedis.close();
			}
		}
		return StringUtils.EMPTY;
	}
}
