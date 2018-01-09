// TODO: move down variables and see if javascript parses it the wright way
function* htmlsSeqDown(){
    for(var name of ["c0106", "c0712", "c1318", "c1924", "c2530", "c3136", "c3741", "aps"]){
        yield name;
    }
}

var cuesMap = {"c0106":"#toc_id_4", "c0712":"#toc_id_20", "c1318":"#toc_id_40",
               "c1924":"#toc_id_50", "c2530":"#toc_id_60", "c3136":"#toc_id_70",
               "c3741":"#toc_id_90", "aps":"#toc_id_130"
              };
var generator = htmlsSeqDown();
var lastScrollTop = 0;
var nextShown;
var lastShown = document.querySelector(cuesMap["c0106"]).getBoundingClientRect().top;
var scrollTimer = null;
var element;

// function used to reveal 6 chapters of the manual on scrolling
function revealText(){
    var st = document.body.scrollTop;
    if(st > lastScrollTop){
        //scrolling down
        if(st > lastShown){
            nextShown = generator.next().value
            if(nextShown === undefined){
                // generator values has reached the last one
                lastScrollTop = st;
                scrollTimer = null;
                window.removeEventListener('scroll', setupTimer);
                return;
            }

            var xhr = new XMLHttpRequest();
            xhr.open("GET", `${nextShown}.html`);
            xhr.onreadystatechange=function(){
                $("html").append(xhr.responseText); // TODO: make this work without jQuery
                element = document.querySelector(cuesMap[nextShown]);
                if(element != null){
                    lastShown = element.getBoundingClientRect().top;
                }
            }
            xhr.send();
        }
    }
    lastScrollTop = st;
    scrollTimer = null;
}

function setupTimer(){
    if (scrollTimer) {
        return;
    }
    scrollTimer = setTimeout(revealText, 50);
}

// sets the timer for the scrolling function, used to reduce the times where the function is called
window.addEventListener('scroll', setupTimer);

