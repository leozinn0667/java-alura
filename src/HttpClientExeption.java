
public class HttpClientExeption extends RuntimeException {
    // extends pra poder lançar um erro mais específico que é filho da run time(no exemplo)
    public HttpClientExeption(String message) {

        // passa pra mãe
        super(message);

    }

}
