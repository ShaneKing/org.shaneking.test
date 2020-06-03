package sktest.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.shaneking.skava.io.FTN;
import org.shaneking.test.SKUnit;

import java.io.File;

public class SKUnitTest extends SKUnit {
  @Before
  public void testBefore1() {
    System.out.println("sktest.test.SKUnitTest.testBefore1");
  }

  @Before
  public void testBefore2() {
    System.out.println("sktest.test.SKUnitTest.testBefore2");
  }

  @Test
  public void testIFiles() {
    Assert.assertEquals(new File("src/test/java/sktest/test/tstfiles/SKUnitTest_testIFiles_null_i.json"), tstIFiles(FTN.JSON));
  }

  @Test
  public void testOFiles() {
    tstPrint(tstOFiles(FTN.JSON));
  }
}
