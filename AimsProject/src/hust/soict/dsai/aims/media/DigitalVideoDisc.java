package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 1;

    public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
        super(title, category, cost, director, length);
        nbDigitalVideoDiscs++;  // Increment the count each time a new DVD is created
    }
    
	public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public static void setNbDigitalVideoDiscs(int nbDigitalVideoDiscs) {
        DigitalVideoDisc.nbDigitalVideoDiscs = nbDigitalVideoDiscs;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());

        if (getLength() == 0) System.out.println("DVD cannot be played.");
        else System.out.println("DVD length: " + getLength());
    }

    
}
