package guru.springframework.webapp.bootstrap;

import guru.springframework.webapp.domain.Author;
import guru.springframework.webapp.domain.Book;
import guru.springframework.webapp.domain.Publisher;
import guru.springframework.webapp.repositories.AuthorRepository;
import guru.springframework.webapp.repositories.BookRepository;
import guru.springframework.webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    @Override
    public void run(String... args) throws Exception{
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Publisher newPress = new Publisher("The New Press","900 Berkeley rd.",
                "New York City", "New York", 11101);
        //publisherRepository.save(newPress);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB","3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        //authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: "+ bookRepository.count());
        System.out.println("Publisher Count: "+ publisherRepository.count());
       // System.out.println("Publisher Count: "+ authorRepository.count());

    }
}
