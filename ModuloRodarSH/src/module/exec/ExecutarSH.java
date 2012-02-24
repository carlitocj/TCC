package module.exec;

import java.io.IOException;

public class ExecutarSH {

    private final String CAMINHO = System.getProperty("user.home")+"/POSTagger/";

    public boolean rodarSH() {
        ProcessBuilder pb = new ProcessBuilder("bash", "-c", "cat " + CAMINHO
                + "input.txt | " + CAMINHO + "run-Tagger.sh > " + CAMINHO
                + "output.txt");
        try {
            Process processo = pb.start();
            int waitFor = processo.waitFor();
            if (waitFor > 0) {
                return false;
            }
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
