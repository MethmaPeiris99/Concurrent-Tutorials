import java.applet.Applet;
import java.awt.*;

public class RaceApplet extends Applet implements Runnable {

    private final static int NUMBER_OF_RUNNERS = 2; //Used to specify the number of Runner objects (The size of the runners array)
    private final static int SPACING = 20;

    Thread updateThread = null; //Used to update the UI of Applet

    Runner runners[] = new Runner[NUMBER_OF_RUNNERS]; //Used store Runner instances

    //Provide body for "updateThread"
    @Override
    public void run() {
        while (updateThread != null){
            repaint(); //This will execute every 10 milliseconds

            try {
                Thread.sleep(10); //After 10 milliseconds the UI get updated
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void init() {

        String raceType = getParameter("type"); //The argument value of HTML tag "type" is passed here

        for (int i = 0; i < NUMBER_OF_RUNNERS; i++) {
            runners[i] = new Runner(i); //Initialize Runner objects and pass them to store in runners array

            if(raceType.compareTo("unfair") == 0){ /*Compare the string value "unfair" or "fair"
                                                     If it's equal compareTo() will return o*/
                runners[i].setPriority(i + 1); //If the raceType is "unfair" the first instance of Runner will get the lowest priority
            }
            else{
                runners[i].setPriority(2); //If the raceType is "fair", then all Runner objects will get the priority as 2
            }
        }

        if(updateThread == null){
            updateThread = new Thread(this, "Thread Race"); //The Applet itself implements the Runnable interface, and it is passed in here

            updateThread.setPriority(NUMBER_OF_RUNNERS + 1); //The priority of the updateThread is always higher than Runner threads
        }
    }

    //Runner threads will start by a mouse click
    @Override
    public boolean mouseDown(java.awt.Event evt, int x, int y) {

        if(!updateThread.isAlive()){
            updateThread.start(); //updateThread will come to RUNNABLE state
        }

        for (int i = 0; i < NUMBER_OF_RUNNERS; i++) {
            if(!runners[i].isAlive()){ //Check whether the Runner objects are in the NEW state or not
                runners[i].start(); //If the Runner objects are in NEW state, change their state to RUNNABLE
            }
        }
        return true;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, size().width, size().height);
        g.setColor(Color.BLACK);

        for (int i = 0; i < NUMBER_OF_RUNNERS; i++) {
            int priority = runners[i].getPriority();

            g.drawString(new Integer(priority).toString(), 0, (i+1)*SPACING);
        }
        update(g);
    }

    @Override
    public void update(Graphics g) {
        for (int i = 0; i < NUMBER_OF_RUNNERS; i++) {
            g.drawLine(SPACING, (i+1)*SPACING,
                    SPACING+(runners[i].tick),
                    (i+1)*SPACING);
        }
    }

    @Override
    public void stop() {
        for (int i = 0; i < NUMBER_OF_RUNNERS; i++) {

            if(runners[i].isAlive()){
                runners[i].terminate = true;
                runners[i] = null;
            }

            if(updateThread.isAlive()){
                updateThread = null;
            }
        }
    }
}

/*<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Applet Tag</title>
</head>
<body>
<applet code="RaceApplet.class" height="300" width="300">
<param name="type" value="fair">
</applet>
</body>
</html>*/
