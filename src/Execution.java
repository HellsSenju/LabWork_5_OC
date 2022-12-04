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
        int IOTime = rnd.nextInt(2,7);
        System.out.println(IOTime);
        Thread current;
        boolean flag = false;

        while(!queue.isEmpty()){
            current = queue.getFirst();
            queue.removeFirst();

            System.out.print(current.Name + "[" + current.TimeLeft + "] : ");
            for(int i = 0; i < Time; i++){
                if(i == saved.getFirst().IOTime){

                }
                if(current.TimeLeft == 0){
                    break;
                }
                if(current.IO && current.Time - current.TimeLeft == current.IOStart){
                    System.out.print("IO ");
                    flag = true;
                    current.IO = false;
                    break;
                }

                System.out.print("... ");
                current.TimeLeft--;
            }
            if(current.TimeLeft == 0){
                System.out.print("завершен");
            }
            else if(current.Time - current.TimeLeft == current.IOStart){
                saved.addLast(current);
            }
            else{
                queue.addLast(current);
                System.out.print("завершен");
            }
        }
    }

    public void NonInterruption() // без прерывания
    {

    }

}
