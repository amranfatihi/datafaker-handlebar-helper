package com.cariad;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.HandlebarsException;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Template;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class FakerTemplateHelperTest {

    @DisplayName("Assert mock for datafaker provider 'Name' ")
    @Test
    void testFakeName() throws IOException {
        Helper<String> dataFakerHelper = new FakerTemplateHelper();
        Handlebars handlebars = new Handlebars();
        handlebars.registerHelper("faker", dataFakerHelper);

        String templateString = "{{faker 'name' 'firstName'}}";
        Template template = handlebars.compileInline(templateString);
        assertNotNull(template.apply(null));
    }

    @DisplayName("Assert mock for datafaker provider 'Internet' ")
    @Test
    void testFakeEmail() throws IOException {
        Helper<String> dataFakerHelper = new FakerTemplateHelper();
        Handlebars handlebars = new Handlebars();
        handlebars.registerHelper("faker", dataFakerHelper);

        String templateString = "{{faker 'internet' 'emailAddress'}}";
        Template template = handlebars.compileInline(templateString);
        assertNotNull(template.apply(null));
    }

    @DisplayName("Assert mock for datafaker invalid provider 'Foo' ")
    @Test
    void testInvalidProvider() throws IOException {
        Helper<String> dataFakerHelper = new FakerTemplateHelper();
        Handlebars handlebars = new Handlebars();
        handlebars.registerHelper("faker", dataFakerHelper);

        String templateString = "{{faker 'foo' 'bar'}}";
        Template template = handlebars.compileInline(templateString);
        assertThrowsExactly(HandlebarsException.class,() -> template.apply(null));
    }

}