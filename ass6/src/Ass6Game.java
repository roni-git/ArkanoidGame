/*323867077*/

import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author - roni gilboa
 * this class has a main method that starts a game with four levels.
 */
public class Ass6Game {
    /**.
     * the function main
     * Create a game object, initializes and runs it
     * @param args - a line of arguments
     */
    public static void main(String[] args) {
        List<LevelInformation> list = new ArrayList<LevelInformation>();
        GUI gui = new GUI("game", 800, 600);
        boolean hasArguments = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("4") || args[i].equals("3") || args[i].equals("2") || args[i].equals("1")) {
                hasArguments = true;
            }
        }
        if ((args.length == 0) || !hasArguments) {
            list.add(new DirectHit());
            list.add(new WideEasy());
            list.add(new Green3());
            list.add(new FinalFour());
        } else {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("4")) {
                    list.add(new FinalFour());
                } else if (args[i].equals("3")) {
                    list.add(new Green3());
                } else if (args[i].equals("2")) {
                    list.add(new WideEasy());
                } else if (args[i].equals("1")) {
                    list.add(new DirectHit());
                }
            }
        }
        AnimationRunner ar = new AnimationRunner(gui);
        KeyboardSensor ks = gui.getKeyboardSensor();
        GameFlow game = new GameFlow(ar, ks);
        game.runLevels(list);
    }
}
