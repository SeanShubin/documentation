var table = document.createElement('table');
for (var rowIndex = 1; rowIndex <= 12; rowIndex++) {
    var row = document.createElement('tr');
    for (var colIndex = 1; colIndex <= 12; colIndex++) {
        var cell = document.createElement('td');
        cell.textContent = '' + rowIndex + ' * ' + colIndex + ' = ' + rowIndex * colIndex;
        row.appendChild(cell);
    }
    table.appendChild(row);
}
document.body.appendChild(table);
