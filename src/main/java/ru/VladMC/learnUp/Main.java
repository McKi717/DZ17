package ru.VladMC.learnUp;

public class Main {
    public static void main(String[] args) {

        ContactBook contactBook = new ContactBook();
        contactBook.add(new Contact("Ass", "8-33"));
        contactBook.add(new Contact("Acs", "7-32"));
        contactBook.add(new Contact("Aas", "90-34"));
        contactBook.add(new Contact("zzz", "9-33"));
        contactBook.add(new Contact("bzzs", "9-334"));

        //System.out.println(contactBook.getCountries(contactBook.sortList()));


        try {
            String a1 = args[0];
            switch (a1) {
                case "a" -> System.out.println(contactBook.getCountries(contactBook.sortList()));
                default -> System.out.println("введите a");
            }
        }
        catch (Exception e){
            System.out.println("Вы ничего не ввели");
        }


    }
}
