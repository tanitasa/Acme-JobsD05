<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not duty any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textarea code="employer.descriptor.form.label.description" path="description"/>
	
	<jstl:if test="${command == 'create' }">
		<acme:form-select code="employer.descriptor.form.label.duties" path="duties">
			<jstl:forEach items="${duties}" var="duties">
				<acme:form-option code="${duty.getTitle()}" value="${duty.getId()}" />
			</jstl:forEach>
		</acme:form-select>
	</jstl:if>
	
	<acme:form-submit test="${command == 'show' }" 
	code="employer.duty.button.list" method="get" 
	action="/employer/duty/list-mine?id=${id}"/>
	
	<acme:form-submit test="${command == 'create' }" 
	code="employer.descriptor.form.button.create" 
	action="/employer/descriptor/create/"/>
	
	
	<acme:form-return code="employer.descriptor.form.button.return"/>
</acme:form>