package org.jbehave.examples.core.needle.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.jbehave.examples.core.service.TradingService;
import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.annotation.ObjectUnderTest;
import de.akquinet.jbosscc.needle.junit.NeedleRule;

/**
 * Test Constructor injection for steps.
 * @author Jan Galinski, Holisticon AG
 */
public class NeedleTraderStepsTest {

    // PONR - Plain old needle rule
    @Rule
    public final NeedleRule needle = new NeedleRule();

    // should be created via constructor injection.
    @ObjectUnderTest
    private NeedleTraderSteps needleTraderSteps;

    @Inject
    private TradingService tradingServiceMock;

    @Test
    public void shouldCreateNewInstanceViaConstructorInjectionWithMockedService() {
        assertNotNull(needleTraderSteps);
        assertThat(needleTraderSteps.getService(), is(tradingServiceMock));
    }

}
