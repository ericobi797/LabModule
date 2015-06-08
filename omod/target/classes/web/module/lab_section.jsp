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
    <openmrs:htmlInclude file="/moduleResources/LabM/dataTables.bootstrap.js"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/jquery-1.11.1.min.js"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/jquery.dataTables.min.js"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/bootstrap.min.js"/>

    <script type="text/javascript">
        $(document).ready(function() {
            $('#example').dataTable();
        } );
    </script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#myModal").modal('show');
        });
    </script>
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
                <table id="example"  class="table table-striped table-bordered table-hover" cellspacing="0">
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
                            <td>

                                <button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#myModal_${ls.id}">Edit</button>
                                <div id="myModal_${ls.id}" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title">Edit ${ls.sectionName}</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form style="margin-left:100px;" class="form-horizontal" action="<c:url value='updatelab.form' />" method="post" >
                                                    <fieldset>
                                                        <input type="hidden" name="labid" value="${ls.id}">
                                                        <div class="form-group">
                                                            <label for="lsname" class="col-lg-2 control-label">Lab Section Name</label>
                                                            <div class="col-lg-5">
                                                                <input class="form-control" id="lsname" name="lsname" placeholder="Blood" type="text" value="${ls.sectionName}">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="textArea" class="col-lg-2 control-label">Description</label>
                                                            <div class="col-lg-5">
                                                                <textarea class="form-control" rows="3" id="textArea" name="lsdescription"></textarea>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-lg-10 col-lg-offset-2">
                                                                <!-- <button type="reset" class="btn btn-default">Cancel</button> -->
                                                                <button type="submit" class="btn btn-sm btn-primary">Submit</button>
                                                            </div>
                                                        </div>
                                                    </fieldset>
                                                </form>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">Close</button>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </td>
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