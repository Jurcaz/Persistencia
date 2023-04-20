package jpg.iescierva.persistencia.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtilSingleton {

	private String driver = "driver";
	private String connectionString = "connectionString";
	private String databaseUser = "databaseUser";
	private String databasePass = "databasePass";

	//instancia
	private static PropertiesUtilSingleton instancia;

	Properties properties = new Properties ();

	//constructor
	private PropertiesUtilSingleton () {
		try {
			properties.load(new FileInputStream ("src/main/resources/persistencia.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static PropertiesUtilSingleton getInstance () {
		if (instancia == null) instancia = new PropertiesUtilSingleton ();
		return instancia;
	}

	public String getDriver () {
		return properties.getProperty(driver);
	}
	public String getConnectionString () {
		return properties.getProperty(connectionString);
	}

	public String getDatabaseUser () {
		return properties.getProperty(databaseUser);
	}
	public String getDatabasePass () {
		return properties.getProperty(databasePass);
	}

}
