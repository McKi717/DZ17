package ru.VladMC.learnUp;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ContactBook {

    Map<String, Contact> contactMap = new HashMap<>();

    public void add(Contact contact) {
        contactMap.put(contact.getNumber(), contact);
    }

    public Contact getByPhone(String phone) {
        return contactMap.get(phone);
    }

    public void removeByPhone(String phone) {
        if(contactMap.get(phone)!=null){
            contactMap.remove(phone);
        }
        else{
            throw new RuntimeException("Данного номера нет");
        }
    }

    public List <Contact> sortList (){
        List <Contact> listContact = new ArrayList<>(contactMap.values());
        Collections.sort(listContact);
        return listContact;
    }


    public List <Contact> searchBy(Predicate<Contact> predicate) {
        List <Contact> listContact = new ArrayList<>();
        for (Contact task : sortList()){
            if (predicate.test(task)) {
                System.out.println(task);
            }
        }
        return listContact;
    }

    public List <Contact> searchBy (String search){
        List <Contact> listContact = new ArrayList<>();
        if(search.contains("*")){
            String searchStart = search.substring(0, search.indexOf("*"));
            String searchEnd = search.substring(search.indexOf("*")+1);
            listContact = searchBy(sear->sear.getName().startsWith(searchStart) && sear.getName().endsWith(searchEnd));
        }
        else {
            listContact = searchBy(sear->sear.getName().contains(search));
        }
        return listContact;
    }

    public Set<Integer> getCountries(List <Contact> contacts){
        Set <Integer> codeNumber = contacts.stream()
                .map (Contact::getNumber)
                .map(code->code.substring(0, code.indexOf("-")))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        return codeNumber;
    }
}
