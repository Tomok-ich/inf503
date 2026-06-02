package alarm;

import javax.sound.sampled.*;
import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Alarm {

    public static void main(String[] args) throws Exception {
        String timeFile = "alarm.txt";
        String soundFile = "alarm.wav";


        BufferedReader reader = new BufferedReader(new FileReader(timeFile));
        String line = reader.readLine().trim();
        reader.close();

        LocalTime alarmTime = LocalTime.parse(line, DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println("Будильник установлен на " + alarmTime);

        while (true) {
            LocalTime now = LocalTime.now();
            if (now.getHour() == alarmTime.getHour()
                    && now.getMinute() == alarmTime.getMinute()) {
                break;
            }
            Thread.sleep(1000);
        }

        System.out.println("Подъём!");
        try {
            playSound(soundFile);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void playSound(String path) throws Exception {
        AudioInputStream stream = AudioSystem.getAudioInputStream(new File(path));
        Clip clip = AudioSystem.getClip();
        clip.open(stream);
        clip.start();

        Thread.sleep(clip.getMicrosecondLength() / 1000);
    }


}
