$(document).ready(function() {
    // Delegación de eventos para el botón de verificación
    $('.form-information-childs').on('click', '.verificar', function() {
        var selectedBrand = $('#brand').val();
        console.log(selectedBrand);
        
        $.ajax({
            url: '/api/user/model/' + selectedBrand, // La URL de tu endpoint que devuelve el fragmento actualizado
            method: 'GET',
            success: function(data) {
                $('.model').empty().html(data);
            },
            error: function() {
                alert('Error al actualizar los elementos');
            }
        });
    });

    // Delegación de eventos para los botones de desplazamiento
    $(".form-information-childs").on("click", ".scroll-left-button", function() {
        $(".grid-button").animate({
            scrollLeft: "-=100px" // Puedes ajustar la cantidad de desplazamiento según tu diseño
        }, "fast");
    });

    $(".form-information-childs").on("click", ".scroll-right-button", function() {
        $(".grid-button").animate({
            scrollLeft: "+=100px" // Puedes ajustar la cantidad de desplazamiento según tu diseño
        }, "fast");
    });

    // Desactiva el scroll horizontal predeterminado del ratón
    $(".form-information-childs").on("wheel", ".grid-button", function(e) {
        e.preventDefault();
        $(".grid-button").stop().animate({
            scrollLeft: $(".grid-button").scrollLeft() + (e.originalEvent.deltaY * 30)
        }, 5);
    });

    $('.model').on('click', '.buttonCategory', function() {
        $('.buttonCategory').removeClass('selected').css('background-color', '');
        $(this).addClass('selected').css('background-color', '#FFCF28');
        var modelId = $(this).data('model-id');
        console.log("Modelo seleccionado: " + modelId);
    });

});

const btnSignIn = document.getElementById("sign-in"),
    btnSignUp = document.getElementById("sign-up"),
    containerFormRegister = document.querySelector(".register"),
    containerFormLogin = document.querySelector(".login");

btnSignIn.addEventListener("click", e => {
    containerFormRegister.classList.add("hide");
    containerFormLogin.classList.remove("hide")
});

btnSignUp.addEventListener("click", e => {
    containerFormLogin.classList.add("hide");
    containerFormRegister.classList.remove("hide")
});

$(document).ready(function() {
    var currentYear = new Date().getFullYear();
    var startYear = 1960;
    var options = "<option value='' disabled selected>Año del modelo</option>";

    for (var year = currentYear; year >= startYear; year--) {
        options += "<option value='" + year + "'>" + year + "</option>";
    }

    $('#yearSelect').html(options);
});

function fetchYearsAndCilinders() {

    $.ajax({
        type: "GET",
        url: "/obtener-datos",
        data: {
            marca: marca,
            modelo: modelo
        },
        success: function(data) {
            // Limpiar y actualizar los desplegables de año y cilindraje
            $('#año').empty();
            $('#cilindraje').empty();

            // Llenar los desplegables con los datos recibidos
            data.años.forEach(function(año) {
                $('#año').append('<option value="' + año + '">' + año + '</option>');
            });

            data.cilindrajes.forEach(function(cilindraje) {
                $('#cilindraje').append('<option value="' + cilindraje + '">' + cilindraje + '</option>');
            });
        },
        error: function() {
            alert('Error al obtener los datos.');
        }
    });
}


$(document).ready(function() {
    // Evento al hacer clic en el botón de verificación
    $('.buttonn').on('click', function() {
        var selectedBrand = $('#brand').val();  // Captura el valor seleccionado de la marca
        var selectedModel = $('.buttonCategory.selected').data('model-id');  // Captura el ID del modelo seleccionado
        var selectedYear = $('#yearSelect').val();  // Captura el año seleccionado
        var selectedCylinder = $('#cylinderSelect').val();  // Captura el cilindraje seleccionado
        console.log(selectedModel);
        console.log(selectedBrand);
        
        
    });


    // Otros eventos y funciones según sea necesario
});

$(document).ready(function() {
    $('#quote').on('submit', function(event) {
        event.preventDefault();
        // Obtener los valores seleccionados
        var selectedBrand = $('#brand').val();
        var selectedYear = $('#yearSelect').val();
        var selectedCylinder = $('#cylinderSelect').val();
        var selectedModel = $('.buttonCategory.selected').data('model-id');

        // Construir la URL con los parámetros de consulta
        var url = '/api/quote?' +
                  'brand=' + encodeURIComponent(selectedBrand) +
                  '&year=' + encodeURIComponent(selectedYear) +
                  '&cylinder=' + encodeURIComponent(selectedCylinder) +
                  '&model=' + encodeURIComponent(selectedModel);

        // Redirigir a la página de resultados con los parámetros
        window.location.href = url;
    });
});

$(document).ready(function() {
    // Manejar el envío del formulario de inicio de sesión
    $('#login').on('submit', function(event) {
        // Evitar el envío del formulario por defecto
        event.preventDefault();
        
        // Realizar validaciones si es necesario
        
        // Redirigir a la página HTML estática
        window.location.href = '/html/functionAdmin.html';
    });
});
