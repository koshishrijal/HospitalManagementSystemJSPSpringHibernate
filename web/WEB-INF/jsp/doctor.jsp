<%@include file="header.jsp" %>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <h1 class="text-danger">Doctor Manage</h1>
            </div>
        </div>
        <div class="jumbotron">
            <div class="row">
                <div class="col-md-6">
                    <table class="table table-bordered table-hover">
                        <tr>
                            <th class="warning">Doctor Name</th>
                            <th class="warning">Disease Category</th>
                        </tr>
                        <c:forEach var="doctor" items="${doctorList}">
                            <tr>
                                <td>${doctor.doctorName}</td>
                                <td>${doctor.disease.diseaseName}</td>
                                <td style="background-color:green"><button class="edit" value="${doctor.doctorId}" diseaseId="${doctor.disease.diseaseId}" doctorName="${doctor.doctorName}" diseaseName="${doctor.disease.diseaseName}">EDIT</button></td>
                                <td style="background-color:red"><button class="delete" value="${doctor.doctorId}">DELETE</button></td>
                            </tr>
                        </c:forEach>                      
                    </table>
                </div>
                <div class="col-md-6">
                    <h2 class="text-info">Insert Doctor </h2>
                    <form method="post" id="doctor-insert-form">
                        <label>Full Name</label>
                        <input type="text" name="doctorName" required="required" class="form-control"/>
                        <label>Disease</label>
                        <select name="disease.diseaseId">
                            <option value="">Disease Category</option>
                            <c:forEach var="disease" items="${diseaseList}">
                                <option value="${disease.diseaseId}">${disease.diseaseName}</option>    
                            </c:forEach>

                        </select>
                        <button class="button-a" id="doctor-insert-form-button">Submit</button>
                    </form>
                </div>

            </div>

        </div>

    </div>
  <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Edit Doctor</h4>
                </div>
                <div class="modal-body">
                    <form method="post" id="doctor-edit-form">
                        <input type="hidden" name="doctorId" id="doctor-id-edit"/>
                        <label>Doctor Name</label>
                        <input type="text"id="doctor-name-edit" value="heart disease" name="doctorName" class="form-control"/>
                        <select name="disease.diseaseId">
                            <option value="" id="disease-name-for-edit">Select Disease</option>
                            <c:forEach var="disease" items="${diseaseList}">
                                <option value="${disease.diseaseId}">${disease.diseaseName}</option>  
                                
                            </c:forEach>
                        </select>
                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="submit-doctor-edit">Submit</button>
                </div>
            </div>

        </div>
    </div>

</body>
<script src="${BASE_URL}/resources/static/ajaxDeletePost.js"></script>
<script>
    $("document").ready(function () {
        $("#doctor-insert-form-button").on("click", function () {
            $.post("${BASE_URL}/doctor/insert", $("#doctor-insert-form").serialize(), function (data) {
                alert(data);
                location.reload();
            });
            return false;
        });
        $("button.delete").on("click", function () {
        ajaxDeleteItem("${BASE_URL}","/doctor/delete/",$(this).attr("value"));
        });
    });

    $("button.edit").on("click",function(){
        var $doctorId=$(this).attr("value");
        var $doctorName=$(this).attr("doctorName");
        var $diseaseName=$(this).attr("diseaseName");
        var $diseaseId=$(this).attr("diseaseId");
       
        $("#doctor-name-edit").val($doctorName);
        $("#disease-name-for-edit").val($diseaseId);
        $("#doctor-id-edit").val($doctorId);
        
        $("#myModal").modal("show");
        $("#submit-doctor-edit").on("click",function(){
            $.post("${BASE_URL}/doctor/update",$("#doctor-edit-form").serialize(),function(data){
                alert(data);
                location.reload();
        });
        
        });
    
    });






</script>
</html>
