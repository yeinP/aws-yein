const ani5 = gsap.timeline();
ani5.to(".containers .t1", {xPercent:150}, "text")
    .to(".containers .t2", {xPercent: -400}, "text")
    .to(".containers .t1_child", {xPercent: 150}, "text")
    .to(".containers .t2_child", {xPercent: -400}, "text")


ScrollTrigger.create({
    animation: ani5,
    trigger: ".pageani",
    start: "top top",
    end: "+=1000",
    scrub: true,
    pin: true,
    markers: true,
    anticipatePin: 0.5,
    onUpdate: self => {
        const progress = self.progress;
        const translateY = -progress * window.innerHeight * 2.5; // 페이지 2의 수직 이동량을 계산합니다.
        gsap.set(".page2", { y: translateY }); // 페이지 2의 위치를 변경합니다.
        gsap.set(".page3", { y: translateY });
        gsap.set(".page4", { y: translateY });
        if (self.progress > 0.55) {
            circleAnimation.play();
        } else {
            circleAnimation.reverse();
        }
    },

});



const circleAnimation = gsap.to(".homeCircle", {
    opacity: 0,
    duration: 0.2,
    ease: "power2.inOut",
    paused: true
});
const observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {

            document.querySelector('.evoGKi').style.transition = 'background-color 1s ease';
            document.querySelector('.evoGKi').style.backgroundColor = 'rgb(250, 216, 31)';
            document.querySelector('.ptitle').style.color = 'gray';
            document.querySelector('.skill .title').style.color = 'gray';
            document.querySelectorAll('.sk_title').forEach(function(element) {
                element.style.color = 'gray';
            });
            document.querySelectorAll('.strong__skill').forEach(function(element) {
                element.style.color = 'gray';
            });
            document.querySelectorAll('.strong__skill').forEach(function(element) {
                element.style.border = '0.2rem solid gray';
            });
        } else {
            // .p 요소가 화면에 보이지 않을 때 배경색 원래대로 변경
            document.querySelector('.evoGKi').style.transition = 'background-color 0.5s ease';
            document.querySelector('.evoGKi').style.backgroundColor = '';
            document.querySelector('.ptitle').style.color = 'rgb(250, 216, 31)';
            document.querySelector('.skill .title').style.color = 'rgb(250, 216, 31)';
            document.querySelectorAll('.sk_title').forEach(function(element) {
                element.style.color = '';
            });
            document.querySelectorAll('.strong__skill').forEach(function(element) {
                element.style.color = '';
            });
            document.querySelectorAll('.strong__skill').forEach(function(element) {
                element.style.border = '';
            });
        }
    });
});


const pElement = document.querySelector('.proBox');
observer.observe(pElement);
