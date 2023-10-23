package PhoneBookProject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {


        Set<HashMap.Entry<String, ArrayList<Integer>>> hm = phoneBook.entrySet();
        String str = null;
        boolean newStr = true;
        ArrayList<Integer> al = new ArrayList<Integer>();

        for (HashMap.Entry<String, ArrayList<Integer>> o : hm) {
            str = o.getKey();
            if (o.getKey().toLowerCase().equals(name.toLowerCase())) {
                newStr = false;
                al = o.getValue();
                o.getValue().add(phoneNum);
            }
        }
        if (newStr) {
            ArrayList<Integer> phone = new ArrayList<Integer>();
            phone.add(phoneNum);
            phoneBook.put(name, phone);
        }

    }

    public ArrayList<Integer> find(String name) {
// Введите свое решение ниже
        ArrayList<Integer> result = new ArrayList<>();
        Set<HashMap.Entry<String, ArrayList<Integer>>> hm = phoneBook.entrySet();
        String str = null;
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (HashMap.Entry<String, ArrayList<Integer>> o : hm) {
            str = o.getKey();

            if (o.getKey().toLowerCase().equals(name.toLowerCase())) {
                al = o.getValue();
                for (Integer num : al) {
                    result.add(num);
                }
            }

        }
        return result;

    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
// Введите свое решение ниже
        return phoneBook;
    }
}
public class PhoneBookProject {
    public static void main(String[] args) {
        String name1;
        String name2;
        int phone1;
        int phone2;

        if (args.length == 0) {
            name1 = "Ivanov";
            name2 = "Petrov";
            phone1 = 123456;
            phone2 = 654321;
        } else {
            name1 = args[0];
            name2 = args[1];
            phone1 = Integer.parseInt(args[2]);
            phone2 = Integer.parseInt(args[3]);
        }

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);

        System.out.println(myPhoneBook.find(name2));
        System.out.println(PhoneBook.getPhoneBook());
        System.out.println(myPhoneBook.find("Me"));
    }
}
