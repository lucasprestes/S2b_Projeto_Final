package testsuits;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.org.dbserver.testcase.*;

@RunWith(Suite.class)
@SuiteClasses({
	
	BS_Login_TestCase.class, 
	BS_LocalNascimento_TestCase.class,
	BS_CPF_TestCaseParam.class
	
})
public class RegressionTestSuite {
	
	@BeforeClass
	public static void init()
	{
		System.out.println("Iniciando execução .... ");
	}
	
	@AfterClass
	public static void end()
	{
		System.out.println("Finalizado .... ");
	}
	

}
