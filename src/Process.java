import java.util.Random;

public class Process {
    public String Name;
    public int Time;
    public int TimeLeft;

    public Process(int num){
        Name = "Процесс№" + num;
        Random rnd = new Random();
        Time = rnd.nextInt(5, 14);
        TimeLeft = Time;
    }
}
