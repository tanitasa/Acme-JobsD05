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

<%@page import="java.util.Locale"%>
<%@page import="acme.features.authenticated.job.AuthenticatedJobShowService"%>
<%@page import="acme.features.authenticated.job.AuthenticatedJobListService"%>
<%@page import="acme.framework.entities.Authenticated"%>
<%@page import="acme.entities.jobs.Job"%>
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<acme:form readonly="true">
    <acme:form-textbox code="authenticated.job.form.label.reference"   path="reference" />
	<acme:form-textbox code="authenticated.job.form.label.title"       path="title" />
	<acme:form-textbox code="authenticated.job.form.label.status"      path="status" />
	<acme:form-moment code="authenticated.job.form.label.deadLine"     path="deadline" />
	<acme:form-money code="authenticated.job.form.label.salary"       path="salary" />
	<acme:form-url code="authenticated.job.form.label.link"         path="link" />
	<acme:form-textbox code="authenticated.job.form.label.isActive"     path="isActive" />
	<acme:form-textarea code="authenticated.job.form.label.descriptor"   path="descriptor" />
    <acme:form-textarea code="authenticated.job.form.label.employer"     path="employer" />
    <%-- 
    <acme:form-textarea code="authenticated.job.form.label.applications" path="applications" />
  
<jstl:forEach items="${applications}" var="app" >
<jstl:out value="${app.getReference()}"/>
</jstl:forEach> --%>
 

	<acme:form-return code="authenticated.job.form.button.return" />
</acme:form>
