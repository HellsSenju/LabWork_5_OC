import java.util.Random;

public class Thread {
    public String Name;
    public int Time;
    public int TimeLeft;
    public int IOStart;
    public int IOTime;
    public boolean IO;

    public Thread(int num, boolean io){
        Name = "Поток№" + num;
        Random rnd = new Random();
        Time = rnd.nextInt(8, 14);
        TimeLeft = Time;
        IO = io;
        if(IO){
            IOStart = rnd.nextInt(4, Time - 4);
            IOTime = rnd.nextInt(4, Time - 4);
        }
    }
}
