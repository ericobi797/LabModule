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
    <title>New Test</title>
    <openmrs:htmlInclude file="/moduleResources/LabM/bootstrap.min.css"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/jquery-1.11.1.min.js"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/jquery.dataTables.min.js"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/dataTables.bootstrap.js"/>
    <openmrs:htmlInclude file="/moduleResources/LabM/bootstrap.min.js"/>
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
            <li><a href="pure.html">Home</a></li>
            <li><a href="#">Test Catalogue</a></li>
            <li><a href="test.html">Test Types</a></li>
            <li><a href="specitype.html">Specimen Types</a></li>
            <li><a href="specimen.html">Specimen Catalogue</a></li>
            <li class="active"><a href="#">New Test</a></li>
            <li><a href="#">Reports</a></li>
        </ul>
    </div>
    <div class="col-md-7">
        <ul class="breadcrumb">
            <li class="active">New Test</li>
        </ul>
        <div class="col-md-8">
            <div class="panel">
                <div class="panel-body">
                    <form class="form-horizontal" action="<c:url value='savetype.form' />" method="post">
                        <fieldset>
                            <div class="form-group">
                                <label class="col-lg-3 control-label" for="tname">Test Name</label>
                                <div class="col-lg-8">
                                    <input class="form-control" id="tname" placeholder="" name="tname" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lsname" class="col-lg-3 control-label">Lab Section</label>
                                <div class="col-lg-8">
                                    <select class="form-control" id="lsname" name="lsname">
                                        <c:forEach items="${section}" var="ls">
                                            <option value="${ls.id}">${ls.sectionName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="textArea" class="col-lg-3 control-label">Description</label>
                                <div class="col-lg-5">
                                    <textarea class="form-control" rows="3" id="textArea" name="description"></textarea>
                                </div>
                            </div>
                            <div style="margin-bottom: 10px;" class="form-group">
                                <label for="measure" class="col-lg-3 control-label">Measures</label>
                                <div class="col-lg-8">
                                    <select class="form-control" id="selectField" name="measure" id="measure">
                                        <option value="option1">Numeric Values</option>
                                        <option value="option2">Alpha Numeric Values</option>
                                    </select>
                                </div>
                                <br/><br/>
                                <br/>
                                <div class="form-group">
                                    <label class="col-lg-3 control-label"></label>
                                    <div id="option1" class="col-lg-8 box">
                                        <div class="col-lg-6">
                                            <input class="form-control" name="min" type="text" placeholder="min">
                                        </div>
                                        <div class="col-lg-6">
                                            <input class="form-control" name="max" type="text" placeholder="max">
                                        </div>
                                    </div>
                                    <div id="option2" class="col-lg-8 box">
                                        <div class="col-lg-6">
                                            <input class="form-control" name="high" type="text" placeholder="High">
                                        </div>
                                        <div class="col-lg-6">
                                            <input class="form-control" name="low" type="text" placeholder="Low">
                                        </div>
                                        <div style="margin-top:10px;" class="col-lg-6">
                                            <input class="form-control" name="normal" type="text" placeholder="Normal">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Compatible Specimen</label>
                                <div class="col-lg-8">
                                    <table class="table">
                                        <c:set var="count" value="${0}"/>
                                        <tr>
                                            <c:forEach items="${specimen}" var="sp">
                                            <td><input type="checkbox" name="specimen" value="${sp.id}">${sp.name}</td>
                                            <c:set var="count" value="${count + 1}"/>
                                            <c:if test="${count == 3}">
                                        </tr><tr>
                                        <c:set var="count" value="${0}"/>
                                        </c:if>
                                        </c:forEach>
                                    </tr>
                                    </table>
                                    <input type="text" value="" id="tags" name="splist">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="cost" class="col-lg-3 control-label">Cost</label>
                                <div class="col-lg-4">
                                    <input class="form-control" id="cost" name="cost" placeholder="Shillings" type="text">
                                </div>
                                <div class="col-lg-4">
                                    <input class="form-control"  placeholder="Cents" name="costc" type="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="tat" class="col-lg-3 control-label">Turnaround Time</label>
                                <div class="col-lg-4">
                                    <input class="form-control" id="tat" name="tat" placeholder="TAT" type="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-3">
                                    <!-- <button type="reset" class="btn btn-default">Cancel</button> -->
                                    <button type="submit" class="btn btn-sm btn-primary">Submit</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
            <div class="col-md-4">
                <table class="table table-hover" cellspacing="0">
                    <thead>
                    <tr><td>Test</td><td>Test</td></tr>
                    </thead>
                    <tbody>
                    <tr><td>Test</td><td>Test</td></tr>
                    <tr><td>Test</td><td>Test</td></tr>
                    <tr><td>Test</td><td>Test</td></tr>
                    <tr><td>Test</td><td>Test</td></tr>
                    </tbody>
                </table>

        </div>

    </div>
    <div class="col-md-1"></div>
</div>
<br/>


<script type="text/javascript">
    $(document).ready(function () {
        $('.box').hide();
        $('#option1').show();
        $('#selectField').change(function () {
            $('.box').hide();
            $('#'+$(this).val()).show();
        });
    });

    function Populate(){
        vals = $('input[type="checkbox"]:checked').map(function() {
            return this.value;
        }).get().join(',');
        console.log(vals);
        $('#tags').val(vals);
    }

    $('input[type="checkbox"]').on('change', function() {
        Populate()
    }).change();
</script>

</body>
</html>

