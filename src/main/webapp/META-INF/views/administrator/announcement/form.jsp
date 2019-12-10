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
	<acme:form-textbox code="administrator.announcement.form.label.title" path="title"/>
	<jstl:if test="${comand != 'create' }">
		<acme:form-moment code="administrator.announcement.form.label.creationMoment" path="creationMoment" readonly="true"/>
	</jstl:if>
	<acme:form-double code="administrator.announcement.form.label.link" path="link"  placeholder="https://"/>
	<acme:form-textbox code="administrator.announcement.form.label.description" path="description"/>	
	
	<acme:form-submit test="${command == 'show'}"
		code = "administrator.announcement.form.button.update"
		action="/administrator/announcement/update"/>
	<acme:form-submit test="${command == 'show'}"
		code = "administrator.announcement.form.button.delete"
		action="/administrator/announcement/delete"/>
	<acme:form-submit test="${command == 'create'}"
		code = "administrator.announcement.form.button.create"
		action="/administrator/announcement/create"/>
	<acme:form-submit test="${command == 'update'}"
		code = "administrator.announcement.form.button.update"
		action="/administrator/announcement/update"/>
	<acme:form-submit test="${command == 'delete'}"
		code = "administrator.announcement.form.button.delete"
		action="/administrator/announcement/delete"/>
		
	<acme:form-return code="administrator.announcement.form.button.return"/>
</acme:form>