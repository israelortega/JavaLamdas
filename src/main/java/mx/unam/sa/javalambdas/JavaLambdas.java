/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.javalambdas;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author israel1971
 */
public class JavaLambdas {

    public static void main(String[] args) {
        System.out.println("Ejemplos Lambdas");

        System.out.println("Operaciones con enteros");
        List<Integer> filteredValues = IntStream.range(0, 10).boxed()
                .filter(i -> i < 7)
                .map(i -> i * 3)
                .filter(i -> i % 2 == 0)
                .toList();

        System.out.println(filteredValues);

        List<Student> students = List.of(
                new Student("john", 18),
                new Student("doe", 16),
                new Student("jane", 19),
                new Student("jonnah", 20),
                new Student("joanne", 17),
                new Student("joey", 17)
        );

        System.out.println("Filtros");
        List<String> names = students.stream()
                .limit(4l)
                .skip(1l)
                .filter(s -> s.getAge() >= 18)
                .map(s -> s.getName().toUpperCase())
                .toList();
        System.out.println(names);

        System.out.println("List separado por comas");
        String edades = students.stream()
                .map(student -> String.valueOf(student.getAge()))
                .collect(Collectors.joining(","));
        System.out.println(edades);

        System.out.println("Verificar si un List contiene un elemento");
        boolean p481 = students.stream()
                .anyMatch(student -> student.getAge() == 17);
        System.out.println(p481);

        System.out.println("Traer el primer elemento que coincida de un List");
        Optional<Student> student1 = students.stream()
                .filter(student -> student.getName().equals("jane") )
                .findAny();
        
        System.out.println(student1.get());

    }

}
