package org.shaneking.test;

import com.google.common.base.Stopwatch;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.shaneking.skava.lang.String0;
import org.shaneking.skava.util.Regex0;

import java.io.File;

@Slf4j
public class SKUnit {
  public static final File MAVEN_TEST_ROOT_FOLDER = new File("src/test/java");

  @Rule
  public TestName testName = new TestName();//Can't private
  @Getter
  @Setter
  private Stopwatch stopwatch;
  @Getter
  @Setter
  private Class tstClazz = this.getClass();
  @Getter
  @Setter
  private String tstSeq = null;
  @Getter
  @Setter
  private String tstFiles = "tstfiles";
  @Getter
  @Setter
  private String tstI = String0.I.toLowerCase();
  @Getter
  @Setter
  private String tstO = String0.O.toLowerCase();

  //CFG BEGIN:files
  public File tstFolder() {
    return new File(MAVEN_TEST_ROOT_FOLDER, this.getTstClazz().getName().replaceAll(this.getTstClazz().getSimpleName(), getTstFiles()).replaceAll(Regex0.DOT, String0.SLASH));
  }

  public File tstFiles(String io, String fileType) {
    return new File(tstFolder(), this.getTstClazz().getSimpleName() + String0.UNDERLINE + testName.getMethodName() + String0.UNDERLINE + this.getTstSeq() + String0.UNDERLINE + io + String0.DOT + fileType);
  }

  public File tstIFiles(String fileType) {
    return tstFiles(getTstI(), fileType);
  }

  public File tstOFiles(String fileType) {
    return tstFiles(getTstO(), fileType);
  }
  //CFG END:files

  //CFG BEGIN:watch
  @Before
  public void tstBefore() {
    setStopwatch(Stopwatch.createStarted());
  }

  @After
  public void tstAfter() {
    log.info(testName.getMethodName() + String0.EQUAL + this.getStopwatch().stop());
  }
  //CFG END:watch

  public void tstPrint(Object o) {
    log.info(testName.getMethodName() + String0.EQUAL + o);
  }
}
