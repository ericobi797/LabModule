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
    <title>Register Specimen</title>
    <openmrs:htmlInclude file="/moduleResources/LabM/bootstrap.min.css"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/jquery-1.11.1.min.js"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/jquery.dataTables.min.js"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/dataTables.bootstrap.js"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/bootstrap.min.js"/>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#example').dataTable();

            $(document).ready(function(){
                $("#myModal").modal('show');
            });
        } );
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
            <div style="margin-top: -34px;height: 89px;">
                <a class="navbar-brand" href="/openmrs/admin"><img style="height:70px; margin-top:12px;" src="/openmrs/moduleResources/LabM/logo.png"></a>
            </div>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
            <ul class="nav navbar-nav navbar-right">
            </ul>
        </div>
    </div>
</nav>


<div class="">
    <div class="col-md-3">
        <ul class="nav nav-pills nav-stacked">
            <li class="active"><a href="<c:url value='manage.form' />">Specimen Entry</a></li>
            <li><a href="<c:url value='test_catalog.form' />">Test Catalogue</a></li>
            <li><a href="<c:url value='test_type.form' />">Test Types</a></li>
        </ul>
    </div>
    <div class="col-md-7">


        <ul class="breadcrumb">
            <li><a href="#">Test Catalog</a></li>
            <li class="active">Register Specimen</li>
        </ul>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Register Specimen</h3>
            </div>
            <div class="panel-body">
                <form style="margin-left:100px;" class="form-horizontal" action="<c:url value='savespecimen.form' />" method="post">
                    <fieldset>
                        <div class="form-group">
                            <label for="sname" class="col-lg-2 control-label">Name</label>
                            <div class="col-lg-5">
                                <input class="form-control" name="sname" id="sname" placeholder="Blood" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="desc" class="col-lg-2 control-label">Description</label>
                            <div class="col-lg-5">
                                <textarea class="form-control" name="description" id="desc" rows="3" cols="40"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <button type="reset" class="btn btn-sm btn-default">Cancel</button>
                                <button type="submit" class="btn btn-sm btn-primary">Submit</button>
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
                <table id="example" class="table table-striped table-bordered table-hover" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Specimen</th>
                        <th>Description</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${allspecimen}" var="specimen">
                        <tr>
                            <td>${specimen.name}</td>
                            <td>${specimen.description}</td>
                            <td>
                                <button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#myModal_${specimen.id}">Edit</button>
                                <div id="myModal_${specimen.id}" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title">Edit Specimen: ${specimen.name}</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form style="margin-left:100px;" class="form-horizontal" action="<c:url value='update.form' />" method="GET" >
                                                    <fieldset>
                                                        <input type="hidden" name="id" value="${specimen.id}">
                                                        <div class="form-group">
                                                            <label for="uname" class="col-lg-2 control-label">Name</label>
                                                            <div class="col-lg-5">
                                                                <input class="form-control" id="uname" name="uname" placeholder="${specimen.name}" type="text">
                                                            </div>
                                                        </div>
                                                        <br/><br/>
                                                        <div class="form-group">
                                                            <label for="textArea" class="col-lg-2 control-label">Description</label>
                                                            <div class="col-lg-5">
                                                                <textarea class="form-control" rows="3" id="textArea" name="description"></textarea>
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
                            <td><a href="<c:url value='delete.form?id=${specimen.id}'/>">delete</a></td>
                        </tr>
                    </c:forEach>
                   </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
    <br/>
</div>
</body>
</html>