public class Thread {
    public String Name;
    public int Time;
    public int WorkTime;
    public int Ost;
    public int IOStart;
    public int IOStop;
    public int IOTime;
    public int Res;
    public boolean IOEnd = true;

    public Thread(int num, int Time, int IOStart, int IOTime){
        Name = "Поток№" + num;
        this.Time = Time;
        WorkTime = 0;
        this.IOStart = IOStart;
        this.IOTime = IOTime;
        IOStop = IOStart + IOTime;
        if(IOTime != -1) IOEnd = false;
    }

    public int Do(int timer){
        //1 - завершен
        //0 - IO, прерывание
        //-1 - не завершен

        System.out.print(Name + "[" + (Time - WorkTime) + "] : ");
        Res  = 0;

        for(int i = 1; i <= timer; i++){
            if(WorkTime == Time){
                System.out.print("завершен");
                System.out.println();
                return 1;
            }
            if(WorkTime == IOStart & !IOEnd){
                System.out.print("IO(" + IOTime + ") ");
                Res += IOTime;
                System.out.println();
                Ost = timer - WorkTime;
                IOEnd = true;
                return 0;
            }
            System.out.print("... ");
            WorkTime++;
            Res++;
        }
        System.out.println();
        return -1;
    }

    public void WithoutInter(int timer){
        System.out.print(Name + "[" + (Time - WorkTime) + "] : ");
        Res = 0;

        for(int i = 1; i <= timer; i++){
            if(WorkTime == Time){
                System.out.print("завершен");
                break;
            }
            if(WorkTime == IOStart){
                Res += IOTime;
                System.out.print("IO(" + IOTime + ") ");
                /*while(kol != IOStop){
                    kol++;
                }*/
            }

            System.out.print("... ");
            WorkTime++;
            Res++;
        }
        System.out.println();
    }
}
