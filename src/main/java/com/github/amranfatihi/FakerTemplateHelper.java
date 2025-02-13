package com.github.amranfatihi;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import net.datafaker.Faker;
import java.lang.reflect.Method;

public class FakerTemplateHelper implements Helper<String> {
    private final Faker faker;

    FakerTemplateHelper(Faker faker) {
        this.faker = faker;
    }

    FakerTemplateHelper() {
        this.faker = new Faker();
    }

    @Override
    public String apply(String context, Options options) {
        String result;
        try {
            Method providerMethod = faker.getClass().getMethod(context);
            Object provider = providerMethod.invoke(faker);

            Method fakeDataMethod = provider.getClass().getMethod(options.param(0));
            result = (String) fakeDataMethod.invoke(provider);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
