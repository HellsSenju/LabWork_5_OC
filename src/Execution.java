import java.util.LinkedList;
import java.util.Random;

public class Execution {
    private LinkedList<Thread> queue;
    private LinkedList<Thread> saved;
    private Random rnd = new Random();
    private int Time = 7; //максимальное время для одного процесса

    public Execution(){
        queue = new LinkedList<>();
        queue.addLast(new Thread(1,  18, 4, 8));
        queue.addLast(new Thread(2,  16, 0, 0));
        System.out.println("Процессы: ");
        for(Thread item : queue){
            System.out.println(item.Name + "  time:  " + item.Time);
        }
    }

    public void Interruption() // с прерыванием
    {
        Thread current;
        boolean flag = false;
        int res;
        //1 - завершен
        //0 - IO, прерывание
        //-1 - не завершен

        while(!queue.isEmpty()){
            current = queue.getFirst();
            queue.removeFirst();
            res = current.Interruption(Time);
            if(res == 0){

            }

            if(res == -1) //идет на еще один круг
                queue.addLast(current);

        }
    }

    public void NonInterruption() // без прерывания
    {

    }

}
