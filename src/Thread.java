import java.util.Random;

public class Thread {
    public String Name;
    public int Time;
    public int TimeLeft;

    public Thread(int num){
        Name = "Поток№" + num;
        Random rnd = new Random();
        Time = rnd.nextInt(8, 14);
        TimeLeft = Time;
    }
}
