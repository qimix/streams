import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        // поиск несовершеннолетних
       long a = persons.stream()
                .filter(w -> w.getAge() < 18)
                .count();
        System.out.println(a);

        // поиск призывников
        List<String> list = persons.stream()
                .filter(w -> w.getAge() >= 18 && w.getAge() <=27)
                .map(w -> w.getFamily())
                .collect(Collectors.toList());
        System.out.println(list);

        // отсортированный по фамилии список
        List<String> list1 = persons.stream()
                .filter(w -> w.getAge() >= 16 && w.getAge() <= 62)
                .filter(w -> w.getEducation().toString().equals("HIGHER"))
                .map(w -> w.getFamily())
                .sorted(Comparator.comparing(w -> w))
                .collect(Collectors.toList());
       System.out.println(list1);

    }
}
