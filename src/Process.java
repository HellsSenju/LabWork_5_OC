import java.util.Random;

public class Process {
    public String Name;
    public int Time;
    public boolean IO;

    public Process(int num){
        Name = "Process №" + num;
        Random rnd = new Random();
        Time = rnd.nextInt(5, 14) * 10;
        IO = rnd.nextBoolean();
    }
}
