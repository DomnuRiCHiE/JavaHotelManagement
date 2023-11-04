import UI.UI;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        try{
            ui.run();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
