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
    <title></title>
    <openmrs:htmlInclude file="/moduleResources/LabM/bootstrap.min.css"/>
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
            <a class="navbar-brand" href="#">Lab Module</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="">
    <div class="col-md-3">
        <ul class="nav nav-pills nav-stacked">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Test Catalogue</a></li>
            <li><a href="test.html">Test Types</a></li>
            <li><a href="specitype.html">Specimen Types</a></li>
            <li><a href="specimen.html">Specimen Catalogue</a></li>
            <li><a href="#">Reports</a></li>
        </ul>
    </div>

    <div class="col-md-7">
        <ul class="breadcrumb">
            <li class="active">Home</li>
        </ul>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Add Lab Sections</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="<c:url value='savelab.form' />" method="post">
                    <fieldset>
                        <div class="form-group">
                            <label for="lname" class="col-lg-2 control-label">Section Name</label>
                            <div class="col-lg-5">
                                <input class="form-control" id="lname" name="lname" placeholder="section name" type="text" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ldescription" class="col-lg-2 control-label">Description</label>
                            <div class="col-lg-5">
                                <textarea class="form-control" rows="3" id="ldescription" name="ldescription"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <!-- <button type="reset" class="btn btn-default">Cancel</button> -->
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <hr>
        <div class="panel panel-default">
            <div class="panel-heading">
                Tests
            </div>
            <div class="panel-body">
                <c:if test="${!empty listsection}">
                <table class="table table-striped table-hover ">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Lab Name</th>
                        <th>Lab Description</th>
                        <th colspan="2">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listsection}" var="ls">
                        <tr>
                            <td>${ls.sectionName}</td>
                            <td>${ls.sectionDescription}</td>
                            <td><button type="reset" class="btn btn-default btn-xs">Edit</button></td>
                            <td><button type="submit" class="btn btn-danger btn-xs"><a href="<c:url value='lsdelete.form?id=${ls.id}' />">delete</a></button></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </c:if>
            </div>
        </div>

    </div>
    <div class="col-md-1"></div>
</div>
<br/>


</body>
</html>