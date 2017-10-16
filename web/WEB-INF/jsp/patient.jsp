<%@include file="header.jsp" %>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1 class="label-warning">Patient Manage</h1>
            </div>                
        </div>
        <div class="row">
            <div class="col-md-12">
                <h2 class="label-info">Patient Details</h2>
                <table class="table table-bordered table-hover">
                    <tr class="label-danger">
                        <th>Patient Name</th>
                        <th> Age</th>
                        <th>Gender</th>
                        <th>Phone Number</th>
                        <th>Email </th>
                        <th>Address</th>
                        <th>Date Added</th>
                        <th>Doctor Name</th>
                        <th>disease Name</th>
                    </tr>
                    <c:forEach var="patient" items="${patientList}"> 
                        <tr class="label-info">
                            <td>${patient.patientName}</td>
                            <td>${patient.age}</td>
                            <td>${patient.gender}</td>
                            <td>${patient.phoneNumber}</td>
                            <td>${patient.email}</td>
                            <td>${patient.address}</td>
                            <td>${patient.dateAdded}</td>
                            <td>${patient.doctor.doctorName}</td>
                            <td>${patient.disease.diseaseName}</td>
                            <td style="background-color: green"><button>EDIT</button></td>
                            <td style="background-color:red"><button>DELETE</button></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            </div>
        <div class="row">
            <div class="col-md-6">
                <form method="post" >
                    <label >Patient Name</label>
                    <input name="patientName"/>
                    <label > Age</label>
                    <input name="patientName"/>
                    <label >Gender</label>
                    <input name="patientName"/>
                    <label >Phone Number</label>
                    <input name="patientName"/>
                    <label >Email </label>
                    <input name="patientName"/>
                    <label >Address</label>
                    <input name="patientName"/>
                    <label >Date Added</label>
                    <input name="patientName"/>
                    <label >Doctor </label>
                    <select></select>
                    <label >Disease</label>
                    <button >Submit</button>

                </form>

            </div>
        </div>

        
    </div>
</body>
<script>

</script>
</html>
