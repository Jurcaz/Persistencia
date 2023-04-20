package jpg.iescierva.persistencia.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PropertiesUtilSingletonTest {

	@Before
	public void init () {
		System.out.println("No sirve de nada pero mola");
	}

	@Test
	public void testGetDriver() {
		assertEquals("com.mysql.cj.jdbc.Driver", PropertiesUtilSingleton.getInstance().getDriver());
	}
	@Test
	public void testGetConnectionString() {
		assertEquals("jdbc:mysql://localhost:3306/persistencia?useSSL=false", PropertiesUtilSingleton.getInstance().getConnectionString());
	}
	@Test
	public void testGetDatabaseUser() {
		assertEquals("jpedreno", PropertiesUtilSingleton.getInstance().getDatabaseUser());
	}
	@Test
	public void testGetDatabasePass() {
		assertEquals("jpedreno", PropertiesUtilSingleton.getInstance().getDatabasePass());
	}
}
