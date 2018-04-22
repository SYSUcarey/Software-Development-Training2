import static org.junit.Assert.*;
import org.junit.Test;

public class HelloWorldTest {
  public helloworld hw = new helloworld();
  @Test
  public void testHello() {
    hw.hello();
    assertEquals("Hello World!", hw.getStr()); 
  } 
}
