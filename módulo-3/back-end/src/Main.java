import model.service.ConsoleOptions;

public class Main {
    public static void main(String[] args) {

        ConsoleOptions consoleOptions = new ConsoleOptions();

        //ÁREA DO LOGIN E SIGN UP
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                                 Login/Sign up                                  ");
        System.out.println("--------------------------------------------------------------------------------");
        int id_usuario = consoleOptions.areaLogin();

        if (id_usuario != 1) {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("                                 Herlivre                                       ");
            System.out.println("--------------------------------------------------------------------------------");
            consoleOptions.areaClient(id_usuario);
        }

        if (id_usuario == 1) {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("                                AREA ADMIN                                      ");
            System.out.println("--------------------------------------------------------------------------------");
            consoleOptions.areaAdmin();
        }

    }
}