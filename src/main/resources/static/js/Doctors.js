var host = "http://localhost:8081/api";

function mostrarInformacionDoc() {
    $.ajax({
        url: host + '/Doctor/all',
        type: 'GET',
        dataType: "JSON",
        success: function (respuesta) {
            tableRespuestaDoc(respuesta);
            //darSelectName();
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }
    });
    $.ajax({
        url: host + '/Specialty/all',
        type: 'GET',
        dataType: "JSON",
        success: function (respuesta) {
            llenarSelectDoc(respuesta);
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }
    });
}
function llenarSelectDoc(items){

    for (let j = 0; j < items.length; j++) {
        $('#specialty').append(`<option value="${items[j].id}" id="S${items[j].id}">${items[j].name}</option>`);
        $('#specialty').val("");
    }
     
}
$("#specialty").on('change', function(){
    console.log($("#specialty").val());
})
$(document).ready(function () { 
    mostrarInformacionDoc();
})

function tableRespuestaDoc(items) {
    let myTableDoc = `<table BORDER CELLPADDING=2 BORDERCOLOR='#7c65b1'><th scope='col'> FULL NAME </th><th> DEPARTMENT </th><th> GRADUATE YEAR </th><th> DESCRIPTION </th><th> SPECIALTY</th>`;
    for (let i = 0; i < items.length; i++) {
        myTableDoc += `<tr>`;
        myTableDoc += `<td>${items[i].name}</td>`;
        myTableDoc += `<td>${items[i].department}</td>`;
        myTableDoc += `<td>${items[i].year}</td>`;
        myTableDoc += `<td>${items[i].description}</td>`;
        myTableDoc += `<td>${items[0].specialty["name"]}</td>`;
        myTableDoc += `<td> <button onclick="finishActuDoc(${items[i].id},'${items[i].name}', '${items[i].department}', ${items[i].year}, '${items[i].description}')" style="background-color:#7c65b1; border-color:#563856; color:white;">Change</button></td>`;
        myTableDoc += `<td> <button onclick="borrarInformacionDoc(${items[i].id})" style="background-color:#7c65b1; border-color:#563856; color:white;">Delete</button></td>`;
        myTableDoc += `</tr>`;
    }
    $("#resultadoDoc").append(myTableDoc);
    myTableDoc = `</table>`;
}

function agregarInformacionDoc() {
    $.ajax({
        type: "POST",
        url: host + "/Doctor/save",
        data: JSON.stringify({
            id: $("#idDoc").val(),
            idSpecialty: $("#specialty").val(),
            year: $("#graduate_year").val(),
            department: $("#department").val(),
            name: $("#nameDoc").val(),
            description: $("#description").val(),
        }),
        contentType: "application/json"
    }).done(function (data) {
        $("#resultadoDoc").empty();
        $("#idDoc").val(""),
        $("#specialty").val("");
        $("#graduate_year").val("");
        $("#department").val("");
        $("#nameDoc").val("");
        $("#description").val("");
        mostrarInformacionDoc();
        alert("Elementos de doctor agregados");//imprimimos respuesta
    }).fail(function (e) {
        alert("Algo salió mal");
    });
}

function finishActuDoc(id, name, department, graduate_year, description) {
    $("#idDoc").val(id),
    $("#nameDoc").val(name);
    $("#department").val(department);
    $("#graduate_year").val(graduate_year);
    $("#description").val(description);
}

function actualizarInformacionDoc() {
    $.ajax({
        method: 'PUT',
        url: host + '/Doctor/update',
        data: JSON.stringify({
            id: $("#idDoc").val(),
            specialty: $("#specialty").val(),
            year: $("#graduate_year").val(),
            department: $("#department").val(),
            name: $("#nameDoc").val(),
            description: $("#description").val(),
        }),
        contentType: "application/JSON",
    }).done(function (data) {
        $("#resultadoDoc").empty();
        $("#graduate_year").val("");
        $("#department").val("");
        $("#nameDoc").val("");
        $("#description").val("")
        mostrarInformacionDoc();
        alert("Elementos de doctor actualizados");//imprimimos respuesta
    }).fail(function (e) {
        console.log(e);
        alert("Algo salió mal");
    });

}

function borrarInformacionDoc(id) {
    $.ajax({
        method: 'DELETE',
        url: host + '/Doctor/' + id,
        contentType: "application/JSON",
        success: function (data) {
            console.log(data);
            $("#resultadoDoc").empty();
            alert("Elementos de doctor se han eliminado");//imprimimos respuesta
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }, complete: function () {
            mostrarInformacionDoc();
        }
    });
}

