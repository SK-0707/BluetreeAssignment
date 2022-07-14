<%@ page isELIgnored = "false" %>

<html>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
</head>

<body>
<div class="container" style="margin:3%">

        <form class="form" action="submitdetails" method="POST" style="width: 50%; margin-left: 28%;border: 2px solid black;padding: 2%;">

              <h2 style="text-align:center"><b>New Registration</b></h2>
              <hr>

            <div class="form-group">
                <label for="name">Employee Name</label>
                <input type="text" class="form-control" name="empName" placeholder="Employee Full Name">
              </div>
             <div class="form-group">
                            <label for="exampleFormControlInput1">Email Id</label>
                            <input type="email" class="form-control" name="email" placeholder="name@example.com" required>
                        </div>
                        <div class="form-group">
                            <label for="dob">Date Of Birth</label>
                            <input type="date" class="form-control" name="dob" placeholder="Date Of Birth" required>
                        </div>
                        <div class="form-group">
                            <label for="salary">Salary</label>
                            <input type="number" class="form-control" name="salary" placeholder="Salary">
                        </div>
                        <div class="form-group">
                            <label for="dob">Status</label>
                            <select class="form-control" name="status">
                                <option value="true">Active</option>
                                <option value="false">Inactive</option>
                              </select>
                        </div>
                          <button class="btn btn-success" type="submit" ><b><span class="glyphicon glyphicon-floppy-disk"> </span> Add Employee</b></button>

            </div>


        </form>
      </div>
</body>
</html>