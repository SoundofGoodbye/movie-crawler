<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movies</title>
</head>
<body ng-app="MovieWebApp" class="ng-cloak">
<div class="generic-container" ng-controller="MovieController as ctrl">

    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Movies </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Year</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="m in ctrl.movies">
                    <td><span ng-bind="m.title"></span></td>
                    <td><span ng-bind="m.year"></span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/service/movies_service.js' />"></script>
<script src="<c:url value='/static/js/controller/movies_controller.js' />"></script>
</body>
</html>