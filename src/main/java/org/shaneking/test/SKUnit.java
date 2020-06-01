package org.shaneking.test;

import com.google.common.base.Stopwatch;
import lombok.Getter;
import lombok.Setter;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.shaneking.skava.lang.String0;
import org.shaneking.skava.util.Regex0;

import java.io.File;

public class SKUnit {
  public static final File MAVEN_TEST_ROOT_FOLDER = new File("src/test/java");

  @Rule
  public TestName testName = new TestName();
  private Stopwatch stopwatch = Stopwatch.createStarted();

  @Getter
  @Setter
  private Class tstClazz = this.getClass();
  @Getter
  @Setter
  private String tstSeq = null;

  //CFG BEGIN:prepare
  public File tstFolder() {
    return new File(MAVEN_TEST_ROOT_FOLDER, this.getTstClazz().getName().replaceAll(this.getTstClazz().getSimpleName(), "tstfiles").replaceAll(Regex0.DOT, String0.SLASH));
  }

  public File tstFiles(String io, String fileType) {
    return new File(tstFolder(), this.getTstClazz().getSimpleName() + String0.UNDERLINE + testName.getMethodName() + String0.UNDERLINE + this.getTstSeq() + String0.UNDERLINE + io + String0.DOT + fileType);
  }

  public File tstIFiles(String fileType) {
    return tstFiles("i", fileType);
  }

  public File tstOFiles(String fileType) {
    return tstFiles("o", fileType);
  }
  //CFG END:prepare

  //CFG BEGIN:watch
  @Before
  public void setUp() {
    stopwatch = Stopwatch.createStarted();
  }

  @After
  public void tearDown() {
    System.out.println(testName.getMethodName() + String0.EQUAL + stopwatch.stop());
  }
  //CFG END:watch

  public void tstPrint(Object o) {
    System.out.println(testName.getMethodName() + String0.EQUAL + o);
  }
}
