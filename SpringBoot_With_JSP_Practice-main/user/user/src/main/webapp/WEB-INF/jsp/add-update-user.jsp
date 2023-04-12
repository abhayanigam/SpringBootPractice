<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>User</title>
    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
    <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
    <form:form modelAttribute="user" action="${pageContext.request.contextPath}/user" method="post">
        <form:errors path="*" cssClass="errorblock" element="div" />
        <form:input id="id" path="id" type="hidden" />

        <section class="text-gray-600 body-font">
            <div class="container px-5 py-24 mx-auto">
              <div class="flex flex-col text-center w-full mb-12">
                <h1 class="sm:text-3xl text-2xl font-medium title-font mb-4 text-gray-900">User</h1>
              </div>

                <!-- First name-->

              <div class="flex lg:w-2/3 w-full sm:flex-row flex-col mx-auto px-8 sm:space-x-4 sm:space-y-0 space-y-4 sm:px-0 items-end">
                <div class="relative flex-grow w-full">
                  <label for="firstname" class="leading-7 text-sm text-gray-600"><spring:message code="firstname" /></label>
                  <label for="firstname" class="leading-7 text-sm text-gray-600"><form:errors path="firstname" cssClass="error" /></label>
                  <input type="text" id="firstname" name="firstname" class="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-indigo-500 focus:bg-transparent focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out">
              </div>

              <!-- Last name-->

              <div class="relative flex-grow w-full">
                  <label for="lastname" class="leading-7 text-sm text-gray-600"><spring:message code="lastname" /></label>
                  <label for="lastname" class="leading-7 text-sm text-gray-600"><form:errors path="lastname" cssClass="error" /></label>
                  <input type="lastname" id="lastname" name="lastname" class="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-indigo-500 focus:bg-transparent focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out">
              </div>

              <!-- Age -->

              <div class="relative flex-grow w-full">
                    <label for="Age" class="leading-7 text-sm text-gray-600"><spring:message code="age" /></label>
                    <label for="Age" class="leading-7 text-sm text-gray-600"><form:errors path="age" cssClass="error" /></label>
                    <input type="Age" id="Age" name="Age" class="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-indigo-500 focus:bg-transparent focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out">
              </div>

              <!-- Email -->

              <div class="relative flex-grow w-full">
                  <label for="Email" class="leading-7 text-sm text-gray-600"><spring:message code="email" />:</label>
                  <label for="Email" class="leading-7 text-sm text-gray-600"><form:errors path="email" cssClass="error" /></label>
                  <input type="Email" id="Email" name="Email" class="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-indigo-500 focus:bg-transparent focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out">
              </div>
          </section>
          <div class="flex justify-center">
              <button class="text-white bg-indigo-500 border-0 py-2 px-8 focus:outline-none hover:bg-indigo-600 rounded text-lg">Add User</button>
          </div>
    </form:form>
</body>
</html>



<!--<html>
<head>
    <title>User</title>
    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>
    <h1>User</h1>
    <form:form modelAttribute="user" action="${pageContext.request.contextPath}/user" method="post">
        <form:errors path="*" cssClass="errorblock" element="div" />
        <form:input id="id" path="id" type="hidden" />
        <table>
            <tr>
                <td><spring:message code="firstname" />:</td>
                <td><form:input path="firstname" /></td>
                <td><form:errors path="firstname" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lastname" />:</td>
                <td><form:input path="lastname" /></td>
                <td><form:errors path="lastname" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="age" />:</td>
                <td><form:input path="age" /></td>
                <td><form:errors path="age" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="email" />:</td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Add User"></td>
            </tr>
        </table>

    </form:form>
</body>
</html>
-->