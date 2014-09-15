package org.lunivore.tyburn;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNull;
import org.hamcrest.text.StringContains;
import org.junit.Assert;
import org.mockito.Mockito;
import org.mockito.internal.progress.OngoingStubbing;

public class Behaviour {
    
    protected <T> void ensureThat(T obj, Matcher<T> matches) {
        MatcherAssert.assertThat(obj, matches);
    }

    protected <T> IsNull<T> isNull() {
        return new IsNull<T>();
    }

    protected <T> Matcher<T> eq(T object) {
        return new IsEqual<T>(object);
    }
    
    protected <T extends Comparable<T>> IsLessThan<T> isLessThan(T object) {
        return new IsLessThan<T>(object);
    }
 
    protected <T extends Comparable<T>> IsGreaterThanOrEq<T> isGreaterThanOrEq(T object) {
        return new IsGreaterThanOrEq<T>(object);
    }
    
    protected <T> T mock(Class<T> classToMock) {
        return Mockito.mock(classToMock);
    }

    protected <T> T verify(T mock) {
        return Mockito.verify(mock);
    }

    protected <T> IsInstanceOf isA(Class<T> clazz) {
        return new IsInstanceOf(clazz);
    }
    
    
    protected <T> OngoingStubbing<T> stub(T methodCall) {
        return Mockito.stub(methodCall);
    }


    protected void ensureThat(boolean expression) {
        Assert.assertTrue(expression);
    }


    protected Matcher<String> contains(String string) {
        return new StringContains(string);
    }


    public class IsGreaterThanOrEq<T extends Comparable<T>> extends TypeSafeMatcher<T> {
        private final Comparable<T> compareTo;
        
        public IsGreaterThanOrEq(Comparable<T> compareTo) {
            this.compareTo = compareTo;
        }
        
        public boolean matchesSafely(T item) {
            return compareTo.compareTo(item) <= 0;
        }
        
        public void describeTo(Description description) {
            description.appendText("a value greater than ");
            description.appendValue(compareTo);
        }
    }
    
    public class IsLessThan<T extends Comparable<T>> extends TypeSafeMatcher<T> {
        private final Comparable<T> compareTo;
        
        public IsLessThan(Comparable<T> compareTo) {
            this.compareTo = compareTo;
        }
        
        public boolean matchesSafely(T item) {
            return compareTo.compareTo(item) > 0;
        }
        
        public void describeTo(Description description) {
            description.appendText("a value greater than ");
            description.appendValue(compareTo);
        }
    }

}
