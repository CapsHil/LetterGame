package fr.esiea.raby_ambassa.dictionary;

import java.awt.peer.SystemTrayPeer;

/**
 * Created by capshil on 20/02/2017.
 */
public class Log {

    private Log() {
    }

    public static void debug(String log) {
        if(Application.LOG_LVL == "debug" || Application.LOG_LVL == "verbose")
            System.out.println(log);
    }

    public void verbose(String log) {
        if(Application.LOG_LVL == "verbose")
            System.out.println(log);
    }
}
