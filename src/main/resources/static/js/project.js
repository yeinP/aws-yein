document.getElementById("content").addEventListener("keydown", function(event) {
    const textarea = event.target;
    if (textarea.tagName.toLowerCase() === 'textarea' && event.key === "Enter") {
        event.preventDefault();
        const cursorPos = textarea.selectionStart;
        const textBeforeCursor = textarea.value.substring(0, cursorPos);
        const textAfterCursor = textarea.value.substring(cursorPos);
        textarea.value = textBeforeCursor + "<br>" + textAfterCursor;
        textarea.setSelectionRange(cursorPos + 4, cursorPos + 4);
    }
});


document.getElementById("redButton").addEventListener("click", function(event) {
    event.preventDefault();
    const textarea = document.getElementById("content");
    const cursorPos = textarea.selectionStart;
    const textBeforeCursor = textarea.value.substring(0, cursorPos);
    const textAfterCursor = textarea.value.substring(cursorPos);
    textarea.value = textBeforeCursor + '<span class="Projects_red__r_DWh"></span>' + textAfterCursor;
    textarea.focus();
});


document.getElementById("boldButton").addEventListener("click", function(event) {
    event.preventDefault();
    const textarea = document.getElementById("content");
    const cursorPos = textarea.selectionStart;
    const textBeforeCursor = textarea.value.substring(0, cursorPos);
    const textAfterCursor = textarea.value.substring(cursorPos);
    textarea.value = textBeforeCursor + '<b></b>' + textAfterCursor;
    textarea.setSelectionRange(cursorPos + 3, cursorPos + 3);
    textarea.focus();
});
