import org.junit.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * @author icql
 * @version 1.0
 * @date 2019/4/8 15:33
 * @Title MyTest
 * @Description MyTest
 */
public class MyTest {

    final int i = 0;

    @Test
    public void test(){
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler(); // 获取编译器对象
    }
}
