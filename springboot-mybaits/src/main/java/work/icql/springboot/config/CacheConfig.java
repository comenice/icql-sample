package work.icql.springboot.config;

/**
 * @author icql
 * @version 1.0
 * @date 2018/11/22 10:25
 * @Title CacheConfig
 * @Description CacheConfig
 */
//#@Configuration
//@EnableCaching
public class CacheConfig {
    //@Bean
    //public CacheLoader<Object, Object> cacheLoader() {
    //
    //    CacheLoader<Object, Object> cacheLoader = new CacheLoader<Object, Object>() {
    //
    //        @Override
    //        public Object load(Object key) throws Exception {
    //            return null;
    //        }
    //
    //        // 重写这个方法将oldValue值返回回去，进而刷新缓存
    //        @Override
    //        public Object reload(Object key, Object oldValue) throws Exception {
    //            return oldValue;
    //        }
    //    };
    //
    //    return cacheLoader;
    //}

    //public static final int DEFAULT_MAXSIZE = 10000;
    //public static final int DEFAULT_TTL = 600;
    ///**
    // * 定义cache名称、超时时长（秒）、最大容量
    // * 每个cache缺省：10秒超时、最多缓存50000条数据，需要修改可以在构造方法的参数中指定。
    // */
    //public enum Caches{
    //    getUserById(600),          //有效期600秒
    //    listCustomers(7200,1000),  //有效期2个小时 , 最大容量1000
    //    ;
    //    Caches() {
    //    }
    //    Caches(int ttl) {
    //        this.ttl = ttl;
    //    }
    //    Caches(int ttl, int maxSize) {
    //        this.ttl = ttl;
    //        this.maxSize = maxSize;
    //    }
    //    private int maxSize=DEFAULT_MAXSIZE;    //最大數量
    //    private int ttl=DEFAULT_TTL;        //过期时间（秒）
    //    public int getMaxSize() {
    //        return maxSize;
    //    }
    //    public int getTtl() {
    //        return ttl;
    //    }
    //}
    //
    ///**
    // * 创建基于Caffeine的Cache Manager
    // * @return
    // */
    //@Bean
    //@Primary
    //public CacheManager caffeineCacheManager() {
    //    SimpleCacheManager cacheManager = new SimpleCacheManager();
    //    ArrayList<CaffeineCache> caches = new ArrayList<CaffeineCache>();
    //    for(Caches c : Caches.values()){
    //        caches.add(new CaffeineCache(c.name(),
    //                Caffeine.newBuilder().recordStats()
    //                        .expireAfterWrite(c.getTtl(), TimeUnit.SECONDS)
    //                        .maximumSize(c.getMaxSize())
    //                        .build())
    //        );
    //    }
    //    cacheManager.setCaches(caches);
    //    return cacheManager;
    //}


}
