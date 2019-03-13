
package Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    public boolean saveUsers(ArrayList<Usuario> usuarios)throws FileNotFoundException, IOException{
        BufferedWriter salida = null;
        
        FileWriter fw = null;

        File file = new File(this.ruta);
        if (!file.exists()) {
            file.createNewFile();
        }
            
        //El true permite seguir escribiendo en el archivo sin que s sobreescriba lo ya existente
        fw = new FileWriter(file.getAbsoluteFile(), true);
        salida = new BufferedWriter(fw);
        
        for(Usuario usuario : usuarios){
            salida.write(usuario.getNombre());
            salida.write(",");
            salida.write(String.valueOf(usuario.getScore()));
            salida.write(",\n");
        }
        salida.flush();
        salida.close();
        return true;
    }
    
    public ArrayList<Usuario> loadUsers(){
        ArrayList<Usuario> users = new ArrayList<Usuario>();
        Scanner sc;
        
        try {
            sc = new Scanner(new File(this.ruta));
            sc.useDelimiter(",");
            while (sc.hasNext()) {
		String name = sc.next().trim();
                double score = Double.parseDouble(sc.next().trim());
                Usuario user = new Usuario(name);
                user.setScore(score);
                users.add(user);
            }
	}catch (FileNotFoundException e) {
            System.out.println("File not found -- " + this.ruta);
            e.printStackTrace();
	}
	return users;
    }
}

