function createModel() {
    var state = {
        tabs: [
            {
                name: 'Color',
                active: true,
                tabs:
                    [
                        {
                            name: 'Red',
                            active: true,
                            description: 'Red Content'
                        },
                        {
                            name: 'Green',
                            active: false,
                            description: 'Green Content'
                        },
                        {
                            name: 'Blue',
                            active: false,
                            description: 'Blue Content'
                        }
                    ]
            },
            {
                name: 'Shape',
                active: false,
                tabs:
                    [
                        {
                            name: 'Oval',
                            active: true,
                            description: 'Oval Content'
                        },
                        {
                            name: 'Diamond',
                            active: false,
                            description: 'Diamond Content'
                        },
                        {
                            name: 'Squiggle',
                            active: false,
                            description: 'Squiggle Content'
                        }
                    ]
            },
            {
                name: 'Shading',
                active: false,
                tabs:
                    [
                        {
                            name: 'Solid',
                            active: true,
                            description: 'Solid Content'
                        },
                        {
                            name: 'Shaded',
                            active: false,
                            description: 'Shaded Content'
                        },
                        {
                            name: 'Outlined',
                            active: false,
                            description: 'Outlined Content'
                        }
                    ]
            }
        ]
    };

    function primaryTabs() {
        return state.tabs;
    }

    function isActiveTab(tab) {
        return tab.active;
    }

    function secondaryTabs() {
        return state.tabs.find(isActiveTab).tabs;
    }

    function setActivePrimaryTab(activeIndex) {
        function f(tab, currentIndex) {
            tab.active = currentIndex === activeIndex;
        }

        primaryTabs().map(f);
    }

    function setActiveSecondaryTab(activePrimaryIndex, activeSecondaryIndex) {
        function f(tab, currentIndex) {
            tab.active = currentIndex === activeSecondaryIndex;
        }

        state.tabs[activePrimaryIndex].tabs.map(f);
    }

    function primaryTabIndex() {
        return state.tabs.findIndex(isActiveTab);
    }

    var model = {
        primaryTabs: primaryTabs,
        secondaryTabs: secondaryTabs,
        setActivePrimaryTab: setActivePrimaryTab,
        setActiveSecondaryTab: setActiveSecondaryTab,
        primaryTabIndex: primaryTabIndex
    };
    return model;
}

var model = createModel();
var root = document.body;

function createElement(name) {
    return document.createElement(name);
}

function createLi(text) {
    var li = createElement('li');
    li.textContent = text;
    return li;
}

function removeAllChildren(parent) {
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
}

function reRender() {
    removeAllChildren(root);
    render();
}

function primaryTabClick(tabView) {
    var primaryTabIndex = Number(tabView.getAttribute('data-index-1'));
    model.setActivePrimaryTab(primaryTabIndex);
    reRender();
}

function secondaryTabClick(tabView) {
    var primaryTabIndex = Number(tabView.getAttribute('data-index-1'));
    var secondaryTabIndex = Number(tabView.getAttribute('data-index-2'));
    model.setActiveSecondaryTab(primaryTabIndex, secondaryTabIndex);
    reRender();
}

function renderPrimaryTab(tabModel, tabIndex) {
    var tabView = createLi(tabModel.name);
    tabView.classList.add('tab');
    if (tabModel.active) {
        tabView.classList.add('active');
    }
    tabView.setAttribute('data-index-1', tabIndex);
    tabView.setAttribute('onclick', 'primaryTabClick(this)');
    return tabView;
}

function renderSecondaryTab(tabModel, secondaryTabIndex) {
    var tabView = createLi(tabModel.name);
    tabView.classList.add('tab');
    if (tabModel.active) {
        tabView.classList.add('active');
    }
    tabView.setAttribute('data-index-1', model.primaryTabIndex());
    tabView.setAttribute('data-index-2', secondaryTabIndex);
    tabView.setAttribute('onclick', 'secondaryTabClick(this)');
    return tabView;
}

function createUl() {
    return createElement('ul');
}

function appendChildren(node, children) {
    function appendChild(child) {
        node.appendChild(child);
    }

    children.forEach(appendChild);
}

function renderPrimaryTabs(tabs) {
    var ul = createUl();
    var tabArray = tabs.map(renderPrimaryTab);
    appendChildren(ul, tabArray);
    return ul;
}

function renderSecondaryTabs(tabs) {
    var ul = createUl();
    var tabArray = tabs.map(renderSecondaryTab);
    appendChildren(ul, tabArray);
    return ul;
}

function render() {
    root.append(renderPrimaryTabs(model.primaryTabs()));
    root.append(renderSecondaryTabs(model.secondaryTabs()));
}

render();
