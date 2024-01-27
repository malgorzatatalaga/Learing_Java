package projects.collections.maps;

import java.util.*;

public class BooksCatalog {
    private static final String EOL = "\n";
    private Map<Author, List<Book>> catalog;

    public BooksCatalog() {

    }

    public BooksCatalog(Map<Author, List<Book>> catalog) {
        this.catalog = catalog;
    }

    public List<Book> findByAuthor(Author author) {
        if (!catalog.containsKey(author)) return null;
        return catalog.get(author);
    }

    public String getAllAuthors() {
        List<Author> authors = new ArrayList<>(catalog.keySet());
        Collections.sort(authors);
        return authors.toString().
                replace("[", "").replace("]", "").
                replace(", ", "\n");
    }

    public Map<Book, List<Author>> findAuthorsByBookTitle(String pattern) {
        Map<Book, List<Author>> result = new TreeMap<>(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                int titleComparison = b1.title().compareToIgnoreCase(b2.title());
                if (titleComparison != 0) {
                    return titleComparison;
                } else {
                    return b1.cost().compareTo(b2.cost());
                }
            }
        });

        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            for (Book book : entry.getValue()) {
                if (book.title().toLowerCase().contains(pattern.toLowerCase())) {
                    // If the pattern is found in the book title, add it to the result map
                    List<Author> authors = result.get(book);
                    if (authors == null) {
                        authors = new ArrayList<>();
                        result.put(book, authors);
                    }
                    authors.add(entry.getKey());
                }
            }
        }

        for (List<Author> authors : result.values()) {
            authors.sort(Comparator.comparing(Author::firstName));
        }
        return result;
    }

    public Set<Book> findBooksByGenre(String pattern) {
        Set<Book> result = new TreeSet<>();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            for (Book book : entry.getValue()) {
                for (String genre : book.genres()) {
                    if (genre.contains(pattern)) {
                        result.add(book);
                        break;
                    }
                }
            }
        }
        return result;
    }

    public List<Author> findAuthorsByBook(Book book) {
        if (book == null) throw new NullPointerException();
        TreeSet<Author> authors = new TreeSet<>();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            for (Book b : entry.getValue()) {
                if (b.equals(book)) authors.add(entry.getKey());
            }
        }
        return List.copyOf(authors);
    }

    @Override
    public String toString() {
        TreeMap<Author, List<Book>> sortedMap = new TreeMap<>(catalog);
        int authorsNumber = sortedMap.size();
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder("{");
        for (Map.Entry<Author, List<Book>> entry : sortedMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append("=[");
            List<Book> books = entry.getValue();
            for (Book book : books) {
                stringBuilder.append(book.toString());
                if (books.indexOf(book) < (books.size() - 1)) {
                    stringBuilder.append(", ");
                }
            }
            i++;
            if (i < authorsNumber) {
                stringBuilder.append("], ");
            } else {
                stringBuilder.append("]");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

