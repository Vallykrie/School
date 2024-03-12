import java.util.*;

public class Main {
    public static void main(String[] args) {
        String divider = "-------------------------------------------------------------------";
        String divider2 = "===================================================================";
        // Teknologi
        Buku teknologi1 = new Buku("Clean Code", "Robert C. Martin");
        Buku teknologi2 = new Buku("The Pragmatic Programmer", "Andrew Hunt, David Thomas");
        Buku teknologi3 = new Buku("Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides");
        Buku teknologi4 = new Buku("Refactoring", "Martin Fowler");
        Buku teknologi5 = new Buku("Extreme Programming Explained", "Kent Beck");
        List<Buku> teknologi = Arrays.asList(teknologi1, teknologi2, teknologi3, teknologi4, teknologi5);
        System.out.println(divider2);
        System.out.println("Teknologi:");
        System.out.println(divider2);
        for (Buku buku : teknologi) {
            buku.show();
            System.out.println(divider);
        }

        // Filsafat
        Buku filsafat1 = new Buku("Meditations", "Marcus Aurelius");
        Buku filsafat2 = new Buku("The Republic", "Plato");
        Buku filsafat3 = new Buku("Beyond Good and Evil", "Friedrich Nietzsche");
        Buku filsafat4 = new Buku("The Myth of Sisyphus", "Albert Camus");
        Buku filsafat5 = new Buku("The Stranger", "Albert Camus");
        List<Buku> filsafat = Arrays.asList(filsafat1, filsafat2, filsafat3, filsafat4, filsafat5);
        System.out.println(divider2);
        System.out.println("Filsafat:");
        System.out.println(divider2);
        for (Buku buku : filsafat) {
            buku.show();
            System.out.println(divider);
        }

        // Sejarah
        Buku sejarah1 = new Buku("A People's History of the United States", "Howard Zinn");
        Buku sejarah2 = new Buku("The Rise and Fall of the Third Reich", "William L. Shirer");
        Buku sejarah3 = new Buku("The Guns of August", "Barbara W. Tuchman");
        Buku sejarah4 = new Buku("The Histories", "Herodotus");
        Buku sejarah5 = new Buku("The Peloponnesian War", "Thucydides");
        List<Buku> sejarah = Arrays.asList(sejarah1, sejarah2, sejarah3, sejarah4, sejarah5);
        System.out.println(divider2);
        System.out.println("Sejarah:");
        System.out.println(divider2);
        for (Buku buku : sejarah) {
            buku.show();
            System.out.println(divider);
        }

        // Agama
        Buku agama1 = new Buku("The Bible", "God");
        Buku agama2 = new Buku("The Quran", "Allah");
        Buku agama3 = new Buku("The Bhagavad Gita", "Krishna");
        Buku agama4 = new Buku("The Torah", "God");
        Buku agama5 = new Buku("The Book of Mormon", "God");
        List<Buku> agama = Arrays.asList(agama1, agama2, agama3, agama4, agama5);
        System.out.println(divider2);
        System.out.println("Agama:");
        System.out.println(divider2);
        for (Buku buku : agama) {
            buku.show();
            System.out.println(divider);
        }

        // Psikologi
        Buku psikologi1 = new Buku("Thinking, Fast and Slow", "Daniel Kahneman");
        Buku psikologi2 = new Buku("Nathan Gtu Loh", "Nathan Sudiara");
        Buku psikologi3 = new Buku("Influence: The Psychology of Persuasion", "Robert Cialdini");
        Buku psikologi4 = new Buku("Man's Search for Meaning", "Viktor E. Frankl");
        Buku psikologi5 = new Buku("The Power of Now", "Eckhart Tolle");
        List<Buku> psikologi = Arrays.asList(psikologi1, psikologi2, psikologi3, psikologi4, psikologi5);
        System.out.println(divider2);
        System.out.println("Psikologi:");
        System.out.println(divider2);
        for (Buku buku : psikologi) {
            buku.show();
            System.out.println(divider);
        }
        // Politik
        Buku politik1 = new Buku("The Prince", "Niccolò Machiavelli");
        Buku politik2 = new Buku("The Communist Manifesto", "Karl Marx, Friedrich Engels");
        Buku politik3 = new Buku("The Federalist Papers", "Alexander Hamilton, James Madison, John Jay");
        Buku politik4 = new Buku("Das Kapital", "Karl Marx");
        Buku politik5 = new Buku("The Road to Serfdom", "Friedrich Hayek");
        List<Buku> politik = Arrays.asList(politik1, politik2, politik3, politik4, politik5);
        System.out.println(divider2);
        System.out.println("Politik:");
        System.out.println(divider2);
        for (Buku buku : politik) {
            buku.show();
            System.out.println(divider);
        }

        // Fiksi
        Buku fiksi1 = new Buku("To Kill a Mockingbird", "Harper Lee");
        Buku fiksi2 = new Buku("1984", "George Orwell");
        Buku fiksi3 = new Buku("Pride and Prejudice", "Jane Austen");
        Buku fiksi4 = new Buku("The Great Gatsby", "F. Scott Fitzgerald");
        Buku fiksi5 = new Buku("The Catcher in the Rye", "J.D. Salinger");
        List<Buku> fiksi = Arrays.asList(fiksi1, fiksi2, fiksi3, fiksi4, fiksi5);
        System.out.println(divider2);
        System.out.println("Fiksi:");
        System.out.println(divider2);
        for (Buku buku : fiksi) {
            buku.show();
            System.out.println(divider);
        }

    }
}

class Buku {
    private String penulis, judul;

    Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    public void show() {
        System.out.println("Judul\t: " + judul);
        System.out.println("Penulis\t: " + penulis);
    }
    
}