<%--
- list.jsp
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

<acme:list>
	<acme:list-column code="employer.application.list.label.reference" width="5%" path="reference"/>
	<acme:list-column code="employer.application.list.label.creationMoment" width="5%" path="creationMoment"/>
	<acme:list-column code="employer.application.list.label.statement" width="5%" path="statement"/>
	<acme:list-column code="employer.application.list.label.status" width="5%" path="status"/>	
	<acme:list-column code="employer.application.list.label.qualifications" width="5%" path="qualifications"/>	
	<acme:list-column code="employer.application.list.label.skills" width="5%" path="skills"/>
	<acme:list-column code="employer.application.list.label.job" width="5%" path="job.title"/>		
</acme:list>
