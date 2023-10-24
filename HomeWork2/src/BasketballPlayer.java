public class BasketballPlayer {
    String lastName;
    String firstName;
    String gender;
    String nationality;
    double weight;
    String birthdate;
    String teamName;
    int playerNumber;
    int totalPoints;
    int totalGamesPlayed;

    public BasketballPlayer(String lastName, String firstName, String gender, String nationality, double weight, String birthdate, String teamName, int playerNumber, int totalPoints, int totalGamesPlayed) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.nationality = nationality;
        this.weight = weight;
        this.birthdate = birthdate;
        this.teamName = teamName;
        this.playerNumber = playerNumber;
        this.totalPoints = totalPoints;
        this.totalGamesPlayed = totalGamesPlayed;
    }

    public static BasketballPlayer[] initialPlayers() {
        BasketballPlayer[] players = new BasketballPlayer[10];
        players[0] = new BasketballPlayer("Бат", "Ганбаатар", "Эр", "Монгол", 80.5, "2000-01-01", "Ирвэсүүд", 23, 90, 20);
        players[1] = new BasketballPlayer("Ган", "Ганцэцэг", "Эм", "Монгол", 65.2, "1998-03-15", "Хилчин", 7, 150, 15);
        players[2] = new BasketballPlayer("Наран", "Дорж", "Эр", "Монгол", 78.0, "1999-05-20", "Ирвэсүүд", 11, 165, 12);
        players[3] = new BasketballPlayer("Энхээ", "Болор", "Эм", "Монгол", 68.7, "1997-11-10", "Хилчин", 15, 100, 18);
        players[4] = new BasketballPlayer("Баттулга", "Баяр", "Эр", "Монгол", 81.2, "2002-02-28", "Ирвэсүүд", 8, 93, 15);
        players[5] = new BasketballPlayer("Оргил", "Номин", "Эм", "Монгол", 72.4, "1996-09-08", "Хилчин", 3, 155, 24);
        players[6] = new BasketballPlayer("Борхүү", "Сүхбаатар", "Эр", "Монгол", 79.8, "2003-07-12", "Ирвэсүүд", 30, 149, 14);
        players[7] = new BasketballPlayer("Булганхүү", "Сарангуа", "Эм", "Монгол", 66.1, "1995-04-30", "Хилчин", 22, 152, 18);
        players[8] = new BasketballPlayer("Ганбат", "Дөлгөөн", "Эр", "Монгол", 79.8, "2003-07-12", "Ирвэсүүд", 9, 99, 11);
        players[9] = new BasketballPlayer("Үйлс", "Саран", "Эм", "Монгол", 66.1, "1995-04-30", "Хилчин", 20, 160, 19);
        return players;
    }
    public void displayInfo() {
        System.out.println("Овог: " + lastName);
        System.out.println("Нэр: " + firstName);
        System.out.println("Хүйс: " + gender);
        System.out.println("Яс үндэс: " + nationality);
        System.out.println("Биеийн жин: " + weight);
        System.out.println("Төрсөн огноо: " + birthdate);
        System.out.println("Багийн нэр: " + teamName);
        System.out.println("Тоглогчийн дугаар: " + playerNumber);
        System.out.println("Нийт авсан оноо: " + totalPoints);
        System.out.println("Нийт хийсэн тоглолтын тоо: " + totalGamesPlayed);
    }
    public static void  findTotalPoint150Above(BasketballPlayer[] players) {
        System.out.println("150 aac дээш оноотой тоглогчдын мэдээлэл:");
        for (BasketballPlayer player : players) {
            if (player.totalPoints > 150) {
                player.displayInfo();
                System.out.println();
            }
        }
    }
    public int calculateAge() {
        String[] parts = birthdate.split("-");
        if (parts.length == 3) {
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            return year * 10000 + month * 100 + day;
        }
        return 0;
    }
    public static void  findYoungestAndOldest(BasketballPlayer[] players) {
        System.out.println("Багийн хамгийн залуу ба хамгийн ахмад тамирчид:");
        int minAge = -1 ,maxAge= 20230916, youngestPlayerID= -1, oldestPlayerID = -1;
        for (int i = 0; i < players.length; i++) {
            int age = players[i].calculateAge();
            if (age >= 0) {
                if (age > minAge) {
                    minAge = age;
                    youngestPlayerID = i;
                }
                if (age < maxAge) {
                    maxAge = age;
                    oldestPlayerID = i;
                }
            }
        }

        if (youngestPlayerID != -1 && oldestPlayerID != -1) {
            System.out.println("Хамгийн залуу тамирч:");
            players[youngestPlayerID].displayInfo();
            System.out.println();

            System.out.println("Хамгийн ахмад тамирч:");
            players[oldestPlayerID].displayInfo();
            System.out.println();
        } else {
            System.out.println("Тамирч олдсонгүй.");
        }
    }
    public static void main(String[] args) {
        BasketballPlayer[] players = initialPlayers();
        findTotalPoint150Above(players);
        findYoungestAndOldest(players);
    }
}