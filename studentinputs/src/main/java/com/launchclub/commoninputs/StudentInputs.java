package com.launchclub.commoninputs;

import java.sql.Date;
import java.util.Scanner;

public class StudentInputs {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String getString(String userinput) {
        System.out.println(userinput);
        return SCANNER.next().trim();
    }
    public static long getLong(String userinput) {
        System.out.println(userinput);
        return SCANNER.nextLong();
    }
    public static int getInt(String userinput) {
        System.out.println(userinput);
        return SCANNER.nextInt();
    }

}
