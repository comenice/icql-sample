import org.junit.Test;

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
    public void test() throws Exception{
        TestObject o1 = new TestObject();
        TestObject o2 = new TestObject();
        boolean equals = o1.o.equals(o2.o);
        synchronized (o1){
            o1.wait();
        }
    }
}
