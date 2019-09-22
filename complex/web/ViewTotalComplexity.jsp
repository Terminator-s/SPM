<%@page import="file.ComplexityFactors" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
    <div class="row content">
        <div class="col-sm-3 sidenav">
            <ul class="nav nav-pills nav-stacked">
                <li><a href="Home.jsp">Home</a></li>
                <li><a href="Upload.jsp">Upload File</a></li>
                <%--                <li><a href="View.jsp">View Complexity</a></li>--%>
            </ul>
            <br>
        </div>

        <div class="col-sm-9">
            <h1 class="heading"><b>Complexity Measuring Tool</b></h1>
            <hr>
            <div class="scrollable">

                <table class="table">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">Line No</th>
                        <th scope="col">Program statements</th>
                        <th scope="col">Tokens identified under the size factor</th>
                        <th scope="col">Cs</th>
                        <th scope="col">Ctc</th>
                        <th scope="col">Cnc</th>
                        <th scope="col">Ci</th>
                        <th scope="col">TW</th>
                        <th scope="col">Cps</th>
                        <th scope="col">Cr</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<ComplexityFactors> factors =
                                (ArrayList<ComplexityFactors>) request.getAttribute("factors");
                        int TotalCr = 0;
                        int TotalCps = 0;

                        for (ComplexityFactors s : factors) {%>
                    <tr>
                        <th scope="row"><%=s.getNoOfLines()%>
                        </th>
                        <th scope="col"><%=s.getLine()%>
                        </th>
                        <th scope="col"><%=s.getTokens()%>
                        </th>
                        <th scope="col"><%=s.getCs()%>
                        </th>
                        <th scope="col"><%=s.getCtc()%>
                        </th>
                        <th scope="col"><%=s.getCnc()%>
                        </th>
                        <th scope="col"><%=s.getCi()%>
                        </th>
                        <th scope="col"><%=s.getTW()%>
                        </th>
                        <th scope="col"><%=s.getCps()%>
                        </th>
                        <th scope="col"><%=s.getCr()%>
                        </th>
                    </tr>
                    <%
                        TotalCps += s.getCps();
                        TotalCr += s.getCr();
                    %>
                    <%}%>
                    <tr>
                        <th scope="row"></th>
                        <th scope="col"></th>
                        <th scope="col"><H4 style="color:red;"><B>Cp</B></H4></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"><H4 style="color:red;"><%=TotalCps + TotalCr%>
                        </H4></th>
                    </tr>
                    <%%>
                    </tbody>
                </table>
            </div>

            <div>
<%--                <form method="POST" action="download" enctype='multipart/form-data'>--%>
                    <button type="button" class="btn btn-success" >download</button>
<%--                </form>--%>
            </div>
        </div>
    </div>
</div>

<footer class="container-fluid" align="right">
    <p>Bought to by: SPM_WE_37</p>
    <p id="timestamp"></p>
    <script>
        document.getElementById("timestamp").innerHTML = Date();
    </script>
</footer>

</body>
</html>