package work.icql.springboot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import work.icql.springboot.service.HelloService;

import java.util.Set;

/**
 * @author icql
 * @version 1.0
 * @date 2019/3/27 13:24
 * @Title HelloServiceImpl
 * @Description HelloServiceImpl
 */
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Cacheable(value = "test", key = "1")
    public void test() {

        Long add = redisTemplate.opsForSet().add("VIN", "12346481");
        Set members = redisTemplate.opsForSet().members("VIN");
        String[] arr = new String[]{"-9999", "A", "2", "B", "3", "C", "4", "D", "9999"};
        double val = 2.5;
        String a = "";
        for (int i = 2; i < arr.length; i = i + 2) {
            double small = Double.valueOf(arr[i - 2]);
            double big = Double.valueOf(arr[i]);

            if (val >= small && val < big) {
                a = arr[i - 1];
                break;
            }
        }
        log.error(a);

        log.error("缓存了");
    }
}
