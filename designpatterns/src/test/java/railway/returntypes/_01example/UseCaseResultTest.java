package railway.returntypes._01example;

import org.assertj.core.api.WithAssertions;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

@SuppressWarnings("unchecked")
class UseCaseResultTest implements WithAssertions {

    @Test
    void returnsSuccessWithDetails() {
        UseCaseResult<Integer, String> underTest = UseCaseResult.success("A");

        MatcherAssert.assertThat(underTest.isSuccess(), is(true));
        MatcherAssert.assertThat(underTest.isFailure(), is(false));
        MatcherAssert.assertThat(underTest.success(), is("A"));
    }

    @Test
    void returnsFailureWithDetails() {
        UseCaseResult<Integer, String> underTest = UseCaseResult.failure(1);

        MatcherAssert.assertThat(underTest.isSuccess(), is(false));
        MatcherAssert.assertThat(underTest.isFailure(), is(true));
        MatcherAssert.assertThat(underTest.failure(), is(1));
    }

    @Test
    void returnsSuccessWithNoDetails() {
        UseCaseResult<Failure, Success> underTest = UseCaseResult.WithNoDetails.success();
        MatcherAssert.assertThat(underTest.isSuccess(), is(true));
        MatcherAssert.assertThat(underTest.isFailure(), is(false));
    }

    @Test
    void returnsFailureWithNoDetails() {
        UseCaseResult<Failure, Success> underTest = UseCaseResult.WithNoDetails.failure();
        MatcherAssert.assertThat(underTest.isSuccess(), is(false));
        MatcherAssert.assertThat(underTest.isFailure(), is(true));
    }

    @Test
    void returnsSuccessWithSuccessDetailsOnly() {
        UseCaseResult<Failure, String> underTest = UseCaseResult.WithSuccessDetailsOnly.success("Foo");

        MatcherAssert.assertThat(underTest.isSuccess(), is(true));
        MatcherAssert.assertThat(underTest.success(), is("Foo"));
    }

    @Test
    void returnsFailureWithSuccessDetailsOnly() {
        UseCaseResult<Failure, String> underTest = UseCaseResult.WithSuccessDetailsOnly.failure();

        MatcherAssert.assertThat(underTest.isSuccess(), is(false));
    }

    @Test
    void returnsSuccessWithFailureDetailsOnly() {
        UseCaseResult<String, Success> underTest = UseCaseResult.WithFailureDetailsOnly.success();

        MatcherAssert.assertThat(underTest.isSuccess(), is(true));
    }

    @Test
    void returnsFailureWithFailureDetailsOnly() {
        UseCaseResult<String, Success> underTest = UseCaseResult.WithFailureDetailsOnly.failure("Foo");

        MatcherAssert.assertThat(underTest.isSuccess(), is(false));
        MatcherAssert.assertThat(underTest.failure(), is("Foo"));
    }

    @Test
    void throwsExceptionIfGettingSuccessOnFailureResult() {
        assertThatThrownBy(() ->
                UseCaseResult.failure("A")
                        .success()).isInstanceOf(ResultOperationException.class);
    }

    @Test
    void throwsExceptionIfGettingFailureOnSuccessResult() {
        assertThatThrownBy(() ->
                UseCaseResult.success("A")
                        .failure()).isInstanceOf(ResultOperationException.class);
    }

    @Test
    void canEqual() {
        String foo = "FOO";
        MatcherAssert.assertThat(UseCaseResult.success(foo), equalTo(UseCaseResult.success(foo)));
    }

    @Test
    void successesAreEqual() {
        MatcherAssert.assertThat(new Success().equals(new Success()), is(true));
        MatcherAssert.assertThat(new Success().hashCode(), is(new Success().hashCode()));
    }

    @Test
    void failuresAreEqual() {
        MatcherAssert.assertThat(new Failure().equals(new Failure()), is(true));
        MatcherAssert.assertThat(new Failure().hashCode(), is(new Failure().hashCode()));
    }

    @Test
    void successDoesNotMatchFailure() {
        assertThat(new Success()).isNotEqualTo(new Failure());
        MatcherAssert.assertThat(new Success().hashCode(), CoreMatchers.not(is(new Failure().hashCode())));
    }

    @Test
    void ifSuccessfulFunctionAppliedOnSuccess() {
        String success = "Yay!";
        UseCaseResult<String, String> underTest = UseCaseResult.success(success);

        Function<String, String> thenApplySuccess = mock(Function.class);
        when(thenApplySuccess.apply(success)).thenReturn("Succeeded");

        Function<String, String> thenApplyFailure = mock(Function.class);

        String result = underTest.ifSuccessful(thenApplySuccess)
                .orElse(thenApplyFailure);

        MatcherAssert.assertThat(result, is("Succeeded"));
        verify(thenApplySuccess).apply(success);
        verifyNoInteractions(thenApplyFailure);
    }

    @Test
    void orElseFunctionAppliedOnFailure() {
        String failure = "Boo!";
        UseCaseResult<String, String> underTest = UseCaseResult.failure(failure);

        Function<String, String> thenApplySuccess = mock(Function.class);

        Function<String, String> thenApplyFailure = mock(Function.class);
        when(thenApplyFailure.apply(failure)).thenReturn("Failed");

        String result = underTest.ifSuccessful(thenApplySuccess)
                .orElse(thenApplyFailure);

        MatcherAssert.assertThat(result, is("Failed"));
        verify(thenApplyFailure).apply(failure);
        verifyNoInteractions(thenApplySuccess);
    }

    @Test
    void orElseThrowSuppliedExceptionThrown() {
        Function<String, String> ifSuccessful = mock(Function.class);

        RuntimeException expected = mock(RuntimeException.class);
        UseCaseResult<String, String> underTest = UseCaseResult.failure("");

        try {
            underTest.ifSuccessful(ifSuccessful)
                    .orElseThrow(() -> expected);
            verifyNoInteractions(ifSuccessful);
            fail("Should have thrown exception");
        } catch (RuntimeException e) {
            MatcherAssert.assertThat(e, is(expected));
        }
    }

    @Test
    void orElseThrowNothingIfSuccess() {
        Function<String, String> ifSuccessful = mock(Function.class);
        when(ifSuccessful.apply("success")).thenReturn("hurrah!");

        RuntimeException expected = mock(RuntimeException.class);
        UseCaseResult<String, String> underTest = UseCaseResult.success("success");

        String outcome = underTest.ifSuccessful(ifSuccessful)
                .orElseThrow(() -> expected);
        MatcherAssert.assertThat(outcome, equalTo("hurrah!"));
    }

    @Test
    void orElseDoThrowSuppliedExceptionThrown() {
        Consumer<String> ifSuccessful = mock(Consumer.class);

        RuntimeException expected = mock(RuntimeException.class);
        UseCaseResult<String, String> underTest = UseCaseResult.failure("");

        try {
            underTest.ifSuccessfulDo(ifSuccessful)
                    .orElseDoThrow(() -> expected);
            verifyNoInteractions(ifSuccessful);
            fail("Should have thrown exception");
        } catch (RuntimeException e) {
            MatcherAssert.assertThat(e, is(expected));
        }
    }

    @Test
    void orElseDoThrowNothingIfSuccess() {
        Consumer<String> ifSuccessful = mock(Consumer.class);

        RuntimeException expected = mock(RuntimeException.class);
        UseCaseResult<String, String> underTest = UseCaseResult.success("success");

        underTest.ifSuccessfulDo(ifSuccessful)
                .orElseDoThrow(() -> expected);
        verify(ifSuccessful).accept("success");
    }

    @Test
    void ifSuccessfulDoConsumerAcceptsOnSuccess() {
        String success = "Yay!";
        UseCaseResult<String, String> underTest = UseCaseResult.success(success);

        Consumer<String> ifSuccessful = mock(Consumer.class);
        Consumer<String> ifFailure = mock(Consumer.class);

        underTest.ifSuccessfulDo(ifSuccessful)
                .orElseDo(ifFailure);

        verify(ifSuccessful).accept(success);
        verifyNoInteractions(ifFailure);
    }

    @Test
    void orElseDoConsumerAcceptsOnFailure() {
        String failure = "Boo!";
        UseCaseResult<String, String> underTest = UseCaseResult.failure(failure);

        Consumer<String> ifSuccessful = mock(Consumer.class);
        Consumer<String> ifFailure = mock(Consumer.class);

        underTest.ifSuccessfulDo(ifSuccessful)
                .orElseDo(ifFailure);

        verifyNoInteractions(ifSuccessful);
        verify(ifFailure).accept(failure);
    }

    @Test
    void onSuccessFunctionAppliesOnSuccess() {
        String success = "Yay!";
        UseCaseResult<String, String> underTest = UseCaseResult.success(success);

        Function<String, String> onSuccess = mock(Function.class);
        when(onSuccess.apply(success)).thenReturn("Success!");

        String result = underTest.onSuccess(onSuccess);
        verify(onSuccess).apply(success);
        MatcherAssert.assertThat(result, is("Success!"));
    }

    @Test
    void onSuccessFunctionDoesNotApplyOnFailure() {
        UseCaseResult<String, String> underTest = UseCaseResult.failure("Boo!");

        Function<String, String> onSuccess = mock(Function.class);

        String result = underTest.onSuccess(onSuccess);
        verifyNoInteractions(onSuccess);
        MatcherAssert.assertThat(result, is(nullValue()));
    }

    @Test
    void onFailureFunctionAppliesOnFailure() {
        String failure = "Boo!";
        UseCaseResult<String, String> underTest = UseCaseResult.failure(failure);

        Function<String, String> onFailure = mock(Function.class);
        when(onFailure.apply("Boo!")).thenReturn("Failure!");

        String result = underTest.onFailure(onFailure);
        verify(onFailure).apply(failure);
        MatcherAssert.assertThat(result, is("Failure!"));
    }

    @Test
    void onFailureFunctionDoesNotApplyOnSuccess() {
        UseCaseResult<String, String> underTest = UseCaseResult.success("Yipeee");

        Function<String, String> onFailure = mock(Function.class);

        String result = underTest.onFailure(onFailure);
        verifyNoInteractions(onFailure);
        MatcherAssert.assertThat(result, is(nullValue()));
    }

    @Test
    void onSuccessDoConsumerAcceptsOnSuccess() {
        String success = "Yay!";
        UseCaseResult<String, String> underTest = UseCaseResult.success(success);

        Consumer<String> onSuccess = mock(Consumer.class);

        underTest.onSuccessDo(onSuccess);

        verify(onSuccess).accept(success);
    }

    @Test
    void onSuccessDoConsumerDoesNotAcceptOnFailure() {
        UseCaseResult<String, String> underTest = UseCaseResult.failure("Boo!");

        Consumer<String> onSuccess = mock(Consumer.class);

        underTest.onSuccessDo(onSuccess);

        verifyNoInteractions(onSuccess);
    }

    @Test
    void onFailureDoConsumerAcceptsOnFailure() {
        String failure = "Boo!";
        UseCaseResult<String, String> underTest = UseCaseResult.failure(failure);

        Consumer<String> onFailure = mock(Consumer.class);

        underTest.onFailureDo(onFailure);

        verify(onFailure).accept(failure);
    }

    @Test
    void onFailureDoConsumerDoesNotAcceptOnSuccess() {
        UseCaseResult<String, String> underTest = UseCaseResult.success("Yipeee");

        Consumer<String> onFailure = mock(Consumer.class);

        underTest.onFailureDo(onFailure);

        verifyNoInteractions(onFailure);
    }

    @Test
    void onFailureThrowException() {
        assertThatThrownBy(() ->
                UseCaseResult.failure("Shit!")
                        .onFailureThrow(() -> new RuntimeException("boom!"))).isInstanceOf(RuntimeException.class);
    }
}