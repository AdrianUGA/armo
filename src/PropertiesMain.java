import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.util.Properties;

import ensembles.EnsembleEntiers;
import ensembles.EnsembleListeEntiers;
import ensembles.EnsembleTableauEntiers;
import exceptions.BadConfigurationException;

public class PropertiesMain {

	private static final String DEFAULT_CONFIG_FILENAME = "defaut.cfg";
	/* jar version */
	//private static final String DEFAULT_CONFIG_FILENAME = "files/defaut.cfg";
	private static final InputStream DEFAULT_CONFIG_FILE = ClassLoader.getSystemClassLoader().getResourceAsStream(DEFAULT_CONFIG_FILENAME);
	private static final String CONFIG_FILE_DESCRIPTION = "Configuration du casse-brique Armoroides";
	private static final String CONFIG_FILE = FileSystems.getDefault().getPath(System.getProperty("user.home"), ".armoroid").toString();
	private static final String[] ensembleNames = {"GrandEnsemble", "PetitEnsemble"};

	public static void main(String[] args) throws BadConfigurationException, IOException  {
		Properties defaultProperties = new Properties();
		InputStream defaultFile = DEFAULT_CONFIG_FILE;
		if(defaultFile == null)
			throw new FileNotFoundException();
		defaultProperties.load(defaultFile);
		
		Properties properties = new Properties(defaultProperties);
		try {
			properties.load(new FileReader(CONFIG_FILE));
		} catch (IOException e) {}

		EnsembleEntiers[] ensembleEntiers = new EnsembleEntiers[2];

		for(int i=0; i<2; i++){
			if(properties.getProperty(ensembleNames[i]).equals("Tableau")){
				ensembleEntiers[i] = new EnsembleTableauEntiers();
			}else if(properties.getProperty(ensembleNames[i]).equals("Liste")){
				ensembleEntiers[i] = new EnsembleListeEntiers();
			}else{
				throw new BadConfigurationException();
			}
		}


		System.out.println(properties.getProperty("PetitEnsemble"));
		properties.store(new PrintWriter(CONFIG_FILE), CONFIG_FILE_DESCRIPTION);

	}
	
	
}
