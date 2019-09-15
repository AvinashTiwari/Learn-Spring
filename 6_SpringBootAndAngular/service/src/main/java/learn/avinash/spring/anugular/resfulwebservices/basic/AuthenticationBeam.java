package learn.avinash.spring.anugular.resfulwebservices.basic;

public class AuthenticationBeam {
    private  String message;

    public AuthenticationBeam(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean [message=%s]" , message);
    }
}
