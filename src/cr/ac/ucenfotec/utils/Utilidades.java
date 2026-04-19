package cr.ac.ucenfotec.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilidades {

    public static String[] getProperties() throws IOException {
        String[] propiedades = new String[5];
        Properties lectura = new Properties();

        try {
            String ruta = System.getProperty("user.dir") + "/src/cr/ac/ucenfotec/utils/bd.properties";
            System.out.println("Buscando archivo en: " + ruta);

            lectura.load(new FileInputStream(ruta));

            propiedades[0] = lectura.getProperty("driver");
            propiedades[1] = lectura.getProperty("server");
            propiedades[2] = lectura.getProperty("database");
            propiedades[3] = lectura.getProperty("user");
            propiedades[4] = lectura.getProperty("password");

            return propiedades;
        } catch (Exception e) {
            System.out.println("Sucedió un error al cargar las credenciales de acceso a la BD.");
            System.out.println("Detalle: " + e.getMessage());
            throw e;
        }
    }
}