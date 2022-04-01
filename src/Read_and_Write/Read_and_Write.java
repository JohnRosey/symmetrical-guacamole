package Read_and_Write;

import java.io.*;
import java.util.ArrayList;

public class Read_and_Write {
    /**
     * @param FilePath
     * @return Le contenue du chemin du fichier passee au main
     */
    public static ArrayList<String> Read(String FilePath) {

        File file = new File(FilePath);
       boolean boo=true;
        ArrayList<String> strs = new ArrayList<>();
        if (boo) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String linetxt = null;
                StringBuilder result = new StringBuilder();

                int count = 1;
                while ((linetxt = bufferedReader.readLine()) != null) {
                    // strProgram+=linetxt+" ";//Ajouter un espace lors du passage à la ligne suivante
                    if (count == 1) {
                        count++;
                        continue;
                    }
                    strs.add(linetxt);

                }
                //Affiche le contenue de strs
                System.out.println(strs);
                return strs;

            }
            catch (Exception e) {
                System.out.println("Impossible de lire le fichier r");
                e.printStackTrace();
            }
            finally {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } else {
            System.out.println("impossibile de trouver le fichier");
        }

        return strs;

    }
    public static void Write(String str,String path ) {
        FileOutputStream o = null;
        byte[] buff = new byte[]{};
        str = str + "\r\n";
        try {
            File file = new File(path);

            buff = str.getBytes();
            o = new FileOutputStream(file, true);
            o.write(buff);
            o.flush();
            o.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
