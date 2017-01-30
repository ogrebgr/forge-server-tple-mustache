package com.bolyartech.forge.server.tple.mustache;

import com.bolyartech.forge.server.misc.TemplateEngine;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


public class MustacheTemplateEngine implements TemplateEngine {
    private final MustacheFactory mMustacheFactory;
    private final Map<String, Object> mAttributes = new HashMap<>();


    public MustacheTemplateEngine(MustacheFactory mustacheFactory) {
        mMustacheFactory = mustacheFactory;
    }


    @Override
    public void assign(String varName, Object object) {
        mAttributes.put(varName, object);
    }


    @Override
    public String render(String templateName) {
        Mustache mustache = mMustacheFactory.compile(templateName);

        StringWriter stringWriter = new StringWriter();
        try {
            mustache.execute(stringWriter, mAttributes).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stringWriter.toString();
    }
}
