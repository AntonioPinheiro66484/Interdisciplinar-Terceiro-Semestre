//We're going to use "check" to get the ckeckbox element
const check = document.getElementById("checkcontraste")

//If darkMode doesn’t exist in the LocalStorage, create it. False by default
if (localStorage.getItem('constraste') === null) {
    localStorage.setItem('constraste', "false");
}

//checkStatus is only called one time in the program, when you reload the page
//It gives the page it's default look, depening on waht darkMode is set to
checkStatus()

function checkStatus() {
    if (localStorage.getItem('constraste') === "true") {
        check.checked = true;                                       //the checkbox is checked (if you load the page by default it isn’t)
        document.getElementsByTagName("body")[0].style.color = "yellow";

        document.getElementsByTagName("p")[0].style.color = "yellow";   //the thext in the p is set to white
        document.body.style.backgroundColor = "black";            //the backgornd is set to a dark grey


    } else {
        check.checked = false;
        document.getElementsByTagName("body")[0].style.color = "black";

        document.getElementsByTagName("p")[0].style.color = "black";  //same CSS changes but for light mode
        document.body.style.backgroundColor = "#FFF";
        document.getElementById("product-title").style.color = "black";
        document.getElementById("product-price").style.color = "black";
    }
}

function changeStatus() {                                            //This function gets called every time the checkbox is clicked
    if (localStorage.getItem('constraste') === "true") {                 //if darkMode was active and this function is called it means the user now wants light
        localStorage.setItem('constraste', "false");                  //so we set it to false, to indicate we are in light mode
        document.getElementsByTagName("body")[0].style.color = "black";

        document.getElementsByTagName("p")[0].style.color = "black"; //same CSS changes as in checkStatus
        document.body.style.backgroundColor = "#FFF";
        document.getElementById("product-title").style.color = "black";
        document.getElementById("product-price").style.color = "black";

        //if ( document.getElementsByName("produto-titulo").classList.contains('product-title')) {
        //document.getElementsByName('produto-titulo').classList.remove("product-title");
        //document.getElementsByName('produto-titulo').classList.add("product-title-escuro");
        //}

        const titulos = document.getElementsByName("produto-titulo")
        for (let i = 0; i < titulos.length; i++) {
            if (titulos[i].classList.contains("product-title-escuro")) {
                titulos[i].classList.remove("product-title-escuro");
                titulos[i].classList.add("product-title");
            }
        }
        console.log(titulos[0].classList);

        const precos = document.getElementsByName("produto-preco")
        for (let i = 0; i < precos.length; i++) {
            if (precos[i].classList.contains("product-price-escuro")) {
                precos[i].classList.remove("product-price-escuro");
                precos[i].classList.add("product-price");
            }
        }
        console.log(precos[0].classList);
    } else {
        localStorage.setItem('constraste', "true");                   //same code but adapted for dark theme
        document.getElementsByTagName("body")[0].style.color = "yellow";

        document.getElementsByTagName("p")[0].style.color = "yellow";
        document.body.style.backgroundColor = "black";
        document.getElementById("product-title").style.color = "yellow";
        document.getElementById("product-price").style.color = "yellow";

        //if ( document.getElementsByName("produto-titulo").classList.contains('product-title-escuro')) {
        //document.getElementsByName('produto-titulo').classList.remove("product-title-escuro");
        //document.getElementsByName('produto-titulo').classList.add("product-title");
        //}

        const titulos = document.getElementsByName('produto-titulo')
        for (let i = 0; i < titulos.length; i++) {
            if (titulos[i].classList.contains('product-title')) {
                titulos[i].classList.remove("product-title");
                titulos[i].classList.add("product-title-escuro");
            }
        }
        console.log(titulos[0].classList);
        //console.log(document.getElementById("product-price").style)

        const precos = document.getElementsByName("produto-preco")
        for (let i = 0; i < precos.length; i++) {
            if (precos[i].classList.contains("product-price")) {
                precos[i].classList.remove("product-price");
                precos[i].classList.add("product-price-escuro");
            }
        }

        console.log(precos[0].classList);
    }

}