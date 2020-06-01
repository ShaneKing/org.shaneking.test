package sktest.test;

import org.junit.Assert;
import org.junit.Test;
import org.shaneking.skava.io.FTN;
import org.shaneking.test.SKUnit;

import java.io.File;

public class SKUnitTest extends SKUnit {
  @Test
  public void testIFiles() {
    Assert.assertEquals(new File("src/test/java/sktest/test/tstfiles/SKUnitTest_testIFiles_null_i.json"), tstIFiles(FTN.JSON));
  }

  @Test
  public void testOFiles() {
    tstPrint(tstOFiles(FTN.JSON));
  }
}
