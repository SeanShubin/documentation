const createDiv = inner => {
    const element = document.createElement('div');
    element.innerHTML = inner;
};

const createContentFunction = text => () => createDiv(text);

const createTabs = tabInitializers => {
};

const tabs = createTabs([
    {path: ['color', 'red'], contentFunction: createContentFunction("Red")},
    {path: ['color', 'green'], contentFunction: createContentFunction("Green")},
    {path: ['color', 'blue'], contentFunction: createContentFunction("Blue")},
    {path: ['shape', 'oval'], contentFunction: createContentFunction("Oval")},
    {path: ['shape', 'diamond'], contentFunction: createContentFunction("Diamond")},
    {path: ['shape', 'squiggle'], contentFunction: createContentFunction("Squiggle")},
    {path: ['shading', 'solid'], contentFunction: createContentFunction("Solid")},
    {path: ['shading', 'shaded'], contentFunction: createContentFunction("Shaded")},
    {path: ['shading', 'outlined'], contentFunction: createContentFunction("Outlined")}
]);

document.body.append(tabs);

