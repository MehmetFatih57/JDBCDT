import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JunitTest01 {

    @Test
    public void test01(){

    assertEquals(1 , 1);//Bu methodun parantez icindeki parametreleri esitse "PASS" olur degilse "FAIL" olur
    assertTrue("hello".contains("e"));//Bu methodun parantez ici "TRUE" ise "PASS" olur degilse "FAIL" olur




    }
}
