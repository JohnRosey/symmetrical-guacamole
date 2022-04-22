package Couche.CTransport;


public class AdresseGestionnaire {

    private static final appName[] APP_NAMES = new appName[249];


    private static int counter = 0;


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

    private static appName findByName(String nomApp) {
        for (appName appName : APP_NAMES) {
            if (appName !=null&& appName.getNomApp().equals(nomApp))
                return appName;
        }
        return null;
    }


    private static class appName {
        final int adr;
        final String nomApp;

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
