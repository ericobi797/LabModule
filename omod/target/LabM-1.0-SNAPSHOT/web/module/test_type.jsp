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
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">New Test Types</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">Name</label>
                            <div class="col-lg-5">
                                <input class="form-control" placeholder="" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="select" class="col-lg-2 control-label">Lab Section</label>
                            <div class="col-lg-5">
                                <select class="form-control" id="select">
                                    <option>Blood Chemistry</option>
                                    <option>Urine Analysis</option>
                                    <option>Serology</option>
                                    <option>Hematology</option>
                                    <option>Bacteriology</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="textArea" class="col-lg-2 control-label">Description</label>
                            <div class="col-lg-5">
                                <textarea class="form-control" rows="3" id="textArea"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="select" class="col-lg-2 control-label">Measures</label>
                            <div class="col-lg-4">
                                <select class="form-control" id="selectField">
                                    <option value="option1">Numeric Values</option>
                                    <option value="option2">Alpha Numeric Values</option>
                                </select>
                            </div>
                            <div id="option1" class="col-lg-4 box">
                                <div class="col-lg-6">
                                    <input class="form-control" type="text" placeholder="one">
                                </div>
                                <div class="col-lg-6">
                                    <input class="form-control" type="text" placeholder="one">
                                </div>
                            </div>
                            <div id="option2" class="col-lg-4 box">
                                <div class="col-lg-6">
                                    <input class="form-control" type="text" placeholder="">
                                </div>
                                <div class="col-lg-6 input_fields_wrap">
                                    <input class="form-control inside" type="text" name="mytext[]">

                                    <!-- <input class="form-control" type="text" placeholder="two"> -->
                                </div>
                            </div>
                            <div class="">

                            </div>
                        </div>
                        <button style="margin-left:255px; margin-bottom:10px;" class="btn btn-xs btn-default add_field_button">Add Another</button>
                        <div class="form-group">
                            <label for="select" class="col-lg-2 control-label">Compatible Specimen</label>
                            <div class="col-lg-5">
                                <table class="table table-bordered">
                                    <tr>
                                        <td><input type="checkbox">Blood</td>
                                        <td><input type="checkbox">Smear</td>
                                        <td><input type="checkbox">Bone Marrow</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox">Tissue</td>
                                        <td><input type="checkbox">Stool</td>
                                        <td><input type="checkbox">Urine</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox">Skin</td>
                                        <td><input type="checkbox">Swab</td>
                                        <td></td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="specimen" class="col-lg-2 control-label">Cost</label>
                            <div class="col-lg-3">
                                <input class="form-control" id="specimen" placeholder="Shillings" type="text">
                            </div>
                            <div class="col-lg-3">
                                <input class="form-control"  placeholder="Cents" type="text">
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
        </div>
    </div>
    <div class="col-md-1"></div>
</div>
<br/>


<script type="text/javascript">
    $(document).ready(function() {
        var max_fields      = 10; //maximum input boxes allowed
        var wrapper         = $(".input_fields_wrap"); //Fields wrapper
        var add_button      = $(".add_field_button"); //Add button ID

        var x = 1; //initlal text box count
        $(add_button).click(function(e){ //on add input button click
            e.preventDefault();
            if(x < max_fields){ //max input box allowed
                x++; //text box increment
                $(wrapper).append('<input class="form-control col-lg-12 inside" type="text" name="mytext[]"/>'); //add input box
            }
        });

        $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
            e.preventDefault(); $(this).parent('div').remove(); x--;
        })
    });




    $(document).ready(function () {
        $('.box').hide();
        $('#option1').show();
        $('#selectField').change(function () {
            $('.box').hide();
            $('#'+$(this).val()).show();
        });
    });
</script>

</body>
</html>

