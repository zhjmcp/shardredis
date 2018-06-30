package com.microservice.dbandcache.config;

//import com.microservice.dbandcache.dao.CarDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {
	/*@Before("execution(* com.microservice.dbandcache.dao.*.*(..))")
	public void setDataSourceKey(JoinPoint point){
		if(point.getTarget() instanceof CarDao){
			DatabaseContextHolder.setDatabaseType(DatabaseType.microservicedb2);
		}
	}*/
}
