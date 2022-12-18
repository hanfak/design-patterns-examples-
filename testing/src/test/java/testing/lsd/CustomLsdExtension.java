package testing.lsd;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.lsd.IdGenerator;
import com.lsd.LsdContext;
import com.lsd.properties.LsdProperties;
import io.lsdconsulting.junit5.LsdPostTestProcessing;
import j2html.tags.Text;
import j2html.tags.UnescapedText;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.platform.commons.util.ExceptionUtils;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.lsd.OutcomeStatus.*;
import static com.lsd.report.model.PopupContent.popupDiv;
import static j2html.TagCreator.*;
import static java.util.Arrays.stream;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.joining;
import static org.junit.platform.commons.util.StringUtils.isBlank;

public class CustomLsdExtension implements TestWatcher, AfterTestExecutionCallback, AfterAllCallback {

    private final LsdContext lsdContext = LsdContext.getInstance();
    private final IdGenerator idGenerator = lsdContext.getIdGenerator();
    private final boolean hideStacktrace = LsdProperties.getBoolean("lsd.junit5.hideStacktrace");

    @Override
    public void testSuccessful(ExtensionContext context) {
        lsdContext.completeScenario(prefixParentDisplayName(context), p(
                h4().with(new UnescapedText("&#127808; Test Passed"))
                        .withClass(SUCCESS.getCssClass())
                        .with(p().with(new UnescapedText(styleOutput(prettify(renderMethod(context)))))
                        )
        ).render(), SUCCESS);
    }

    private String styleOutput(String value) {
        // TODO: Add Css and html to parts of the description, ie given/when/then differetn colours
        return value;
    }

    private String prettify(String value) {
        // TODO: Make method output nicer (see yatspec), replace brackets, punctuation, maintain tabs etc
        return value;
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        lsdContext.completeScenario(prefixParentDisplayName(context), p(
                h4("Test Disabled").withClass(WARN.getCssClass())
        ).render(), WARN);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        var description = createErrorDescription(cause, "Test Aborted!");
        lsdContext.completeScenario(prefixParentDisplayName(context), description, WARN);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        var description = createErrorDescription(cause, "&#10060; Failed!");
        lsdContext.completeScenario(prefixParentDisplayName(context), description, ERROR);
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        Object testInstance = context.getRequiredTestInstance();
        additionalProcessing(testInstance, LsdPostTestProcessing.class);
    }

    @Override
    public void afterAll(ExtensionContext context) {
        if (isNested(context)) {
            return;
        }
        lsdContext.completeReport(context.getDisplayName());
        lsdContext.createIndex();
    }

    private boolean isNested(ExtensionContext context) {
        return context.getParent()
                .map(ExtensionContext::getParent)
                .map(Optional::isPresent)
                .orElse(false);
    }

    private String prefixParentDisplayName(ExtensionContext context) {
        var parent = context.getParent();
        if (parent.isPresent()) {
            var parentDisplayName = prefixParentDisplayName(parent.get());
            var separator = isBlank(parentDisplayName) ? "" : ": ";
            return parentDisplayName + separator + context.getDisplayName();
        }
        return "";
    }

    private String createErrorDescription(Throwable cause, String header) {
        var contentId = idGenerator.next();
        String exceptionMessage = extractMessage(cause);
        return p(
                h4().with(new UnescapedText(header)).withClass(ERROR.getCssClass()),
                a().withHref("#" + contentId).withText(exceptionMessage),
                popupDiv(contentId, "Stacktrace", readStackTrace(cause))
        ).render();
    }

    private void additionalProcessing(final Object instance, Class<? extends Annotation> annotation) {
        Class<?> klass = instance.getClass();
        while (klass != Object.class) {
            stream(klass.getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(annotation))
                    .forEach(invokeMethodOn(instance));
            klass = klass.getSuperclass();
        }
    }

    private String extractMessage(Throwable cause) {
        return Optional.ofNullable(cause)
                .map(Throwable::getMessage)
                .orElse("");
    }

    private String readStackTrace(Throwable cause) {
        return Optional.ofNullable(cause)
                .filter(not(throwable -> hideStacktrace))
                .map(ExceptionUtils::readStackTrace)
                .orElse("[Displaying the stacktrace was disabled or no cause was provided]");
    }

    private Consumer<Method> invokeMethodOn(Object instance) {
        return method -> {
            try {
                method.setAccessible(true);
                method.invoke(instance);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public String renderMethod(ExtensionContext context) {
        String simpleName = getClass().getSimpleName();
        Optional<Class<?>> testClass = context.getTestClass();
        String property = System.getProperty("user.dir");
        // TODO: Get full path programatically
        Path path = Path.of("C:\\Users\\fakir\\Documents\\git\\design-patterns-examples-\\testing\\src\\test\\java\\testing\\lsd\\Example03Test.java");
        File projectDir = new File(path.toUri());
        return parseClass(path).get().getStatements()
                .stream()
                .map(x->x.getTokenRange().get().toString())
                .collect(joining("<br>"));
    }

    private Optional<BlockStmt> parseClass(Path projectDir) {
        try {
            ParseResult<CompilationUnit> parse = new JavaParser().parse(projectDir);
            return new MethodVisitor().visit(parse, null);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    private static class MethodVisitor  {

        public Optional<BlockStmt> visit(ParseResult<CompilationUnit> n, Object arg) {
            // here you can access the attributes of the method.
            // this method will be called for all methods in this
            // CompilationUnit, including inner class methods

            CompilationUnit compilationUnit = n.getResult()
                    .get();
            Optional<BlockStmt> body = compilationUnit.getTypes()
                    .get(0)
                    .getMembers()
                    .get(0)
                    .asMethodDeclaration()
                    .getBody();
            System.out.println("body = " + body);
            return body;
        }

    }
}