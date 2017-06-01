package input;

public class Action {
    public enum Actions {
        EXIT, UPDATE, ADD, DELETE;
    }

    Actions actions;

    public Action(Actions actions) {

    }

    public void executeAction() {
        switch (actions) {
            case ADD:
                System.out.println("add");
                break;
            case EXIT:
                System.out.println("exit");
                break;
            case DELETE:
                System.out.println("delete");
                break;
            case UPDATE:
                System.out.println("update");
                break;
            default:
                System.out.println("Please give me a valid action! (EXIT, UPDATE, ADD, DELETE): ");
                break;
        }
    }



}