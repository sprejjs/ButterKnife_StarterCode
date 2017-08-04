package com.spreys.viewholderexample.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockDataGenerator {
    private static final String[] firstNames = {"Hermila", "Brynn", "Christeen", "Maren", "Clifton", "Madelyn",
            "Yan", "Tia", "Zulema", "Casey", "Sonia", "Timmy", "Lynn", "Hae", "Thaddeus", "Flossie",
            "Cleveland", "Zona", "Wm", "Nathanial", "Shane", "Chanell", "Fredia", "Wayne", "Carin",
            "Darren", "Valentina", "Mahalia", "Donn", "Beverley", "Zachery", "Araceli", "Joel",
            "Hellen", "Ema", "Ivan", "Elisa", "Lina", "Bernice", "Marinda", "Leanora", "Rochell",
            "Nelia", "Jimmie", "Carolynn", "Shantelle", "Emile", "Zenia", "Juan", "Kandi"};
    private static final String[] lastNames = {"Stephen", "Granier", "Guild", "Frazer", "Jacobs", "Bassi", "Thies",
            "Gracey", "Kicklighter", "Klingman", "Spade", "Podesta", "Gatz", "Mineo", "Magda", "Coronado",
            "Hanks", "Ellington", "Barone", "Leibowitz", "Hileman", "Box", "Soileau", "Ament", "Bracken",
            "Gholston", "Eagles", "Roop", "Huber", "Carollo", "Seidl", "Rohrer", "Peach", "Monarrez",
            "Markey", "Sidwell", "Stoneham", "Pinkerton", "Westervelt", "Despres", "Belair", "Derksen",
            "Suzuki", "Distefano", "Montalto", "Jung", "Bratt", "Obrien", "Figueredo", "Keim"};

    private MockDataGenerator() {
    }

    public static List<Contact> getMockContacts(int length) {
        ArrayList<Contact> mockContacts = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            mockContacts.add(getMockContact());
        }
        return mockContacts;
    }

    private static Contact getMockContact() {
        return new Contact(
                getRandomFirstName(),
                getRandomLastName(),
                getRandomMobile(),
                getRandomLandline()
        );
    }

    private static String getRandomFirstName() {
        return firstNames[new Random().nextInt(firstNames.length)];
    }

    private static String getRandomLastName() {
        return lastNames[new Random().nextInt(lastNames.length)];
    }

    private static String getRandomMobile() {
        return getRandomNumber(11);
    }

    private static String getRandomLandline() {
        return getRandomNumber(9);
    }

    private static String getRandomNumber(int length) {
        String number = "";
        for (int i = 0; i < length; i++) {
            number += String.valueOf(new Random().nextInt(10));
        }
        return number;
    }
}
