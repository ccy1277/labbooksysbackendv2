package org.labbooksys.util;

public class DateUtils {
    public static int monthWrapper(int month){
        int newM = 0;
        switch (month){
            case 0: newM = 12; break;
            case 1: newM = 2; break;
            case 2: newM = 3; break;
        }
        return 0;
    }
}
