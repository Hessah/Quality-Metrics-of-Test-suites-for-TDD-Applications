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
package samples.components;

import wheel.components.Component;
import wheel.components.StandaloneComponent;
import wheel.annotations.Persist;
import wheel.annotations.ActionMethod;

import java.util.List;
import java.util.LinkedList;

public class TabbedPanel extends StandaloneComponent {
    private List<Tab> tabs;
    @Persist
    private int selectedTabIndex;

    public TabbedPanel(String componentId) {
        super(componentId);
        config().setReusable(true);
        config().useAsset("TabbedPanel.css");
    }

    public void buildComponent() {
        Component tabsDiv = div().id("TabbedPanelTabs");;

        Component list = create().ul();

        for (int i = 0; i < tabs.size(); i++) {
            Tab tab = tabs.get(i);
            Component li = list.li();

            li.a().actionBinding(action("this.onSelectTab").parameter(i)).
                   span(tab.title);

            if (i == selectedTabIndex)
                li.clasS("selected");
        }

        tabsDiv.add(list);

        div().clasS("tabPanel").
                add(tabs.get(selectedTabIndex).component);

        tabs.clear();
    }

    public TabbedPanel addTab(String title, StandaloneComponent component) {
        if (tabs == null)
            tabs = new LinkedList<Tab>();

        Tab tab = new Tab(title, component);
        tabs.add(tab);

        return this;
    }

    @ActionMethod
    public void onSelectTab(int index) {
        selectedTabIndex = index;
    }

    class Tab {
        private String title;
        private StandaloneComponent component;

        public Tab(String title, StandaloneComponent component) {
            this.title = title;
            this.component = component;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public StandaloneComponent getComponent() {
            return component;
        }

        public void setComponent(StandaloneComponent component) {
            this.component = component;
        }
    }
}

