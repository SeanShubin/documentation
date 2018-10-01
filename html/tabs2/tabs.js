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

    function setActiveTab(activeIndex) {
        function f(tab, currentIndex) {
            tab.active = currentIndex === activeIndex;
        }

        primaryTabs().map(f);
    }

    var model = {
        primaryTabs: primaryTabs,
        secondaryTabs: secondaryTabs,
        setActiveTab: setActiveTab
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

function tabClick(tabView) {
    var tabIndex = Number(tabView.getAttribute('data-index'));
    model.setActiveTab(tabIndex);
    reRender();
}

function renderPrimaryTab(tabModel, tabIndex) {
    var tabView = createLi(tabModel.name);
    tabView.classList.add('tab');
    if (tabModel.active) {
        tabView.classList.add('active');
    }
    tabView.setAttribute('data-index', tabIndex);
    tabView.setAttribute('onclick', 'tabClick(this)');
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

function renderTabs(tabs) {
    var ul = createUl();
    var tabArray = tabs.map(renderPrimaryTab);
    appendChildren(ul, tabArray);
    return ul;
}

function render() {
    root.append(renderTabs(model.primaryTabs()));
    root.append(renderTabs(model.secondaryTabs()));
}

render();
