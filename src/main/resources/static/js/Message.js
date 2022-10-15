var host = "http://localhost:8081/api";

function mostrarInformacionMes() {
    $.ajax({
        url: host + '/Message/all',
        type: 'GET',
        dataType: "JSON",
        success: function (respuesta) {
            tablaRespuestaMes(respuesta);
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }
    });
    $.ajax({
        url: host + '/Client/all',
        type: 'GET',
        dataType: "JSON",
        success: function (respuesta) {
            llenarCli(respuesta);
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }
    });$.ajax({
        url: host + '/Doctor/all',
        type: 'GET',
        dataType: "JSON",
        success: function (respuesta) {
            llenarDoc(respuesta);

        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }
    });
}
function llenarCli(items){
    for (let l = 0; l < items.length; l++) {
        $('#client').append(`<option value="${items[l].id}">${items[l].name}</option>`);
        $('#client').val("");
    } 
}
function llenarDoc(items){
    for (let k = 0; k < items.length; k++) {
        $('#doctor').append(`<option value="${items[k].id}">${items[k].name}</option>`);
        $('#doctor').val("");
    }
}
$(document).ready(function () {
    mostrarInformacionMes();
})

function tablaRespuestaMes(items) {
    let myTableMes = `<table BORDER CELLPADDING=2 BORDERCOLOR='#7c65b1'><th scope='col'> MESSAGE </th><th>DOCTOR</th><th>CLIENT</th>`;
    for (let i = 0; i < items.length; i++) {
        myTableMes += `<tr>`;
        myTableMes += `<td>${items[i].messageText}</td>`;
        myTableMes += `<td>${items[i].client["name"]}</td>`;
        myTableMes += `<td>${items[i].doctor["name"]}</td>`;
        myTableMes += `<td> <button onclick="finishActuMes(${items[i].idMessage},'${items[i].messageText}')" style="background-color:#7c65b1; border-color:#563856; color:white;">Change</button></td>`;
        myTableMes += `<td> <button onclick="borrarInformacionMes(${items[i].idMessage})" style="background-color:#7c65b1; border-color:#563856; color:white;">Delete</button>`;
        myTableMes += `</tr>`;
    }
    $("#resultadoMes").append(myTableMes);
    myTableMes = `</table>`;
}

function agregarInformacionMes() {
    $.ajax({
        type: "POST",
        url: host + "/Message/save",
        data: JSON.stringify({
            idMessage: $("#idMes").val(),
            messageText: $("#messageText").val(),
            client: $("#client").val(),
            doctor: $("#doctor").val(),
        }),
        contentType: "application/json"
    }).done(function (data) {
        $("#resultadoMes").empty();
        $("#messageText").val("");
        $("#client").val("");
        $("#doctor").val("");
        mostrarInformacionMes();
        alert("Elementos de mensaje agregados");//imprimimos respuesta
    }).fail(function (e) {
        alert("Algo salió mal");
    });
}

function finishActuMes(id, messagetext) {
    $("#idMes").val(id);
    $("#messageText").val(messagetext);
}

function actualizarInformacionMes() {
    $.ajax({
        method: 'PUT',
        url: host + '/Message/update',
        data: JSON.stringify({
            messageText: $("#messageText").val(),
            idMessage: $("#idMes").val(),
        }),
        contentType: "application/JSON"
    }).done(function (data) {
        $("#resultadoMes").empty();
        $("#idMes").val("");
        $("#messageText").val("");
        $("#client").val("");
        $("#doctor").val("");
        mostrarInformacionMes();
        alert("Elementos de mensaje actualizados");//imprimimos respuesta
    }).fail(function (e) {
        console.log(e);
        alert("Algo salió mal");
    });
}

function borrarInformacionMes(id) {
    $.ajax({
        method: 'DELETE',
        url: host + '/Message/' + id,
        contentType: "application/json",
        success: function (data) {
            $("#resultadoMes").empty();
            alert("Elementos de mensaje se han eliminado");//imprimimos respuesta
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }, complete: function () {
            mostrarInformacionMes();
        }
    });
}