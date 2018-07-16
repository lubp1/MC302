public class ExcecaoImobiliaria extends Exception{
    private static final long serialVersionUID = 1149241039409861914L;

    public ExcecaoImobiliaria(String message) {
        super(message);
    }

    public ExcecaoImobiliaria(String message, Throwable cause) {
        super(message, cause);
    }
}
