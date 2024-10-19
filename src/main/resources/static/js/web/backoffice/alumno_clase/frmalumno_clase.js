$(document).on("click", "#btnagregar", function(){
    $("#cboalumno").empty();
    $("#cboclase").empty();
    listarCboAlumnos(0);
    listarCboClase(0);
    $("#txtfchreg").val("");
    $("#hddaleq").val("0");
    $("#switchactivo").hide();
    $("#cbactivo").prop("checked", true);
    $("#modalbailarines").modal("show");
})

$(document).on("click", ".btnactualizar", function(){
    $("#cboalumno").empty();
    $("#cboclase").empty();
    listarCboAlumnos($(this).attr("data-aleqa"));
    listarCboClase($(this).attr("data-aleqe"));
    $("#txtfchreg").val($(this).attr("data-aleqfch"));
    $("#hddaleq").val($(this).attr("data-aleqcod"));
    $("#switchactivo").show();
    $("#modalbailarines").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/alumno_clase/register",
        contentType: "application/json",
        data: JSON.stringify({
            id: $("#hddaleq").val(),
            alumno: $("#cboalumno").val(),
            clase: $("#cboclase").val(),
            fecha_registro: $("#txtfchreg").val(),
            activo: $("#cbactivo").prop("checked")
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarbailarines()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalbailarines").modal("hide");
});

function listarbailarines(){
    $.ajax({
        type: "GET",
        url: "/alumno_clase/list",
        datatype:"json",
        success: function(resultado){
            $("#tblalumno_clase > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblalumno_clase > tbody").append(`<tr>`+
                `<td>${value.id_alumno_clase}</td>`+
                `<td>${value.alumno.nombre}</td>`+
                `<td>${value.clase.nombre_clase}</td>`+
                `<td>${value.fecha_registro}</td>`+
                `<td>${value.activo}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-aleqcod="${value.id_alumno_clase}" `+
                    `data-aleqa="${value.alumno.id}" `+
                    `data-aleqe="${value.clase.id}" `+
                    `data-aleqfch="${value.fecha_registro}" `+
                    `data-aleqact="${value.activo}">Actualizar `+
                    `</button></td>`+
                    `<td><button type='button' class='btn btn-danger btneliminar' `+
                    `data-registro-id="${value.id}">Eliminar `+
                    `</button></td>`+
                `</tr>`);
            });
        }
    });
}

function listarCboClase(id){
    $.ajax({
    type: "GET",
    url: "/clases/list",
    datatype: "json",
    success: function(resultado){
        $.each(resultado, function(index, value){
            $("#cboclase").append(
                `<option value="${value.id}"> ${value.nombre_clase}</option>`
            )
        });
            if(id > 0){
                $("#cboclase").val(id);
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
        const alumno_claseId = parseInt($(this).data('registro-id'));

        // Construir la URL con el ID del alumno
        const url = `/alumno_clase/eliminar/${alumno_claseId}`; // Reemplazar con la URL real

        // Enviar solicitud AJAX para eliminar el registro
        $.ajax({
            url: url,  // Usar la URL construida
            method: 'DELETE',
            success: function(resultado) {
                if(resultado.respuesta){
                    listarbailarines()
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

