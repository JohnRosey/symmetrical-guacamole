package Paquet;

public class paquet {
    public abstract class Paquet {
        protected int adresseSource;
        protected int adresseDestination;


        public Paquet(int adresseSource, int adresseDestination) {
            this.adresseSource = adresseSource;
            this.adresseDestination = adresseDestination;
        }

        public int getAdresseSource() {
            return adresseSource;
        }

        public void setAdresseSource(int adresseSource) {
            this.adresseSource = adresseSource;
        }

        public int getAdresseDestination() {
            return adresseDestination;
        }

        public void setAdresseDestination(int adresseDestination) {
            this.adresseDestination = adresseDestination;
        }

        @Override
        public String toString() {
            return "Paquet{" +
                    "adresseSource=" + adresseSource +
                    ", adresseDestination=" + adresseDestination +
                    '}';
        }
    }
}
