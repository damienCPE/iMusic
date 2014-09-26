package partie2.vueGraphique;

import javax.swing.JButton;

public class MenuBarre {

    JButton home, previous, play, pause, stop, next;
    
    public MenuBarre () {
        home = new JButton("./images/home.png");
        previous = new JButton("./images/previous.png");
        play = new JButton("./images/play.png");
        pause = new JButton("./images/pause.png");
        stop = new JButton("./images/stop.png");
        next = new JButton("./images/next.png");
    }
}
