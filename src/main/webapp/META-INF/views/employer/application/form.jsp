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
	<acme:form-textbox code="employer.application.form.label.reference" path="reference" readonly="true"/>
	<jstl:if test="${comand != 'create' }">
		<acme:form-moment code="employer.application.form.label.creationMoment" path="creationMoment" readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="employer.application.form.label.statement" path="statement" readonly="true"/>
	<acme:form-textbox code="employer.application.form.label.status" path="status"/>
	<acme:form-textbox code="employer.application.form.label.qualifications" path="qualifications" readonly="true"/>
	<acme:form-textbox code="employer.application.form.label.skills" path="skills" readonly="true"/>	
	<acme:form-textbox code="employer.application.form.label.job" path="job.title" readonly="true"/>
	<acme:form-textarea code="employer.application.form.label.justification" path="justification"/>
	
	<acme:check-access test="hasRole('Employer')">
		<acme:form-submit code="employer.application.form.button.update" action="/employer/application/update"/>
	</acme:check-access>
	
	
<%-- 	<acme:form-submit test="${command == 'show'}"
		code = "employer.application.form.button.update"
		action="/employer/application/update"/>
	<acme:form-submit test="${command == 'show'}"
		code = "employer.application.form.button.delete"
		action="/employer/announcement/delete"/>
	<acme:form-submit test="${command == 'create'}"
		code = "employer.application.form.button.create"
		action="/employer/application/create"/>
	<acme:form-submit test="${command == 'update'}"
		code = "employer.application.form.button.update"
		action="/employer/application/update"/>
	<acme:form-submit test="${command == 'delete'}"
		code = "employer.application.form.button.delete"
		action="/employer/application/delete"/> --%>
		
	<acme:form-return code="employer.application.form.button.return"/>
</acme:form>