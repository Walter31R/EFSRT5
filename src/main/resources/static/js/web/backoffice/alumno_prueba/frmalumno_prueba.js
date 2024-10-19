$(document).on("click", "#btnagregar", function(){
    $("#cboalumno").empty();
    $("#cboprueba").empty();
    listarCboAlumnos(0);
    listarCboPruebas(0);
    $("#txtresprueba").val("");
    $("#txtfchprueba").val("");
    $("#hddalpru").val("0");
    $("#modalresultados").modal("show");
})

$(document).on("click", ".btnactualizar", function(){
    $("#cboalumno").empty();
    $("#cboprueba").empty();
    listarCboAlumnos($(this).attr("data-alprua"));
    listarCboPruebas($(this).attr("data-alprup"));
    $("#txtresprueba").val($(this).attr("data-alprures"));
    $("#txtfchprueba").val($(this).attr("data-alprufch"));
    $("#hddalpru").val($(this).attr("data-alprucod"));
    $("#modalresultados").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/alumno_prueba/register",
        contentType: "application/json",
        data: JSON.stringify({
            id: $("#hddalpru").val(),
            alumno: $("#cboalumno").val(),
            prueba: $("#cboprueba").val(),
            resultados: $("#txtresprueba").val(),
            fecha_prueba: $("#txtfchprueba").val(),
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarresultados()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalresultados").modal("hide");
});

function listarresultados(){
    $.ajax({
        type: "GET",
        url: "/alumno_prueba/list",
        datatype:"json",
        success: function(resultado){
            $("#tblalumno_prueba > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblalumno_prueba > tbody").append(`<tr>`+
                `<td>${value.id_alumno_prueba}</td>`+
                `<td>${value.alumno.nombre}</td>`+
                `<td>${value.prueba.tipo_prueba}</td>`+
                `<td>${value.resultados}</td>`+
                `<td>${value.fecha_prueba}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-alprucod="${value.id_alumno_prueba}" `+
                    `data-alprua="${value.alumno.id}" `+
                    `data-alprup="${value.prueba.id}" `+
                    `data-alprures="${value.resultados}" `+
                    `data-alprufch="${value.fecha_prueba}">Actualizar `+
                    `</button></td>`+

                    `<td><button type='button' class='btn btn-danger btneliminar' `+
                    `data-registro-id="${value.id}">Eliminar `+
                    `</button></td>`+
                `</tr>`);
            });
        }
    });
}

function listarCboPruebas(id){
    $.ajax({
    type: "GET",
    url: "/pruebas/list",
    datatype: "json",
    success: function(resultado){
        $.each(resultado, function(index, value){
            $("#cboprueba").append(
                `<option value="${value.id}"> ${value.tipo_prueba}</option>`
            )
        });
            if(id > 0){
                $("#cboprueba").val(id);
            }
        }
    })
}

function listarCboAlumnos(id){
    $.ajax({
    type: "GET",
    url: "/alumnos/list",
    datatype: "json",
    success: function(resultado){
        $.each(resultado, function(index, value){
            $("#cboalumno").append(
                `<option value="${value.id}"> ${value.nombre}</option>`
            )
        });
            if(id > 0){
                $("#cboalumno").val(id);
            }
        }
    })
}
$(document).ready(function() {
    // Evento click para el botón "Eliminar"
    $(document).on("click", ".btneliminar", function(){
        // Obtener el ID del alumno desde el atributo data-registro-id
        const alumno_pruebaId = parseInt($(this).data('registro-id'));

        // Construir la URL con el ID del alumno
        const url = `/alumno_prueba/eliminar/${alumno_pruebaId}`; // Reemplazar con la URL real

        // Enviar solicitud AJAX para eliminar el registro
        $.ajax({
            url: url,  // Usar la URL construida
            method: 'DELETE',
            success: function(resultado) {
                if(resultado.respuesta){
                    listarresultados()
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
