$(document).ready(function() {
    $('#datetimepicker1').datetimepicker({
        format: 'DD/MM/YYYY'
    });
    $('#datetimepicker2').datetimepicker({
        format: 'DD/MM/YYYY'
    });
});

function search() {
    const data = $("#frmSearch").serialize();
    $.ajax({
        url: "/quanly/thongkesach/seach",
        dataType: "json",
        type: "GET",
        data: data,
        beforeSend: function () {
            $("body .wrapper").css('opacity', 0.3);
            $("#loader").show();
        },
        success: function (result) {
            if (result.status = 200) {
                const thongKeSachList = result.thongKeSachList;
                for (const thongKeSach of thongKeSachList) {
                    const newTrTag = document.createElement("tr");
                    var html = "<td><span>" + thongKeSach.maSach + "</span></td>";
                    html += "<td><span>" + thongKeSach.tenSach + "</span></td>";
                    html += "<td><span>" + thongKeSach.tacGia + "</span></td>";
                    html += "<td><span>" + thongKeSach.maVach + "</span></td>";
                    html += "<td><span>" + thongKeSach.tongSoLuotMuon + "</span></td>";
                    html += "<td><button type='button' class='btn btn-search' onclick='showDanhSachTacGia(this)' data-bookId='" + thongKeSach.id + "'>Chọn</button></td>";
                    newTrTag.innerHTML = html;
                    newTrTag.innerHTML = html;
                    tblThongKeSach.appendChild(newTrTag);
                }
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