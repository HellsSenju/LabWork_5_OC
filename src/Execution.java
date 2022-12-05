import java.util.LinkedList;
import java.util.Random;

public class Execution {
    private LinkedList<Thread> queue;
    private LinkedList<Thread> saved;
    private Random rnd = new Random();
    private int Time = 6; //максимальное время для одного процесса

    public Execution(){
        queue = new LinkedList<>();
        queue.addLast(new Thread(1, true));
        queue.addLast(new Thread(2, false));
        System.out.println("Процессы: ");
        for(Thread item : queue){
            System.out.println(item.Name + "  time:  " + item.Time);
        }
    }

    public void Interruption() // с прерыванием
    {
        Thread current;
        boolean flag = false;

        while(!queue.isEmpty()){
            current = queue.getFirst();
            queue.removeFirst();
            System.out.print(current.Name + "[" + current.WorkTime + "] : ");

            for(int i = 0; i < Time; i++){
                if(!saved.isEmpty())
                    if(i == saved.getFirst().IOTime){
                        System.out.print("Прерывание");
                        saved.addLast(current);
                    }

                if(current.WorkTime == current.Time) //выполняется раньше выделенного премени
                {
                    System.out.print("завершен");
                    break;
                }
                if(current.IO && current.Time - current.WorkTime == current.IOStart){
                    System.out.print("IO ");
                    current.IO = false;
                    saved.addLast(current);
                    break;
                }

                if(i == Time - 1){
                    queue.addLast(current);
                }
                System.out.print("... ");
                current.WorkTime++;
            }
        }
    }

    public void NonInterruption() // без прерывания
    {

    }

}
