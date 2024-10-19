$(document).on("click", "#btnagregar", function(){
    $("#txtnomclase").val("");
    $("#txtmaxequi").val("");
    $("#hddequicod").val("0");
    listarCboEntrenador(0, 0);

    $("#modalclases").modal("show");
})

$(document).on("click", ".btnactualizar", function(){
    $("#txtnomclase").val($(this).attr("data-equinom"));
    $("#cboentrenador").empty();
        listarCboEntrenador($(this).attr("data-equient"));
    $("#txtmaxequi").val($(this).attr("data-equimax"));
    $("#hddequicod").val($(this).attr("data-equicod"));
    $("#modalclases").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/clases/register",
        contentType: "application/json",
        data: JSON.stringify({
            id: $("#hddequicod").val(),
            nombre_clase: $("#txtnomclase").val(),
            entrenador: $("#cboentrenador").val(),
            nromaximo: $("#txtmaxequi").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarclases()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalclases").modal("hide");
});

function listarclases(){
    $.ajax({
        type: "GET",
        url: "/clases/list",
        datatype:"json",
        success: function(resultado){
            $("#tblclase > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblclase > tbody").append(`<tr>`+
                `<td>${value.id}</td>`+
                `<td>${value.nombre_clase}</td>`+
                `<td>${value.entrenador.nombre + ' ' + value.entrenador.apellido}</td>`+
                `<td>${value.nromaximo}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-equicod="${value.id}" `+
                    `data-equinom="${value.nombre_clase}" `+
                    `data-equient="${value.entrenador.id}" `+
                    `data-equimax="${value.nromaximo}">Actualizar `+
                    `</button></td>`+
                    `<td><button type='button' class='btn btn-danger btneliminar' `+
                    `data-registro-id="${value.id}">Eliminar `+
                    `</button></td>`+
                `</tr>`);
            });
        }
    });
}

function listarCboEntrenador(id){
    $.ajax({
    type: "GET",
    url: "/profesores/get",
    datatype: "json",
    success: function(resultado){
        $.each(resultado, function(index, value){
            $("#cboentrenador").append(
                `<option value="${value.id}">${value.nombre} ${value.apellido}</option>`
            )
        });
        if(id > 0){
            $("#cboentrenador").val(id);
        }
    }
    })
}

$(document).ready(function() {
    // Evento click para el botón "Eliminar"
    $(document).on("click", ".btneliminar", function(){
        // Obtener el ID del alumno desde el atributo data-registro-id
        const claseId = parseInt($(this).data('registro-id'));

        // Construir la URL con el ID del alumno
        const url = `/clases/eliminar/${claseId}`; // Reemplazar con la URL real

        // Enviar solicitud AJAX para eliminar el registro
        $.ajax({
            url: url,  // Usar la URL construida
            method: 'DELETE',
            success: function(resultado) {
                if(resultado.respuesta){
                    listarclases()
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
