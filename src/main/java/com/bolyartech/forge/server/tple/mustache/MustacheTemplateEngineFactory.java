package com.bolyartech.forge.server.tple.mustache;

import com.bolyartech.forge.server.misc.TemplateEngine;
import com.bolyartech.forge.server.misc.TemplateEngineFactory;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;

import java.io.File;


public class MustacheTemplateEngineFactory implements TemplateEngineFactory {
    private final MustacheFactory mMustacheFactory;


    public MustacheTemplateEngineFactory(MustacheFactory mustacheFactory) {
        mMustacheFactory = mustacheFactory;
    }


    public MustacheTemplateEngineFactory(String templatePathPrefix) {
        if (templatePathPrefix.startsWith(File.separator)) {
            templatePathPrefix = templatePathPrefix.substring(1);
        }

        mMustacheFactory = new DefaultMustacheFactory(templatePathPrefix);
    }


    @Override
    public TemplateEngine createNew() {
        return new MustacheTemplateEngine(mMustacheFactory);
    }
}
