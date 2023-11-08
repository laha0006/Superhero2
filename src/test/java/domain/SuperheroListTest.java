package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SuperheroListTest {

    private SuperheroList superheroList;
    private int originalListSize;

//    @Test
//    void save() {
//        fail();
//    }

    @BeforeEach
    void setup() {
        superheroList = new SuperheroList("mockData.csv");
        originalListSize = superheroList.getSuperheroList().size();
    }

    @AfterEach
    void teardown() {
        while (superheroList.getSuperheroList().size() > originalListSize ) {
            superheroList.delete(superheroList.getSuperheroList().size()-1);
        }
    }

    @Test
    void addSuperhero() {
        //arrange
        Superhero superheroToAdd = new Superhero("QA","John Doe",true,"Tests code",1994,100);

        //act
        superheroList.addSuperhero(superheroToAdd);
        Superhero lastSuperhero = superheroList.getSuperheroList().get(originalListSize);

        //assert
        assertEquals(originalListSize + 1, superheroList.getSuperheroList().size());
        assertEquals(superheroToAdd,lastSuperhero);
        assertAll("SuperheroToAdd fields should match lastSuperhero in list)",
                () -> assertEquals("QA",lastSuperhero.getName()),
                () -> assertEquals("John Doe",lastSuperhero.getRealName()),
                () -> assertTrue(lastSuperhero.isHuman()),
                () -> assertEquals("Tests code",lastSuperhero.getSuperPower()),
                () -> assertEquals(1994,lastSuperhero.getCreationYear()),
                () -> assertEquals(100,lastSuperhero.getStrength()));

    }

    @Test
    void search() {
        //arrange
        Superhero superheroToAdd = new Superhero("QA","John Doe",true,"Tests code",1994,100);
        superheroList.addSuperhero(superheroToAdd);

        //act
        Superhero superheroToFind = superheroList.search("QA");
        Superhero superheroToFind2 = superheroList.search("Q");

        //assert
        assertAll("SuperheroToAdd fields should match superheroToFind in list)",
                () -> assertEquals("QA",superheroToFind.getName()),
                () -> assertEquals("John Doe",superheroToFind.getRealName()),
                () -> assertTrue(superheroToFind.isHuman()),
                () -> assertEquals("Tests code",superheroToFind.getSuperPower()),
                () -> assertEquals(1994,superheroToFind.getCreationYear()),
                () -> assertEquals(100,superheroToFind.getStrength()));

        assertAll("SuperheroToAdd fields should match superheroToFind2 in list)",
                () -> assertEquals("QA",superheroToFind2.getName()),
                () -> assertEquals("John Doe",superheroToFind2.getRealName()),
                () -> assertTrue(superheroToFind2.isHuman()),
                () -> assertEquals("Tests code",superheroToFind2.getSuperPower()),
                () -> assertEquals(1994,superheroToFind2.getCreationYear()),
                () -> assertEquals(100,superheroToFind2.getStrength()));

    }

    @Test
    void searchMany() {
        //arrange
        Superhero superheroToAdd1 = new Superhero("QAgod","John Doe",true,"Tests code",1994,100);
        Superhero superheroToAdd2 = new Superhero("Demigod","Some guy",true,"Godly things",243,10000);
        Superhero superheroToAdd3 = new Superhero("UnicornGod","Sparkles",true,"Unicorn things",1243,400);

        superheroList.addSuperhero(superheroToAdd1);
        superheroList.addSuperhero(superheroToAdd2);
        superheroList.addSuperhero(superheroToAdd3);

        //act
        ArrayList<Superhero> searchResult = superheroList.searchMany("god");

        //assert
        assertEquals(3,searchResult.size());

        assertAll("searchResult.get(0) fields should match superheroToAdd1)",
                () -> assertEquals("QAgod",searchResult.get(0).getName()),
                () -> assertEquals("John Doe",searchResult.get(0).getRealName()),
                () -> assertTrue(searchResult.get(0).isHuman()),
                () -> assertEquals("Tests code",searchResult.get(0).getSuperPower()),
                () -> assertEquals(1994,searchResult.get(0).getCreationYear()),
                () -> assertEquals(100,searchResult.get(0).getStrength()));

        assertAll("searchResult.get(1) fields should match superheroToAdd2)",
                () -> assertEquals("Demigod",searchResult.get(1).getName()),
                () -> assertEquals("Some guy",searchResult.get(1).getRealName()),
                () -> assertTrue(searchResult.get(1).isHuman()),
                () -> assertEquals("Godly things",searchResult.get(1).getSuperPower()),
                () -> assertEquals(243,searchResult.get(1).getCreationYear()),
                () -> assertEquals(10000,searchResult.get(1).getStrength()));

        assertAll("searchResult.get(2) fields should match superheroToAdd3)",
                () -> assertEquals("UnicornGod",searchResult.get(2).getName()),
                () -> assertEquals("Sparkles",searchResult.get(2).getRealName()),
                () -> assertTrue(searchResult.get(2).isHuman()),
                () -> assertEquals("Unicorn things",searchResult.get(2).getSuperPower()),
                () -> assertEquals(1243,searchResult.get(2).getCreationYear()),
                () -> assertEquals(400,searchResult.get(2).getStrength()));
    }

    @Test
    void delete() {
        //arrange
        Superhero superheroToAdd = new Superhero("QA","John Doe",true,"Tests code",1994,100);
        superheroList.addSuperhero(superheroToAdd);

        //act
        int sizeBeforeDelete = superheroList.getSuperheroList().size();
        superheroList.delete(superheroToAdd);
        int sizeAfterDelete = superheroList.getSuperheroList().size();
        Superhero searchForDeletedSuperhero = superheroList.search("QA");

        //assert
        assertEquals(sizeBeforeDelete-1,sizeAfterDelete);
        assertNull(searchForDeletedSuperhero);
    }

    @Test
    void sortBy() {
        //                comparators
        //                0 = SuperheroNameComparator(),
        //                1 = SuperheroRealNameComparator(),
        //                2 = SuperheroIsHumanComparator(),
        //                3 = SuperheroSuperpowerComparator(),
        //                4 = SuperheroStrengthComparator(),
        //                5 = SuperheroYearCreatedComparator()

        //arrange
        Superhero superheroToAdd1 = new Superhero("QA","John Doe",true,"Tests code",1894,400);
        Superhero superheroToAdd2 = new Superhero("QA","John Doe",true,"Tests code",1994,300);
        Superhero superheroToAdd3 = new Superhero("QA","John Doe",true,"Tests code",1694,300);
        Superhero superheroToAdd4 = new Superhero("QA","John Doe",true,"Tests code",2044,1200);
        Superhero superheroToAdd5 = new Superhero("QA","John Doe",true,"Tests code",2014,1200);
        superheroList.addSuperhero(superheroToAdd1);
        superheroList.addSuperhero(superheroToAdd2);
        superheroList.addSuperhero(superheroToAdd3);
        superheroList.addSuperhero(superheroToAdd4);
        superheroList.addSuperhero(superheroToAdd5);

        //act
        superheroList.sortBy(4,5,1,0); //sort by strength descending, then by year ascending
        ArrayList<Superhero> result = superheroList.getSuperheroList();

        //assert

        //expected order
        //Superhero("QA","John Doe",true,"Tests code",2014,1200);
        //Superhero("QA","John Doe",true,"Tests code",2044,1200);
        //Superhero("QA","John Doe",true,"Tests code",1894,400);
        //Superhero("QA","John Doe",true,"Tests code",1694,300);
        //Superhero("QA","John Doe",true,"Tests code",1994,300);

        assertEquals(result.get(0).getCreationYear(),2014);
        assertEquals(result.get(1).getCreationYear(),2044);
        assertEquals(result.get(2).getCreationYear(),1894);
        assertEquals(result.get(3).getCreationYear(),1694);
        assertEquals(result.get(4).getCreationYear(),1994);

    }
}