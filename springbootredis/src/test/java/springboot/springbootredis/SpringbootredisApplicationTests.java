package springboot.springbootredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootredisApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;
    /*
    Redis的五大常见数据类型
    string List Set Hash Zset（有序集合）
     stringRedisTemplate.opsForList(List列表)
      stringRedisTemplate.opsForHash(Hash散列)
      ……

     */

    @Test
    public void test01() {

        //给redis中保存一个数据
       // stringRedisTemplate.opsForValue().append("msg", "Hello");

        //将redis中保存的数据读取出来,并将返回的数据打印出来
       // String msg = stringRedisTemplate.opsForValue().get("msg");
        //System.out.println("Redis中的数据为" + msg);

        //stringRedisTemplate.opsForList().leftPush("wc", "1");
       // stringRedisTemplate.opsForList().leftPush("wc", "2");

    }

    //测试对象,使用RedisTemplate
    public void test02() {
        //需要进行序列化的时候，以后我们可以直接进行改序列化器

    }

    @Test
    void contextLoads() {

    }

}
