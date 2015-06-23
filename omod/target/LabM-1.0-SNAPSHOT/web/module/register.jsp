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
            <li><a href="<c:url value='home.form' />">Home</a></li>
            <li class="active"><a href="<c:url value='register.form' />">View Test</a></li>
            <li><a href="#">Reports</a></li>
        </ul>
    </div>

    <div class="col-md-7">
        <ul class="breadcrumb">
            <li class="active">Lab Technician Panel</li>
        </ul>
        <hr>



        <hr>
        <div class="panel panel-default">
            <div class="panel-heading">
                Tests
            </div>
            <div class="panel-body">
                <c:if test="${!empty resultlist}">
                    <table id="example"  class="table table-striped table-bordered table-hover" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Patient Id</th>
                            <th>Test Name</th>
                            <th>Specimen Name</th>
                            <th>Status</th>
                            <td>Register Results</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${resultlist}" var="ls">
                            <tr>
                                <td>${ls.patientId}</td>
                                <td>${ls.labTest.testName}</td>
                                <td>${ls.specimen.name}</td>
                                <td>
                                    <c:if test="${ls.status == NULL}">
                                        Test Not Done
                                    </c:if>
                                    <c:if test="${ls.status == 1}">
                                        ${ls.result}
                                    </c:if>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#myModal_${ls.id}">Register Results</button>
                                    <div id="myModal_${ls.id}" class="modal fade">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">Request Test For: ${ls.labTest.testName}</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <form style="margin-left:100px;" class="form-horizontal" action="<c:url value='results.form' />" method="post" >
                                                        <fieldset>
                                                            <input type="hidden" name="rid" value="${ls.id}">
                                                            <input type="hidden" name="pid" value="${ls.patientId}">
                                                            <input type="hidden" name="ttid" value="${ls.labTest.id}">
                                                            <input type="hidden" name="status" value=1>
                                                            <input type="hidden" name="sid" value="${ls.specimen.id}">
                                                            <input type="text" name="tname" value="${ls.labTest.testName}" disabled/>
                                                            <br/><br/>
                                                            <input type="text" name="sname" value="${ls.specimen.name}" disabled/>
                                                            <div class="form-group">
                                                                <label for="result" class="col-lg-2 control-label">Test Result</label>
                                                                <div class="col-lg-5">
                                                                    <input class="form-control" id="result" name="result" type="text">
                                                                </div>
                                                            </div>
                                                            <br/><br/>
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