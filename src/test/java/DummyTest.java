import org.junit.Test;
import pl.edu.pw.elka.pik.issueTracker.DummyClass;

import static org.junit.Assert.assertEquals;


public class DummyTest {

    @Test
    public void testDummyClass() {
        DummyClass dummyObject = new DummyClass();
        dummyObject.setDummyVar("dummyValue");
        assertEquals("dummyValue", dummyObject.getDummyVar());
    }
}
