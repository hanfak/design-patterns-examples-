package database.jdbcTemplate.example01;

import java.time.Clock;
import java.util.List;

import static database.jdbcTemplate.example01.DataSourceFactory.dataSourceFor;

public class Runner {
  public static void main(String[] args) {
    Repository repository = new Repository(Clock.systemDefaultZone(),
        dataSourceFor("app-connection-pool-1"));

    PersonName personName = repository.getPersonName(16L);
    System.out.println("personName = " + personName);

    Character character = repository.getCharacter(1L);
    System.out.println("character = " + character);

//    if (repository.getCharacter(100L) !=null) {
//      repository.deleteCharacter(100L);
//      List<Character> allCharacters2 = repository.getAllCharacters();
//      System.out.println("allCharacters2 = " + allCharacters2);
//    }

    List<Character> allCharacters = repository.getAllCharacters();
    System.out.println("allCharacters = " + allCharacters);

    repository.insertCharacter(new Character(100,"Bobo"));
    List<Character> allCharacters1 = repository.getAllCharacters();
    System.out.println("allCharacters1 = " + allCharacters1);

    repository.updateCharacter(new Character(100,"messi"));
    PersonName updatedPersonName = repository.getPersonName(100L);
    System.out.println("updatedPersonName = " + updatedPersonName);

    // to fix
//    repository.callStoredProcedure(null);
  }
}
