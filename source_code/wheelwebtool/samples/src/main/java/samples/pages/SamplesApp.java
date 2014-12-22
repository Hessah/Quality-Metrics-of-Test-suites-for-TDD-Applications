package samples.pages;

import wheel.annotations.Persist;
import wheel.components.StandaloneComponent;
import wheel.persistence.Scope;
import samples.components.TabbedPanel;

/**
 * An example of an application base class. Note how all pages inherit from this class. 
 */
public abstract class SamplesApp extends StandaloneComponent {
    @Persist(Scope.session)
    private int pageViews;

    protected SamplesApp() {
    }

    protected SamplesApp(String componentId) {
        super(componentId);
    }

    public void buildComponent() {
        getEngine().addErrorMapping("java.io.IOException", "MyErrorPage");
        head().title("Wheel sample application - page loads: " + pageViews);
    }

    public int getPageViews() {
        return pageViews;
    }

    public void setPageViews(int pageViews) {
        this.pageViews = pageViews;
    }

    @Override
    public void postBuild() {
        if (isPage())
            pageViews++;
    }
}
