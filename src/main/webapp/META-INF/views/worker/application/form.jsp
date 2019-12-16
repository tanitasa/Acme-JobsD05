<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox code="worker.application.form.label.reference" path="reference"/>
	<jstl:if test="${command == 'show' }">
		<acme:form-moment code="worker.application.form.label.creationMoment" path="creationMoment" readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="worker.application.form.label.statement" path="statement"/>
	<jstl:if test="${command == 'show' }">
	<acme:form-textbox code="worker.application.form.label.status" path="status" readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="worker.application.form.label.qualifications" path="qualifications"/>
	<acme:form-textbox code="worker.application.form.label.skills" path="skills"/>	
	<jstl:if test="${command == 'show' }">
	<acme:form-textbox code="worker.application.form.label.job" path="job.title"/>
	</jstl:if>
	<jstl:if test="${command == 'create' }">
		<acme:form-select code="worker.application.form.label.job" path="jobId">
			<jstl:forEach items="${jobs}" var="job">
				<acme:form-option code="${job.getReference()}" value="${job.getId()}" />
			</jstl:forEach>
		</acme:form-select>
	</jstl:if>
	<jstl:if test="${command == 'show' }">
	<acme:form-textarea code="worker.application.form.label.justification" path="justification"/>
	</jstl:if>
	<acme:form-submit test="${command == 'create'}"
		code = "worker.application.form.button.create"
		action="/worker/application/create"/>
	<acme:form-return code="worker.application.form.button.return"/>
</acme:form>