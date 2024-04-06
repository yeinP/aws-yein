function addMainFunctionInput() {
    var mainfunctionList = document.getElementById('mainfunction-list');
    var newIndex = mainfunctionList.children.length;


    var newLi = document.createElement('li');
    var newInput = document.createElement('input');
    newInput.setAttribute('type', 'text');
    newInput.setAttribute('class', 'form-control');
    newInput.setAttribute('name', 'mainfunction[' + newIndex + ']');
    newInput.setAttribute('required', true);
    newLi.appendChild(newInput);

    var removeButton = document.createElement('button');
    removeButton.textContent = '삭제';
    removeButton.setAttribute('type', 'button');
    removeButton.setAttribute('onclick', 'removeMFunction(this)');
    newLi.appendChild(removeButton);

    mainfunctionList.appendChild(newLi);
}

function removeMainFunction(event) {
    event.preventDefault();
    var listItem = event.target.parentNode;
    listItem.parentNode.removeChild(listItem);
}
function removeMFunction(button) {
    var li = button.parentElement;
    li.parentElement.removeChild(li);
}










