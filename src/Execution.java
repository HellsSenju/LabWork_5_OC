import java.util.LinkedList;
import java.util.Random;

public class Execution {
    private LinkedList<Thread> queueF;
    private LinkedList<Thread> queueS;
    private Random rnd = new Random();
    private int Time = 7; //максимальное время для одного процесса

    public Execution(){
        queueF = new LinkedList<>();
        queueF.addLast(new Thread(1,  18, 4, 8));
        queueF.addLast(new Thread(2,  16, -1, -1));

        queueS = new LinkedList<>();
        queueS.addLast(new Thread(1,  18, 4, 8));
        queueS.addLast(new Thread(2,  16, -1, -1));

        System.out.println("Процессы: ");
        for(Thread item : queueF){
            System.out.print(item.Name + "  time:  " + item.Time);
            if(item.IOTime != -1) System.out.print("  IOTime:  " + item.IOTime);
            System.out.println();
        }
    }

    public void Interruption()
    {
        System.out.println("=============================================");
        System.out.println("Ввод вывод, управляемый прерываниями");
        Thread current;
        Thread saved;
        int allTime = 0;
        int res;
        //1 - завершен
        //0 - IO, прерывание
        //-1 - не завершен

        while(!queueF.isEmpty()){
            current = queueF.getFirst();
            queueF.removeFirst();
            res = current.Do(Time);
            allTime += Time;
            if(res == 0){
                saved = current;
                int need = saved.IOTime;
                current = queueF.getFirst();
                queueF.removeFirst();

                int kol = need / Time + 1;
                while(kol > 0){
                    if(need <= Time){
                        current.Do(need);
                        allTime += need;
                    }
                    else{
                        current.Do(Time);
                        allTime += Time;
                    }
                    kol--;
                    need -= Time;
                }

                if(current.WorkTime < current.Time) queueF.addLast(current);

                if(saved.Ost != 0){
                    saved.Do(saved.Ost);
                    allTime += saved.Ost;
                    saved.Ost = 0;
                    if(saved.WorkTime < saved.Time) queueF.addLast(saved);
                }
            }

            if(res == -1) //идет на еще один круг
                queueF.addLast(current);
        }
        System.out.println("Все время работы: " + allTime);
    }

    public void NonInterruption() // без прерывания
    {

    }
}
