/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.BEArtist;
import BE.BEGenre;
import BE.BESong;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class DALSongStorage {

    private static final String FILE_NAME = "songs.txt";
    ArrayList<BEGenre> allGenres = new ArrayList<>();
    ArrayList<BEArtist> allArtists = new ArrayList<>();
    ArrayList<BESong> allSongs;

    public DALSongStorage() {
        allSongs = new ArrayList<>();
        allArtists = new ArrayList<>();
        allGenres = new ArrayList<>();

        ArrayList<String> words = new ArrayList<>();
        Scanner s;
        try {
            s = new Scanner(new File(FILE_NAME));
            while (s.hasNextLine()) {
                words.add(s.nextLine());
            }
            s.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Couldn't find the specified file: " + FILE_NAME);
        }
        allArtists.add(new BEArtist("Any"));
        allGenres.add(new BEGenre("Any"));
        for (int i = 0; i < words.size(); i++) {
            String theWord = words.get(i);
            String[] parts = theWord.split("#");
            String title = parts[0]; // titlen
            String artist = parts[1];
            int length = Integer.parseInt(parts[4]);
            String bpm = parts[3];
            String genre = parts[2];
            boolean favorite = Boolean.parseBoolean(parts[5]);

            BEArtist localArtist = null;

            for (BEArtist a : allArtists) {
                if (a.getArtist().equals(artist)) {
                    localArtist = a;
                }
            }
            if (localArtist == null) {
                localArtist = new BEArtist(artist);
                allArtists.add(localArtist);
            }

            BEGenre localGenre = null;
            for (BEGenre b : allGenres) {
                if (b.getGenre().equals(genre)) {
                    localGenre = b;
                    
                }
            }
            if (localGenre == null) {
                localGenre = new BEGenre(genre);
                allGenres.add(localGenre);
            }

            BESong localS = new BESong(title, localArtist, convertLength(length), correctBPM(bpm), localGenre, favorite);
            allSongs.add(localS);
        }
    }

    public String correctBPM(String bpm) {
        if (bpm.toLowerCase().equals("unknown")) {
            bpm = "-";
            return bpm;
        }
        return bpm;
    }

    public String convertLength(int length) {
        int seconds = (length / 1000) % 60;
        int minutes = (length / (1000 * 60) % 60);
        int secondsLength = String.valueOf(seconds).length();
        String theLength;
        if (secondsLength == 1) {
            theLength = minutes + ":0" + seconds;
        } else {
            theLength = minutes + ":" + seconds;
        }
        return theLength;
    }

    public ArrayList<BESong> getAll() {
        return allSongs;
    }

    public ArrayList<BEArtist> getArtists() {
        return allArtists;
    }

    public ArrayList<BEGenre> getGenres() {
        return allGenres;
    }
}
