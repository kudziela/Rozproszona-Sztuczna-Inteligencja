package my_exception;

public class MyExceptionClass extends Exception{


    public MyExceptionClass(String message){
        super(message);
    }
    public MyExceptionClass(String message, Throwable throwable){
        super(message,throwable);
    }
}
