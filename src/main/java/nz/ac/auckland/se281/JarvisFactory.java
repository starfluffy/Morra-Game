package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class JarvisFactory {

  public static Jarvis createJarvis(Difficulty jarvisType) {
    /*
        Checks what the user chose as the difficulty level and
        creates a Jarvis object based on that.
    */
    switch (jarvisType) {
      case EASY:
        return new EasyJarvis(new RandomStrategy());
      case MEDIUM:
        return new MediumJarvis(new RandomStrategy());
      case HARD:
        return new HardJarvis(new RandomStrategy());
      case MASTER:
        return new MasterJarvis(new RandomStrategy());
      default:
        System.out.println("error");
    }
    return null;
  }
}
