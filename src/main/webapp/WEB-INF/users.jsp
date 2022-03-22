<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </head>
    <body>
       
        
        <div class="container">
             <h1>User Management System</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>E-mail</th>                                      
                        <th>First Name</th>                                      
                        <th>Last Name</th>
                        <th>Active</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>
                                ${user.email}
                            </td>
                            <td>
                                ${user.firstName}
                            </td>
                            <td>
                                ${user.lastName}
                            </td>
                            <td>
                                ${user.active ? "Y" : "N"}
                            </td>
                            <td>
                                ${user.role.name}
                            </td>
                            <td>
<!--                                <a href="user?action=delete&email=${user.email}">Delete</a>-->
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        
        
            <div class="form">
                <div class="insert" style="float:left;" >           
                    <form action="user" method="post">
                        <h2>Insert User</h2>
                        <input type="hidden" name="action" value="add">
                        <label for="addEmail">Email:</label> 
                        <input type="text" name="addEmail" id="addEmail" value=""><br>
                        <label for="addFName">First Name:</label> 
                        <input type="text" name="addFName" id="addFName" value=""><br>
                        <label for="addLName">Last Name:</label> 
                        <input type="text" name="addLName" id="addLName" value=""><br>
                        <label for="addPassword">Password:</label> 
                        <input type="text" name="addPassword" id="addPassword" value=""><br>
                        <label for="addRole">Role:</label> 
                        <select name="addRole" id="addRole">
                            <option value="2">Regular User</option>
                            <option value="3">Company Admin</option>
                            <option value="1">System Admin</option>
                        </select>

                        <button type="submit" >Create User</button>
                    </form>
                </div>

                <div class="edit" style="float:right; margin: auto ">           
                    <form action="user" method="post">
                        <h2>Edit User</h2>
                        <input type="hidden" name="action" value="edit">
                        <label for="editEmail">Email:</label> 
                        <input type="text" name="editEmail" id="editEmail" value=""><br>
                        <label for="addFName">First Name:</label> 
                        <input type="text" name="editFName" id="editFName" value=""><br>
                        <label for="addLName">Last Name:</label> 
                        <input type="text" name="editLName" id="editLName" value=""><br>
                        <label for="addPassword">Password:</label> 
                        <input type="text" name="editPassword" id="editPassword" value=""><br>
                        <label for="editRole">Role:</label> 
                        <select name="editRole" id="editRole">
                            <option value="2">Regular User</option>
                            <option value="3">Company Admin</option>
                            <option value="1">System Admin</option>
                        </select>

                        <button type="submit" >Edit User</button>
                    </form>
                </div>
            </div>
                <p>${error}</p>
        </div>
    </body>
</html>
