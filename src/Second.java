import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

import java.util.*;

class WrongArgs extends Exception {

    public WrongArgs(String message) {
        super(message);
    }

    public WrongArgs(String message, Throwable throwable) {
        super(message, throwable);
    }

}

public class Second {

	public static void main(String[] args) {
        int n1=-2147483648, n2=-2147483648;
        String s = null;
        try {
            if (args.length != 3)
                throw new WrongNumberArgsException("Three arguments expected");
            } catch (WrongNumberArgsException e) {
                System.err.println("Caught WrongNumberArgsException: " + e.getMessage());
                System.exit(3);
            }

        try{
            n1 = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            s = args[0];
        }
        try{
            if (n1 == -2147483648){
                n1 = Integer.parseInt(args[1]);
            } else
                n2 = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            s = args[1];
        }
        try{
            if (n1 != -2147483648 && n2 != -2147483648)
                s = args[2];
            n2 = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            s = args[2];
        }
        try {
            if (s != null && n1 >= 0 && n2 > 0) {
                try {
                    if (s.length() >= Integer.max(n1, n2)) {
                        System.out.println(s.substring(Integer.min(n1, n2), Integer.max(n1, n2)));
                    } else throw new StringIndexOutOfBoundsException("String was too short:");
                } catch (StringIndexOutOfBoundsException e) {
                    System.err.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
                }
            } else throw new WrongArgs("Wrong arguments");
        } catch (WrongArgs e){
            System.err.println("Caught WrongArgs: " + e.getMessage());
        }
    }
}
