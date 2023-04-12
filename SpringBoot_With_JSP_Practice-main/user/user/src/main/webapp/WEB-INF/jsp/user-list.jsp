<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>

<head>
    <style>
        * {
            /* margin: 13px; */
            /* padding: 0; */
        }

        .div1 {
            margin: 18px;
        }

        form {
            margin-top: 12px;
            text-align: center;
            padding: 6px 2px;
            border: 2px solid white;
            background-color: rgba(102, 126, 234);
            color: white;
            margin: 17px;
            border-radius: 10px;
            cursor: pointer;
        }

        input {
            color: rgba(255, 255, 255);
            background-color: rgba(102, 126, 234);
            cursor: pointer;
        }

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        /* td,th{
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px 44px;
        } */
        th{
            text-align: left;
            padding: 8px 44px;
        }

        .info{
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px 44px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
    <title>View Users</title>
    <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
</head>

<body>
    <div class="div1">
        <br></br>
        <table>
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td class="info">${user.firstname}</td>
                        <td class="info">${user.lastname}</td>
                        <td class="info">${user.email}</td>
                        <td class="info">${user.age}</td>
                        <td class="info">
                            <form action="delete-user/${user.id}" method="post">
                                <input type="submit" value="Delete User" />
                            </form>
                        </td>

                        <td class="info">
                            <form action="user/${user.id}" method="get">
                                <input type="submit" value="Update User" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <br></br>
    </div>
    <div class="flex justify-center">
        <a href="user"><button
                class="inline-flex text-white bg-indigo-500 border-0 py-2 px-6 focus:outline-none hover:bg-indigo-600 rounded text-lg">Add
                Users</button>
        </a>
    </div>
    </div>
</body>

</html>



<!--
<html>
    <head>
        <title>View Users</title>
    </head>
    <body>

        <form action="user">
            <input type="submit" value="Add User" />
        </form>

    <div>
        <table>
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Age</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.firstname}</td>
                        <td>${user.lastname}</td>
                        <td>${user.email}</td>
                        <td>${user.age}</td>
                        <td>
                            <form action="delete-user/${user.id}" method="post">
                                <input type="submit" value="Delete User" />
                            </form>
                        </td>

                        <td>
                            <form action="user/${user.id}" method="get">
                                <input type="submit" value="Update User" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    </body>
</html>
-->