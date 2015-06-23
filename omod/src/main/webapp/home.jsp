<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<%@ taglib prefix="openmrs" uri="/WEB-INF/taglibs/openmrs.tld" %>
<%@ taglib prefix="openmrs_tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="page" uri="/WEB-INF/taglibs/page.tld" %>
<%@ taglib prefix="request" uri="/WEB-INF/taglibs/request.tld" %>
<%@ taglib prefix="response" uri="/WEB-INF/taglibs/response.tld" %>
<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>
<%@ taglib prefix="form" uri="/WEB-INF/taglibs/spring-form.tld" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/png" href="/openmrs/moduleResources/LabM/openmrs-favicon.png">
    <title></title>
    <openmrs:htmlInclude file="/moduleResources/LabM/bootstrap.min.css"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/jquery-1.11.1.min.js"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/jquery.dataTables.min.js"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/dataTables.bootstrap.js"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/bootstrap.min.js"/>

    <style type="text/css">
        .link {
            width: 150px;
            height: 150px;
            margin-left: 20px;
            color: #ffffff;
            border-radius: 50%;
            text-align: center;
        }

        .link > p {
            margin: 50%;
        }

        .link-default {
            background-color: #555555;
        }

        .link-primary {
            background-color: #444555;
        }

        .link-danger {
            background-color: #555444;
        }

        .link-warning {
            background-color: #333333;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div style="margin-top: -34px;height: 89px;">
                <a class="navbar-brand" href="/openmrs/admin"><img style="height:70px; margin-top:12px;" src="/openmrs/moduleResources/LabM/logo.png"></a>
            </div>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
            <ul class="nav navbar-nav navbar-right">
                <li></li>
            </ul>
        </div>
    </div>
</nav>


<div class="">
    <div class="col-md-3">
        <ul class="nav nav-pills nav-stacked">
            <li class="active"><a href="<c:url value='home.form' />">Home</a></li>
            <li><a href="<c:url value='register.form' />">View Test</a></li>
            <li><a href="#">Reports</a></li>
        </ul>
    </div>

    <div class="col-md-7">
        <ul class="breadcrumb">
            <li class="active">Home</li>
        </ul>
        <div>

            <hr>
            <div class="panel panel-default">
                <div class="panel-heading">
                    Tests
                </div>
                <div class="panel-body">
                    <table id="example" class="table table-striped table-bordered table-hover" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Specimen</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${allspecimen}" var="specimen">
                            <tr>
                                <td>${specimen.name}</td>
                                <td>${specimen.description}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>


    </div>
    <div class="col-md-1"></div>
</div>
<br/>


</body>
</html>

