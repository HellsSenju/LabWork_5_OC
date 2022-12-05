import java.util.Random;

public class Thread {
    public String Name;
    public int Time;
    public int WorkTime;
    public int IOStart;
    public int IOStop;
    public int IOTime;

    public Thread(int num, boolean io){
        Name = "Поток№" + num;
        Random rnd = new Random();
        Time = rnd.nextInt(10, 18);
        WorkTime = 0;
        boolean IO = io;
        if(IO){
            IOStart = rnd.nextInt(4, Time / 2);
            IOTime = rnd.nextInt(2, 6);
            IOStop = IOStart + IOTime;
        }
    }

    public void Interruption(int timer){
        System.out.print(Name + "[" + WorkTime + "] : ");

        for(int i = 1; i <= timer; i++){
            if(WorkTime == timer){
                System.out.print("завершен");
                break;
            }
            if(WorkTime == IOStart){
                System.out.print("IO => прерывание");
                InputOutput();
            }
            System.out.print("... ");
            WorkTime++;
        }
    }

    private void InputOutput(){

    }
}
