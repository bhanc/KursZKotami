import java.util.Scanner;

/**
 * Created by Bartosz Hanc on 2017-03-17.
 */
public class Interface {
    public static void main(String[] args) {
        CatDAO catDAO = new CatDAO();
        Scanner sc = new Scanner(System.in);
        Integer option = SHOW_MENU;

        do{
            switch (option){
                case SHOW_MENU:
                    showMenu();
                    option = sc.nextInt();
                    break;
                case ADD_CAT:
                    catDAO.addCat();
                    System.out.println("Dodano do bazy");
                    option = SHOW_MENU;
                    break;
                case SHOW_CATS:
                    break;
            }
        } while(option != EXIT);
    }
    final static int SHOW_MENU = 0;
    final static int ADD_CAT = 1;
    final static int SHOW_CATS = 2;
    final static int EXIT = 3;

    static void showMenu(){
        System.out.println("1. Dodaj kota\n2. Pokaz koty\n3. Wyjdz");
    }


}
