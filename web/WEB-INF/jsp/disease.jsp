
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-offset-4">
                <label class="label-default"><h1>Disease Manager</h1></label>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <table class="table table-bordered table-hover">
                    <tr>
                        <th class="warning"><h2>Disease Name</h2></th>
                    <th class="warning"><h2>Days Opening</h2></th>
                    </tr>
                    <c:forEach var="disease" items="${diseaseList}">
                        <tr>
                            <td class="success">${disease.diseaseName}</td>
                            <td class="success">${disease.dayOpening}</td>
                            <td style="background-color: green" ><button class="edit" value="${disease.diseaseId}" diseaseName="${disease.diseaseName}" dayopening="${disease.dayOpening}"  > EDIT</button></td>
                            <td style="background-color: red" ><button class="delete" value="${disease.diseaseId}">DELETE</button></td>
                        <tr>
                        </c:forEach>
                </table>
            </div>
            <div class="col-md-6">
                <label class="label-danger">Insert Disease category</label>
                <form id="disease-form" method="post">
                    <label >Disease Name</label>
                    <input type="text" name="diseaseName" class="form-control" value=""/>
                    <label class="">Days Opening</label>
                    <input type="text" name="dayOpening" class="form-control" value=""/>
                    <input type="submit" value="Insert" id="submit-button"/>
                </form>
            </div>
        </div>
    </div>
    <!-- Modal content for editing the disesase category -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Edit Disease Category</h4>
                </div>
                <div class="modal-body">
                    <form method="post" id="disease-edit-form">
                        <label>Disease Name</label>
                        <input type="text"id="disease-name-edit" value="heart disease" name="diseaseName" class="form-control"/>
                        <label>Days opening</label>
                        <input type="text" id="disease-opening-day-edit" value="sunday,monday" name="dayOpening" class="form-control"/>
                        <input type="hidden" name="diseaseId" value="" id="disease-id-edit"/>
                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="submit-disease-edit">Submit</button>
                </div>
            </div>

        </div>
    </div>

</body>
<script src="${BASE_URL}/resources/static/ajaxDeletePost.js"></script>
<script>
   
    $('document').ready(function () {
        
   
        $("button.delete").on("click", function () {
            //pass path to delete without base url and pass id of selected item
          ajaxDeleteItem("${BASE_URL}","/disease/delete/",$(this).attr("value"));

        });
      
      
        $("#submit-disease-edit").on("click", function () {
            $.post("${BASE_URL}/disease/update", $("#disease-edit-form").serialize(), function (data) {
                     alert(data);
                    location.reload();

            });
            return false;
        });


        $("button.edit").on("click", function () {
            var $diseaseName = $(this).attr("diseaseName");
            var $dayOpening = $(this).attr("dayOpening");
            var $diseaseId = $(this).attr("value");
            console.log($diseaseId);
            
            $("#disease-name-edit").val($diseaseName);
            $("#disease-opening-day-edit").val($dayOpening);
            $("#disease-id-edit").val($diseaseId);
            $("#myModal").modal('show');

        });


        $("#submit-button").click(function () {
           
            $.post("${BASE_URL}/disease/insert", $("#disease-form").serialize(), function (data) {
                alert(data);
                location.reload();

            });
            return false;
        });

    });

</script>
</html>
