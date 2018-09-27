var debugLines = [];
var debugLinesSize = 6;
var debugLineIndex = 0;

var state = {
    activeTab: 1,
    activeSubTab: 1,
    tabs: [
        {
            name: 'Cat',
            tabs:
                [
                    {
                        name: 'Tiger',
                        description: 'The tiger (Panthera tigris) is the largest cat species, most recognizable for its pattern of dark vertical stripes on reddish-orange fur with a lighter underside.'
                    },
                    {
                        name: 'Ocelot',
                        description: 'The ocelot (Leopardus pardalis) /ˈɒsəlɒt/ is a wild cat native to the southwestern United States, Mexico, Central and South America.'
                    },
                    {
                        name: 'Jaguar',
                        description: 'The jaguar (Panthera onca) is a wild cat species and the only extant member of the genus Panthera native to the Americas.'
                    }
                ]
        },
        {
            name: 'Dog',
            tabs:
                [
                    {
                        name: 'Wolf',
                        description: 'The wolf (Canis lupus), also known as the gray wolf, timber wolf, western wolf, and its other subspecies is a canine native to the wilderness and remote areas of Eurasia and North America.'
                    },
                    {
                        name: 'Fox',
                        description: 'Foxes are small-to-medium-sized, omnivorous mammals belonging to several genera of the family Canidae.'
                    },
                    {
                        name: 'Jackal',
                        description: 'Jackals are medium-sized omnivorous mammals of the genus Canis, which also includes wolves, coyotes and the domestic dog.'
                    }
                ]
        }
    ]
};

function addDebugLine(line) {
    debugLines.push('' + debugLineIndex++ + ' - ' + line);
    if (debugLines.length > debugLinesSize) {
        debugLines = debugLines.slice(1)
    }
}

function debug(text) {
    addDebugLine(text);
    var debugElement = document.getElementById('debug');
    debugElement.innerText = "";
    debugLines.forEach(function (line) {
        var node = document.createElement('p');
        node.innerText = line;
        debugElement.appendChild(node);
    });
}

function removeClassFromElement(targetClass, element) {
    element.classList.remove(targetClass);
}

function removeClass(targetClass) {
    function partialApplication(element) {
        removeClassFromElement(targetClass, element);
    }

    return partialApplication;
}

function setDisplayForElement(display, element) {
    element.style.display = display;
}

function setDisplay(display) {
    function partialAppliaction(element) {
        setDisplayForElement(display, element);
    }

    return partialAppliaction;
}

function myForEach(list, f) {
    for (var i = 0; i < list.length; i++) {
        f(list[i]);
    }
}

function tabClick(source) {
    var allTabs = document.getElementsByClassName('level-1');
    myForEach(allTabs, removeClass('active'));
    source.classList.add('active');
    var allChildTabs = document.getElementsByClassName('child-tab');
    myForEach(allChildTabs, setDisplay('none'));
    var children = document.getElementById('children-of-' + source.id);
    children.style.display = 'block';
}

function subTabClick(source) {
    var allTabs = document.getElementsByClassName('level-2');
    myForEach(allTabs, removeClass('active'));
    source.classList.add('active');
}

function createSubTab(subTabState, index) {
    var li = document.createElement('li');
    li.setAttribute('onclick', 'subTabClick(this)');
    li.classList.add('tab');
    li.classList.add('level-2');
    if (state.activeSubTab === index) {
        li.classList.add('active');
    }
    li.textContent = subTabState.name;
    return li;
}

function renderSubTab(attachTo) {
    function partialApplication(subTabState, index) {
        attachTo.appendChild(createSubTab(subTabState, index));
    }

    return partialApplication;
}

function renderSubTabs(tabState, index) {
    var subTabs = document.getElementById('sub-tabs');
    tabState.tabs.forEach(renderSubTab(subTabs));
}

function renderTab(tabState, index) {
    var tabs = document.getElementById('tabs');
    var li = document.createElement('li');
    li.setAttribute('id', 'tab-' + index);
    li.setAttribute('onclick', 'tabClick(this)');
    li.classList.add('tab');
    li.classList.add('level-1');
    if (state.activeTab === index) {
        li.classList.add('active');
        renderSubTabs(tabState, index);
    }
    li.textContent = tabState.name;
    tabs.appendChild(li);
}

function forEachTab(f) {
    state.tabs.forEach(f);
}

function renderTabs() {
    forEachTab(renderTab);
}

function render() {
    renderTabs();
}

render();