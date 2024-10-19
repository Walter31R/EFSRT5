$(document).on("click", "#btnagregar", function(){
    $("#txtdnialu").val("");
    $("#txtnomalu").val("");
    $("#txtapealu").val("");
    $("#txtfecalu").val("");
    $("#txtdiralu").val("");
    $("#txttelalu").val("");
    $("#hddalucod").val("0");

    $("#modalalumnos").modal("show");
})

$(document).on("click", ".btnactualizar", function(){
    $("#txtdnialu").val($(this).attr("data-aludni"));
    $("#txtnomalu").val($(this).attr("data-aluname"));
    $("#txtapealu").val($(this).attr("data-alulast"));
    $("#txtfecalu").val($(this).attr("data-alufec"));
    $("#txtdiralu").val($(this).attr("data-aludir"));
    $("#txttelalu").val($(this).attr("data-alutel"));
    $("#hddalucod").val($(this).attr("data-alucod"));

    $("#modalalumnos").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/alumnos/register",
        contentType: "application/json",
        data: JSON.stringify({
            id: $("#hddalucod").val(),
            dni: $("#txtdnialu").val(),
            nombre: $("#txtnomalu").val(),
            apellido: $("#txtapealu").val(),
            fecha_nacimiento: $("#txtfecalu").val(),
            direccion: $("#txtdiralu").val(),
            telefono: $("#txttelalu").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarAlumnos()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalalumnos").modal("hide");
});

function listarAlumnos(){
    $.ajax({
        type: "GET",
        url: "/alumnos/list",
        datatype:"json",
        success: function(resultado){
            $("#tblalumno > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblalumno > tbody").append(`<tr>`+
                `<td>${value.id}</td>`+
                `<td>${value.dni}</td>`+
                `<td>${value.nombre}</td>`+
                `<td>${value.apellido}</td>`+
                `<td>${value.fecha_nacimiento}</td>`+
                `<td>${value.direccion}</td>`+
                `<td>${value.telefono}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-alucod="${value.id}" `+
                    `data-aludni="${value.dni}" `+
                    `data-aluname="${value.nombre}" `+
                    `data-alulast="${value.apellido}" `+
                    `data-alufec="${value.fecha_nacimiento}" `+
                    `data-aludir="${value.direccion}" `+
                    `data-alutel="${value.telefono}">Actualizar `+
                    `</button></td>`+
                `<td><button type='button' class='btn btn-danger btneliminar' `+
                    `data-registro-id="${value.id}">Eliminar `+
                    `</button></td>`+
                `</tr>`);
            });
        }
    });
}

$(document).ready(function() {
    // Evento click para el botón "Eliminar"
    $(document).on("click", ".btneliminar", function(){
        // Obtener el ID del alumno desde el atributo data-registro-id
        const alumnoId = parseInt($(this).data('registro-id'));

        // Construir la URL con el ID del alumno
        const url = `/alumnos/eliminar/${alumnoId}`; // Reemplazar con la URL real

        // Enviar solicitud AJAX para eliminar el registro
        $.ajax({
            url: url,  // Usar la URL construida
            method: 'DELETE',
            success: function(resultado) {
                if(resultado.respuesta){
                    listarAlumnos()
                }
                alert(resultado.mensaje);
            },
            error: function(error) {
                // Mostrar mensaje de error
                console.error("Error al eliminar el registro:", error);
            }
        });
    });
});
