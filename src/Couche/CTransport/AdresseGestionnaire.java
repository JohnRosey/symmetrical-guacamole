package Couche.CTransport;


//une classe qui permet de gestion des adresse
public class AdresseGestionnaire {

    //une tableau qui stocker les difference APP_NAMES
    private static final appName[] APP_NAMES = new appName[249];

    //un counter pour compter le nombre d;extremite
    private static int counter = 0;

//
//    Cette méthode permet à:
//    1.generer un adresse source et un adresse destination qui vont etre retourner par un tableau int[]
//    2.Aucune nouvelle adresse ne sera générée pour les extremite qui ont déjà des adresses
//    3.Évitez de générer la même adresse
    public static int[] genererAdresses(String nomAppSrc, String nomAppDes) {
        int[] adresses = new int[2];
        int adrSource, adrDestination;
        appName appNameSrc = findByName(nomAppSrc);
        appName appNameDes = findByName(nomAppDes);
        do {
            if (appNameSrc != null)
                adrSource = appNameSrc.getAdr();
            else
                do {
                    adrSource = (int) (249 * Math.random());
                } while (isAdressOccupied(adrSource));

            if (appNameDes != null)
                adrDestination = appNameDes.getAdr();
            else
                do {
                    adrDestination = (int) (249 * Math.random());
                } while (isAdressOccupied(adrDestination));

        }while (adrSource == adrDestination);
        APP_NAMES[counter++] = new appName(adrSource,nomAppSrc);
        APP_NAMES[counter++] = new appName(adrDestination,nomAppDes);
        adresses[0] = adrSource;
        adresses[1] = adrDestination;

        return adresses;
    }

//    Une méthode pour determiner si une adresse nouvellement générée a été occupée par
//    d'autres Applications
    private static boolean isAdressOccupied(int adr) {
        for (int i = 0; i < 249; i++) {
            if (APP_NAMES[i] != null) {
                if (APP_NAMES[i].getAdr() == adr) {
                    return true;
                }
            }
        }
        return false;
    }

//     Une méthode pour trouver un extremite par son nom
    private static appName findByName(String nomApp) {
        for (appName appName : APP_NAMES) {
            if (appName !=null&& appName.getNomApp().equals(nomApp))
                return appName;
        }
        return null;
    }

//    definir un classe interne appName
//    qui presenter un extremite(un app)
    private static class appName {
        int adr;
        String nomApp;

        public appName(int adrSource, String nomApp) {
            this.adr = adrSource;
            this.nomApp = nomApp;
        }

        public int getAdr() {
            return adr;
        }

    public String getNomApp() {
            return nomApp;
        }

}

}
