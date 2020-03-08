import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalculAge {

    public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in);
        String dateNaissance;

        //récuperer la date de naissance
        System.out.println("Donner votre date de naissance (jj-mm-aaaa)");
        dateNaissance=sc.nextLine();

        //parser le string en date
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = df.parse(dateNaissance);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);

        //chercher la date du jour et comparer avec la date de naissance pour obtenir l'age
        GregorianCalendar maintenant = new GregorianCalendar();
        int age = maintenant.get(GregorianCalendar.YEAR) - cal.get(GregorianCalendar.YEAR);
        if ((cal.get(GregorianCalendar.MONTH) > maintenant.get(GregorianCalendar.MONTH))
                || (cal.get(GregorianCalendar.MONTH) == maintenant.get(GregorianCalendar.MONTH)
                && cal.get(GregorianCalendar.DAY_OF_MONTH) > maintenant.get(GregorianCalendar.DAY_OF_MONTH))) { age--;}

        //afficher l'age
        System.out.println("Age: "+age);

        sc.close();
    }
}