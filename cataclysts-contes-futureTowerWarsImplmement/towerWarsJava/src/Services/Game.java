package Services;

import java.io.File;
import java.util.Scanner;

public class Game {
    private Integer dimmensionX;
    private Integer dimmensionY;
    private static Game ourInstance = new Game();

    public static Game getInstance() {
        return ourInstance;
    }

    private Game() {
        File file = new File("D:\\Stuffs\\Facultate\\git\\cataclysts-coding-contest\\towerWarsJava\\src\\data\\info.in");
        Scanner scanner = new Scanner(file);
        dimmensionX = scanner.nextInt();
        dimmensionY = scanner.nextInt();


    }

}
