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
	<acme:form-textbox code="administrator.companyRecord.form.label.name" path="name"/>
	<acme:form-textbox code="administrator.companyRecord.form.label.sector" path="sector"/>
	<acme:form-textbox code="administrator.companyRecord.form.label.ceoName" path="ceoName"/>
	<acme:form-textbox code="administrator.companyRecord.form.label.description" path="description"/>
	<acme:form-url     code="administrator.companyRecord.form.label.web" path="web"/>
	<acme:form-textbox code="administrator.companyRecord.form.label.phoneNumber" path="phoneNumber" placeholder="+NNN (NNNNN) NNNNNNNNNN"/>
	<acme:form-textbox code="administrator.companyRecord.form.label.email" path="email"/>
	<acme:form-checkbox code="administrator.companyRecord.form.label.isIncorporated" path="isIncorporated"/>
	
	<acme:form-integer code="administrator.companyRecord.form.label.stars" path="stars"/>
	
	<acme:form-submit test="${command == 'show'}"
		code = "administrator.companyRecord.form.button.update"
		action="/administrator/company-record/update"/>
	<acme:form-submit test="${command == 'show'}"
		code = "administrator.companyRecord.form.button.delete"
		action="/administrator/company-record/delete"/>
	<acme:form-submit test="${command == 'create'}"
		code = "administrator.companyRecord.form.button.create"
		action="/administrator/company-record/create"/>
	<acme:form-submit test="${command == 'update'}"
		code = "administrator.companyRecord.form.button.update"
		action="/administrator/company-record/update"/>
	<acme:form-submit test="${command == 'delete'}"
		code = "administrator.companyRecord.form.button.delete"
		action="/administrator/company-record/delete"/>
	
	<acme:form-return code="administrator.companyRecord.form.button.return"/>
</acme:form>
