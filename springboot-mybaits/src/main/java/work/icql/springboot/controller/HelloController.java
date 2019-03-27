package work.icql.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import work.icql.springboot.service.HelloService;

/**
 * @author icql
 * @version 1.0
 * @date 2019/3/27 13:21
 * @Title HelloController
 * @Description HelloController
 */
@Api("Hello test")
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @ApiOperation("test缓存")
    @GetMapping("/test1")
    public void test1(){
        helloService.test();
    }
}
