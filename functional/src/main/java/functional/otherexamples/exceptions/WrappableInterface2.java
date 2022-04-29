package functional.otherexamples.exceptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WrappableInterface2 {
    public List<URL> getURLs() {
        return Stream
                .of("https://www.hahnekamp.com" , "https://www.austria.info")
                        .map(RuntimeWrappableFunctionMapper.wrap(this::createURL))
                        .collect(Collectors.toList());
    }

    private URL createURL(String url) throws MalformedURLException {
        return new URL(url);
    }

    public List<URL> getURLs2() {
        return Stream
                .of("https://www.hahnekamp.com" , "https://www.austria.info")

                .map(url -> {
            try {
                return this.createURL(url);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        })
                .collect(Collectors.toList());
    }
}

@FunctionalInterface
interface RuntimeWrappableFunction<T, R> {
    R apply(T t) throws Exception;
}

class RuntimeWrappableFunctionMapper {
    static <T, R> Function<T, R> wrap(RuntimeWrappableFunction<T, R> wrappable) {
        return t -> {
            try {
                return wrappable.apply(t);
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        };
    }
}