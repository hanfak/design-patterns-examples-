package functional.otherexamples.exceptions;

public class WrappableInterface {
    public DbConnection getDbConnection(String username, String password) {
        return RuntimeExceptionWrapper.wrap(() ->
                new DbProvider().getConnection(username, password));
    }
}

class DbProvider {
    DbConnection getConnection(String username, String passwor){
      return new DbConnection();
    }
}

class DbConnection {

}

@FunctionalInterface
interface RuntimeExceptionWrappable<T> {
    T execute() throws Exception;
}

class RuntimeExceptionWrapper {
    static <T> T wrap(RuntimeExceptionWrappable<T> runtimeExceptionWrappable) {
        try {
            return runtimeExceptionWrappable.execute();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}


