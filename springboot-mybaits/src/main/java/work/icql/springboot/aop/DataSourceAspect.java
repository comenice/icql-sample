package work.icql.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.stereotype.Component;
import work.icql.springboot.config.DataSourceConfig;

import java.lang.reflect.Method;

@Component
@Aspect
@Order(0)
public class DataSourceAspect {

    /**
     * execution() 方法模式串，通用
     * @within 有注解标记的类型
     * @annotation 有注解标记的方法
     */
    @Pointcut("@within(work.icql.springboot.annotation.DataSource) || @annotation(work.icql.springboot.annotation.DataSource)")
    private void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint point) throws Exception {
        Class<?> clazz = point.getTarget().getClass();
        String methodName = point.getSignature().getName();
        Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
        Method method = clazz.getMethod(methodName, argClass);
        //如果方法上有注解，则使用方法上注解的数据源；否则使用类型上的；若都没有则使用默认数据源
        if (method.isAnnotationPresent(work.icql.springboot.annotation.DataSource.class)) {
            setDataSource(clazz, methodName, method.getAnnotation(work.icql.springboot.annotation.DataSource.class));
        } else if (clazz.isAnnotationPresent(work.icql.springboot.annotation.DataSource.class)) {
            setDataSource(clazz, methodName, clazz.getAnnotation(work.icql.springboot.annotation.DataSource.class));
        }
    }

    @After("pointcut()")
    public void after() {
        DataSourceConfig.dataSourceContextHolder.remove();
    }

    private void setDataSource(Class<?> clazz, String methodName, work.icql.springboot.annotation.DataSource annotation) {
        //取出注解中的数据源名，并设置数据源
        String value = annotation.value();
        if (!DataSourceConfig.dataSourceBeanNames.contains(value)) {
            String msg = clazz + "." + methodName + "() 配置的数据源名称不正确";
            throw new DataSourceLookupFailureException(msg);
        }
        DataSourceConfig.dataSourceContextHolder.set(value);
    }
}
