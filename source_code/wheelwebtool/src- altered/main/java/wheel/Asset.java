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
package wheel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wheel.components.StandaloneComponent;

/**
 * Asset is something that a html page needs aside from the html-code. Assets are requested separately by the browser. Typically an asset is a
 * css file, a js file or an image.
 */
public class Asset {
    private final Logger log = LoggerFactory.getLogger(Asset.class);
    public enum AssetType {css,js, other};
    private AssetType type;
    private String fileUri;
    private StandaloneComponent owner;
    private String packagePath;
    private String url;
    private int expires = 48;
    private String media;


    public Asset(String fileUri, StandaloneComponent owner) {
        if (fileUri.endsWith(".css"))
            type = AssetType.css;
        else if (fileUri.endsWith(".js"))
            type = AssetType.js;
        else
            type = AssetType.other;

        this.fileUri = fileUri;
        this.owner = owner;
    }

    public Asset(String url, String fileUri,  AssetType type) {
        this.url = url;
        this.type = type;
        this.fileUri = fileUri;
    }

    public AssetType getType() {
        return type;
    }

    public String getFileUri() {
        if (owner != null && owner.config().isReusable())
            return getPackagePath() + "/" + fileUri;

        return fileUri;
    }

    public StandaloneComponent getOwner() {
        return owner;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public String getUrl() {
        if (url != null)
            return url;

        if (fileUri.indexOf("://") != -1)
            return fileUri;

        if (owner.config().isReusable()) {
            return "asset/" + getPackagePath() + "/" + fileUri + "?expires=" + expires;
        }

        else {
            if (type == AssetType.css)
                return owner.getEngine().getCssPath() + fileUri + "?expires=" + expires;
            else
                return owner.getEngine().getJsPath() + fileUri + "?expires=" + expires;
        }

    }

    public String getExpiresQueryString() {
        return "?expires=" + expires;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asset asset = (Asset) o;

        if (fileUri != null ? !fileUri.equals(asset.fileUri) : asset.fileUri != null) return false;

        return true;
    }

    public int hashCode() {
        return (fileUri != null ? fileUri.hashCode() : 0);
    }

    public String getPackagePath() {
        if (packagePath == null) {
            if (owner.config().isReusable()) {
                String className = owner.getClass().getName();
                this.packagePath = className.substring(0, className.lastIndexOf(".")).replace('.',  '/');
            }
        }
        return packagePath;
    }
}
