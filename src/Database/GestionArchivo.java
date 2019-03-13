
package Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import modelo.Usuario;


/**
 * @author kjime
 */
public class GestionArchivo {
    private String ruta;

    public GestionArchivo(String ruta) {
        this.ruta = ruta;
    }
    
    //El formato de guardado por linea es: Nombreusuario,score,
    public boolean saveUsers(Map<String,String> usuarios)throws FileNotFoundException, IOException{
        File file = new File(this.ruta);

        if (!file.exists()) {
            file.createNewFile();
        }
            
        //El true permite seguir escribiendo en el archivo sin que s sobreescriba lo ya existente
        PrintStream salida = new PrintStream(file);
        
        for(String key : usuarios.keySet()){
            salida.print(key);
            salida.print(",");
            salida.print(usuarios.get(key));
            salida.print(",");
        }
        salida.flush();
        salida.close();
        return true;
    }
    
    
    public Map<String,String> loadUsers(){
        Map<String,String> users = new HashMap<String,String>();
        Scanner sc;
        
        try {
            sc = new Scanner(new File(this.ruta));
            sc.useDelimiter(",");
            while (sc.hasNext()) {
		String name = sc.next().trim();
                String score = sc.next().trim();
                users.put(name, score);
            }
	}catch (FileNotFoundException e) {
            System.out.println("File not found -- " + this.ruta);
            e.printStackTrace();
	}
	return users;
    }
}

