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
                <br/>
                <li class="active"><a href="Home.jsp">Home</a></li>
                <li><a href="Upload.jsp">Upload File</a></li>
<%--                <li><a href="View.jsp">View Complexity</a></li>--%>
            </ul>
            <br>
        </div>

        <div class="col-sm-9">
            <h1 class="heading"><b>Complexity Measuring Tool</b></h1>
            <hr>
            <table >
                <tr>
                    <th class="column"><img class="bgImage" src="images/bgImage.jpg" alt="bgImage"></th>
                    <th class="column">
                        <table>
                            <tr>
                                <h2 class="description"><b>Complex is better</b></h2>
                                <p align="justify" class="description">
                                    Than complicated. It's OK to build very complex software, but
                                    you don't have to build it in a complicated way.
                                    Complexity Measuring Tool is a free open source tool that analyse
                                    the complexity of your source code right away supporting C++ and Java
                                    programming languages, without any extra setup. It also does code
                                    clone / copy-paste detection.
                                </p>
                            </tr>
                        </table>
                    </th>
                </tr>
            </table>
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