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

import wheel.Asset;
import wheel.persistence.Scope;
import wheel.util.InitialFieldValue;
import wheel.util.LinkToDomain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class StandaloneComponentConfiguration extends RenderableComponentConfiguration {
    private StandaloneComponent forComponent;

    public StandaloneComponentConfiguration(StandaloneComponent forComponent) {
        super(forComponent);
        this.forComponent = forComponent;
    }

    /**
     * With this method you can make any object available during form element validation.
     * The added Object should have methods that take a String[] as input and return boolean (true if valid, else false).
     * You can access these variables in the validation rule el-expression with the key given here.
     * @param key The name that will be used in the validation rule el-expressions
     * @param var The validation object.
     * @return
     */
    public StandaloneComponentConfiguration useValidationVariable(String key, Object var) {
        if (forComponent.validationVariables == null)
            forComponent.validationVariables = new HashMap<String,Object>();

        forComponent.validationVariables.put(key, var);

        return this;
    }

    public Map<String, Object> getValidationVariables() {
        return forComponent.validationVariables;
    }

    /**
     * Returns the MIME content type for this complex component. Default is "text/html".
     * @return
     */
    public String getContentType() {
        return forComponent.contentType;
    }

    /**
     * Sets the content type for this complex component. For Pages this is simple enough, but in ajax-situations you might want to
     * change the content type of a single component.
     * @param contentType The new content type as a MIME type.
     */
    public StandaloneComponentConfiguration setContentType(String contentType) {
        forComponent.contentType = contentType;
        return this;
    }

    /**
     * Adds a String literal that will be rendered to html output if the indicated field is null.
     * Useful when you want to display for example a short help text for form fields.
     * @param fieldName An el-expression pointing to the field member.
     * @param stringReplacement The String literal to render when the field is null.
     * @return
     */
    public StandaloneComponentConfiguration initialFieldValue(String fieldName, String stringReplacement) {
        if (forComponent.initialFieldValues == null)
            forComponent.initialFieldValues = new HashMap<String, InitialFieldValue>();

        forComponent.initialFieldValues.put(fieldName, new InitialFieldValue(stringReplacement));

        return this;
    }

    /**
     * Adds a String literal that will be rendered to html output if the indicated field is null.
     * Useful when you want to display for example a short help text for form fields.
     * @param fieldName An el-expression pointing to the field member.
     * @param stringReplacement The String literal to render when the field is null.
     * @return
     */
    public StandaloneComponentConfiguration initialFieldValue(String fieldName, String stringReplacement, Object emptyValue) {
        if (forComponent.initialFieldValues == null)
            forComponent.initialFieldValues = new HashMap<String, InitialFieldValue>();

        forComponent.initialFieldValues.put(fieldName, new InitialFieldValue(emptyValue, stringReplacement));

        return this;
    }



    /**
     * Intended for internal use. Returns the empty string value for the given field.
     * @param fieldName
     * @return
     */
    public InitialFieldValue getInitialFieldValue(String fieldName) {
        if (forComponent.initialFieldValues == null)
            return null;

        return forComponent.initialFieldValues.get(fieldName);
    }

    /**
     * Links a field in aIComplexComponent object and a field in a domain object. This link is in effect two MVEL-expressions
     * that give access to the field in the component and to the domain object. With this mechanism, its easy to make forms that
     * edit domain-object fields in "conversations" that can be rolled back. Committing the changes is done with StandaloneComponent#commitToDomain() methods.
     *
     * @param fieldName An el-expression that point to the field in the component-class
     * @param elExpression An el-expression that is evaluated on the domain object. Access to the domain object must be
     * @return
     */
    public StandaloneComponentConfiguration linkToDomain(ElExpression fieldName, ElExpression elExpression) {
        Map<String, LinkToDomain> links = (Map<String,LinkToDomain>)forComponent.getEngine().getObjectStore().get("linksToDomain", forComponent.getPage().getPagePath(), Map.class, forComponent, Scope.component);

        if (links == null)
            links = new HashMap<String,LinkToDomain>();

        if (links.containsKey(fieldName))
            return null;

        LinkToDomain linkToDomain = new LinkToDomain(fieldName, elExpression);
        links.put(fieldName.toString(), linkToDomain);

        forComponent.getEngine().getObjectStore().put("linksToDomain", forComponent.getPage().getPagePath(), links, Scope.component, forComponent);

        linkToDomain.copyFromDomain(forComponent);

        return this;
    }

    public boolean isAjaxComponent() {
        return forComponent.ajaxComponent;
    }

    public StandaloneComponentConfiguration setAjaxComponent(boolean ajaxComponent) {
        forComponent.ajaxComponent = ajaxComponent;
        return this;
    }

    /**
     * Sets this component as reusable.
     * @param reusable
     */
    public StandaloneComponentConfiguration setReusable(boolean reusable) {
        forComponent.reusable = reusable;
        return this;
    }

    /**
     * Intended for internal use. Returns true if this component is a reusable component. Reusable components have different
     * rules for processing assets.
     * @return
     */
    public boolean isReusable() {
        return forComponent.reusable;
    }

    /**
     * Adds a css/js asset to the surrounding page.
     * @param fileUri If the asset is available inside the application, only the filename without path is given. Can also be a http-url.
     */
    public StandaloneComponentConfiguration useAsset(String fileUri) {
        Asset asset = new Asset(fileUri, forComponent);

        if (forComponent.assetsToAddToPage == null)
            forComponent.assetsToAddToPage = new LinkedList<Asset>();

        forComponent.assetsToAddToPage.add(asset);

        return this;
    }

    /**
     * Adds a css/js asset to the surrounding page.
     * @param fileUri If the asset is available inside the application, only the filename without path is given. Can also be a http-url.
     * @param media When using css-assets, this parameter sets the media which this asset supports.
     */
    public StandaloneComponentConfiguration useAsset(String fileUri, String media) {
        Asset asset = new Asset(fileUri, forComponent);
        asset.setMedia(media);

        if (forComponent.assetsToAddToPage == null)
            forComponent.assetsToAddToPage = new LinkedList<Asset>();

        forComponent.assetsToAddToPage.add(asset);

        return this;
    }

    /**
     * Adds a css/js asset to the surrounding page.
     * @param fileUri If the asset is available inside the application, only the filename without path is given. Can also be a http-url.
     * @param expires In how many hours the asset will expire from user agent caches. Default is 48.
     */
    public StandaloneComponentConfiguration useAsset(String fileUri, int expires) {
        Asset asset = new Asset(fileUri, forComponent);
        asset.setExpires(expires);

        if (forComponent.assetsToAddToPage == null)
            forComponent.assetsToAddToPage = new LinkedList<Asset>();

        forComponent.assetsToAddToPage.add(asset);

        return this;
    }

    /**
     * Adds a css/js asset to the surrounding page.
     * @param fileUri If the asset is available inside the application, only the filename without path is given. Can also be a http-url.
     * @param media When using css-assets, this parameter sets the media which this asset supports.
     * @param expires In how many hours the asset will expire from user agent caches. Default is 48.
     */
    public StandaloneComponentConfiguration useAsset(String fileUri, String media, int expires) {
        Asset asset = new Asset(fileUri, forComponent);
        asset.setExpires(expires);
        asset.setMedia(media);

        if (forComponent.assetsToAddToPage == null)
            forComponent.assetsToAddToPage = new LinkedList<Asset>();

        forComponent.assetsToAddToPage.add(asset);

        return this;
    }

    /**
     * Any field in a StandaloneComponent (provided it has getter and setter) can be "exposed". Exposing fields means that they can be manipulated
     * via url parameters. Exposing fields can be very convinient when you have a page that needs an id of some kind to initialize itself.
     * Example: you have a field private int counter; in your component and you want to expose it.<br/>
     * <pre>
     * public MyPage() {
     *  config().exposeField("counter");
     * }
     * </pre>
     * Now you can access the counter field in an URL: MyPage?counter=100
     * <br/>
     * Note: you can use config().exposeField() anywhere, but using it in a constructor is most convinient.
     * @param fieldName
     * @return
     */
    public StandaloneComponentConfiguration exposeField(String fieldName) {
        if (forComponent.exposedFields == null)
            forComponent.exposedFields = new LinkedList<String>();

        forComponent.exposedFields.add(fieldName);

        return this;
    }

    /**
     * Returns true if a field by the given name is exposed in this component. Intended for internal use.
     * @param fieldName
     * @return
     */
    public boolean isFieldExposed(String fieldName) {
        if (forComponent.exposedFields == null)
            return false;

        return forComponent.exposedFields.contains(fieldName);
    }

    /**
     * Intended for internal use.
     * @return True if this page will render doctype declaration.
     */
    public boolean _isRenderDoctype() {
        return forComponent.renderDoctype;
    }

    /**
     * When set to false, the page will not render doctype declaration. This is useful if you wish to project xpath-expressions
     * to the page when the page is an XML-tree.
     * @param renderDoctype
     */
    public StandaloneComponentConfiguration _setRenderDoctype(boolean renderDoctype) {
        forComponent.renderDoctype = renderDoctype;
        return this;
    }

    /**
     * Intended for internal use.
     * @return Returns true if generated componentId's should be rendered.
     */
    public boolean _isRenderGeneratedComponentIds() {
        return forComponent.renderGeneratedComponentIds;
    }

    /**
     * When set to true, genereated componentId's will be rendered as id-attributes to html-tags.
     * @param renderGeneratedComponentIds
     */
    public StandaloneComponentConfiguration setRenderGeneratedComponentIds(boolean renderGeneratedComponentIds) {
        forComponent.renderGeneratedComponentIds = renderGeneratedComponentIds;
        return this;
    }
}
