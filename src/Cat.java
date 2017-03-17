import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bartosz Hanc on 2017-03-17.
 */
public class Cat {
    private String name;
    private String ownersName;
    private Float weight;
    private Date birthdayDate;


    private Cat(final Builder builder){
        this.name = builder.name;
        this.ownersName = builder.ownersName;
        this.weight = builder.weight;
        this.birthdayDate = builder.birthdayDate;
    }

    public static class Builder{
        private final String name;
        private String ownersName;
        private Float weight;
        private SimpleDateFormat simpleDateBirthday = new SimpleDateFormat("yyyy.MM.dd");
        private Date birthdayDate;

        public Builder(final String name){
            this.name = name;
        }

        public Builder ownersName(final String ownersName){
            this.ownersName = ownersName;
            return this;
        }

        public Builder weight(final Float weight){
            this.weight = weight;
            return this;
        }

        public Builder birthdayDate(String birthdayDate){
            try {
                this.birthdayDate = simpleDateBirthday.parse(birthdayDate);
            } catch (ParseException e) {
                System.out.println("Niepoprawny format daty");
            }
            return this;
        }

        public Cat build(){
            return new Cat(this);
        }

        @Override
        public String toString(){
            return name + " " + ownersName + " " + weight + " " + birthdayDate;
        }
    }
}
