class WrongNumberArgsException extends Exception {

    public WrongNumberArgsException(String message) {
        super(message);
    }

    public WrongNumberArgsException(String message, Throwable throwable) {
        super(message, throwable);
    }

}

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
        int n1=-1, n2=-1;
        String s = null;
        try {
            if (args.length != 3)
                throw new WrongNumberArgsException("Three arguments expected");
            try{
                n1 = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                s = args[0];
            }
            try{
                if (n1 == -1){
                    n1 = Integer.parseInt(args[1]);
                } else
                    n2 = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                s = args[1];
            }
            try{
                if (n1 != -1 && n2 != -1){
                    s = args[2];
	            } else
			        n2 = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                s = args[2];
            }
            if (s != null && n1 >= 0 && n2 > 0) {
                if (s.length() >= Integer.max(n1, n2)) {
                    System.out.println(s.substring(Integer.min(n1, n2), Integer.max(n1, n2)+1));
                } else throw new StringIndexOutOfBoundsException("String was too short:");
            } else throw new WrongArgs("Wrong arguments");
        } catch (WrongNumberArgsException e) {
            System.err.println("Caught WrongNumberArgsException: " + e.getMessage());
            System.exit(3);
        } catch (WrongArgs e){
            System.err.println("Caught WrongArgs: " + e.getMessage());	
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }		
    }
}

 
