public class EmptyStructureException extends RuntimeException {

    public EmptyStructureException() {
        super();
        System.out.println("That stack is empty.");
    }

}
