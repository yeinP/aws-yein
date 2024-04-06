document.querySelectorAll('.Projects_show-readme-btn__v1p__').forEach(function(button) {
    button.addEventListener('click', function() {
        var projectTitle = this.getAttribute('data-project-title');
        console.log(projectTitle);
        openModal(projectTitle);
    });
});

function openModal(projecttitle) {
    console.log(projecttitle);
    $.ajax({
        url: '/readme/' + projecttitle,
        type: 'GET',
        success: function(response) {
            console.log(response);
            $('#myModal .readmeTitle h2').text(response.projecttitle);
            $('#myModal .summary .modalinfo').html(response.summary);

            var mainFunctionContainer = $('#myModal .fun .modalinfo');
            mainFunctionContainer.empty(); // 이전 내용을 지웁니다.
            response.mainfunction.forEach(function(functionItem) {
                var functionElement = $('<p>').text('✔ ' + functionItem);
                mainFunctionContainer.append(functionElement);
            });

            var techList = $('#myModal .tech ul');
            techList.empty(); // 이전 내용을 지웁니다.
            var techItems = ["Backend", "Frontend", "DB", "IDE", "Deployment"];
            response.tech.forEach(function(techItem, index) {
                var listItem = $('<li>').text(techItems[index] + " : " + techItem);
                techList.append(listItem);
            });

            var rolebeList = $('#myModal .member .modalinfo .be ul');
            rolebeList.empty();
            response.rolebe.forEach(function(rolebeItem) {
                var rolebeElement = $('<li>').html( rolebeItem);
                rolebeList.append(rolebeElement);
            });

            var rolefeList = $('#myModal .member .modalinfo .fe ul');
            rolefeList.empty();
            response.rolefe.forEach(function(rolefeItem) {
                var rolefeElement = $('<li>').html(rolefeItem);
                rolefeList.append(rolefeElement);
            });



            var reviewElement = $('#myModal .meaning .modalinfo p');
            reviewElement.html(response.review);

            var codeElement = $('#myModal .set .modalinfo code');
            codeElement.html(response.code);


            var modal = document.getElementById("myModal");
            modal.style.display = "block";
        },
        error: function(xhr, status, error) {
            console.error('README 정보를 불러오는 중 오류가 발생했습니다:', error);
        }
    });
}

function closeModal() {
    var modal = document.getElementById("myModal");
    modal.style.display = "none";
}

window.onclick = function(event) {
    var modal = document.getElementById("myModal");
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

