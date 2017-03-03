package fr.esiea.raby_ambassa.utils;

import fr.esiea.raby_ambassa.Application;

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

    public static void verbose(String log) {
        if(Application.LOG_LVL == "verbose")
            System.out.println(log);
    }
}
