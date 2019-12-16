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

<acme:form >
	<acme:form-textbox code="employer.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="employer.job.form.label.title" path="title"/>
	<acme:form-moment  code="employer.job.form.label.deadline" path="deadline"/>
	<acme:form-money   code="employer.job.form.label.salary" path="salary"/>
	<acme:form-url     code="employer.job.form.label.link" path="link"/>
		
	<jstl:if test="${status == 'draft' && command !='create' }">
	<acme:form-select code="employer.job.form.label.status" path="status">
				<acme:form-option code="draft" value="draft"/>
			    <acme:form-option code="published" value="published"/>
		<!-- 	draft|published|borrador|publicado -->
			
	</acme:form-select>
	</jstl:if>
	<jstl:if test="${status == 'published' }">
		<acme:form-url     code="employer.job.form.label.status" path="status" readonly="true"/>
	</jstl:if>
	
	<jstl:if test="${command == 'create' }">
		<acme:form-select code="employer.job.form.label.descriptor" path="descriptorId">
			<jstl:forEach items="${descriptors}" var="descriptor">
				<acme:form-option code="${descriptor.getDescription()}" value="${descriptor.getId()}" />
			</jstl:forEach>
		</acme:form-select>
	</jstl:if>
    
    <acme:form-submit test="${command == 'show' }" 
		code="employer.descriptor.button.show" 
		method="get" 
		action="/employer/descriptor/show?id=${id}"/>	
    <acme:form-submit test="${command == 'show'}"
		code = "employer.job.form.button.update"
		action="/employer/job/update"/>
	<acme:form-submit test="${command == 'show'}"
		code = "employer.job.form.button.delete"
		action="/employer/job/delete"/>
	<acme:form-submit test="${command == 'create'}"
		code = "employer.job.form.button.create"
		action="/employer/job/create"/>
	<acme:form-submit test="${command == 'update'}"
		code = "employer.job.form.button.update"
		action="/employer/job/update"/>
	<acme:form-submit test="${command == 'delete'}"
		code = "employer.job.form.button.delete"
		action="/employer/job/delete"/>
	
	<acme:form-return code="employer.job.form.button.return"/>
</acme:form>