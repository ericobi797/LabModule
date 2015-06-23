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
    <link rel="icon" type="image/png" href="/openmrs/moduleResources/LabM/openmrs-favicon.png">
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
            <li class="active"><a href="<c:url value='doctor.form' />">Doctor Panel</a></li>
        </ul>
    </div>

    <div class="col-md-7">
        <ul class="breadcrumb">
            <li class="active">Doctors Panel</li>
        </ul>
        <hr>
        <div class="panel panel-default">
            <div class="panel-heading">
                Request for test
            </div>
            <div class="panel-body">
                <c:if test="${!empty patientlist}">
                    <table id="example"  class="table table-striped table-bordered table-hover" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Identifiers</th>
                            <th>Patient Name</th>
                            <th>Age</th>
                            <th>Gender</th>
                            <th>Request Test</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${patientlist}" var="pl">
                            <tr>
                                <td>${pl.identifiers}</td>
                                <td>${pl.personName}</td>
                                <td>${pl.age}</td>
                                <td>${pl.gender}</td>
                                <td>

                                    <button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#myModal_${pl.patientId}">Place Test Request</button>
                                    <div id="myModal_${pl.patientId}" class="modal fade">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">Request Test For: ${pl.personName}</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <form style="margin-left:100px;" class="form-horizontal" action="<c:url value='requesttest.form' />" method="post" >
                                                        <fieldset>
                                                            <input type="hidden" name="pid" value="${pl.patientId}">
                                                            <div class="form-group">
                                                                <label for="pname" class="col-lg-2 control-label">Patient Name</label>
                                                                <div class="col-lg-5">
                                                                    <input class="form-control" id="pname" name="pname" disabled type="text" value="${pl.personName}">
                                                                </div>
                                                            </div>
                                                            <br/><br/>
                                                            <div class="form-group">
                                                                <label for="sname" class="col-lg-4 control-label">Specimen</label>
                                                                <div class="col-lg-6">
                                                                    <select class="form-control" id="sname" name="sname">
                                                                        <c:forEach items="${specimenlist}" var="sl">
                                                                            <option value="${sl.id}">${sl.name}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <br/><br/>
                                                            <div class="form-group">
                                                                <label for="tname" class="col-lg-2 control-label">Test</label>
                                                                <div class="col-lg-5">
                                                                    <select class="form-control" id="tname" name="tname">
                                                                        <c:forEach items="${testlist}" var="tl">
                                                                            <option value="${tl.id}">${tl.testName}</option>
                                                                        </c:forEach>
                                                                    </select>
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
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>


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
                                        Test Result: ${ls.result}
                                    </c:if>
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