import java.applet.Applet;
import java.awt.*;
import java.util.Calendar;

public class Clock extends Applet implements Runnable {

    private Thread clockThread = null;

    public void start(){ //Applet's start method
        if(clockThread == null){
            clockThread = new Thread(this, "Clock");
            clockThread.start(); //Thread's start method
        }
    }

    @Override
    public void run(){
        while (clockThread != null){
            repaint();
            try{
                clockThread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics graphics){
        Calendar now = Calendar.getInstance();

        graphics.drawString(now.get(Calendar.HOUR_OF_DAY) + ":" +
                now.get(Calendar.MINUTE) + ":" +
                now.get(Calendar.SECOND), 5, 10);
    }

    public void stop(){
        clockThread = null;
    }
}
