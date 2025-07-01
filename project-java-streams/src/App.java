import java.util.*;
import java.util.stream.*;

public class App {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("El Quijote", "Miguel de Cervantes", 39.99),
            new Book("Cien años de soledad", "Gabriel García Márquez", 45.50),
            new Book("Clean Code", "Robert C. Martin", 55.00),
            new Book("Effective Java", "Joshua Bloch", 70.00),
            new Book("The Pragmatic Programmer", "Andy Hunt", 65.00),
            new Book("Java: The Complete Reference", "Herbert Schildt", 60.00),
            new Book("Design Patterns", "Erich Gamma", 72.00),
            new Book("Refactoring", "Martin Fowler", 68.00),
            new Book("Donde viven los monstruos", "Maurice Sendak", 28.00),
            new Book("Rayuela", "Julio Cortázar", 40.00),
            new Book("1984", "George Orwell", 42.00),
            new Book("Fahrenheit 451", "Ray Bradbury", 38.00),
            new Book("Brave New World", "Aldous Huxley", 43.00),
            new Book("La sombra del viento", "Carlos Ruiz Zafón", 47.00),
            new Book("La ladrona de libros", "Markus Zusak", 34.00),
            new Book("El código Da Vinci", "Dan Brown", 49.00),
            new Book("Inferno", "Dan Brown", 52.00),
            new Book("Angels & Demons", "Dan Brown", 50.00),
            new Book("Harry Potter y la piedra filosofal", "J.K. Rowling", 41.00),
            new Book("Harry Potter y el prisionero de Azkaban", "J.K. Rowling", 43.50),
            new Book("The Hobbit", "J.R.R. Tolkien", 45.00),
            new Book("The Lord of the Rings", "J.R.R. Tolkien", 80.00),
            new Book("Dune", "Frank Herbert", 69.00),
            new Book("Crónica de una muerte anunciada", "Gabriel García Márquez", 37.00),
            new Book("El amor en los tiempos del cólera", "Gabriel García Márquez", 44.00),
            new Book("Yo, robot", "Isaac Asimov", 55.00),
            new Book("Fundación", "Isaac Asimov", 60.00),
            new Book("Steve Jobs", "Walter Isaacson", 49.90),
            new Book("Sapiens", "Yuval Noah Harari", 61.00),
            new Book("Homo Deus", "Yuval Noah Harari", 63.00),
            new Book("Thinking, Fast and Slow", "Daniel Kahneman", 59.00),
            new Book("Atomic Habits", "James Clear", 50.00),
            new Book("Hábitos atómicos", "James Clear", 49.50),
            new Book("The Clean Coder", "Robert C. Martin", 53.00),
            new Book("Code Complete", "Steve McConnell", 74.00),
            new Book("Soft Skills", "John Sonmez", 65.00),
            new Book("The Mythical Man-Month", "Fred Brooks", 58.00),
            new Book("Head First Java", "Kathy Sierra", 62.00),
            new Book("Java Concurrency in Practice", "Brian Goetz", 75.00)
        );

        // 1. Mostrar todos los libros
        System.out.println("📚 Todos los libros:");
        books.stream().forEach(System.out::println);

        // 2. Filtrar libros con precio mayor a $50
        System.out.println("\n💰 Libros con precio > $50:");
        books.stream()
             .filter(book -> book.getPrice() > 50)
             .forEach(System.out::println);

        // 3. Títulos en mayúsculas
        System.out.println("\n🔠 Títulos en mayúsculas:");
        books.stream()
             .map(book -> book.getTitle().toUpperCase())
             .forEach(System.out::println);

        // 4. Libros baratos (< $50)
        System.out.println("\n🪙 Libros baratos (< $50):");
        List<Book> cheapBooks = books.stream()
            .filter(book -> book.getPrice() < 50)
            .collect(Collectors.toList());
        cheapBooks.forEach(System.out::println);

        // 5. Precio total
        System.out.println("\n🔢 Precio total de todos los libros:");
        double totalPrice = books.stream()
            .map(Book::getPrice)
            .reduce(0.0, Double::sum);
        System.out.println("Total: $" + totalPrice);

        // 6. ¿Hay algún libro de Robert C. Martin?
        System.out.println("\n📖 ¿Hay algún libro de Robert C. Martin?");
        boolean hasMartin = books.stream()
            .anyMatch(book -> book.getAuthor().equals("Robert C. Martin"));
        System.out.println("Resultado: " + hasMartin);

        // 7. Títulos únicos (eliminar duplicados)
        System.out.println("\n📌 Títulos únicos:");
        List<String> titles = books.stream()
            .map(Book::getTitle)
            .distinct()
            .collect(Collectors.toList());
        titles.forEach(System.out::println);

        // 8. Limit y skip
        System.out.println("\n⏳ Primeros 2 libros:");
        books.stream()
             .limit(2)
             .forEach(System.out::println);

        System.out.println("\n⏭️ Libros omitidos (primeros 2 saltados):");
        books.stream()
             .skip(2)
             .forEach(System.out::println);

        // 9. Ordenar por precio
        System.out.println("\n📈 Libros ordenados por precio (ascendente):");
        books.stream()
             .sorted(Comparator.comparing(Book::getPrice))
             .forEach(System.out::println);

        // 10. Recomendaciones (precio < 60, ordenado desc)
        System.out.println("\n🎯 Recomendaciones (< $60, orden desc):");
        List<String> recomendaciones = books.stream()
            .filter(book -> book.getPrice() < 60)
            .sorted(Comparator.comparing(Book::getPrice).reversed())
            .map(Book::getTitle)
            .collect(Collectors.toList());
        recomendaciones.forEach(System.out::println);
    }
}
