/*
Copyright (c) 2007-2008, Henri Frilund

All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    * Neither the name of the <ORGANIZATION> nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package wheel.components;

import org.xmlpull.v1.XmlSerializer;
import org.mvel.PropertyAccessor;
import wheel.*;
import wheel.persistence.Scope;
import wheel.util.ComponentStore;
import wheel.util.InitialFieldValue;
import wheel.util.LinkToDomain;
import wheel.util.WheelURL;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * Defines the contract for complex components. Complex components are components that can contain forms and can have their
 * own resource bundles for messages.
 * There are no limitations for complex components and they can be full-blown applications that live inside a containing Page.
 *
 * @author Henri Frilund
 */
public abstract class StandaloneComponent extends RenderableComponent implements IContainer, IBuildableComponent {
    private IEngine engine;
    Map<String,Object> validationVariables;
    private Messages messages;
    String contentType = "text/html";
    Map<String, InitialFieldValue> initialFieldValues;
    boolean ajaxComponent;
    private boolean built;
    private StandaloneComponentConfiguration config;
    boolean reusable;
    List<Asset> assetsToAddToPage;
    List<String> exposedFields;
    private Map<String,Integer> typeCounts = new HashMap<String,Integer>();
    private boolean rewinding;
    private ComponentStore componentStore;
    private Block head;
    private Block body;
    private List<Asset> assets;
    boolean renderDoctype = true;
    boolean renderGeneratedComponentIds = false;
    private Form submittedForm;
    private String submitTarget;
    private String focusedComponent;
    private List<String> updateTargets;
    private Set<IBuildableComponent> postBuildCallbacks;
    private boolean pageBuild;
    Set<String> standaloneComponentsUsed;
    boolean wrapIds;
    boolean wrapFormIds;
    boolean containsForm;


    public StandaloneComponent() {
        super("");
        engine = AbstractEngine.getCurrentServer();
        messages = new Messages(this);
    }

    protected StandaloneComponent(String componentId) {
        super(componentId);
        messages = new Messages(this);
        engine = AbstractEngine.getCurrentServer();
    }

    protected StandaloneComponent(Component parent, String componentId) {
        super(parent, componentId);
        messages = new Messages(this);
        engine = AbstractEngine.getCurrentServer();
    }

    @Override
    public StandaloneComponentConfiguration config() {
        if (config == null)
            config = new StandaloneComponentConfiguration(this);

        return config;
    }

    /**
     * Returns true if this complex component is rewinding. Rewinding means that a form submit has been recieved and the component
     * tree has been built once so that values from the submit were possible to bind. When the binding is done, the component tree is
     * built again, this time in rewind-mode. You should use this method whenever you want to append validation messages or change the structure of the
     * component in any way depending on the results of the form submit.
     * @return
     */
    public boolean isRewinding() {
        StandaloneComponent page = getPage();

        if (page.isPageRewinding() && page._getSubmitTarget().equals(getComponentId()))
            return true;

        return false;
    }

    /**
     * Returns the Messages-object giving access to localized messages. Localized messages can be added to any complex component
     * by creating .properties file to the same package as the class file and with the same name as the component class.
     * @return
     */
    public Messages getMessages() {
        return messages;
    }



    /**
     * Returns true if the form element with the given componentId is valid. Internally this method checks first if the component is rewinding.
     * If not, will return true.
     * @param formElementName The component ID of the form element.
     * @return
     */
    public boolean isValid(String formElementName) {
        if (isRewinding() && !getSubmittedForm().isValid(formElementName))
            return false;

        return true;
    }

    /**
     * Lists all valiation errors for all form elements. Internally checks if the component is rewinding. If not, will return an empty list.
     * @return
     */
    public List<ValidationError> listErrors() {
        List<ValidationError> errors = new LinkedList<ValidationError>();

        if (isRewinding()) {
            for (FormElement formElement : getSubmittedForm().getInvalidFields()) {
                errors.addAll(formElement.getErrors());
            }
        }

        return errors;
    }

    /**
     * Returns the first error for the form element in the submitted form. If the field is valid or doesn't exist, returns null.
     * @param componentId
     * @return
     */
    public ValidationError getError(String componentId) {
        if (isRewinding()) {
            FormElement field = getSubmittedForm().field(componentId);

            if (field != null && field.getErrors().size() > 0)
                return field.getErrors().get(0);
        }

        return null;
    }


    public String defaultTagName() {
        return "div";
    }


    /**
     * Calling this method causes all field marked with @Value(linkTo = ...) annotation to be written to the domain objects.
     */
    public void commit() {
        Map<String,LinkToDomain> links = (Map<String,LinkToDomain>) getEngine().getObjectStore().get("linksToDomain", getPage().getPagePath(), Map.class, this, Scope.component);

        if (links != null) {
            for (LinkToDomain linkToDomain : links.values()) {
                linkToDomain.writeToDomain(this);
            }
        }
    }

    /**
     * Calling this method causes all field marked with @Value(linkTo = ...) annotation and identified in the input varargs to be writtetn to the domain objects.
     * @param fields Names of the fields to commit.
     */
    public void commit(String...fields) {
        Map<String,LinkToDomain> links = (Map<String,LinkToDomain>) getEngine().getObjectStore().get("linksToDomain", getPage().getPagePath(), Map.class, this, Scope.component);

        if (links != null && fields != null) {
            for (int i = 0; i < fields.length; i++) {
                String field = fields[i];
                LinkToDomain link = links.get(field);

                if (link != null)
                    link.writeToDomain(this);
            }
        }
    }

    public void rollback() {
        Map<String,LinkToDomain> links = (Map<String,LinkToDomain>) getEngine().getObjectStore().get("linksToDomain", getPage().getPagePath(), Map.class, this, Scope.component);

        if (links != null) {
            for (LinkToDomain linkToDomain : links.values()) {
                linkToDomain.copyFromDomain(this);
            }
        }
    }

    public void rollback(String...fields) {
        Map<String,LinkToDomain> links = (Map<String,LinkToDomain>) getEngine().getObjectStore().get("linksToDomain", getPage().getPagePath(), Map.class, this, Scope.component);

        if (links != null && fields != null) {
            for (int i = 0; i < fields.length; i++) {
                String field = fields[i];
                LinkToDomain link = links.get(field);

                if (link != null)
                    link.copyFromDomain(this);
            }
        }
    }

    public void preBuild() {
    }

    public void postBuild() {
    }

    public boolean _isBuilt() {
        return built;
    }

    public void _setBuilt(boolean built) {
        this.built = built;
    }

    @Override
    public void afterAdd() {
        if (assetsToAddToPage != null) {
            StandaloneComponent page = getPage();

            for (Asset asset : assetsToAddToPage) {
                page._addAsset(asset);
            }

            assetsToAddToPage.clear();
            assetsToAddToPage = null;
        }
    }

    @Override
    public void _render(XmlSerializer serializer) throws IOException {
        if (isPage())
            renderPage(serializer);
        else
            super._render(serializer);
    }

    private void renderPage(XmlSerializer serializer) throws IOException {
        if (engine.getRequest().getParameter("xml") != null)
            config().setContentType("text/xml");
        else
            config().setContentType("text/html");

        buildPage();

        List<Component> styleAndScriptComponents = head.findAll(el("getTagName() == 'script' || getTagName() == 'style'"));

        Set cssFiles = engine._getAvailableCssFiles();
        Set jsFiles = engine._getAvailableJsFiles();

        LinkedList<Class> classes = new LinkedList<Class>();

        Class clazz = getClass();
        boolean assetFound = false;

        while (clazz != null && !clazz.getName().equals("wheel.components.StandaloneComponent")) {
            classes.addFirst(clazz);
            clazz = clazz.getSuperclass();
        }

        for (Class aClass : classes) {
            String className = aClass.getName().replaceAll(engine.getBasePackage() + ".", "");

            String cssName = className.replace('.', '/') + ".css";
            String jsName = className.replace('.', '/') + ".js";

            if (cssFiles.contains(cssName)) {
                Component css = head.create().link();
                css.attributes("rel", "stylesheet", "type", "text/css", "href", engine.getCssPath() + cssName);
                head.add(css);
            }

            if (cssFiles.contains(cssName.replace(".css", "_print.css"))) {
                Component printCss = head.create().link();
                printCss.attributes("rel", "stylesheet", "type", "text/css", "href", cssName.replace(".css", "_print.css"));
                head.add(printCss);
            }

            if (jsFiles.contains(jsName)) {
                Component js = head.create().script();
                js.attributes("type", "text/javascript", "src", engine.getJsPath() + jsName);
                head.add(js);
            }

            if (!assetFound) {
                if (clazz.getResource(cssName) != null) {
                    _addAsset(new Asset(getComponentName() + ".css", this));
                }

                if (clazz.getResource(jsName) != null) {
                    _addAsset(new Asset(getComponentName() + ".js", this));
                }
            }
        }




        if (assetsToAddToPage != null) {
            if (assets == null)
                assets = new LinkedList<Asset>();

            assets.addAll(assetsToAddToPage);
        }

        if (assets != null) {
            for (Asset asset : assets) {
                if (asset.getType() == Asset.AssetType.js) {
                    Component script = head.create().script();

                    script.attribute("type", "text/javascript");

                    if (jsFiles.contains(asset.getFileUri())) {
                        script.attribute("src", engine.getJsPath() + asset.getFileUri() + asset.getExpiresQueryString());
                    }
                    else
                        script.attribute("src", asset.getUrl());


                    head.add(script);
                }

                else if (asset.getType() == Asset.AssetType.css) {
                    Component link = head.create().link();

                    link.attribute("rel", "stylesheet").
                            attribute("type", "text/css");

                    if (asset.getMedia() != null)
                        link.attribute("media", asset.getMedia());

                    if (cssFiles.contains(asset.getFileUri())) {
                        link.attribute("href", engine.getCssPath() + asset.getFileUri() + asset.getExpiresQueryString());
                    }
                    else {
                        link.attribute("href", asset.getUrl());
                    }

                    head.add(link);
                }
            }
        }

        for (Component component : styleAndScriptComponents) {
            head.remove(component);
            head.add(component);
        }

        serializer.startDocument(engine.getEncoding(), null);

        if (renderDoctype)
            serializer.docdecl(" html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\"");

        serializer.text("\n");

        serializer.startTag("", "html");
        serializer.attribute("", "lang", engine.getLocale().getLanguage());

        if (renderDoctype)
            serializer.attribute("", "xmlns", "http://www.w3.org/1999/xhtml");

        head._render(serializer);
        remove(head);

        serializer.startTag("", body.getTagName());
        body._renderXhtmlAttributes(serializer);
        body._renderClassReferenceFromHints(serializer);

        for (RenderableComponent renderable : _getRenderableChildren()) {
            renderable._render(serializer);
        }

        if (focusedComponent != null) {
            serializer.startTag("", "script");
            serializer.attribute("", "language", "javascript");
            serializer.text("document.getElementById('" + focusedComponent + "').focus();");
            serializer.endTag("", "script");
        }

        serializer.endTag("", body.getTagName());
        serializer.endTag("", "html");
        serializer.endDocument();
    }

    private void buildPage() {
        if (pageBuild)
            return;

        try {
            head = create().wBlock("head");

            add(head);
            body = create().wBlock("body");

            if (updateTargets != null) {
                for (String updateTarget : updateTargets) {
                    find(updateTarget).wrapSelf();
                }
            }

            head.meta().attributes("http-equiv", "content-type", "content", "text/html;charset=" + engine.getEncoding());
        } finally {
            pageBuild = true;
        }
    }

    public void _postProcessRequest() {
        if (postBuildCallbacks != null) {
            for (IBuildableComponent buildableComponent : postBuildCallbacks) {
                buildableComponent.postBuild();
            }
        }
    }

    public void _postBuildPage() {
        if (standaloneComponentsUsed != null)
            standaloneComponentsUsed.clear();

        containsForm = false;
        wrapFormIds = false;
    }

    /**
     * Generates a componentId for the given Component.
     * @param component Component to generate componentId for.
     * @return Component short classname + "_" + integer count of the component type on this page. Example_ Label_4.
     */
    public String _generateComponentId(Component component) {
        StandaloneComponent page = getPage();

        component._setGeneratedId(true);
        String className = component.getClass().getName();
        int lastIndex = className.lastIndexOf(".");
        className = className.substring(lastIndex + 1, className.length());

        int count = 0;

        if (page.typeCounts.containsKey(className))
            count = page.typeCounts.get(className);

        count++;

        page.typeCounts.put(className, count);

        return className + "_" + count;
    }

    /**
     * Creates a string representation that, when appended to an URL, give access to this page.
     * @return The full classname where basePackageForPages is removed and .'s are replaced with /'s. Example com.foo.bar.TestPage -> bar/TestPage (where basePackageForPages = com.foo).
     */
    public String getPagePath() {
        String basePackage = engine.getBasePackage();
        String className = getPage().getClass().getName();
        className = className.replace(basePackage, "");

        if (className.startsWith("."))
            className = className.substring(1, className.length());


        return className.replace('.', '/');
    }

    /**
     * Returns true if a form submit is rewinding on this page.
     * @return
     */
    public boolean isPageRewinding() {
        return getPage().rewinding;
    }

    /**
     * Intended for internal use.
     * @param rewinding
     */
    public void _setPageRewinding(boolean rewinding) {
        getPage().rewinding = rewinding;
    }

    /**
     * Intended for internal use.
     * @param form
     * @return True if the page is rewinding the given form.
     */
    public boolean _isRewindingForm(Form form) {
        if (rewinding && getSubmittedForm().equals(form))
            return true;

        return false;
    }


    /**
     * Intended for internal use.
     * @return
     */
    public ComponentStore _getComponentStore() {
        if (componentStore == null)
            componentStore = new ComponentStore();

        return componentStore;
    }


    Block getHead() {
        StandaloneComponent page = getPage();
        page.buildPage();
        return page.head;
    }

    Block getBody() {
        StandaloneComponent page = getPage();
        page.buildPage();
        return page.body;
    }

    /**
     * Reserved for internal use. Use Component.addAsset() instead
     * @param asset
     */
    void _addAsset(Asset asset) {
        StandaloneComponent page = getPage();

        if (page.assets == null)
            page.assets = new LinkedList<Asset>();

        if (!page.assets.contains(asset))
            page.assets.add(asset);

        if (page.updateTargets != null)
            page.updateTargets.clear();
    }



    /**
     *
     * @return The complete URL for this page, including scheme, engine name, port, context path and servlet path.
     */
    public String getPageUrl() {
        HttpServletRequest request = getEngine().getRequest();
        return  request.getScheme() + "://" + request.getServerName() + ":" +  request.getServerPort() +
                request.getContextPath() + request.getServletPath() + "/" + getPagePath();
    }




    /**
     * Intended for internal use.
     */
    @Override
    public synchronized void _clear() {
        super._clear();

        if (assets != null)
            assets.clear();

        if (postBuildCallbacks != null)
            postBuildCallbacks.clear();

        if (updateTargets != null)
            updateTargets.clear();
    }

    /**
     * @return The form that was submitted to this page.
     * @throws wheel.WheelException if no form was submitted.
     */
    public Form getSubmittedForm() {
        StandaloneComponent page = getPage();

        if (page.submittedForm == null)
            throw new WheelException("Tried to access a form, but none was submitted.", this);

        return page.submittedForm;
    }

    /**
     * Intended for internal use.
     * @param submittedForm
     */
    public void _setSubmittedForm(Form submittedForm) {
        getPage().submittedForm = submittedForm;
    }


    /**
     *
     * @return componentId for the StandaloneComponent that is the reciever of the submitted form.
     */
    public String _getSubmitTarget() {
        if (submitTarget == null)
            throw new WheelException("Tried to access a submit target, but no form was submitted.", this);

        return submitTarget;
    }

    /**
     * Intended for internal use.
     * @param submitTarget
     */
    public void _setSubmitTarget(String submitTarget) {
        this.submitTarget = submitTarget;
    }


    /**
     * Sets the browser focus. Will cause the page to render a javascript fragment like this:<br/>
     * <pre>document.getElementById('componentId').focus();</pre>
     */
    public void setFocus(Component component) {
        getPage().focusedComponent = component.getComponentId();
    }



    public void loadJQuery() {
        _addAsset(new Asset("asset/wheel/components/jquery.js" + "?expires=88", "jquery.js", Asset.AssetType.js));
    }

    void _addUpdateTarget(String updateTargetId) {
        StandaloneComponent page = getPage();

        if (page.updateTargets == null)
            page.updateTargets = new LinkedList<String>();

        page.updateTargets.add(updateTargetId);
    }

    void _addPostBuildCallback(IBuildableComponent buildableComponent) {
        StandaloneComponent page = getPage();

        if (page.postBuildCallbacks == null)
            page.postBuildCallbacks = new HashSet<IBuildableComponent>();

        page.postBuildCallbacks.add(buildableComponent);
    }

    public boolean isPage() {
        return this.getParent() == null;
    }

    void addUsedStandaloneComponent(StandaloneComponent component) {
        if (standaloneComponentsUsed == null)
            standaloneComponentsUsed = new HashSet<String>();

        String name = component.getComponentName();

        if (standaloneComponentsUsed.contains(name)) {
            component.wrapIds = true;
        }
        else
            standaloneComponentsUsed.add(component.getComponentName());
    }

    public void _injectExposedFields() {
        WheelURL url = getEngine().getWheelURL();

        if (url.getParameters().size() == 0 || url.getParameters().containsKey("wheelSubmitId"))
            return;

        if (this.isPage() || url.getComponent().equals(getComponentId())) {
            for (Iterator iterator = url.getParameters().keySet().iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                String value = ((String[])url.getParameters().get(key))[0];

                if (config().isFieldExposed(key)) {
                    try {
                        PropertyAccessor.set(this, key, value);
                    } catch(Exception e) {}
                }
            }
        }
    }
}

