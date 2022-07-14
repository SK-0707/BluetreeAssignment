<%@ page isELIgnored = "false" %>
<html>

<head>
<title>BlueTree Assignment</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
</head>

<body>

<div class="container">
  <h1 style="text-align:center"><b>Employee Details<b></h1>
<table class="table table-bordered border-primary">
 <thead>
        <th>Employee-Id</th>
        <th>Employee-Name</th>
        <th>Email-Id</th>
        <th>Date Of Birth</th>
        <th>Age</th>
        <th>Salary (p-m)</th>
        <th>Status</th>
        <th>Options</th>
  </thead>
   <tbody>
          <c:forEach items="${empData}" var="e">
              <tr>
                  <td>${e.empId}</td>
                  <td>${e.empName}</td>
                  <td>${e.email}</td>
                  <td>${e.dob}</td>
                  <td>${e.age}</td>
                  <td>${e.salary}</td>
                  <td>${e.status}</td>
                  <td>
                      <a href="deletermp?empId=${e.empId}" class="btn btn-danger">
                               <b> <span class="glyphicon glyphicon-trash"></span> Delete </b>
                      </a>
                              <span>   </span>
                        <a href="updateinfo?empId=${e.empId}" class="btn btn-success">
                         <b> <span class="glyphicon glyphicon-edit"></span> Edit </b>
                         </a>
                  </td>
              </tr>
          </c:forEach>

      </tbody>
</table>
<a href="addemployee" class="btn btn-info"> <b> <span class="glyphicon glyphicon-plus"></span> ADD Employee </b></a>
</div>
</body>
</html>



