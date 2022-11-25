import java.util.LinkedList;
import java.util.Random;

public class Execution {
    private LinkedList<Process>  firstQueue = new LinkedList<>();
    private LinkedList<Process> secondQueue = new LinkedList<>();
    private Random rnd = new Random();
    private int Time = 6; //максимальное время для одного процесса

    public Execution(){
        int kolProc = rnd.nextInt(3, 5);
        System.out.println("Процессы: ");
        for(int i = 0; i < rnd.nextInt(2, 4); i++){
            Process first = new Process(i + 1);
            Process second = new Process(i + 1);
            second.Time = first.Time;
            second.TimeLeft = first.Time;
            System.out.println(first.Name + "  time:  " + first.Time);
            firstQueue.addLast(first); // заполнение первой очереди
            secondQueue.addLast(second); // заполнение второй очереди
        }
    }
    public void Interruption() // с прерыванием
    {
        Process saved = null;
        int TimeIO;
        int IO = 1;
        int kol;
        boolean ifIO;


        while(!firstQueue.isEmpty())
        {
            kol = 0;
            Process process = firstQueue.getFirst();
            firstQueue.removeFirst();
            System.out.println("Работает: " + process.Name);
            System.out.print("   ");

            ifIO = rnd.nextBoolean(); //будет ли работа с IO
            if(ifIO){
                IO = rnd.nextInt(process.Time); //на каком моменте будет работа с IO
            }

            for(int i = 0; i < process.Time; i++){
                if(kol == Time){

                    break;
                }

                if(i == IO){
                    TimeIO = rnd.nextInt(1, 3); //время работы IO
                    System.out.print("IO->блокировка");
                    saved = process; //сохранение процесса
                    break;
                }
                else{
                    System.out.print("...");
                    process.TimeLeft--;

                }
            }

            if(saved == null){

            }

        }
    }

    public void NonInterruption() // без прерывания
    {
        System.out.println("Без прерываний");
        int kol;
        while(!secondQueue.isEmpty()){
            kol = 0;
            Process process = secondQueue.getFirst();
            secondQueue.removeFirst();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("Работает: " + process.Name + " [" + process.TimeLeft + "]  =>");

            boolean ifIO;
            for(int i = 0; i < process.TimeLeft; i--){
                if(kol == Time){
                    if(process.TimeLeft > 0)
                        System.out.println(" => приостановка процесса");
                    break;
                }

                ifIO = rnd.nextBoolean();
                if(ifIO){
                    System.out.print(" IO ");
                    kol++;
                }
                else{
                    System.out.print(" ... ");
                    process.TimeLeft--;
                    kol++;
                }
            }
            if(process.TimeLeft > 0) secondQueue.addLast(process);
            else  System.out.println(" => завершен");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
        }
    }

}
