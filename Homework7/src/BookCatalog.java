import java.util.*;

public class BookCatalog {
    public BookCatalog() {
        Map<String, Book> bookByName = new HashMap<>();
        Map<Integer, Set<Book>> booksByPageCount = new HashMap<>();

        addBookToCatalog(bookByName, booksByPageCount, new Book("Харри Поттер", 273));
        addBookToCatalog(bookByName, booksByPageCount, new Book("Ад үзэгдэх зориг", 250));
        addBookToCatalog(bookByName, booksByPageCount, new Book("Алхалт", 129));
        addBookToCatalog(bookByName, booksByPageCount, new Book("Кофе хөрөхөөс өмнө", 232));
        addBookToCatalog(bookByName, booksByPageCount, new Book("Өвгөн тэнгис хоёр", 136));
        addBookToCatalog(bookByName, booksByPageCount, new Book("Харизм ", 272));
        addBookToCatalog(bookByName, booksByPageCount, new Book("Цойлогсод", 183));
        addBookToCatalog(bookByName, booksByPageCount, new Book("Хайрлах урлаг", 158));
        addBookToCatalog(bookByName, booksByPageCount, new Book("Алхимич", 183));
        addBookToCatalog(bookByName, booksByPageCount, new Book("Цагаан Бороо", 424));
        input(bookByName, booksByPageCount);
    }
    private void addBookToCatalog(Map<String, Book> bookByName, Map<Integer, Set<Book>> booksByPageCount, Book book) {
        bookByName.put(book.getName(),book);
        booksByPageCount.computeIfAbsent(book.getPageCount(), k -> new HashSet<>()).add(book);
    }
    private static void searchByName(Map<String, Book> bookByName, String name) {
        Book book = bookByName.get(name);
        if (book != null) {
            System.out.println( name + " нэрээр олдсон ном");
            System.out.println(book);
        } else {
            System.out.println( name + " нэртэй ном олдсонгүй");
        }
    }
    private static void searchByPageCount(Map<Integer, Set<Book>> booksByPageCount, int pageCount) {
        Set<Book> books = booksByPageCount.get(pageCount);
        if (books != null) {
            System.out.println( pageCount + " хуудастай олдсон ном:");
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println( pageCount + " хуудастай ном олдсонгүй.");
        }
    }
    private void input(Map<String, Book> bookByName, Map<Integer, Set<Book>> booksByPageCount){
        System.out.println("Хайх номын нэр эсвэл хуудасны дугаарыг оруулна уу:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        if (userInput.matches("\\d+")) {
            int page = Integer.parseInt(userInput);
            searchByPageCount(booksByPageCount, page);
        } else {
            searchByName(bookByName, userInput);
        }
    }

    public static void main(String[] args){
        new BookCatalog();
    }
}
