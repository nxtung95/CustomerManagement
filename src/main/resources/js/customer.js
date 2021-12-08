const removeHtmlElement = (arr) => {
    for (var i = arr.length - 1; i >= 0; --i) {
        arr[i].remove();
    }
}

function fillData(e) {
    $("#name1").val(e.getAttribute("data-companyName"));
    $("#address1").val(e.getAttribute("data-address"));
    $("#represent_name1").val(e.getAttribute("data-representName"));
    $("#total_price").val(e.getAttribute("data-totalPrice"));
    $("#btnEdit").attr("data-id", e.getAttribute("data-id"));
}

function printTable(result) {
    const customerListTable = document.getElementById("customerListTable");
    const oldTrTag = customerListTable.getElementsByTagName("tr");
    removeHtmlElement(oldTrTag);
    const customerList = result.customerList;
    var stt = 1;
    for (const customer of customerList) {
        const newTrTag = document.createElement("tr");
        var html = "<td><span>" + stt++ + "</span></td>";
        html += "<td><span>" + customer.companyName + "</span></td>";
        html += "<td><span>" + customer.address + "</span></td>";
        html += "<td><span>" + customer.representName + "</span></td>";
        html += "<td><span>" + customer.totalPrice + "</span></td>";
        html += "<td><button type='button' class='btn btn-search' data-toggle='modal' data-target='#editModal' onclick='fillData(this)' " +
            "data-id='" + customer.id + "' " +
            "data-companyName='" + customer.companyName + "' " +
            "data-address='" + customer.address + "' " +
            "data-representName='" + customer.representName + "' " +
            "data-totalPrice='" + customer.totalPrice + "'>" +
            "Sửa</button>" +
            "</td>";
        html += "<td><button type='button' class='btn btn-search' onclick='remove(this)' data-id='" + customer.id + "'>Xóa</button></td>";
        newTrTag.innerHTML = html;
        customerListTable.appendChild(newTrTag);
    }
}

function search() {
    const data = $("#frmSearch").serialize();
    $.ajax({
        url: "/app/manager/customer/search",
        dataType: "json",
        type: "GET",
        data: data,
        beforeSend: function () {
            $("body .wrapper").css('opacity', 0.3);
            $("#loader").show();
        },
        success: function (result) {
            if (result.status == "200") {
                printTable(result);
            }
        },
        error: function (jqXhr, textStatus, errorMessage) {
            console.log("Error: ", errorMessage);
        },
        complete: function () {
            $("#loader").fadeOut("slow");
            $("body .wrapper").fadeIn(600);
            $("body .wrapper").css('opacity', 1);
        }
    });
}

function add() {
    const data = $("#frmAdd").serialize();
    $.ajax({
        url: "/app/manager/customer",
        dataType: "json",
        contentType: "application/json",
        type: "POST",
        data: data,
        beforeSend: function () {
            $("body .wrapper").css('opacity', 0.3);
            $("#loader").show();
        },
        success: function (result) {
            if (result.status == "200") {
                printTable(result);
            }
        },
        error: function (jqXhr, textStatus, errorMessage) {
            console.log("Error: ", errorMessage);
        },
        complete: function () {
            $("#loader").fadeOut("slow");
            $("body .wrapper").fadeIn(600);
            $("body .wrapper").css('opacity', 1);
        }
    });
}

function edit(e) {
    const data = $("#frmEdit").serialize();
    const id = e.getAttribute("data-id");
    $.ajax({
        url: "/app/manager/customer" + id,
        dataType: "json",
        contentType: "application/json",
        type: "PUT",
        data: data,
        beforeSend: function () {
            $("body .wrapper").css('opacity', 0.3);
            $("#loader").show();
        },
        success: function (result) {
            if (result.status == "200") {
                printTable(result);
            }
        },
        error: function (jqXhr, textStatus, errorMessage) {
            console.log("Error: ", errorMessage);
        },
        complete: function () {
            $("#loader").fadeOut("slow");
            $("body .wrapper").fadeIn(600);
            $("body .wrapper").css('opacity', 1);
        }
    });
}

function remove(e) {
    var result = confirm("Bạn có chắc chắn muốn xóa khách hàng này không?");
    if (result) {
        const id = e.getAttribute("data-id");
        $.ajax({
            url: "/app/manager/customer/" + id,
            dataType: "json",
            type: "DELETE",
            beforeSend: function () {
                $("body .wrapper").css('opacity', 0.3);
                $("#loader").show();
            },
            success: function (result) {
                if (result.status == "200") {
                    printTable(result);
                }
            },
            error: function (jqXhr, textStatus, errorMessage) {
                console.log("Error: ", errorMessage);
            },
            complete: function () {
                $("#loader").fadeOut("slow");
                $("body .wrapper").fadeIn(600);
                $("body .wrapper").css('opacity', 1);
            }
        });
    }
}

function exportJsonFile() {

}

function exportXMLFile() {

}