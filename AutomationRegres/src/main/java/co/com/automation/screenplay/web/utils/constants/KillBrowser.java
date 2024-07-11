package co.com.automation.screenplay.web.utils.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class KillBrowser {
    static final Logger logger = LoggerFactory.getLogger(KillBrowser.class);

    private KillBrowser() {
        throw new IllegalStateException("Utility class");
    }

    public static void processes(String browser) throws IOException, InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        ProcessBuilder processBuilder;
        if (os.contains("win")) {
            processBuilder = new ProcessBuilder(new String[]{"taskkill", "/F", "/IM", browser + ".exe"});
        } else {
            if (!os.contains("nix") && !os.contains("nux") && !os.contains("mac")) {
                logger.info("Sistema operativo no compatible");
                return;
            }

            String[] command = new String[]{"bash", "-c", "pkill " + browser};
            processBuilder = new ProcessBuilder(command);
        }

        Process process = processBuilder.start();
        int exitCode = process.waitFor();
        if (exitCode == 0) {
            logger.info("Procesos del browser cerrados exitosamente");
        } else {
            logger.info("No existen procesos del browser o no fue posible cerrarlos");
        }

    }
}
