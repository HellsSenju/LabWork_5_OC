import java.util.LinkedList;
import java.util.Random;

public class Execution {
    private LinkedList<Process>  firstQueue = new LinkedList<>();
    private LinkedList<Process> secondQueue = new LinkedList<>();
    private Random rnd = new Random();
    private int Time = 6; //максимальное время для одного процесса

    public Execution(){
        int kolProc = rnd.nextInt(3, 5);
        for(int i = 0; i < rnd.nextInt(3, 5); i++){
            firstQueue.addLast(new Process(i + 1)); // заполнение первой очереди
            secondQueue.addLast(new Process(i + 1)); // заполнение второй очереди
        }
    }
    public void Interruption() // с прерыванием
    {
        Process saved;
        while(!firstQueue.isEmpty()){
            Process process = firstQueue.getFirst();
            firstQueue.removeFirst();
            System.out.println("Работает: " + process.Name);
            System.out.print("   ");

            boolean ifIO;
            for(int i = 0; i < process.Time; i++){
                if(i == )
                ifIO = rnd.nextBoolean();
                if(ifIO){
                    System.out.print("IO->блокировка");
                    saved = process;
                    break;
                }
                else{
                    System.out.print("...");
                    process.TimeLeft--;
                }
            }
        }
    }

    public void NonInterruption() // без прерывания
    {

    }

}
