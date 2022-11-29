import java.util.LinkedList;
import java.util.Random;

public class Execution {
    private Thread first;
    private Thread second;
    private Random rnd = new Random();
    private int Time = 6; //максимальное время для одного процесса

    public Execution(){
        first = new Thread(1);
        second = new Thread(2);
        System.out.println("Процессы: ");
        System.out.println(first.Name + "  time:  " + first.Time);
        System.out.println(second.Name + "  time:  " + second.Time);
    }
    public void Interruption() // с прерыванием
    {
        int IOTime = rnd.nextInt(2,7);
        int start = rnd.nextInt(2, second.Time - 2);
        System.out.println(IOTime);
        System.out.println(start);

        System.out.print(first.Name + "[" + first.TimeLeft + "] : ");

        while(first.TimeLeft != 0){
            if(first.Time - first.TimeLeft + 1 == start){
                System.out.print("IO ");

                System.out.println();
                System.out.print(second.Name + "[" + second.TimeLeft + "] : ");
                while(second.TimeLeft != 0){
                    if(second.Time - second.TimeLeft == IOTime){
                        break;
                    }
                    System.out.print("... ");
                    second.TimeLeft--;
                }
                System.out.println();
                System.out.print(first.Name + "[" + first.TimeLeft + "] : ");
            }
            System.out.print("... ");
            first.TimeLeft--;
        }

        System.out.println();
        System.out.print(second.Name + "[" + second.TimeLeft + "] : ");
        while (second.TimeLeft != 0){
            System.out.print("... ");
            second.TimeLeft--;
        }

        System.out.println("Общее время выполнения: ");
    }

    public void NonInterruption() // без прерывания
    {

    }

}
