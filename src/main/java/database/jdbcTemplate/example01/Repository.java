package database.jdbcTemplate.example01;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.List;

public class Repository {
  private final Clock clock;
  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final SimpleJdbcCall simpleJdbcTemplate;

  public Repository(Clock clock, DataSource dataSource) {
    this.clock = clock;
    this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    this.simpleJdbcTemplate = new SimpleJdbcCall(dataSource);
  }

  public PersonName getPersonName(Long personId) {
    return jdbcTemplate.queryForObject(
        "SELECT person_name FROM records.characters WHERE person_id = :person_id;",
        new MapSqlParameterSource().addValue("person_id", personId),
        PersonName.class
    );
  }

  public Character getCharacter(Long personId) {
    return jdbcTemplate.queryForObject(
        "SELECT person_id, person_name FROM records.characters WHERE person_id = :person_id;",
        new MapSqlParameterSource().addValue("person_id", personId),
        new CharacterRowMapper()
    );
  }

  public List<Character> getAllCharacters() {
    return jdbcTemplate.query(
        "SELECT person_id, person_name FROM records.characters",
        new CharacterRowMapper()
    );
  }

  public void insertCharacter(Character character) {
    String s = "insert into records.characters (person_id, person_name) values (:person_id, :person_name)";
    jdbcTemplate.update(s,
        new MapSqlParameterSource()
            .addValue("person_id", character.getPersonId())
            .addValue("person_name", character.getPersonName()
            )
        );
  }

  public void updateCharacter(Character character) {
    String s = "update records.characters set person_name = :person_name where person_id = :person_id";
    int update = jdbcTemplate.update(s,
        new MapSqlParameterSource()
            .addValue("person_id", character.getPersonId())
            .addValue("person_name", character.getPersonName()
            )
    );
    if (update != 0) {
      System.out.println("update complete");
    } else {
      System.out.println("update failed");
    }
  }

  public void deleteCharacter(Long personId) {

    String s = "delete from records.characters where person_id = :person_id";
    int update = jdbcTemplate.update(s,
        new MapSqlParameterSource()
            .addValue("person_id", personId)
            );
    if (update != 0) {
      System.out.println("delete complete");
    } else {
      System.out.println("delete failed");
    }
  }

  public void callStoredProcedure(Character character) {
    // TODO
    simpleJdbcTemplate.withFunctionName("test()").executeFunction(String.class);
  }

  private static class CharacterRowMapper implements RowMapper<Character> {
    @Override
    public Character mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new Character(
          rs.getLong("person_id"),
          rs.getString("person_name"));
    }
  }
}


