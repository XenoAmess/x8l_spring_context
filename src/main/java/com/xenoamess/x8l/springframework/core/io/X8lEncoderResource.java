package com.xenoamess.x8l.springframework.core.io;

import com.xenoamess.x8l.X8lTree;
import com.xenoamess.x8l.dealers.LanguageDealer;
import com.xenoamess.x8l.dealers.XmlDealer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.URI;
import java.net.URL;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.core.io.Resource;

public class X8lEncoderResource implements Resource {
    private final Resource resource;
    private final String stringCache;

    public X8lEncoderResource(Resource resource) {
        this(resource, XmlDealer.INSTANCE);
    }

    public X8lEncoderResource(Resource resource, LanguageDealer languageDealer) {
        this.resource = resource;
        X8lTree x8lTree = null;
        try {
            x8lTree = X8lTree.load(resource.getInputStream());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        x8lTree.setLanguageDealer(languageDealer);
        this.stringCache = x8lTree.toString();
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public URL getURL() throws IOException {
        return null;
    }

    @Override
    public URI getURI() throws IOException {
        return null;
    }

    @Override
    public File getFile() throws IOException {
        return null;
    }

    @Override
    public long contentLength() throws IOException {
        return 0;
    }

    @Override
    public long lastModified() throws IOException {
        return resource.lastModified();
    }

    @Override
    public Resource createRelative(String relativePath) throws IOException {
        throw new IOException(new NotImplementedException());
    }

    @Override
    public String getFilename() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new StringBufferInputStream(stringCache);
    }
}
