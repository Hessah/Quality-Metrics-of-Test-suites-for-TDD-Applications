package org.jbehave.core.configuration.needle;

import org.jbehave.core.steps.needle.ValueGetter;

import de.akquinet.jbosscc.needle.injection.InjectionProvider;
import de.akquinet.jbosscc.needle.injection.InjectionTargetInformation;

public class ValueGetterProvider implements InjectionProvider<ValueGetter> {

	public boolean verify(InjectionTargetInformation target) {
		return target.getType().isAssignableFrom(ValueGetter.class);
	}

	public ValueGetter getInjectedObject(Class<?> injectionPointType) {
		return new ValueGetter() {

			public Object getValue() {
				return VALUE;
			}

		};
	}

	public Object getKey(InjectionTargetInformation target) {
		return target.getType().getCanonicalName();
	}
}