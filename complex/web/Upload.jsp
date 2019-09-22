<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Complexity Factor Tool</title>
    <link rel="icon" href="res/pi.png">

    <!-- bootstrap plugins -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="css/Home.css" type="text/css">

    <style>

    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row content" >
        <div class="col-sm-3 sidenav">
            <ul class="nav nav-pills nav-stacked">
                <li><a href="Home.jsp">Home</a></li>
                <li class="active"><a href="Upload.jsp">Upload File</a></li>
<%--                <li><a href="View.jsp">View Complexity</a></li>--%>
            </ul>
            <br>
        </div>

        <div class="col-sm-9">
            <h1 class="heading"><b>Complexity Measuring Tool</b></h1>
            <hr>
            <div class="upload">
                <!--*************************add content**************************-->
                <form method ="POST" action="FileUploadServlet" enctype='multipart/form-data'>
                <tr>
                    <td>Upload: </td>
                    <td><input type="file" name="codeFile"/></td>
                </tr>
                    <tr>
                        <td><button type = "submit" class="btn btn-success">View Complexity</button></td>
                </tr>
                </form>
            </div>
        </div>
    </div>
</div>

<footer class="container-fluid" align="right">
    <p>Bought to by: SPM_WE_37</p>
    <p id="timestamp" ></p>
    <script>
        document.getElementById("timestamp").innerHTML = Date();
    </script>
</footer>

</body>
</html>