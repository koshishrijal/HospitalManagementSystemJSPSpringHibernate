<%@include file="header.jsp"%>
</head>
<body>
    <div class="container">
        <h1 class="label-warning">Room Manage</h1>
        <div class="row">
            <div class="col-md-6">
                <h2>Rooms Table</h2>
                <table class="table table-bordered table-hover">
                    <tr>
                        <th class="warning">Status(Active=1/InActive=0)</th>
                        <th class="warning">Type</th>
                    </tr>

                    <c:forEach var="room" items="${roomList}">
                        <tr>
                            <td class="info">${room.status}</td>
                            <td class="info">${room.roomType}</td>
                            <td style="background-color:red"><button class="delete" value="${room.roomId}">DELETE</button></td>
                            <td style="background-color:green"><button class="edit" value="${room.roomId} " roomStatus="${room.status}" roomType="${room.roomType}">EDIT</button></td>
                        </tr>
                    </c:forEach> 

                </table>
            </div>
            <div class="col-md-6">
                <h2 class="label-info">Insert Room</h2>
                <form id="room-insert-form" method="post">

                    <label>Status</label>
                    <select name="status" class="form-control">
                        <option value="1">True</option>
                        <option value="0">False</option>
                    </select>
                    <label>Room Type</label>
                    <input list="roomList" name="roomType" class="form-control"/>
                    <datalist id="roomList">
                        <option value="ICU">
                        <option value="CCU">
                        <option value="GeneralWard">
                        <option value="VIPWard">
                    </datalist>
                    <button type="button" id="room-insert-form-submit">Submit</button>
                </form>

            </div>
        </div>

    </div>
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Edit Room</h4>
                </div>
                <div class="modal-body">
                    <form method="post" id="room-edit-form">
                        <input type="hidden" name="roomId" id="selected-room-id"/>
                        <label>Room Status</label>
                        <select name="status" class="form-control">
                            <option value="1">True</option>
                            <option value="0">False</option>
                        </select>
                        <label>Room Type</label>
                        <input list="roomList" name="roomType" value="" id="selected-room-type" class="form-control"/>
                        <datalist id="roomList">
                            <option value="ICU">
                            <option value="CCU">
                            <option value="GeneralWard">
                            <option value="VIPWard">

                        </datalist>
                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="submit-room-edit">Submit</button>
                </div>
            </div>

        </div>
    </div>

</body>
<script src="${BASE_URL}/resources/static/ajaxDeletePost.js"></script>
<script>
    $("document").ready(function () {
        $("#room-insert-form-submit").on("click", function () {
            $.post("${BASE_URL}/room/insert", $("#room-insert-form").serialize(), function (data) {
                alert(data);
                location.reload();
            });
            return false;
        });

        $("button.delete").on("click", function () {
            ajaxDeleteItem("${BASE_URL}", "/room/delete/", $(this).attr("value"));
        });
        $("button.edit").on("click", function () {
            var $selectedRoomType = $(this).attr("roomType");
            // var $selectedRoomStatus = $(this).attr("roomStatus");
            var $selectedRoomId = $(this).attr("value");
            //  $("#selected-room-status").val($selectedRoomStatus);
            $("#selected-room-type").val($selectedRoomType);
            $("#selected-room-id").val($selectedRoomId);
            $("#myModal").modal("show");
            $("#submit-room-edit").on("click", function () {
                $.post("${BASE_URL}/room/update", $("#room-edit-form").serialize(), function (data) {
                    alert(data);
                    location.reload();
                });
            });
        });
    });


</script>

</html>
