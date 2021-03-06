/*
 * This file was automatically generated by EvoSuite
 */

package com.sap.netweaver.porta.core.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sap.netweaver.porta.core.AuthenticationCallback;
import com.sap.netweaver.porta.core.AuthenticationReason;
import com.sap.netweaver.porta.core.CoreException;
import com.sap.netweaver.porta.core.NotAuthorizedException;
import com.sap.netweaver.porta.core.mock.CoreModuleMock;
import com.sap.netweaver.porta.core.snippets.SnippetUseDeployManager;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class CoreModuleMockEvoSuiteTest {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      CoreModuleMock coreModuleMock0 = new CoreModuleMock();
      SnippetUseDeployManager snippetUseDeployManager0 = new SnippetUseDeployManager();
      coreModuleMock0.setAuthenticationCallback((AuthenticationCallback) snippetUseDeployManager0);
      AuthenticationReason authenticationReason0 = AuthenticationReason.AUTHORIZATION_REQUIRED;
      coreModuleMock0.getCredentials(authenticationReason0);
      try {
        coreModuleMock0.checkCredentials();
        fail("Expecting exception: NotAuthorizedException");
      } catch(NotAuthorizedException e) {
      }
  }

  @Test
  public void test1()  throws Throwable  {
      CoreModuleMock coreModuleMock0 = new CoreModuleMock();
      try {
        coreModuleMock0.checkCredentials();
        fail("Expecting exception: NotAuthorizedException");
      } catch(NotAuthorizedException e) {
      }
  }
}
