package com.xenoamess.x8l.springframework.context;

import com.xenoamess.x8l.springframework.core.io.X8lEncoderResource;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

public class ClassPathX8lApplicationContext extends ClassPathXmlApplicationContext {
    @Nullable
    private Resource[] configResources;

    /**
     * Create a new ClassPathX8lApplicationContext for bean-style configuration.
     * @see #setConfigLocation
     * @see #setConfigLocations
     * @see #afterPropertiesSet()
     */
    public ClassPathX8lApplicationContext() {
    }

    /**
     * Create a new ClassPathX8lApplicationContext for bean-style configuration.
     * @param parent the parent context
     * @see #setConfigLocation
     * @see #setConfigLocations
     * @see #afterPropertiesSet()
     */
    public ClassPathX8lApplicationContext(ApplicationContext parent) {
        super(parent);
    }

    /**
     * Create a new ClassPathX8lApplicationContext, loading the definitions
     * from the given X8L file and automatically refreshing the context.
     * @param configLocation resource location
     * @throws BeansException if context creation failed
     */
    public ClassPathX8lApplicationContext(String configLocation) throws BeansException {
        this(new String[]{configLocation}, true, null);
    }

    /**
     * Create a new ClassPathX8lApplicationContext, loading the definitions
     * from the given X8L files and automatically refreshing the context.
     * @param configLocations array of resource locations
     * @throws BeansException if context creation failed
     */
    public ClassPathX8lApplicationContext(String... configLocations) throws BeansException {
        this(configLocations, true, null);
    }

    /**
     * Create a new ClassPathXmlApplicationContext with the given parent,
     * loading the definitions from the given XML files and automatically
     * refreshing the context.
     * @param configLocations array of resource locations
     * @param parent the parent context
     * @throws BeansException if context creation failed
     */
    public ClassPathX8lApplicationContext(String[] configLocations, @Nullable ApplicationContext parent)
            throws BeansException {

        this(configLocations, true, parent);
    }

    /**
     * Create a new ClassPathXmlApplicationContext, loading the definitions
     * from the given XML files.
     * @param configLocations array of resource locations
     * @param refresh whether to automatically refresh the context,
     * loading all bean definitions and creating all singletons.
     * Alternatively, call refresh manually after further configuring the context.
     * @throws BeansException if context creation failed
     * @see #refresh()
     */
    public ClassPathX8lApplicationContext(String[] configLocations, boolean refresh) throws BeansException {
        this(configLocations, refresh, null);
    }

    /**
     * Create a new ClassPathXmlApplicationContext with the given parent,
     * loading the definitions from the given XML files.
     * @param configLocations array of resource locations
     * @param refresh whether to automatically refresh the context,
     * loading all bean definitions and creating all singletons.
     * Alternatively, call refresh manually after further configuring the context.
     * @param parent the parent context
     * @throws BeansException if context creation failed
     * @see #refresh()
     */
    public ClassPathX8lApplicationContext(
            String[] configLocations, boolean refresh, @Nullable ApplicationContext parent)
            throws BeansException {

        super(parent);
        setConfigLocations(configLocations);
        if (refresh) {
            refresh();
        }
    }

    /**
     * Set the config locations for this application context.
     * <p>If not set, the implementation may use a default as appropriate.
     */
    @Override
    public void setConfigLocations(@Nullable String... locations) {
        if (locations != null) {
            Assert.noNullElements(locations, "Config locations must not be null");
            this.configResources = new Resource[locations.length];
            for (int i = 0; i < locations.length; i++) {
                this.configResources[i] = new X8lEncoderResource(new ClassPathResource(locations[i]));
            }
        } else {
            this.configResources = null;
        }
    }


    @Override
    @Nullable
    protected Resource[] getConfigResources() {
        return this.configResources;
    }
}
