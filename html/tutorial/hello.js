var colors = ['red', 'green', 'blue'];
var things = ['bird', 'fish', 'cat'];

function appendParagraph(text) {
    var paragraph = document.createElement('p');
    paragraph.textContent = text;
    document.body.appendChild(paragraph)
}

function greetDifferentColorsOfThings() {
    for (var colorIndex = 0; colorIndex < colors.length; colorIndex++) {
        for (var thingIndex = 0; thingIndex < things.length; thingIndex++) {
            var color = colors[colorIndex];
            var thing = things[thingIndex];
            var greeting = 'Hello, ' + color + ' ' + thing + '!';
            appendParagraph(greeting);
        }
    }
}

greetDifferentColorsOfThings();
