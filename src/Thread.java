import java.util.Random;

public class Thread {
    public String Name;
    public int Time;
    public int WorkTime;
    public int IOStart;
    public int IOStop;
    public int IOTime;

    public Thread(int num, int Time, int IOStart, int IOTime){
        Name = "Поток№" + num;
        this.Time = Time;
        WorkTime = 0;
        this.IOStart = IOStart;
        this.IOTime = IOTime;
        IOStop = IOStart + IOTime;
    }

    public int Interruption(int timer){
        //1 - завершен
        //0 - IO, прерывание
        //-1 - не завершен

        System.out.print(Name + "[" + WorkTime + "] : ");

        for(int i = 1; i <= timer; i++){
            if(WorkTime == timer){
                System.out.print("завершен");
                return 1;
            }
            if(WorkTime == IOStart){
                System.out.print("IO => прерывание");
                return 0;
            }
            System.out.print("... ");
            WorkTime++;
        }
        return -1;
    }
}
