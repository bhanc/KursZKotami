import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Bartosz Hanc on 2017-03-17.
 */
public class CatDAO {
    private ArrayList<Cat> cats = new ArrayList<Cat>();

    public void addCat(Cat cat){
        cats.add(cat);
    }

    public void addCat(){
        String name, ownersName, birthday;
        Float weight;
        Scanner sc = new Scanner(System.in);
        final String WEIGHT_REGEX = "[0-9]+,*[0-9]*";
        final String DATE_REGEX = "20[0-9]{2}\\.[[(0[1-9])(1[0-2])]\\.[(0[1-9])([1-2][0-9])(3[0-1])]][0{,1}2\\.[(0[1-9])([1-2][0-9])]]";

        System.out.print("Imie kota: ");
        name = sc.nextLine();
        System.out.print("Imie wlasciciela: ");
        ownersName = sc.nextLine();
        do{
            System.out.print("Waga: ");
            weight = Float.parseFloat(sc.nextLine());
        } while (Pattern.matches(WEIGHT_REGEX, weight.toString()));
        do{
            System.out.print("Data urodzenia (yyyy.mm.dd): ");
            birthday = sc.nextLine();
        } while(Pattern.matches(DATE_REGEX,birthday));

        cats.add(new Cat.Builder(name)
                .ownersName(ownersName)
                .weight(weight)
                .birthdayDate(birthday)
                .build());
    }

    public ArrayList<Cat> getCats() {
        return cats;
    }

    public Cat getCat(int index){
        return cats.get(index);
    }


}
