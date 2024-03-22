package OOP.Praktikum;

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
        teknologi1.setSinopsis(
                "Even bad code can function. But if code isn't clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn't have to be that way. Noted software expert Robert C. Martin presents a revolutionary paradigm with Clean Code: A Handbook of Agile Software Craftsmanship. Martin has teamed up with his colleagues from Object Mentor to distill their best agile practice of cleaning code 'on the fly' into a book that will instill within you the values of a software craftsman and make you a better programmer--but only if you work at it.");
        teknologi2.setSinopsis(
                "What others in the trenches say about The Pragmatic Programmer... 'The cool thing about this book is that it's great for keeping the programming process fresh. The book helps you to continue to grow and clearly comes from people who have been there.' --Kent Beck, author of Extreme Programming Explained: Embrace Change 'I found this book to be a great mix of solid advice and wonderful analogies!' --Martin Fowler, author of Refactoring and UML Distilled 'I would buy a copy, read it twice, then tell all my colleagues to run out and grab a copy. This is a book I would never loan because I would worry about it being lost.' --Kevin Ruland, Management Science, MSG-Logistics 'The wisdom and practical experience of the authors is obvious. The topics presented are relevant and useful...By far its greatest strength for me has been the outstanding analogies--tracer bullets, broken windows, and the fabulous helicopter-based explanation of the need for orthogonality, especially in a crisis situation.' --John Lakos, author of Large-Scale C++ Software Design 'This is the sort of book I will buy a dozen copies of when it comes out so I can give it to my clients.' --Eric Vought, Software Engineer 'Most modern books on software development fail to cover the basics of what makes a good developer. This book does not.' --A. A. Jackson 'I would like to see this issued to every new employee at my company.' --Chris Cleeland, Senior Software Engineer 'The Pragmatic Programmer is a superb book that will become a classic. It is easy to read and easy to understand, and full of practical advice.' --David Maynard, Senior Software Engineer, The Claxton Group 'The author's voice is clear, and his advice is great. I'll buy this book for our whole development team.' --Ward Cunningham Straight from the programming trenches, The Pragmatic Programmer cuts through the increasing specialization and technicalities of modern software development to examine the core process--taking a requirement and producing working, maintainable code that delights its users. It covers topics ranging from personal responsibility and career development to architectural techniques for keeping your code flexible and easy to adapt and reuse. Read this book, and you'll learn how to Fight software rot; Avoid the trap of duplicating knowledge; Write flexible, dynamic, and adaptable code; Avoid programming by coincidence; Bullet-proof your code with contracts,");
        teknologi3.setSinopsis(
                "Capturing a wealth of experience about the design of object-oriented software, four top-notch designers present a catalog of simple and succinct solutions to commonly occurring design problems. Previously undocumented, these 23 patterns allow designers to create more flexible, elegant, and ultimately reusable designs without having to rediscover the design solutions themselves. The authors begin by describing what patterns are and how they can help you design object-oriented software. They then go on to systematically name, explain, evaluate, and catalog recurring designs in object-oriented systems. With Design Patterns as your guide, you will learn how these important patterns fit into the software development process, and how you can leverage them to solve your own design problems most efficiently.");
        teknologi4.setSinopsis(
                "As the application of object technology--particularly the Java programming language--has become commonplace, a new problem has emerged to confront the software development community. Significant numbers of poorly designed programs have been created by less-experienced developers, resulting in applications that are inefficient and hard to maintain and extend. Increasingly, software system professionals are discovering just how difficult it is to work with these inherited, non-optimal applications. For several years, expert-level object programmers have employed a growing collection of techniques to improve the structural integrity and performance of such existing software programs. Referred to as 'refactoring,' these practices have remained in the domain of experts because no attempt has been made to transcribe the lore into a form that all developers could use. . .until now. In Refactoring: Improving the Design of Existing Code, renowned object technology mentor Martin Fowler breaks new ground, demystifying these master practices and demonstrating how software practitioners can realize the significant benefits of this new process.");
        teknologi5.setSinopsis(
                "In this second edition of Extreme Programming Explained, Kent Beck organizes and presents five years' worth of experiences, growth, and change revolving around XP. If you are seriously interested in understanding how you and your team can start down the path of improvement with XP, this book is the place to start.");
        // List<Buku> teknologi = Arrays.asList(teknologi1, teknologi2, teknologi3,
        // teknologi4, teknologi5);
        // System.out.println("Teknologi:");
        // System.out.println(divider2);
        // System.out.println(divider2);
        // for (Buku buku : teknologi) {
        // buku.show();
        // System.out.println(divider);
        // }

        // Filsafat
        Buku filsafat1 = new Buku("Meditations", "Marcus Aurelius");
        Buku filsafat2 = new Buku("The Republic", "Plato");
        Buku filsafat3 = new Buku("Beyond Good and Evil", "Friedrich Nietzsche");
        Buku filsafat4 = new Buku("The Myth of Sisyphus", "Albert Camus");
        Buku filsafat5 = new Buku("The Stranger", "Albert Camus");
        filsafat1.setSinopsis(
                "Few ancient works have been as influential as the Meditations of Marcus Aurelius, philosopher and emperor of Rome (A.D. 161–180). A series of spiritual exercises filled with wisdom, practical guidance, and profound understanding of human behavior, it remains one of the greatest works of spiritual and ethical reflection ever written. Marcus’s insights and advice—on everything from living in the world to coping with adversity and interacting with others—have made the Meditations required reading for statesmen and philosophers alike, while generations of ordinary readers have responded to the straightforward intimacy of his style. In Gregory Hays’s new translation—the first in a generation—Marcus’s thoughts speak with a new immediacy: never before have they been so directly and powerfully presented.");
        filsafat2.setSinopsis(
                "The Republic is a Socratic dialogue, written by Plato around 380 BC, concerning justice, the order and character of the just city-state");
        filsafat3.setSinopsis(
                "Beyond Good and Evil: Prelude to a Philosophy of the Future is a book by philosopher Friedrich Nietzsche that expands the ideas of his previous work, Thus Spoke Zarathustra, with a more critical and polemical approach. It was first published in 1886.");
        filsafat4.setSinopsis(
                "The Myth of Sisyphus is a philosophical essay by Albert Camus. The English translation by Justin O'Brien was first published in 1955. Influenced by philosophers such as Søren Kierkegaard, Arthur Schopenhauer, and Friedrich Nietzsche, Camus introduces his philosophy of the absurd, that life is inherently devoid of meaning and consequently absurd, but humans will nevertheless forever search for meaning.");
        filsafat5.setSinopsis(
                "The Stranger is a novel by Albert Camus published in 1942. Its theme and outlook are often cited as examples of Camus's philosophy, absurdism coupled with that of existentialism, though Camus personally rejected the latter label. The title character is Meursault, an indifferent French Algerian described as 'a citizen of France domiciled in North Africa");

        // List<Buku> filsafat = Arrays.asList(filsafat1, filsafat2, filsafat3,
        // filsafat4, filsafat5);
        // System.out.println("Filsafat:");
        // System.out.println(divider2);
        // System.out.println(divider2);
        // for (Buku buku : filsafat) {
        // buku.show();
        // System.out.println(divider);
        // }

        // Sejarah
        Buku sejarah1 = new Buku("A People's History of the United States", "Howard Zinn");
        Buku sejarah2 = new Buku("The Rise and Fall of the Third Reich", "William L. Shirer");
        Buku sejarah3 = new Buku("The Guns of August", "Barbara W. Tuchman");
        Buku sejarah4 = new Buku("The Histories", "Herodotus");
        Buku sejarah5 = new Buku("The Peloponnesian War", "Thucydides");
        sejarah1.setSinopsis(
                "A People's History of the United States is a 1980 non-fiction book by American historian and political scientist Howard Zinn. In the book, Zinn presented what he considered to be a different side of history from the more traditional 'fundamental nationalist glorification of country'. Zinn portrays a side of American history that can largely be seen as the exploitation and manipulation of the majority by rigged systems that hugely favor a small aggregate of elite rulers from across the orthodox political parties.");
        sejarah2.setSinopsis("The Rise and Fall of the Third Reich. Yeah, that's all");
        sejarah3.setSinopsis(
                "The Guns of August (1962), also published as August 1914, is a volume of history by Barbara W. Tuchman. It is centered on the first month of World War I. After introductory chapters, Tuchman describes in great detail the opening events of the conflict. Its focus then becomes the military history of the contestants, chiefly the great powers.");
        sejarah4.setSinopsis(
                "The Histories is a history of ancient Greece written by Herodotus in the fifth century BC. It is a chronicle of the wars between the Greeks and the Persians, and it is best known for its narrative of the Persian invasion of Greece in the early fifth century BC and for its account of the Battle of Thermopylae in 480 BC.");
        sejarah5.setSinopsis(
                "The History of the Peloponnesian War is a historical account of the Peloponnesian War (431–404 BC), which was fought between the Peloponnesian League (led by Sparta) and the Delian League (led by Athens). It was written by Thucydides, an Athenian historian who also happened to serve as an Athenian general during the war. His account of the conflict is widely considered to be a classic and regarded as one of the earliest scholarly works of history.");
        // List<Buku> sejarah = Arrays.asList(sejarah1, sejarah2, sejarah3, sejarah4,
        // sejarah5);
        // System.out.println("Sejarah:");
        // System.out.println(divider2);
        // System.out.println(divider2);
        // for (Buku buku : sejarah) {
        // buku.show();
        // System.out.println(divider);
        // }

        // Agama
        Buku agama1 = new Buku("The Bible", "God");
        Buku agama2 = new Buku("The Quran", "Allah");
        Buku agama3 = new Buku("The Bhagavad Gita", "Krishna");
        Buku agama4 = new Buku("The Torah", "God");
        Buku agama5 = new Buku("The Book of Mormon", "God");
        agama1.setSinopsis("The Bible is a collection of religious texts or scriptures sacred to Christians");
        agama2.setSinopsis(
                "The Quran is the central religious text of Islam, believed by Muslims to be a revelation from God");
        agama3.setSinopsis(
                "The Bhagavad Gita, often referred to as the Gita, is a 700-verse Hindu scripture that is part of the Indian epic Mahabharata");
        agama4.setSinopsis("The Torah is the central reference of the religious Judaic tradition");
        agama5.setSinopsis(
                "The Book of Mormon is a sacred text of the Latter Day Saint movement, which, according to Latter Day Saint theology, contains writings of ancient prophets who lived on the American continent from approximately 2200 BC to AD 421");
        // List<Buku> agama = Arrays.asList(agama1, agama2, agama3, agama4, agama5);
        // System.out.println("Agama:");
        // System.out.println(divider2);
        // System.out.println(divider2);
        // for (Buku buku : agama) {
        // buku.show();
        // System.out.println(divider);
        // }

        // Psikologi
        Buku psikologi1 = new Buku("Thinking, Fast and Slow", "Daniel Kahneman");
        Buku psikologi2 = new Buku("Nathan Gtu Loh", "Nathan Sudiara");
        Buku psikologi3 = new Buku("Influence: The Psychology of Persuasion", "Robert Cialdini");
        Buku psikologi4 = new Buku("Man's Search for Meaning", "Viktor E. Frankl");
        Buku psikologi5 = new Buku("The Power of Now", "Eckhart Tolle");
        psikologi1.setSinopsis(
                "In the international bestseller, Thinking, Fast and Slow, Daniel Kahneman, the renowned psychologist and winner of the Nobel Prize in Economics, takes us on a groundbreaking tour of the mind and explains the two systems that drive the way we think. System 1 is fast, intuitive, and emotional; System 2 is slower, more deliberative, and more logical. The impact of overconfidence on corporate strategies, the difficulties of predicting what will make us happy in the future, the profound effect of cognitive biases on everything from playing the stock market to planning our next vacation—each of these can be understood only by knowing how the two systems shape our judgments and decisions.");
        psikologi2.setSinopsis("Nathan Gtu Loh adalah seorang penulis yang sangat terkenal di Indonesia.");
        psikologi3.setSinopsis(
                "Influence, the classic book on persuasion, explains the psychology of why people say 'yes'—and how to apply these understandings. Dr. Robert Cialdini is the seminal expert in the rapidly expanding field of influence and persuasion. His thirty-five years of rigorous, evidence-based research along with a three-year program of study on what moves people to change behavior has resulted in this highly acclaimed book.");
        psikologi4.setSinopsis(
                "Psychiatrist Viktor Frankl's memoir has riveted generations of readers with its descriptions of life");
        psikologi5.setSinopsis(
                "Eckhart Tolle's message is simple: living in the now is the truest path to happiness and enlightenment. And while this message may not seem stunningly original or fresh, Tolle's clear writing, supportive voice, and enthusiasm make this an excellent manual for anyone who's ever wondered what exactly 'living in the now' means. Foremost, Tolle is a world-class teacher, able to explain complicated concepts in concrete language. More importantly, within a chapter of reading this book, readers are already holding the world in a different container--more conscious of how thoughts and emotions get in the way of their ability to live in genuine peace and happiness.");
        // List<Buku> psikologi = Arrays.asList(psikologi1, psikologi2, psikologi3,
        // psikologi4, psikologi5);
        // System.out.println("Psikologi:");
        // System.out.println(divider2);
        // System.out.println(divider2);
        // for (Buku buku : psikologi) {
        // buku.show();
        // System.out.println(divider);
        // }

        // Politik
        Buku politik1 = new Buku("The Prince", "Niccolò Machiavelli");
        Buku politik2 = new Buku("The Communist Manifesto", "Karl Marx, Friedrich Engels");
        Buku politik3 = new Buku("The Federalist Papers", "Alexander Hamilton, James Madison, John Jay");
        Buku politik4 = new Buku("Das Kapital", "Karl Marx");
        Buku politik5 = new Buku("The Road to Serfdom", "Friedrich Hayek");
        politik1.setSinopsis(
                "The Prince is a 16th-century political treatise by the Italian diplomat and political theorist Niccolò Machiavelli. From correspondence a version appears to have been distributed in 1513, using a Latin title, De Principatibus (Of Principalities). However, the printed version was not published until 1532, five years after Machiavelli's death. This was done with the permission of the Medici pope Clement VII, but 'long before then, in fact since the first appearance of the Prince in manuscript, controversy had swirled about his writings.' Although it was written as if it were a traditional work in the mirrors for princes style, it is generally agreed that it was especially innovative. This is only partly because it was written in the vernacular Italian rather than Latin, a practice that had become increasingly popular since the publication of Dante's Divine Comedy and other works of Renaissance literature.");
        politik2.setSinopsis(
                "The Communist Manifesto is a political pamphlet written by German philosophers Karl Marx and Friedrich Engels. Commissioned by the Communist League and originally published in London in 1848, the Manifesto is considered one of the most influential political texts in history. It presents an analytical approach to class struggle and the problems of capitalism, advocating for the overthrow of the bourgeoisie and the establishment of a communist society.");
        politik3.setSinopsis(
                "The Federalist Papers is a collection of 85 articles and essays written by Alexander Hamilton, James Madison, and John Jay under the collective pseudonym 'Publius' to promote the ratification of the United States Constitution. The collection was commonly known as The Federalist until the name The Federalist Papers emerged in the 20th century.");
        politik4.setSinopsis(
                "Das Kapital, also known as Capital. A Critique of Political Economy (German: Das Kapital. Kritik der politischen Ökonomie), is a foundational theoretical text in materialist philosophy, economics and politics by Karl Marx. Marx aimed to reveal the economic patterns underpinning the capitalist mode of production in contrast to classical political economists such as Adam Smith, Jean-Baptiste Say, David Ricardo and John Stuart Mill. While Marx did not live to publish the planned second and third parts, they were both completed from his notes and published after his death by his colleague Friedrich Engels. Das Kapital is the most cited book in the social sciences published before 1950.");
        politik5.setSinopsis(
                "The Road to Serfdom is a book written between 1940 and 1943 by Austrian British economist and philosopher Friedrich Hayek. Since its publication in 1944, The Road to Serfdom has been an influential and popular exposition of market libertarianism. It has been translated into more than 20 languages and sold over two million copies (as of 2010). The book was first published in Britain by Routledge in March 1944, during World War II, and was quite popular in the United States, leading Henry Hazlitt to write in The New York Times Book Review that it was 'one of the most important books of our generation'.");
        // List<Buku> politik = Arrays.asList(politik1, politik2, politik3, politik4,
        // politik5);
        // System.out.println("Politik:");
        // System.out.println(divider2);
        // System.out.println(divider2);
        // for (Buku buku : politik) {
        // buku.show();
        // System.out.println(divider);
        // }

        // Fiksi
        Buku fiksi1 = new Buku("To Kill a Mockingbird", "Harper Lee");
        Buku fiksi2 = new Buku("1984", "George Orwell");
        Buku fiksi3 = new Buku("Pride and Prejudice", "Jane Austen");
        Buku fiksi4 = new Buku("The Great Gatsby", "F. Scott Fitzgerald");
        Buku fiksi5 = new Buku("The Catcher in the Rye", "J.D. Salinger");
        fiksi1.setSinopsis(
                "To Kill a Mockingbird is a novel by Harper Lee published in 1960. Instantly successful, widely read in high schools and middle schools in the United States, it has become a classic of modern American literature, winning the Pulitzer Prize. The plot and characters are loosely based on Lee's observations of her family, her neighbors and an event that occurred near her hometown of Monroeville, Alabama, in 1936, when she was 10 years old.");
        fiksi2.setSinopsis(
                "1984 is a dystopian social science fiction novel by English novelist George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime. Thematically, Nineteen Eighty-Four centres on the consequences of totalitarianism, mass surveillance, and repressive regimentation of persons and behaviours within society.");
        fiksi3.setSinopsis(
                "Pride and Prejudice is a romantic novel of manners written by Jane Austen in 1813. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness. Its humour lies in its honest depiction of manners, education, marriage, and money during the Regency era in Great Britain.");
        fiksi4.setSinopsis(
                "The Great Gatsby is a novel by American writer F. Scott Fitzgerald. Set in the Jazz Age on Long Island, near New York City, the novel depicts first-person narrator Nick Carraway's interactions with mysterious millionaire Jay Gatsby and Gatsby's obsession to reunite with his former lover, Daisy Buchanan. The novel was inspired by a youthful romance Fitzgerald had with a socialite, and by parties he attended on Long Island's North Shore in 1922.");
        fiksi5.setSinopsis(
                "The Catcher in the Rye is a novel by J.D. Salinger, first published in 1951. It is a story of Holden Caulfield, a teenager from New York City, who is expelled from his school and embarks on a journey of self-discovery. The novel explores themes of teenage angst, alienation, and the loss of innocence. It has become a classic of American literature and has had a significant influence on modern literature and popular culture.");
        // List<Buku> fiksi = Arrays.asList(fiksi1, fiksi2, fiksi3, fiksi4, fiksi5);
        // System.out.println("Fiksi:");
        // System.out.println(divider2);
        // System.out.println(divider2);
        // for (Buku buku : fiksi) {
        // buku.show();
        // System.out.println(divider);
        // }

        System.out.println("Fiksi 1 vs Agama 4");
        System.out.println(fiksi1.similarity(agama4));
        System.out.println();

        System.out.println("teknologi2.show() : ");
        teknologi2.show();
        System.out.println();

        System.out.println("Jumlah kata dalam sinopsis teknologi2 : " + teknologi2.countWords());
        Buku bukuCopy = politik3.copy();
        System.out.println();

        System.out.println("bukuCopy.show() : ");
        bukuCopy.show();

    }
}

class Buku {
    private String penulis, judul, sinopsis;

    Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    Buku(String judul, String penulis, String sinopsis) {
        this.judul = judul;
        this.penulis = penulis;
        this.sinopsis = sinopsis;
    }

    public void show() {
        System.out.println("Judul\t: " + judul);
        System.out.println("Penulis\t: " + penulis);
        System.out.println("Sinopsis:\n" + sinopsis);
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int countWords() {
        return sinopsis.split(" ").length;
    }

    public String similarity(Buku buku) {

        // Similarity "sinopsis" logic
        String[] sinopsis1 = sinopsis.split(" ");
        String[] sinopsis2 = buku.sinopsis.split(" ");
        double countS = 0;
        for (String word1 : sinopsis1) {
            for (String word2 : sinopsis2) {
                if (word1.equals(word2)) {
                    countS++;
                }
            }
        }
        double sinopsisSimilarity = countS / 100;

        // Similarity "judul" logic
        String[] judul1 = judul.split(" ");
        String[] judul2 = buku.judul.split(" ");
        double countJ = 0;
        for (String word1 : judul1) {
            for (String word2 : judul2) {
                if (word1.equals(word2)) {
                    countJ++;
                }
            }
        }
        double judulSimilarity = countJ / 100;

        // Similarity "penulis" logic
        String[] penulis1 = penulis.split(" ");
        String[] penulis2 = buku.penulis.split(" ");
        double countP = 0;
        for (String word1 : penulis1) {
            for (String word2 : penulis2) {
                if (word1.equals(word2)) {
                    countP++;
                }
            }
        }
        double penulisSimilarity = countP / 100;
        double similarity = (sinopsisSimilarity + judulSimilarity + penulisSimilarity) / 3;

        return "Similarity: " + similarity + " %";
    }

    public Buku copy() {
        Buku copyBuku = new Buku(judul, penulis, sinopsis);
        return copyBuku;
    }

}