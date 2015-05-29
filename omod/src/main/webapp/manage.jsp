<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p>Hello ${user.systemId}!</p>
<p>Register specimen</p>
<form action="<c:url value='savespecimen.form' />" method="post">
    <label for="sname">Specimen Name:</label>
    <input type="text" name="sname" id="sname" required>
    <label for="desc">*Description:</label>
    <textarea name="description" id="desc" rows="3" cols="40"></textarea>
    <button>Save</button>
</form>
<div>
    <c:if test="${!empty allspecimen}">
        <table>
            <thead>
            <tr>
                <th width="80">Specimen Name</th>
                <th width="150">Specimen Description</th>
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
    </c:if>
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>