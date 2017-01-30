package com.bolyartech.forge.server.tple.mustache;

import com.bolyartech.forge.server.misc.TemplateEngine;
import com.bolyartech.forge.server.misc.TemplateEngineFactory;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;


public class MustacheTemplateEngineFactory implements TemplateEngineFactory {
    private final MustacheFactory mMustacheFactory;


    public MustacheTemplateEngineFactory(MustacheFactory mustacheFactory) {
        mMustacheFactory = mustacheFactory;
    }


    public MustacheTemplateEngineFactory(String templatePathPrefix) {
        mMustacheFactory = new DefaultMustacheFactory(templatePathPrefix);
    }


    @Override
    public TemplateEngine createNew() {
        return new MustacheTemplateEngine(mMustacheFactory);
    }
}
